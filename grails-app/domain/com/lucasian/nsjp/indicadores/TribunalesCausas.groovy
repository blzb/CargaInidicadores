package com.lucasian.nsjp.indicadores

class TribunalesCausas {

	String tipoDelitoGrupo
	String tipoDelitoModus
	String tipoDelitoModalidad
	String tipoDelitoSubgrupo
	String tipoDelito
	String nuc
	String victimaGenero
	Integer victimaEdad
	String victimaEscolaridad
	String victimaEstadoCivil
	String victimaOcupacion
	String imputadoGenero
	String numeroExpediente
	String imputadoEscolaridad
	String imputadoEstadoCivil
	String imputadoOcupacion
	Integer año
	Integer mes
	Integer dia
	String municipio
	String distrito
	Integer imputadoEdad

	static mapping = {
                id column: "id_fact"
		version false
                numeroExpediente column: "numeroExpediente"
	}

	static constraints = {
		tipoDelitoGrupo nullable: true, maxSize: 150
		tipoDelitoModus nullable: true, maxSize: 200
		tipoDelitoModalidad nullable: true, maxSize: 200
		tipoDelitoSubgrupo nullable: true, maxSize: 150
		tipoDelito nullable: true, maxSize: 150
		nuc nullable: true, maxSize: 200
		victimaGenero nullable: true, maxSize: 200
		victimaEdad nullable: true
		victimaEscolaridad nullable: true, maxSize: 150
		victimaEstadoCivil nullable: true, maxSize: 200
		victimaOcupacion nullable: true, maxSize: 200
		imputadoGenero nullable: true, maxSize: 200
		numeroExpediente nullable: true, maxSize: 200
		imputadoEscolaridad nullable: true, maxSize: 150
		imputadoEstadoCivil nullable: true, maxSize: 200
		imputadoOcupacion nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		imputadoEdad nullable: true
	}
}
