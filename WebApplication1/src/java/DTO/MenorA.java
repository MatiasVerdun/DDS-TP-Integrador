package DTO;
import DAO.IndicadorDAO;




public class MenorA extends Condicion {

    /**
     *
     * @param numero
     * @param indicador
     */
    public MenorA(String numero, String indicador) {
        super(numero, indicador);
    }

    public MenorA() {
        super();
    }
    
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        boolean pasa = true;
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        Indicador indicador = indicadorDAO.get(this.indicador);
        
        int i = anioDesde;
        while(i <= anioHasta){
        double resultado = indicador.resultadoFinal(empresa.getNombreEmpresa(),Integer.toString(i));
        if(resultado >= Integer.parseInt(this.getMonto()) ){
            pasa = false;
            
        }
        i++;
        }
      return pasa;
    }
    
}