package DTO;
import DAO.*;


public class MayorA extends Condicion{
     

    public MayorA() {
        super();
    }
     
    @Override
    public Boolean pasaCondicion(Empresa empresa,int anioDesde, int anioHasta){
        
        IndicadorDAO indicadorDAO = new IndicadorDAO();
        Indicador indi = indicadorDAO.get(this.indicador);
        int i = anioDesde;
        while(i <= anioHasta){
        double resultado = indi.resultadoFinal(empresa.getCodEmpresa(),Integer.toString(i));
        if(resultado <= Integer.parseInt(this.getMonto()) ){
            return  false;
        }
        i++;
        }
      return true ;
    }
}