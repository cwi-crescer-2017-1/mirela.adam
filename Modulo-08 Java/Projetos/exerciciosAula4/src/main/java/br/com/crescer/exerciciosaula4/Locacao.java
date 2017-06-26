package br.com.crescer.exerciciosaula4;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mirela
 */
@Entity
@Table(name = "LOCACAO")
public class Locacao implements Serializable {
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_LOCACAO")
    @SequenceGenerator(name = "SEQ_LOCACAO", sequenceName = "SEQ_LOCACAO")
    private Long id;
    
    @Basic
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valor_total;
    
    @ManyToOne
    @JoinColumn(name = "ID_FUNCIONARIO")
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "ID_VIDEO")
    private Video video;
    
    @Basic
    @Column(name = "DATA_DEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date data_devolucao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor_total() {
        return valor_total;
    }

    public void setValor_total(BigDecimal valor_total) {
        this.valor_total = valor_total;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Date getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    
    
    
}
