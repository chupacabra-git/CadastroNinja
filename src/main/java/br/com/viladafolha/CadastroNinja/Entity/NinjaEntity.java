package br.com.viladafolha.CadastroNinja.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

/*
ATRIBUTOS DA NOSSA CLASSE
*/
public class NinjaEntity {
    @Id
    private Long id;
    private String nome;
    private String cpf;
    private String email;
}
