package com.lucasian.nsjp.indicadores

class ProcuraduriaTiempoAtencion {

	String ministerioTipo
	String ministerio
	String municipio
	String distrito
	String unidadProcuraduria
	Integer año
	Integer mes
	Integer dia
	Integer tiempoSegundos
	String claveUnidad

	static mapping = {
		version false
                id column: "id_fact"
	}

	static constraints = {
		ministerioTipo nullable: true, maxSize: 200
		ministerio nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		unidadProcuraduria nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		tiempoSegundos nullable: true
		claveUnidad nullable: true, maxSize: 200
	}
}
