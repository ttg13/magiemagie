/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import streaming.entity.Carte;

/**
 *
 * @author ajc
 */
@Service
    public interface CarteCrudService extends CrudRepository<Carte, Long>{
}
