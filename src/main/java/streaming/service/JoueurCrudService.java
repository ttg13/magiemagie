/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import streaming.entity.Joueur;

@Service
public interface JoueurCrudService extends CrudRepository<Joueur, Long> {
    @Override
    public List<Joueur> findAll();
    
    public List<Joueur> findAllByMarqueurmainIsTrue();
}
