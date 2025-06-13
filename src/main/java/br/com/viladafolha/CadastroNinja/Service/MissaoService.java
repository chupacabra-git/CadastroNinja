package br.com.viladafolha.CadastroNinja.Service;

import br.com.viladafolha.CadastroNinja.Entity.MissaoEntity;
import br.com.viladafolha.CadastroNinja.Repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;
    /* # CADASTRAR # */
    public MissaoEntity cadastrarMissao(MissaoEntity missao){
        return missaoRepository.saveAndFlush(missao);
    }

    /* # LISTAR # */
    public List<MissaoEntity> listarMissao(){
        return missaoRepository.findAll();
    }

    /* # PESQUISAR # */
    public List<MissaoEntity> pesquisarMissao(String nome) {
        List<MissaoEntity> todas = missaoRepository.findAll();
        List<MissaoEntity> filtradas = todas.stream()
                .filter(m -> m.getNome() != null && m.getNome().toLowerCase().contains(nome.toLowerCase()))
                .toList();
        if (filtradas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma missão encontrada com esse nome.");
        }
        return filtradas;
    }

    /* # DELETAR # */
    public HashMap<String, Object> deletarMissao(Long id){
        Optional<MissaoEntity> missao =
                Optional.ofNullable(missaoRepository.findById(id)
                        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Missão não encontrada!")));
        missaoRepository.delete(missao.get());
        HashMap<String, Object> resultado = new HashMap<String, Object>();
        resultado.put("resultado", "Missão: " + missao.get().getNome() + " excluída com sucesso!");
        return resultado;
    }

    /* # ALTERAR # */
    public HashMap<String, Object> alterarMissao(Long id, MissaoEntity missaoAlterada){
        MissaoEntity missaoId = missaoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Ninja não encontrado, não é possível alterar."));
        missaoAlterada.setId(id);
        missaoRepository.saveAndFlush(missaoAlterada);
        HashMap<String, Object> resultado = new HashMap<>();
        resultado.put("resultado", "Missão: " + missaoAlterada.getNome() + " atualizada com sucesso!");
        return resultado;
    }

}
