package com.lucasian.nsjp.indicadores

class ProcuraduriaInvestigaciones {

	String unidadInvestigacion
	String municipio
	String distrito
	Integer año
	Integer mes
	Integer dia
	String claveUnidad
	String nombreUnidad
	String nuc
	String claveUnidadInvestigacion

	static mapping = {
                id column: "id_fact"
		version false
                claveUnidad column:"claveUnidad"
                nombreUnidad column:"nombreUnidad"
                
	}

	static constraints = {
		unidadInvestigacion nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
		claveUnidad maxSize: 200
		nombreUnidad maxSize: 200
		nuc maxSize: 200
		claveUnidadInvestigacion maxSize: 200
	}
}
