/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="Empresas")
public class Empresa implements Serializable {
    @Id
    @Column(name="codEmpresa")
    private String codEmpresa;
   
    @Column(name="vombreEmpresa")
    private String nombreEmpresa;

    public Empresa() {
    }
    
    
    public String getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(String CodEmpresa) {
        this.codEmpresa = CodEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
}
