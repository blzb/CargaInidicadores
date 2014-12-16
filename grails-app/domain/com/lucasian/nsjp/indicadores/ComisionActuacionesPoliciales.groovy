package com.lucasian.nsjp.indicadores

class ComisionActuacionesPoliciales {

	String corporacion
	String tipoActuacion
	String tipoActuacionGrupo
	String tipoActuacionSubgrupo
	String municipio
	String distrito
	Integer año
	Integer mes
	Integer dia

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		corporacion nullable: true, maxSize: 200
		tipoActuacion nullable: true, maxSize: 200
		tipoActuacionGrupo nullable: true, maxSize: 200
		tipoActuacionSubgrupo nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
	}
}
