package br.com.viladafolha.CadastroNinja.Exception;

import java.util.HashMap;
import java.util.Map;

//classe utilitária responsável por formatar respostas padrão
public class ResponseGenericException {
    public static <T> Map<String, T> response(T object) {
        Map<String, T> map = new HashMap<>();
        map.put("resultado", object);
        return map;
    }

    public static Map<String, Object> error(String message, Object details) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "error");
        map.put("mensagem", message);
        map.put("detalhes", details != null ? details : "Sem detalhes adicionais");
        return map;
    }
}
