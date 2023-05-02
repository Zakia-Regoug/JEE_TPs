package com.example.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @Column(unique = true, length = 20)
 private String roleName;
 private String desc;
 @ManyToMany(fetch = FetchType.EAGER)
 //@JoinTable(name="USERS_ROLES")
 @ToString.Exclude
 private List<User> users=new ArrayList<>();
}
