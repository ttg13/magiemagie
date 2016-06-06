/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author ajc
 */
@Entity
public class Carte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public enum Typecarte{
        CORNELICORNE,
        SANGVIERGE,
        BAVECRAPAUD,
        LAPISLAZULIS,
        AILESOURIS
    }
    
    @ManyToOne
    @JoinColumn(name = "joueurId")
    private Joueur joueur;
    
    @Enumerated(EnumType.STRING)
    private Typecarte typecarte;

    public Typecarte getTypecarte() {
        return typecarte;
    }

    public void setTypecarte(Typecarte typecarte) {
        this.typecarte = typecarte;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carte)) {
            return false;
        }
        Carte other = (Carte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carte" + this.typecarte;
    }
    
}
