/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import streaming.entity.Message;

/**
 *
 * @author ajc
 */
@Service
    public interface MessageCrudService extends CrudRepository<Message, Long>{
        public List<Message> findAllByJoueurId(long id);
        @Override
    public List<Message> findAll();
}
