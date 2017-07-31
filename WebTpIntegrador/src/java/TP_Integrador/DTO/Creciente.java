package TP_Integrador.DTO;
import TP_Integrador.DAO.IndicadorDAO;


public class Creciente extends Condicion{
     public Creciente(String numero, String indicador) {
        super(numero, indicador);
    }
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        boolean pasa = true;
        double resultadoInicial = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultadoAComparar < resultadoInicial ){
            pasa = false;
            resultadoInicial = resultadoAComparar;
        }
        i++;
        }
      return pasa;
    }
}