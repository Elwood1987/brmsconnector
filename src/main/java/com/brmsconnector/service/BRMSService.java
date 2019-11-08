package com.brmsconnector.service;

import com.brmsconnector.entity.ValidacionOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

@Service
public class BRMSService {

    @Autowired
    RestTemplate restTemplate;

    public HttpStatus validarOrden(ValidacionOrden validacionOrden){
        try {
            Properties prop = getPropertiesFile();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<String> result = restTemplate.postForEntity("http://10.39.1.153:8090/webservice/KallSonys/KallSonys/validacionOrden", validacionOrden, String.class);
            String url = prop.getProperty("HOST") + ":"+ prop.getProperty("PORT")+"/bonita/API/bpm/process?s=" + prop.getProperty("PROCESSNAME");
            return HttpStatus.ACCEPTED;
        } catch (Exception e){
            return HttpStatus.BAD_REQUEST;
        }
    }

    public Properties getPropertiesFile() {
        InputStream inputStream;
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            return prop;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}
