package DTO;
import DAO.IndicadorDAO;




public class Decreciente extends Condicion{
     public Decreciente(String numero, String indicador) {
        super(numero, indicador);
    } 

    public Decreciente() {
        super();
    }
     
    @Override
     public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        Indicador indicador = indicadorDAO.get(this.indicador);
        boolean pasa = true;
        double resultadoInicial = indicador.resultadoFinal( empresa.getNombreEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicador.resultadoFinal(empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultadoAComparar > resultadoInicial ){
            pasa = false;
            resultadoInicial = resultadoAComparar;
        }
        i++;
        }
      return pasa;
    }
}
