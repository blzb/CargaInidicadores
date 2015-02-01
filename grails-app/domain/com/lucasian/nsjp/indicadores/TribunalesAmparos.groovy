package com.lucasian.nsjp.indicadores

class TribunalesAmparos {

	String nuc
	String tipoResolucion
	String tipoAmparo
	String municipio
	String distrito
	Integer año
	Integer mes
	Integer dia
        String numeroExpediente

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
                numeroExpediente nullable:true, maxSize: 200
		nuc nullable: true, maxSize: 200
		tipoResolucion nullable: true, maxSize: 200
		tipoAmparo nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
	}
}
