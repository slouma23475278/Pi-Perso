package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chiffreaffairegrp")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiffreAffaireGrp2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgrp;

    @Column(nullable = false)
    private Integer chiffreaffairegrp;

    @Column(nullable = false)
    private Integer chiffreaffairesin;

    @Column(nullable = false)
    private Integer resultatnet;

    @Column(nullable = false)
    private Integer resulatpargrp;
}