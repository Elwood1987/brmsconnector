package com.brmsconnector.controller;

import com.brmsconnector.entity.ValidacionOrden;
import com.brmsconnector.service.BRMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rules")
public class BRMSController {

    @Autowired
    private BRMSService brmsService;

    @PostMapping(value = "/orderValidation", consumes = "application/json", produces = "application/json")
    public HttpStatus orderValidation(@RequestBody ValidacionOrden validacionOrden){
        return brmsService.validarOrden(validacionOrden);
    }
/*
    @PostMapping("/seleccionMensajeria")
    public HttpStatus seleccionMensajeria(){
        return brmsService.validarOrden();
    }
*/
}
