package com.lucasian.nsjp.indicadores

class ComisionIphs {

	String agente
	String puesto
	String corporacion
	Integer año
	Integer mes
	Integer dia
	String municipio
	String distrito
	String tipoParticipacion
	String asunto
	String operativo
	String faltaAdministrativa
	String folioIph
	String calle
	String numero
	String entrecalle
	String colonia
	String delito
	String delitoGravedad
	String cnumeroEmpleado
	String cp
	Double latitud
	Double longitud

	static mapping = {
                id column: "id_fact"
		version false
                cnumeroEmpleado column: "cNumeroEmpleado"
                faltaAdministrativa column: "FaltaAdministrativa"
                tipoParticipacion column:"tipoParticipacion"
                folioIph column: "folioIPH"
	}
	static constraints = {
		agente nullable: true, maxSize: 200
		puesto nullable: true, maxSize: 200
		corporacion nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		tipoParticipacion nullable: true, maxSize: 200
		asunto nullable: true, maxSize: 200
		operativo nullable: true, maxSize: 200
		faltaAdministrativa nullable: true, maxSize: 200
		folioIph nullable: true, maxSize: 200
		calle nullable: true, maxSize: 200
		numero nullable: true, maxSize: 200
		entrecalle nullable: true, maxSize: 200
		colonia nullable: true, maxSize: 200
		delito nullable: true, maxSize: 200
		delitoGravedad nullable: true, maxSize: 200
		cnumeroEmpleado nullable: true, maxSize: 200
		cp nullable: true, maxSize: 200
	}
}
