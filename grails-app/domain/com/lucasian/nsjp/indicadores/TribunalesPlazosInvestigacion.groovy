package com.lucasian.nsjp.indicadores

class TribunalesPlazosInvestigacion {

	Integer plazoInvestigacionHora
	Integer aprobadoHora
	String nuc
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
		plazoInvestigacionHora nullable: true
		aprobadoHora nullable: true
		nuc nullable: true, maxSize: 200
                numeroExpediente nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
	}
}
