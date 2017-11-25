package DTO;
import DAO.IndicadorDAO;




public class MenorA extends Condicion {

   

    public MenorA() {
        super();
    }
    
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        Indicador indicador = indicadorDAO.get(this.indicador);
        int i = anioDesde;
        while(i <= anioHasta){
        double resultado = indicador.resultadoFinal(empresa.getCodEmpresa(),Integer.toString(i));
        if(resultado >= Integer.parseInt(this.getMonto()) ){
           return false;
        }
        i++;
        }
      return true;
    }
    
}