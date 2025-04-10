package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "articles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idart;

    @Column(nullable = false, length = 25)
    private String titreart;

    @Column(nullable = false, length = 500)
    private String desart;

    @Column(nullable = false, length = 30)
    private String Pseudoart;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datemiseajourart;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date autodateart;
}