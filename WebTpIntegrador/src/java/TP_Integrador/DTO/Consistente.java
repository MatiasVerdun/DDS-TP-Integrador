package TP_Integrador.DTO;
import TP_Integrador.DAO.IndicadorDAO;
import static java.lang.Math.abs;

public class Consistente extends Condicion{
     @Override
     public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        double resultadoInicial = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(i));
        if( abs(resultadoAComparar - resultadoInicial)  < resultadoAComparar * 0.05 ){
            pasa = false;
            resultadoInicial = resultadoAComparar;
        }
        i++;
        }
      return pasa;
    }
    
}