package br.com.crescer.backend.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mirela.adam
 */
@Entity
@Table(name = "AMIZADE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amizade.findAll", query = "SELECT a FROM Amizade a"),
    @NamedQuery(name = "Amizade.findById", query = "SELECT a FROM Amizade a WHERE a.id = :id")})
public class Amizade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_AMIZADE")
    @SequenceGenerator(name = "SEQ_AMIZADE", sequenceName = "SEQ_AMIZADE", allocationSize = 1)
    private Long id;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idusuario;
    @JoinColumn(name = "IDAMIGO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idamigo;

    public Amizade() {
    }

    public Amizade(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario getIdamigo() {
        return idamigo;
    }

    public void setIdamigo(Usuario idamigo) {
        this.idamigo = idamigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amizade)) {
            return false;
        }
        Amizade other = (Amizade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.backend.entidades.Amizade[ id=" + id + " ]";
    }
    
}
