/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "SOLICITACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s"),
    @NamedQuery(name = "Solicitacao.findById", query = "SELECT s FROM Solicitacao s WHERE s.id = :id")})
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_SOLICITACAO")
    @SequenceGenerator(name = "SEQ_SOLICITACAO", sequenceName = "SEQ_SOLICITACAO", allocationSize = 1)
    private Long id;
    @JoinColumn(name = "IDSOLICITANTE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idsolicitante;
    @JoinColumn(name = "IDRECEPTOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Usuario idreceptor;

    public Solicitacao() {
    }

    public Solicitacao(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getIdsolicitante() {
        return idsolicitante;
    }

    public void setIdsolicitante(Usuario idsolicitante) {
        this.idsolicitante = idsolicitante;
    }

    public Usuario getIdreceptor() {
        return idreceptor;
    }

    public void setIdreceptor(Usuario idreceptor) {
        this.idreceptor = idreceptor;
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
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.crescer.backend.entidades.Solicitacao[ id=" + id + " ]";
    }
    
}
