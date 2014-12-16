package com.lucasian.nsjp.indicadores

class ArchivosCargados {
    String nombre
    Date periodo
    String status
    String tabla    
    String path
    Date lastUpdated
    static belongsTo = [usuario: ShiroUser]
    static constraints = {
        
    }    
}
