package DTO;
import DAO.IndicadorDAO;




public class Decreciente extends Condicion{
    

    public Decreciente() {
        super();
    }
     
    @Override
     public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        Indicador indicador = indicadorDAO.get(this.indicador);
        
        double resultadoInicial = indicador.resultadoFinal( empresa.getCodEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicador.resultadoFinal(empresa.getCodEmpresa(),Integer.toString(i));
        if(resultadoAComparar > resultadoInicial ){
            resultadoInicial = resultadoAComparar;
            return  false;
        }
        i++;
        }
      return true;
    }
}
