package com.example.sokolovswebapp.controllers;

import com.example.sokolovswebapp.repositories.FileEntityRepository;
import com.example.sokolovswebapp.services.UserService;
import com.example.sokolovswebapp.models.FileEntity;
import com.example.sokolovswebapp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {
    private UserService userService;
    private FileEntityRepository fileEntityRepository;

    @Autowired
    public UserRestController(UserService userService,FileEntityRepository fileEntityRepository) {
        this.userService = userService;
        this.fileEntityRepository = fileEntityRepository;
    }

    public String register(String username, String password, String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);

        userService.register(user);
        return "redirect:/login";
    }

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(Principal principal, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("No file uploaded (File is empty)");
        }

        try {
            FileEntity fileEntity = new FileEntity();

            fileEntity.setFileName(file.getOriginalFilename());
            fileEntity.setContentType(file.getContentType());
            fileEntity.setData(file.getBytes());

            List<FileEntity> list = new ArrayList<>();
            list.add(fileEntity);

            String username = principal.getName();
            User user = userService.findUserByUsername(username);

            fileEntity.setUser(user);

            fileEntityRepository.save(fileEntity);

            user.setFiles(list);

            return ResponseEntity.ok("File uploaded successful");
        } catch (IOException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }

    @GetMapping("/getFile")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("id") String id, Principal principal) {
        try {
            Long valuId = Long.valueOf(id);

            String username = principal.getName();
            User user = userService.findUserByUsername(username);

            FileEntity fileEntity = user.getFiles().stream().filter(file -> file.getId().equals(valuId)).findFirst().orElseThrow(() -> new FileNotFoundException("File not found."));

            if (fileEntity == null) {
                return ResponseEntity.notFound().build();
            }

            ByteArrayResource resource = new ByteArrayResource(fileEntity.getData());

            return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename" + fileEntity.getFileName())
                    .contentType(MediaType.parseMediaType(fileEntity.getContentType()))
                    .contentLength(fileEntity.getData().length)
                    .body(resource);

        } catch (FileNotFoundException exception) {
            return ResponseEntity.notFound().build();
        }
    }
}
