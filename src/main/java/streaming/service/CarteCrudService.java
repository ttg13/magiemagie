/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import streaming.entity.Carte;
import streaming.entity.Carte.Typecarte;

/**
 *
 * @author ajc
 */
@Service
    public interface CarteCrudService extends CrudRepository<Carte, Long>{
        public List<Carte> findAllByJoueurId(long id);
        public List<Carte> findAllByJoueurIdByTypecarte(long id, Typecarte type);
}
