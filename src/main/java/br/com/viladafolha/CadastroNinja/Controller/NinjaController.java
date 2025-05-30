package br.com.viladafolha.CadastroNinja.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ninja")

/*
MAPEAMENTO DAS REQUISICOES
*/
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem vindo ao sistema de cadastro de ninjas da Vila da Folha.";
    }

    //Cadastrar

    //Listar

    //Pesquisar

    //Alterar

    //Excluir
}
