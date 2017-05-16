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
    private int Descripcion;

    public String getCodCuenta() {
        return CodCuenta;
    }

    public void setCodCuenta(String CodCuenta) {
        this.CodCuenta = CodCuenta;
    }

    public int getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(int Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
