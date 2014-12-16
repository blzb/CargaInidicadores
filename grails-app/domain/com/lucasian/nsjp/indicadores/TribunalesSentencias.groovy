package com.lucasian.nsjp.indicadores

class TribunalesSentencias {

	String nuc
	String tipoSentencia
	String causaEjecutoria
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
		nuc nullable: true, maxSize: 200
                numeroExpediente nullable: true, maxSize: 200
		tipoSentencia nullable: true, maxSize: 200
		causaEjecutoria nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
	}
}
