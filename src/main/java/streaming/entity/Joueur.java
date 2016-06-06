/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author ajc
 */
@Entity
public class Joueur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String Pseudo;
    private long DateArrivee;
    private boolean Marqueurmain;
    private long TypeSorciere;
    
    
//    @ManyToOne
//    @JoinColumn(name = "tablejeuId")
//    private TableJeu tablejeu;

    @OneToMany(mappedBy = "joueur")
    private List<Carte> cartes = new ArrayList();

    

    public Long getId() {
        return id;
    }

    public String getPseudo() {
        return Pseudo;
    }

    public void setPseudo(String Pseudo) {
        this.Pseudo = Pseudo;
    }

    public long getDateArrivee() {
        return DateArrivee;
    }

    public void setDateArrivee(long DateArrivee) {
        this.DateArrivee = DateArrivee;
    }

    public boolean isMarqueurmain() {
        return Marqueurmain;
    }

    public void setMarqueurmain(boolean Marqueurmain) {
        this.Marqueurmain = Marqueurmain;
    }

   

    public long getTypeSorciere() {
        return TypeSorciere;
    }

    public void setTypeSorciere(long TypeSorciere) {
        this.TypeSorciere = TypeSorciere;
    }

//    public TableJeu getTablejeu() {
//        return tablejeu;
//    }
//
//    public void setTablejeu(TableJeu tablejeu) {
//        this.tablejeu = tablejeu;
//    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
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
        if (!(object instanceof Joueur)) {
            return false;
        }
        Joueur other = (Joueur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Joueur[ id=" + id + " ]";
    }
    
}
