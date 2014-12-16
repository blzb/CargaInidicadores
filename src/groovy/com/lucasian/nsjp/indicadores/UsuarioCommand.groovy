/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lucasian.nsjp.indicadores

/**
 *
 * @author Angel
 */
@grails.validation.Validateable
class UsuarioCommand {
	String username
        String password
        String passwordConfirm
        String permisos        
        List<String> permisosList
        String rol
        static constraints ={
            
        }
}

