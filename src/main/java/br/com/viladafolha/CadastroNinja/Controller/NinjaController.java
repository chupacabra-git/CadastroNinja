package br.com.viladafolha.CadastroNinja.Controller;
import br.com.viladafolha.CadastroNinja.Entity.NinjaEntity;
import br.com.viladafolha.CadastroNinja.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/ninja")
/*
MAPEAMENTO DAS REQUISICOES
*/
public class NinjaController {
    @Autowired
    private NinjaService ninjaService;
    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Bem vindo ao sistema de cadastro de ninjas da Vila da Folha.";
    }
    //Cadastrar
    @PostMapping("/cadastrar")
    public NinjaEntity cadastrar(@RequestBody NinjaEntity ninja){
        return ninjaService.cadastrar(ninja) ;
    }

    //Listar

    //Pesquisar

    //Alterar

    //Excluir
}
