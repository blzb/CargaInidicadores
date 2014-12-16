/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lucasian.nsjp.indicadores

import java.text.MessageFormat
import org.springframework.context.support.AbstractMessageSource
/**
 *
 * @author Angel
 */
class DatabaseMessageSource  extends AbstractMessageSource{

    protected MessageFormat resolveCode(String code, Locale locale) { 
        def format
        Message msg = Message.findByCode(code)                
        if(msg) {
            format = new MessageFormat(msg.text, locale)
        }
        else {
            Message m = new Message(code: code, text: '-')
            m.save(failOnError: true)
            
        }
        return format;
    }
}

