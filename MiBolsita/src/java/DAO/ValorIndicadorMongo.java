/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



import DTO.ValorIndicador;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;





public class ValorIndicadorMongo {
   
  public void saveOrUpdate(ValorIndicador valor){
    try (MongoClient client = new MongoClient()) {
      Morphia morphia = new Morphia();
      morphia.mapPackage("DTO");

      Datastore datastore = morphia.createDatastore(client, "preCalculoIndicador");
      datastore.save(valor);
    }
    
  }


   public ArrayList<ValorIndicador> filterId(String id_usuario){
     
       try (MongoClient client = new MongoClient()) {
      Morphia morphia = new Morphia();
      morphia.mapPackage("DTO");

      Datastore datastore = morphia.createDatastore(client, "preCalculoIndicador");
        ArrayList<ValorIndicador> valores  = (ArrayList<ValorIndicador>) datastore.createQuery(ValorIndicador.class).field("id_usuario").equal(id_usuario).asList();
       
       return valores;
    }
     
       
      
       
   
   }
   
   
     
}
