package com.lucasian.nsjp.indicadores

class TribunalesAudiencias {

	String etapa
	String tipoAudiencia
	String statusAudiencia
	Integer año
	Integer mes
	Integer dia
	String folioAudiencia
	String participante
	String rolParticipante
	String municipio
	String distrito
	String nuc
        String numeroExpediente

	static mapping = {
		id column: "id_fact"
		version false
                folioAudiencia column:"folioAudiencia"
                rolParticipante column:"rolParticipante"
	}

	static constraints = {
		etapa nullable: true, maxSize: 200
		tipoAudiencia nullable: true, maxSize: 200
		statusAudiencia nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		folioAudiencia nullable: true, maxSize: 200
		participante nullable: true, maxSize: 200
		rolParticipante nullable: true, maxSize: 200
		municipio maxSize: 200
		distrito maxSize: 200
		nuc nullable:true, maxSize: 200
                numeroExpediente nullable:true, maxSize: 200
	}
}
