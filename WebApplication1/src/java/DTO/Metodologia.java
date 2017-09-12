/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import DAO.CondicionDAO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;


@Entity
@Table(name="Metodologias")
public class Metodologia  implements Serializable {
    @Id
    @Column(name="nombreMetodologia")
    private String nombreMetodologia; 
   
    @Transient
    private ArrayList<Condicion> condiciones = new ArrayList<Condicion>();
    
    @Column(name="id_usuario")
    private String id_usuario;

    public Metodologia() {
    }
    
    
    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    
    public String getNombreMetodologia() {
        return nombreMetodologia;
    }

    public void setNombreMetodologia(String nombreMetodologia) {
        this.nombreMetodologia = nombreMetodologia;
    }

   
    public ArrayList getCondiciones() {
        return condiciones;
    }

    public void addCondicion(Condicion condicion) {
        condiciones.add(condicion);
    }
    
    public void addCondiciones(ArrayList<Condicion> condicionesAAgregar){
        condicionesAAgregar.forEach(condicion -> addCondicion(condicion));
    }
    
    public boolean pasaCondiciones(Empresa empresa, int anioDesde, int anioHasta){
        //return condiciones.stream().allMatch(condicion -> condicion.pasaCondicion(empresa, anioDesde, anioHasta));
        boolean pasa = true;
            for(int i = 0; i < condiciones.size(); i++){
                if(!(condiciones.get(i).pasaCondicion(empresa, anioDesde, anioHasta))){
                    pasa = false;
                }
            }
        return pasa;
    }
    
     public Metodologia ObtenerMetodologiaConCondiciones(String metodologia){
           Metodologia meto = new Metodologia();
           meto.setNombreMetodologia(metodologia);
           CondicionDAO condicionDAO = new CondicionDAO();
           meto.addCondiciones((ArrayList<Condicion>) condicionDAO.filter(metodologia));
           return meto;
       }
     
}

