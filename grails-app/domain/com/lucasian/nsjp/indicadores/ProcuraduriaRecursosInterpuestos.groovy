package com.lucasian.nsjp.indicadores

class ProcuraduriaRecursosInterpuestos {

	String tipoRecurso
	String ministerio
	Integer año
	Integer mes
	Integer dia
	String municipio
	String distrito
	String claveUnidad
	String nombreUnidad
	String nuc
	String ministerioGrupo

	static mapping = {
		version false
                id column: "id_fact"
                claveUnidad column:"claveUnidad"
                nombreUnidad column:"nombreUnidad"
                
	}

	static constraints = {
		tipoRecurso nullable: true, maxSize: 200
		ministerio nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		claveUnidad maxSize: 200
		nombreUnidad maxSize: 200
		nuc maxSize: 200
		ministerioGrupo maxSize: 200
	}
}
