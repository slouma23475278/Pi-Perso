package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "bonplan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonPlan1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpb;

    @Column(nullable = false, length = 30)
    private String titrepb;

    @Column(nullable = false, length = 15)
    private String typepb;

    @Column(nullable = false, length = 500)
    private String descriptionpb;

    @Column(nullable = false, length = 15)
    private String statuspb;

    @Lob
    @Column(nullable = false)
    private byte[] photopb;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datedebutpb;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datefinpb;
}
