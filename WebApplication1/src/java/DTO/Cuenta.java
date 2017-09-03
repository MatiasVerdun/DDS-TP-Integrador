/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="Cuentas")
public class Cuenta implements Serializable{
    @Id
    @Column(name="codCuenta")
    private String codCuenta;
    @Column(name="nombreCuenta")
    private String nombreCuenta;

    public Cuenta() {
    }

    
    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String CodCuenta) {
        this.codCuenta = CodCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }
    
}
