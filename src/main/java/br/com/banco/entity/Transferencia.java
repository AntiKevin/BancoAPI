package br.com.banco.entity;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "transferencia")
public class Transferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private OffsetDateTime data_transferencia;
    private Double valor;
    private String tipo;
    private String nome_operador_transacao;
    private Integer conta_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OffsetDateTime getData_transferencia() {
        return data_transferencia;
    }

    public void setData_transferencia(OffsetDateTime data_transferencia) {
        this.data_transferencia = data_transferencia;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome_operador_transacao() {
        return nome_operador_transacao;
    }

    public void setNome_operador_transacao(String nome_operador_transacao) {
        this.nome_operador_transacao = nome_operador_transacao;
    }

    public Integer getConta_id() {
        return conta_id;
    }

    public void setConta_id(Integer conta_id) {
        this.conta_id = conta_id;
    }
}
