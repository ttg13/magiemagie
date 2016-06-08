/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import streaming.entity.Message;

/**
 *
 * @author ajc
 */
@Service
public class MessageService {
    @Autowired
    JoueurCrudService joueurCrud;
    
    @Autowired
    MessageCrudService messageCrud;
    
    public void debut(long l){
        Message msg = new Message();
        msg.setJoueur(joueurCrud.findOne(l));
        msg.setMessage("");
        messageCrud.save(msg);
    }
    
    public void messageGlodal(String msg){
        List<Message> messages = messageCrud.findAll();
        for(Message message : messages){
            message.setMessage(msg);
            messageCrud.save(message);
        }
    }
    
    public void messagePersonnel(String msg, long id){
        List<Message> messages = messageCrud.findAllByJoueurId(id);
        for(Message message : messages){
            message.setMessage(msg);
            messageCrud.save(message);
        }
    }
}
