package com.lucasian.nsjp.indicadores

class TribunalesSegundaInstancia {

	String salaPenal
	String tribunalDistrital
	String tipoResolucionNombre
	String tipoRecurso
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
		salaPenal nullable: true, maxSize: 200
		tribunalDistrital nullable: true, maxSize: 200
		tipoResolucionNombre nullable: true, maxSize: 200
		tipoRecurso nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
	}
}
