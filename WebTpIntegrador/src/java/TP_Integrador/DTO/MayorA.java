package TP_Integrador.DTO;
import TP_Integrador.DAO.IndicadorDAO;


public class MayorA extends Condicion{
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        int i = anioDesde;
        while(i <= anioHasta){
        double resultado = indicadorDAO.resultadoFinal(this.getIndicador(), empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultado <= Integer.parseInt(this.getNumero()) ){
            pasa = false;
        }
        i++;
        }
      return pasa;
    }
}