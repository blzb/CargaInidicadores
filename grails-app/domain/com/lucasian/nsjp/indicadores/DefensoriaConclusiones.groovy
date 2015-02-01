package com.lucasian.nsjp.indicadores

class DefensoriaConclusiones {

	String defensor
	String puesto
	String distrito
	String municipio
	String conclusionGrupo
	String conclusionSubgrupo
	String conclusionNombre
	String etapaGrupo
	String etapaSubgrupo
	String etapaNombre
	Integer año
	Integer mes
	Integer dia
	Integer valor
        String numeroExpediente
        String nuc
        

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		defensor nullable: true, maxSize: 200
		puesto nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		conclusionGrupo nullable: true, maxSize: 200
		conclusionSubgrupo nullable: true, maxSize: 200
		conclusionNombre nullable: true, maxSize: 200
		etapaGrupo nullable: true, maxSize: 200
		etapaSubgrupo nullable: true, maxSize: 200
		etapaNombre nullable: true, maxSize: 200
                nuc nullable: true, maxSize: 200
                numeroExpediente nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
	}
}
