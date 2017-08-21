package TP_Integrador.DTO;
import static java.lang.Math.abs;

public class Consistente extends Condicion{
     public Consistente(String numero, String indicador) {
        super(numero, indicador);
    } 
    @Override
     public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        Indicador indicador = new Indicador();
        indicador.setIndicador(this.indicador);
        boolean pasa = true;
        double resultadoInicial = indicador.resultadoFinal(empresa.getNombreEmpresa(),Integer.toString(anioDesde));
        
        int i = anioDesde++;
        while(i <= anioHasta){
        double resultadoAComparar = indicador.resultadoFinal(empresa.getNombreEmpresa(),Integer.toString(i));
        if( abs(resultadoAComparar - resultadoInicial)  < resultadoAComparar * 0.05 ){
            pasa = false;
            resultadoInicial = resultadoAComparar;
        }
        i++;
        }
      return pasa;
    }
    
}