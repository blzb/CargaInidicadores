/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lucasian.nsjp.indicadores
import org.springframework.web.multipart.MultipartFile

/**
 *
 * @author Angel
 */
@grails.validation.Validateable
class FormatUploadCommand {
	MultipartFile archivo
        
        static constraints ={
            
        }
        public String toString(){
            archivo.name
        }
}

