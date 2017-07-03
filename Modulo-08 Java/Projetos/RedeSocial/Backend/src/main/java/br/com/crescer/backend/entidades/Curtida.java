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
@Table(name = "CURTIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curtida.findAll", query = "SELECT c FROM Curtida c"),
    @NamedQuery(name = "Curtida.findById", query = "SELECT c FROM Curtida c WHERE c.id = :id")})

public class Curtida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURTIDA")
@SequenceGenerator(name = "SEQ_CURTIDA", sequenceName = "SEQ_CURTIDA", allocationSize = 1)
    private Long id;
    @JoinColumn(name = "IDPOST", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Post idpost;
    @JoinColumn(name = "IDUSUARIO", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Curtida() {
    }

    public Curtida(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getIdpost() {
        return idpost;
    }

    public void setIdpost(Post idpost) {
        this.idpost = idpost;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
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
        if (!(object instanceof Curtida)) {
            return false;
        }
        Curtida other = (Curtida) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.backend.entidades.Curtida[ id=" + id + " ]";
    }
    
}
