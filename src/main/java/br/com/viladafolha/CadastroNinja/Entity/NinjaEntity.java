package br.com.viladafolha.CadastroNinja.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Column(name="id_ninja")
    private Long id;
    @Column(name="nome_ninja")
    private String nome;
    @Column(name="cpf_ninja")
    private String cpf;
    @Column(name="email_ninja")
    private String email;
}
