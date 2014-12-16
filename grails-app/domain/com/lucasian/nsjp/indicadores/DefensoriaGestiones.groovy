package com.lucasian.nsjp.indicadores

class DefensoriaGestiones {

	String defensor
	String puesto
	String distrito
	String nuc
	String etapaSubgrupo
	String etapaGrupo
	String etapaNombre
	String tipoGestionGrupo
	String tipoGestionSubgrupo
	String tipoGestionNombre
	Integer año
	Integer mes
	Integer dia
	String municipio
	Integer valor
        String numeroExpediente

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		defensor nullable: true, maxSize: 200
		puesto nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		nuc nullable: true, maxSize: 200
                numeroExpediente nullable:true, maxSize: 200
		etapaSubgrupo nullable: true, maxSize: 200
		etapaGrupo nullable: true, maxSize: 200
		etapaNombre nullable: true, maxSize: 200
		tipoGestionGrupo nullable: true, maxSize: 200
		tipoGestionSubgrupo nullable: true, maxSize: 200
		tipoGestionNombre nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		municipio nullable: true, maxSize: 200
	}
}
