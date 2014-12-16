package com.lucasian.nsjp.indicadores
import com.lucasian.nsjp.indicadores.ArchivosCargados
class ShiroUser {
    String username
    String passwordHash
    
    static hasMany = [ roles: ShiroRole, permissions: String, archivosCargados: ArchivosCargados ]
    

    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
    public String toString(){
        username
    }
}
