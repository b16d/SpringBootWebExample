package com.training.web.connector.db.dto;

import jakarta.persistence.*;

@Entity
@Table(name="APPLICATION_USER")
public class UserDTO {

    private String name;
    private String familyName;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public UserDTO() {

    }
    public UserDTO(String name, String familyName, Long id) {
        this.name = name;
        this.familyName = familyName;
        this.id = id;
    }

    public UserDTO(String name, String familyName) {
        this.name = name;
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
