package br.com.crescer.aula7.entidades;
/**
 *
 * @author mirela.adam
 */
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Mirela
 */
@Entity
@Table(name = "GENERO")
public class Genero implements Serializable{
    @Id
    @Basic(optional = false)
    @Column(name = "ID_GENERO")
    @GeneratedValue(strategy = SEQUENCE, generator = "SQ_GENERO")
    @SequenceGenerator(name = "SQ_GENERO", sequenceName = "SQ_GENERO", allocationSize = 1)
    private Long id;
    
    @Basic(optional=false)
    @Column(name = "DS_GENERO")
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
