package TP_Integrador.DTO;
import TP_Integrador.DTO.Indicador;
import TP_Integrador.DAO.*;


public class MayorA extends Condicion{
     public MayorA(String numero, String indicador) {
        super(numero, indicador);
    }
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        boolean pasa = true;
        Indicador indicador = new Indicador();
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        indicador.setIndicador(indicadorDAO.conseguirIndicador(this.indicador));
        int i = anioDesde;
        while(i <= anioHasta){
        double resultado = indicador.resultadoFinal(empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultado <= Integer.parseInt(this.getNumero()) ){
            pasa = false;
        }
        i++;
        }
      return pasa;
    }
}