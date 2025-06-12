package br.com.viladafolha.CadastroNinja.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="ninja")
/*
ATRIBUTOS DA NOSSA CLASSE
*/
public class NinjaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_ninja")
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    @Size(min = 3, max = 255, message = "Nome deve ter entre 3 e 50 caracteres")
    @Column(name="nome_ninja", nullable = false)
    private String nome;

    @NotBlank(message = "CPF é obrigatório.")
    @CPF
    @Column(name="cpf_ninja", unique = true, nullable = false)
    private String cpf;

    @Email(message = "Email inválido.")
    @Column(name="email_ninja")
    private String email;
}
