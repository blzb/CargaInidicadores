package com.lucasian.nsjp.indicadores

class ComisionProgramasIndividualizados {

	String centroPenitenciario
	String centroPenitenciarioTipo
	String distrito
	String municipio
	String tipoPrograma
	String tipoProgramaSubgrupo
	String tipoProgramaGrupo
	Integer año
	Integer mes
	Integer semana
	Integer valor

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		centroPenitenciario nullable: true, maxSize: 200
		centroPenitenciarioTipo nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		tipoPrograma nullable: true, maxSize: 100
		tipoProgramaSubgrupo nullable: true, maxSize: 100
		tipoProgramaGrupo nullable: true, maxSize: 100
		año nullable: true
		mes nullable: true
		semana nullable: true
	}
}
