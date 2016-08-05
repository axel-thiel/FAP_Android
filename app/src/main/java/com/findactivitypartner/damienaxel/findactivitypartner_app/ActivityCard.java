package com.findactivitypartner.damienaxel.findactivitypartner_app;

import android.media.Image;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by maax on 02/08/16.
 */
public class ActivityCard implements Serializable {
    private User user;
    private String sport;
    private String ville;
    private String pseudo;
    private int image;
    private String dateDebut;
    private String dateFin;
    private boolean pretMateriel;
    private boolean besoinMateriel;
    private String comentaireActivite;
    private String niveauActivite;

    public ActivityCard() {

    }

    public ActivityCard(String sport, String ville, String pseudo, int image, String dateDebut,
                        String dateFin , boolean pretMateriel, boolean besoinMateriel,
                        String comentaireActivite , String niveauActivite ) {
        this.sport = sport;
        this.ville = ville;
        this.pseudo = pseudo;
        this.image = image;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.pretMateriel = pretMateriel;
        this.besoinMateriel = besoinMateriel;
        this.comentaireActivite = comentaireActivite;
        this.niveauActivite = niveauActivite;

    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isPretMateriel() {
        return pretMateriel;
    }

    public void setPretMateriel(boolean pretMateriel) {
        this.pretMateriel = pretMateriel;
    }

    public boolean isBesoinMateriel() {
        return besoinMateriel;
    }

    public void setBesoinMateriel(boolean besoinMateriel) {
        this.besoinMateriel = besoinMateriel;
    }

    public String getComentaireActivite() {
        return comentaireActivite;
    }

    public void setComentaireActivite(String comentaireActivite) {
        this.comentaireActivite = comentaireActivite;
    }

    public String getNiveauActivite() {
        return niveauActivite;
    }

    public void setNiveauActivite(String niveauActivite) {
        this.niveauActivite = niveauActivite;
    }
}
