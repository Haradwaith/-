/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc.classes;

import java.util.Date;

/**
 *
 * @author Clelia
 */
public class Imc {
   private int idUser;
    private Date dateCalcule;
    private float ResultatImc; 

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
        return ResultatImc;
    }

    public void setResultatImc(float ResultatImc) {
        this.ResultatImc = ResultatImc;
    }
    
    public float calculeImc(int height, int weight){
        return this.ResultatImc = (float) (height/Math.pow(weight,2));
    }
   
    
    
}
