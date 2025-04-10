package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "bilanfinancier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BilanFinancier2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idbf;

    @Column(nullable = false, length = 20)
    private String titrebf;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datebf;

    @Column(nullable = false, length = 10)
    private String typebf;

    @Column(nullable = false, length = 30)
    private String periodecouverture;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(nullable = false, length = 10)
    private String section;

    @Column(nullable = false, length = 1000)
    private String lienassocie;

}
