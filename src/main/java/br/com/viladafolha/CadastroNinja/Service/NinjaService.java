package br.com.viladafolha.CadastroNinja.Service;

import br.com.viladafolha.CadastroNinja.Entity.NinjaEntity;
import br.com.viladafolha.CadastroNinja.Repository.NinjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*
IMPLEMENTACAO DAS FUNCOES
*/
public class NinjaService {
    @Autowired
    private NinjaRepository ninjaRepository;

    //CADASTRAR
    public NinjaEntity cadastrar(NinjaEntity ninja){
        return ninjaRepository.save(ninja);
    }
    //LISTAR
    public List<NinjaEntity> listar(){
        return ninjaRepository.findAll();
    }


}
