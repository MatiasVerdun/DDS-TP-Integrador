package DTO;
import DAO.IndicadorDAO;
import static java.lang.Math.abs;


public class Consistente extends Condicion{
     

    public Consistente() {
        super();
    }
     
    @Override
     public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        Indicador indicador = indicadorDAO.get(this.indicador);
        
        double resultadoInicial = indicador.resultadoFinal(empresa.getCodEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicador.resultadoFinal(empresa.getCodEmpresa(),Integer.toString(i));
        if( abs(resultadoAComparar - resultadoInicial)  < resultadoAComparar * 0.05 ){
            resultadoInicial = resultadoAComparar;
           return false;
        }
        i++;
        }
      return true;
    }
    
}