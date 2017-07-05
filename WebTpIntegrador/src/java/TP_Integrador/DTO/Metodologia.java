/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DTO;

import java.util.ArrayList;

/**
 *
 * @author Vic
 */
public class Metodologia {
    private String nombreMetodologia; 
   
    private ArrayList condiciones = new ArrayList();

    public String getNombreMetodologia() {
        return nombreMetodologia;
    }

    public void setNombreMetodologia(String nombreMetodologia) {
        this.nombreMetodologia = nombreMetodologia;
    }

   
    public ArrayList getCondiciones() {
        return condiciones;
    }

    public void addCondiciones(String condiciones) {
        this.condiciones.add(condiciones);
    }
    
     
}

