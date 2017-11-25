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

   
    public ArrayList<Condicion> getCondiciones() {
        return condiciones;
    }

    public void setCondiciones(ArrayList<Condicion> condiciones) {
        this.condiciones = condiciones;
    }
    

    public boolean pasaCondiciones(Empresa empresa, int anioDesde, int anioHasta){
        boolean resultado=condiciones.stream().allMatch(condicion -> condicion.pasaCondicion(empresa, anioDesde, anioHasta));
        return resultado;
    }
    
     public Metodologia ObtenerMetodologiaConCondiciones(String metodologia){
           Metodologia meto = new Metodologia();
           meto.setNombreMetodologia(metodologia);
           CondicionDAO condicionDAO = new CondicionDAO();
           ArrayList<Condicion> condicionesAux = (ArrayList<Condicion>) condicionDAO.filter(metodologia);
           condicionesAux.forEach(condicion -> {
                                if(condicion.getTipo().equals("mayorA")){
                                    MayorA mayor = new MayorA ();
                                    mayor.setId(condicion.getId());
                                    mayor.setIndicador(condicion.getIndicador());
                                    mayor.setMetodologia(metodologia);
                                    mayor.setMonto(condicion.getMonto());
                                    mayor.setTipo("mayorA");
                                    condiciones.add(mayor);
                                }
                                if(condicion.getTipo().equals("menorA")){
                                    MenorA menor = new MenorA();
                                    menor.setId(condicion.getId());
                                    menor.setIndicador(condicion.getIndicador());
                                    menor.setMetodologia(metodologia);
                                    menor.setMonto(condicion.getMonto());
                                    menor.setTipo("menorA");
                                    condiciones.add(menor);
                                }if(condicion.getTipo().equals("consistente")){
                                    Consistente consistente = new Consistente();
                                    consistente.setId(condicion.getId());
                                    consistente.setIndicador(condicion.getIndicador());
                                    consistente.setMetodologia(metodologia);
                                    consistente.setMonto(condicion.getMonto());
                                    consistente.setTipo("consistente");
                                    condiciones.add(consistente);
                                }
                                if(condicion.getTipo().equals("decreciente")){
                                    Decreciente decreciente = new Decreciente();
                                    decreciente.setId(condicion.getId());
                                    decreciente.setIndicador(condicion.getIndicador());
                                    decreciente.setMetodologia(metodologia);
                                    decreciente.setMonto(condicion.getMonto());
                                    decreciente.setTipo("decreciente");
                                    condiciones.add(decreciente);
                                }
                                if(condicion.getTipo().equals("creciente")){
                                    Creciente   creciente = new Creciente();
                                    creciente.setId(condicion.getId());
                                    creciente.setIndicador(condicion.getIndicador());
                                    creciente.setMetodologia(metodologia);
                                    creciente.setMonto(condicion.getMonto());
                                    creciente.setTipo("creciente");
                                    condiciones.add(creciente);
                                }
                          
           });
           meto.setCondiciones(condiciones);
           return meto;
       }
     
}

