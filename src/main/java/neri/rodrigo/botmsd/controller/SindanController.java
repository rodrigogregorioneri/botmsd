package neri.rodrigo.botmsd.controller;


import com.fasterxml.jackson.databind.JsonNode;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/sindan")
public class SindanController {

    static final String URL_EMPLOYEES_XML = "https://rss.app/feeds/HFblHdNm7cbSnLCE.xml";



    @PostMapping("/noticias")
    public String getSindan(@RequestBody JsonNode request) throws SOAPException {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();

        SOAPConnection soapConnection = soapConnectionFactory.createConnection();
        return "";
    }







}