package com.lucasian.nsjp.indicadores

class TribunalesMedidasCautelares {

	String tipoMedida
	String statusMedida
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
		tipoMedida nullable: true, maxSize: 200
		statusMedida nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
	}
}
