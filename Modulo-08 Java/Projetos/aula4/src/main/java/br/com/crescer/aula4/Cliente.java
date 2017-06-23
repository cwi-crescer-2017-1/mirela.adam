package br.com.crescer.aula4;
import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mirela.adam
 */
@Entity
@Table
public class Cliente implements Serializable{
    @Id // Identifica a PK
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "NM_CLIENTE")
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
