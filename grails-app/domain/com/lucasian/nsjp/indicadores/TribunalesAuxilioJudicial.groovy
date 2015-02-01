package com.lucasian.nsjp.indicadores

class TribunalesAuxilioJudicial {

	String estadoOrigen
	String municipioOrigen
	String distritoOrigen
	String estadoDestino
	String municipioDestino
	String distritoDestino
	String tipoAuxilioGrupo
	String tipoAuxilioNombre
	Integer año
	Integer mes
	Integer dia
	Integer semana

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		estadoOrigen nullable: true, maxSize: 200
		municipioOrigen nullable: true, maxSize: 200
		distritoOrigen nullable: true, maxSize: 200
		estadoDestino nullable: true, maxSize: 200
		municipioDestino nullable: true, maxSize: 200
		distritoDestino nullable: true, maxSize: 200
		tipoAuxilioGrupo nullable: true, maxSize: 200
		tipoAuxilioNombre nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
	}
}
