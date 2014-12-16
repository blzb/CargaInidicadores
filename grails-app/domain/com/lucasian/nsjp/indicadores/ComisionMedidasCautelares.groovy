package com.lucasian.nsjp.indicadores

class ComisionMedidasCautelares {

	String solicitanteTipo
	String solicitanteNombre
	
	String status
	String tipoMedida
	Integer año
	Integer mes
	Integer dia
	String municipio
	String distrito

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		solicitanteTipo nullable: true, maxSize: 200
		solicitanteNombre nullable: true, maxSize: 200
		
		status nullable: true, maxSize: 200
		tipoMedida nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
	}
}
