package br.com.viladafolha.CadastroNinja.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
    @Column(name="nome_ninja", nullable = false)
    private String nome;
    @CPF
    @Column(name="cpf_ninja", unique = true)
    private String cpf;
    @Email
    @Column(name="email_ninja")
    private String email;
}
