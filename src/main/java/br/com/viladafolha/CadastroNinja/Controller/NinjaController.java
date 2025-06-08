package br.com.viladafolha.CadastroNinja.Controller;
import br.com.viladafolha.CadastroNinja.Entity.NinjaEntity;
import br.com.viladafolha.CadastroNinja.Service.NinjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public NinjaEntity cadastrar(@RequestBody NinjaEntity ninja)  {
        return ninjaService.cadastrar(ninja) ;
    }

    //Listar
    @GetMapping("/listar")
    public List<NinjaEntity> listar(){
        return ninjaService.listar();
    }

    //Pesquisar
    @GetMapping("/pesquisar/{id}")
    public NinjaEntity pesquisarNinja (@PathVariable Long id){
        return ninjaService.pesquisar(id);
    }

    //Delete
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja (@PathVariable Long id){
        ninjaService.deletar(id);
    }

    //ALTERAR
    @PutMapping("/alterar/{id}")
    public NinjaEntity alterar(@PathVariable Long id, @RequestBody NinjaEntity ninja){
        return ninjaService.alterar(id,ninja);
    }

}
