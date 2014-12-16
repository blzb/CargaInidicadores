package com.lucasian.nsjp.indicadores

class ComisionInternos {

	String centroPenitenciarioTipo
	String centroPenitenciario
	String municipio
	String distrito
	String internoGenero
	Integer año
	Integer mes
	Integer dia
        String clasificacionInternosGrupo
        String clasificacionInternosSubgrupo
        String clasificacionInternos
        Integer numeroInternos
        Integer capacidadInternamiento
        
	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		centroPenitenciarioTipo nullable: true, maxSize: 200
		centroPenitenciario nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		internoGenero nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
                clasificacionInternosGrupo nullable: true
                clasificacionInternosSubgrupo nullable: true
                clasificacionInternos nullable: true
                numeroInternos nullable: true
                capacidadInternamiento nullable: true
	}
}
