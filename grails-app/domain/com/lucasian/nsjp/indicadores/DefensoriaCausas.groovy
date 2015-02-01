package com.lucasian.nsjp.indicadores

class DefensoriaCausas {

	String defensor
	String puesto
	String municipio
	String distrito
	Integer año
	Integer mes
	Integer dia
	String nuc
	String numeroCausa
	String impGenero
	Integer impEdad
	String impEscolaridad
	String impEstadoCivil
	String impOcupacion
	String tipoDelito
	String tipoDelitoModus
	String tipoDelitoModalidad
	String tipoDelitoGrupo
	String tipoDelitoSubgrupo

	static mapping = {
		id column: "id_fact"
		version false
                numeroCausa column : "numeroCausa"
	}

	static constraints = {
		defensor nullable: true, maxSize: 200
		puesto nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
		nuc nullable: true, maxSize: 200
		numeroCausa maxSize: 200
		impGenero nullable: true, maxSize: 200
		impEdad nullable: true
		impEscolaridad nullable: true, maxSize: 200
		impEstadoCivil nullable: true, maxSize: 200
		impOcupacion nullable: true, maxSize: 200
		tipoDelito nullable: true, maxSize: 200
		tipoDelitoModus nullable: true, maxSize: 200
		tipoDelitoModalidad nullable: true, maxSize: 200
		tipoDelitoGrupo nullable: true, maxSize: 200
		tipoDelitoSubgrupo nullable: true, maxSize: 200
	}
}
