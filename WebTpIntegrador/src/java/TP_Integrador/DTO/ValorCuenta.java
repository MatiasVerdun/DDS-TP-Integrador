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
public class ValorCuenta {
    private String CodEmpresa;
    private String Periodo;
    private String CodCuenta;
    private double Valor;
    
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

    public String getCodCuenta() {
        return CodCuenta;
    }

    public void setCodCuenta(String CodCuenta) {
        this.CodCuenta = CodCuenta;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

}
