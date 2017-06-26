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
 * @author Mirela
 */
@Entity
@Table(name = "VIDEO")
public class Video implements Serializable{
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_VIDEO")
    @SequenceGenerator(name = "SEQ_VIDEO", sequenceName = "SEQ_VIDEO")
    private Long id;
    
    @Basic(optional=false)
    @Column(name = "VALOR")
    private BigDecimal valor;
    
    @Basic
    @Column(name = "DURACAO")
    private String duracao;
    
    @ManyToOne
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;
    
    @Basic
    @Column(name = "NOME")
    private String nome;
    
    @Basic
    @Column(name = "QUANTIDADE_ESTOQUE")
    private int quantidade_estoque;
    
    @Basic
    @Column(name = "DATA_LANCAMENTO")
    @Temporal(TemporalType.DATE)
    private Date data_lancamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public Date getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(Date data_lancamento) {
        this.data_lancamento = data_lancamento;
    }
    
    
    
    
}
