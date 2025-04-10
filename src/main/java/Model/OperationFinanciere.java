package Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "operationsfinanciere")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationFinanciere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idoperation;

    @Column(nullable = false)
    private Integer nombreaction;

    @Column(nullable = false)
    private Integer montantaction;

    @Column(nullable = false)
    private Integer montantoperation;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date annee;

    @Column(nullable = false, length = 30)
    private String nomactionnaire;

    @Column(nullable = false, length = 10)
    private String typetransaction;

    @Column(nullable = false, length = 30)
    private String societe;
}