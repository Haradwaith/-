/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhfc2;

import java.util.List;

/**
 *
 * @author Clelia
 */
public class Sport {
    
    private List<Short> idExercice;
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public List<Short> getSport() {
        return idExercice;
    }

    public void setSport(List<Short> idExercice) {
        this.idExercice = idExercice;
    }
    
  
    
}
