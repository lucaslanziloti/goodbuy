package br.com.caelum.goodbuy.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 * @author lucas
 */

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 5461289499090358151L;

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Nome precisa ser preenchido")
    @Length(min = 3, message = "Nome precisa ter mais de 3 letras")
    private String nome;

    @NotNull(message = "Nome precisa ser preenchido")
    @Length(max = 40, message = "O campo não pode exceder 40 caracteres")
    private String descricao;

    @Min(0)
    private Double preco;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
