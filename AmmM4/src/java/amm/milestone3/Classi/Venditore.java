/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amm.milestone3.Classi;

import java.util.ArrayList;

/**
 *
 * @author Alessandro Mainas
 */
public class Venditore extends Utente{
    private ArrayList<OggettiInVendita> oggettiVenditore = new ArrayList<>();
    public Venditore(){
        super();
    }

    /**
     * @return the oggettiVenditore
     */
    public ArrayList<OggettiInVendita> getOggettiVenditore() {
        return oggettiVenditore;
    }

    /**
     * @param oggettiVenditore the oggettiVenditore to set
     */
    public void setOggettiVenditore(ArrayList<OggettiInVendita> oggettiVenditore) {
        this.oggettiVenditore = oggettiVenditore;
    }
}
