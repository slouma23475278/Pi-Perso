package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "chiffreaffairesociete")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiffreAffaireSociete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcas;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date annee;

    @Column(nullable = false, length = 30)
    private String societe;

    @Column(nullable = false)
    private Integer chiffreaffaire;

    @Column(nullable = false)
    private Integer resultattech;

    @Column(nullable = false)
    private Integer resultatnet;
}
