/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlFileInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSpan;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CargaArchivosTest extends Assert {
private WebClient webClient;

    @Before
    public void setUp() {
        this.webClient = new WebClient();
    }
    
 
    
    @Test
    public void testIndexHtml() throws Exception {
        Assert.assertEquals(1, 1);
        HtmlPage page = this.webClient.getPage("http://localhost:8080/WebTpIntegrador");
        //HtmlForm form = page1.getFormByName("myform");
        Assert.assertEquals(1, 1);
        HtmlTextInput usuario = page.getElementByName("Usuario");
        HtmlPasswordInput contrasenia = page.getElementByName("Clave");
        usuario.setValueAttribute("Hector");
        contrasenia.setValueAttribute("1234");
        HtmlSubmitInput button = page.getElementByName("iniciarSesion");
        HtmlPage page1 = button.click();
        Assert.assertEquals("http://localhost:8080/WebTpIntegrador/AccesoControllerServlet", page1.getUrl().toString());
        HtmlSubmitInput cargarValoresCuentasButton = page1.getElementByName("cargarValoresCuentas");
        HtmlPage cargarValoresCuentasPage = cargarValoresCuentasButton.click();
        Assert.assertEquals("http://localhost:8080/WebTpIntegrador/MenuControllerServlet", cargarValoresCuentasPage.getUrl().toString());
        HtmlFileInput uploadedfile = cargarValoresCuentasPage.getElementByName("uploadedfile");
        uploadedfile.setValueAttribute("C:\\ValoresCuentas.txt");
        HtmlSubmitInput SubirArchivo = cargarValoresCuentasPage.getElementByName("subirArchivo");
        HtmlPage menu = SubirArchivo.click();
        Assert.assertEquals("http://localhost:8080/WebTpIntegrador/CargarValoresCuentasControllerServlet", menu.getUrl().toString());
        cargarValoresCuentasButton = menu.getElementByName("cargarValoresCuentas");
        cargarValoresCuentasPage = cargarValoresCuentasButton.click();
        Assert.assertEquals("http://localhost:8080/WebTpIntegrador/MenuControllerServlet", cargarValoresCuentasPage.getUrl().toString());
        
        
        
        
    }
}