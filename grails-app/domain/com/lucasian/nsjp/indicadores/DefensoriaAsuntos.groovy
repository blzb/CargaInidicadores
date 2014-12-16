package com.lucasian.nsjp.indicadores

class DefensoriaAsuntos {

	String defensor
	String puesto
	String etapaGrupo
	String etapaSubgrupo
	String etapaNombre
	String nuc
        String distrito
        String numeroExpediente
	String municipio
	Integer año
	Integer mes
	Integer dia
	Integer valor        
	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		defensor nullable: true, maxSize: 200
		puesto nullable: true, maxSize: 200
		etapaGrupo nullable: true, maxSize: 200
		etapaSubgrupo nullable: true, maxSize: 200
		etapaNombre nullable: true, maxSize: 200
		nuc nullable: true, maxSize: 200
                numeroExpediente nullable:true, maxSize: 200
                distrito nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
                
	}
}
