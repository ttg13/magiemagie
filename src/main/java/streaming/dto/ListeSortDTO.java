/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dto;

/**
 *
 * @author ajc
 */
public class ListeSortDTO {
    private String sort;
    private String joueurCible;
    private String carteCible;
    
//    private Joueur joueurCible;
//    private Carte carteCible;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
    
    
    

    public String getJoueurCible() {
        return joueurCible;
    }

    public void setJoueurCible(String joueurCible) {
        this.joueurCible = joueurCible;
    }

    public String getCarteCible() {
        return carteCible;
    }

    public void setCarteCible(String carteCible) {
        this.carteCible = carteCible;
    }

    
    
    
    
}
