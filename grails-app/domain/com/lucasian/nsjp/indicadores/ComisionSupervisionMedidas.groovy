package com.lucasian.nsjp.indicadores

class ComisionSupervisionMedidas {

	String tipoDelitoGrupo
	String tipoDelitoSubgrupo
	String tipoDelito
	String tipoMedida
	String statusSupervicion
	String estado
	String municipio
	String distrito
	String colonia
	String codigoPostal
	Integer año
	Integer mes
	Integer dia

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		tipoDelitoGrupo nullable: true, maxSize: 200
		tipoDelitoSubgrupo nullable: true, maxSize: 200
		tipoDelito nullable: true, maxSize: 200
		tipoMedida nullable: true, maxSize: 200
		statusSupervicion nullable: true, maxSize: 200
		estado nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		colonia nullable: true, maxSize: 200
		codigoPostal nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
	}
}
