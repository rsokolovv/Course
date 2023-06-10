package com.example.sokolovswebapp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> files;

    public List<FileEntity> getFiles(){
        return files;
    }

    public void setFiles(List<FileEntity> files){
        this.files = files;
    }

    public void setFile(FileEntity file){
        files.add(file);
    }

    //private List<String> roles = new ArrayList<>(Arrays.asList("ADMIN", "USER", "MODERATOR"));

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
