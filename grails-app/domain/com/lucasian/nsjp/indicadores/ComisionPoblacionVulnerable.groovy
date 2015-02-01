package com.lucasian.nsjp.indicadores

class ComisionPoblacionVulnerable {

	String centroPenitenciario
	String centroPenitenciarioTipo
	String distrito
	String tipoInterno
	String tipoInternoGrupo
	String tipoInternoSubgrupo
	String municipio
	Integer año
	Integer mes
	Integer dia
	Integer numero
	String situacionJuridca
	String situacionJuridicaGrupo

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		centroPenitenciario nullable: true, maxSize: 200
		centroPenitenciarioTipo nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		tipoInterno nullable: true, maxSize: 150
		tipoInternoGrupo nullable: true, maxSize: 200
		tipoInternoSubgrupo nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
		situacionJuridca maxSize: 200
		situacionJuridicaGrupo maxSize: 200
	}
}
