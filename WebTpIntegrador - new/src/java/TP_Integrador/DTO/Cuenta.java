/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP_Integrador.DTO;

/**
 *
 * @author Matias
 */
public class Cuenta {
    private String CodCuenta;
    private String nombreCuenta;

    public String getCodCuenta() {
        return CodCuenta;
    }

    public void setCodCuenta(String CodCuenta) {
        this.CodCuenta = CodCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }
    
}
