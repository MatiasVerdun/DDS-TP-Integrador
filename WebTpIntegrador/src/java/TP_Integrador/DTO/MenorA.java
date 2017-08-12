package TP_Integrador.DTO;
import TP_Integrador.DTO.Indicador;


public class MenorA extends Condicion {

    /**
     *
     * @param numero
     * @param indicador
     */
    public MenorA(String numero, String indicador) {
        super(numero, indicador);
    }
    
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        boolean pasa = true;
        Indicador indicador = new Indicador();
        indicador.setIndicador(this.indicador);
        
        int i = anioDesde;
        while(i <= anioHasta){
        double resultado = indicador.resultadoFinal(empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultado >= Integer.parseInt(this.getNumero()) ){
            pasa = false;
            
        }
        i++;
        }
      return pasa;
    }
    
}