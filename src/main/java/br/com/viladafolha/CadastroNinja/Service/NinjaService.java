package br.com.viladafolha.CadastroNinja.Service;

import br.com.viladafolha.CadastroNinja.Entity.NinjaEntity;
import br.com.viladafolha.CadastroNinja.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
/*
IMPLEMENTACAO DAS FUNCOES
*/
public class NinjaService {
    @Autowired
    private NinjaRepository ninjaRepository;

    //CADASTRAR
    public NinjaEntity cadastrar(NinjaEntity ninja){
        return ninjaRepository.saveAndFlush(ninja);
    }
    /*
        public NinjaEntity cadastrar(NinjaEntity ninja){
        return ninjaRepository.save(ninja);
    }
    */

    //LISTAR
    public List<NinjaEntity> listar(){
        return ninjaRepository.findAll();
    }
    /*
     public List<NinjaEntity> listar(){
        return ninjaRepository.findAll();
    }
    */

    //PESQUISAR
    public Optional<NinjaEntity> pesquisar(Long id){
        return Optional.ofNullable(ninjaRepository.findById(id)
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ninja não encontrado")));
    }
    /*
     public NinjaEntity pesquisar(Long id){
        Optional<NinjaEntity> ninjaId = ninjaRepository.findById(id);
        return ninjaId.orElse(null);
    }
     */
    //DELETAR
    public HashMap<String, Object> deletar(Long id) {
        Optional<NinjaEntity> ninja =
                Optional.ofNullable(ninjaRepository.findById(id).
                        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Ninja não encontrado!")));

        ninjaRepository.delete(ninja.get());
        HashMap<String, Object> resultado = new HashMap<String, Object>();
        resultado.put("resultado", "Ninja: " + ninja.get().getNome() + " excluído com sucesso!");
        return resultado;
    }
    /*
      public void deletar(Long id){
        ninjaRepository.deleteById(id);
    }
     */

    //ALTERAR
    public HashMap<String, Object> alterar(Long id, NinjaEntity ninjaAlterado){
        NinjaEntity ninjaId = ninjaRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Ninja não encontrado, não é possível alterar."));
        ninjaAlterado.setId(id);
        ninjaRepository.saveAndFlush(ninjaAlterado);
        HashMap<String, Object> resultado = new HashMap<>();
        resultado.put("resultado", "Ninja: " + ninjaAlterado.getNome() + " atualizado com sucesso!");
        return resultado;
    }
    /*
     public NinjaEntity alterar (Long id, NinjaEntity ninjaAlterado){
        //se encontrar o ID
        if(ninjaRepository.existsById(id)){
            //altera as informacoes
            ninjaAlterado.setId(id);
            // salva no banco
            return ninjaRepository.save(ninjaAlterado);
        }
        return null;
    }
     */



}
