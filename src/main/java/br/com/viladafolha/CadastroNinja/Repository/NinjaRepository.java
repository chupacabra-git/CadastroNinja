package br.com.viladafolha.CadastroNinja.Repository;

import br.com.viladafolha.CadastroNinja.Entity.NinjaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/*
CAMADA DE COMUNICACAO COM O BD
*/
public interface NinjaRepository extends JpaRepository<NinjaEntity, Long> {
}
