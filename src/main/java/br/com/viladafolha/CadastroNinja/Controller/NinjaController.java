package br.com.viladafolha.CadastroNinja.Controller;
import br.com.viladafolha.CadastroNinja.Entity.NinjaEntity;
import br.com.viladafolha.CadastroNinja.Exception.ResponseGenericException;
import br.com.viladafolha.CadastroNinja.Service.NinjaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Object> salvar(@Valid @RequestBody NinjaEntity ninja){
        NinjaEntity resultado = ninjaService.cadastrar(ninja);
        return ResponseEntity.ok().body(ResponseGenericException.response(resultado));
    }
    /*
    @PostMapping("/cadastrar")
    public NinjaEntity cadastrar(@RequestBody NinjaEntity ninja)  {
        return ninjaService.cadastrar(ninja) ;
    }     */

    //Listar
    @GetMapping("/listar")
    public List<NinjaEntity> listar(){
        return ninjaService.listar();
    }
    /*
    @GetMapping("/listar")
    public List<NinjaEntity> listar(){
        return ninjaService.listar();
    }*/

    //Pesquisar
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Object> pesquisarNinja (@PathVariable Long id){
        Optional<NinjaEntity> resultado = ninjaService.pesquisar(id);
        return ResponseEntity.ok().body(ResponseGenericException.response(resultado));
    }
    /*
    @GetMapping("/pesquisar/{id}")
    public NinjaEntity pesquisarNinja (@PathVariable Long id){
        return ninjaService.pesquisar(id);
    }
    */

    //Delete
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id){
        HashMap<String, Object> resultado = ninjaService.deletar(id);
        return  ResponseEntity.ok().body(ResponseGenericException.response(resultado));
    }
    /*
    @DeleteMapping("/deletar/{id}")
    public void deletarNinja (@PathVariable Long id){
        ninjaService.deletar(id);
    }*/

    //ALTERAR
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody @Valid NinjaEntity ninjaAlterado){
        return ResponseEntity.ok(ninjaService.alterar(id,ninjaAlterado));
    }
    /*

    @PutMapping("/alterar/{id}")
    public NinjaEntity alterar(@PathVariable Long id, @RequestBody NinjaEntity ninja){
        return ninjaService.alterar(id,ninja);
    }
     */

}
