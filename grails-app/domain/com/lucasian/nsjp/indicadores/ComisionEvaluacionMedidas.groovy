package com.lucasian.nsjp.indicadores

class ComisionEvaluacionMedidas {

	String tipoResultado
	String municipio
	String distrito
	String codigoPostal
	Integer año
	Integer mes
	Integer dia

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		tipoResultado nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		codigoPostal nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
	}
}
