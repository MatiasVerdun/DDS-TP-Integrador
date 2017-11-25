package DTO;



import DAO.IndicadorDAO;
import DAO.ValorCuentaDAO;
import DAO.ValorIndicadorMongo;
import java.util.ArrayList;



public class ValorIndicador {
    
    

    private String CodEmpresa;
    
    
    private String Periodo;
    
  
    private String NombreIndicador;
    
    private double Valor;

    
    private String id_usuario;
    
    

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
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

    
    
     //DB Relacional 
    public void generarValores() {
       
       IndicadorDAO indicadorDAO = new IndicadorDAO();
       Indicador indicador = indicadorDAO.filter(NombreIndicador);
        ValorCuentaDAO valorCuentaDAO = new ValorCuentaDAO();
        ValorIndicadorMongo valorIndicadorDAO = new ValorIndicadorMongo();
       //Obtiene todos los valoresCuenta
        ArrayList<ValorCuenta> valorCuenta = (ArrayList<ValorCuenta>) valorCuentaDAO.filter();
        
        valorCuenta.forEach((unValorCuenta) -> {
                setCodEmpresa(unValorCuenta.getCodEmpresa());
                setPeriodo(unValorCuenta.getPeriodo());
                double resultado = indicador.resultadoFinal(unValorCuenta.getCodEmpresa(), unValorCuenta.getPeriodo());
                setValor(resultado);
                valorIndicadorDAO.saveOrUpdate(this);
        });
       
        
    }
    
    
    
    
    
        
    public ArrayList<ValorIndicador> filtrarEmpresa(ArrayList<ValorIndicador> valores , String empresa){
        ArrayList<ValorIndicador> valoresAux = new ArrayList();
        valores.forEach(valor -> {
            if(valor.getCodEmpresa().equals(empresa)){
                valoresAux.add(valor);
            }
        } );
    return valoresAux;
    }
    
    public ArrayList<ValorIndicador> filtrarPeriodo(ArrayList<ValorIndicador> valores , String periodo){
        ArrayList<ValorIndicador> valoresAux = new ArrayList();
        valores.forEach(valor -> {
            if(valor.getPeriodo().equals(periodo)){
                valoresAux.add(valor);
            }
        } );
    return valoresAux;
    }
     
     public ArrayList<ValorIndicador> filtrarIndicador(ArrayList<ValorIndicador> valores , String cuenta){
        ArrayList<ValorIndicador> valoresAux = new ArrayList();
        valores.forEach(valor -> {
            if(valor.getNombreIndicador().equals(cuenta)){
                valoresAux.add(valor);
            }
        } );
    return valoresAux;
    }
     
      public double obtenerValor(ArrayList<ValorIndicador> valores,String empresa,String indicador, String periodo){
       ValorIndicador valor = new ValorIndicador();
       ArrayList<ValorIndicador> filterEmpresa=valor.filtrarEmpresa(valores,empresa);
       ArrayList<ValorIndicador> filterCuenta= valor.filtrarIndicador(filterEmpresa, indicador);
       ArrayList<ValorIndicador> filterPeriodo= valor.filtrarPeriodo(filterCuenta, periodo);
       if(filterPeriodo.isEmpty()){
           System.out.print("Error al conseguir un valor");
          
       }else{ 
           return filterPeriodo.get(0).getValor();
       }
        return 0;
     }

    
     

}