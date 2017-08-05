/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
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
    
    @After
    public void tearDown() {
        this.webClient.closeAllWindows();
    }
    
    @Test
    public void testIndexHtml() throws Exception {
        HtmlPage page = this.webClient.getPage("http://localhost:8080/WebTpIntegrador/MenuControllerServlet");
        Html
        input.setValueAttribute("23");
        
        HtmlSubmitInput submit = form.getInputByName("convertir");
        page = submit.click();
        
        HtmlSpan span = page.getFirstByXPath("//span[@class='kilometros']");
        assertEquals("37.01482", span.asText());
    }

}
