/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc;

import java.util.Date;

/**
 *
 * @author Clelia
 */
public class Imc {
    private int idUser;
    private Date dateCalcule;
    private float resultatImc;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDateCalcule() {
        return dateCalcule;
    }

    public void setDateCalcule(Date dateCalcule) {
        this.dateCalcule = dateCalcule;
    }

    public float getResultatImc() {
        return resultatImc;
    }

    public void setResultatImc(float resultatImc) {
        this.resultatImc = resultatImc;
    }
   
    
    
}
