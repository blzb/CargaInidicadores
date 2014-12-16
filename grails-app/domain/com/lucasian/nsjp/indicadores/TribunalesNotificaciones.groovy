package com.lucasian.nsjp.indicadores

class TribunalesNotificaciones {

	String statusNotificacion
	String nuc
	String tipoNotificacion
	Integer año
	Integer mes
	Integer dia
	String municipio
	String distrito
	String numeroExpediente

	static mapping = {
		id column: "id_fact"
		version false
                numeroExpediente column: "numeroExpediente"
	}

	static constraints = {
		statusNotificacion nullable: true, maxSize: 200
		nuc nullable: true, maxSize: 200
		tipoNotificacion nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		numeroExpediente nullable: true, maxSize: 200
	}
}
