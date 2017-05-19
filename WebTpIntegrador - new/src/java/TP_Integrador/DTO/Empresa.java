/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DTO;

/**
 *
 * @author Victoria
 */
public class Empresa {
    private String CodEmpresa;
    private String NombreEmpresa;
    
    
    public String getCodEmpresa() {
        return CodEmpresa;
    }

    public void setCodEmpresa(String CodEmpresa) {
        this.CodEmpresa = CodEmpresa;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String Descripcion) {
        this.NombreEmpresa = Descripcion;
    }
}
