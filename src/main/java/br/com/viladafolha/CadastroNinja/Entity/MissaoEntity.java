package br.com.viladafolha.CadastroNinja.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="missao")
public class MissaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_missao")
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    @Size(min = 5, max = 150, message = "Nome deve ter entre 5 e 50 caracteres")
    @Column(name="nome_missao", nullable = false)
    private String nome;

    @Column(name="classificacao_missao", length = 1)
    private Character classificacao;

    @NotNull(message = "Status é obrigatório.")
    @Column(name="status", nullable = false)
    private Boolean status;

}

