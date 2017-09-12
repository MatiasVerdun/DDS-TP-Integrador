/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="Usuarios")
public class Usuario  implements Serializable{
    
    @Id
    @Column(name="id_usuario")
    private String Usuario;
    
    @Column(name="contrasena")
    private String Contrasena;

    public Usuario() {
    }
    
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsario(String UserName) {
        this.Usuario = UserName;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setPassword(String Password) {
        this.Contrasena = Password;
    }
}
