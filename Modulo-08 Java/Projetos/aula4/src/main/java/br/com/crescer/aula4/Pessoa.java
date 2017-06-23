
package br.com.crescer.aula4;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mirela.adam
 */
@Entity
@Table
public class Pessoa {
   @Id // Identifica a PK
    @Basic(optional = false)
    private Long id;
    
    @Basic(optional = false)
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
