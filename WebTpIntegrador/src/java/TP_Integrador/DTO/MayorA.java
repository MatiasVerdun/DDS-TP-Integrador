package TP_Integrador.DTO;
import TP_Integrador.DAO.IndicadorDAO;


public class MayorA extends Condicion{
     public MayorA(String numero, String indicador) {
        super(numero, indicador);
    }
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        boolean pasa = true;
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        int i = anioDesde;
        while(i <= anioHasta){
        double resultado = indicadorDAO.resultadoFinal(getIndicador(), empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultado <= Integer.parseInt(this.getNumero()) ){
            pasa = false;
        }
        i++;
        }
      return pasa;
    }
}