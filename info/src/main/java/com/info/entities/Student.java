package com.info.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String course;

    private double fee;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_proof_id", referencedColumnName = "id")
    private IdProof idProof;

}
