/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;

/**
 *
 * @author Matias
 */

public class ValorIndicador implements Serializable {
    private String CodEmpresa;
    private String Periodo;
    private String NombreIndicador;
    private double Valor;

    public ValorIndicador() {
    }
    
    
    
    public String getCodEmpresa() {
        return CodEmpresa;
    }

    public void setCodEmpresa(String CodEmpresa) {
        this.CodEmpresa = CodEmpresa;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String Periodo) {
        this.Periodo = Periodo;
    }

    public String getNombreIndicador() {
        return NombreIndicador;
    }

    public void setNombreIndicador(String CodCuenta) {
        this.NombreIndicador = CodCuenta;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

}
