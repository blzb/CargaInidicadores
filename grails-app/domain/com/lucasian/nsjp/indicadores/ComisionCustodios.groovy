package com.lucasian.nsjp.indicadores

class ComisionCustodios {

	String tipoCentroPenitenciario
	String centroPenitenciario
	String genero
	Integer enServicio
	Integer año
	Integer mes
	Integer dia
	String municipio
	String distrito
	Integer incapacitados
	Integer vacaciones
	Integer inasistencias
	Integer descanso
	Integer comisionados
	Integer enCursos
	Integer otrosPermisos
	Integer total

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		tipoCentroPenitenciario nullable: true, maxSize: 200
		centroPenitenciario nullable: true, maxSize: 200
		genero nullable: true, maxSize: 200
		enServicio nullable: true
		año nullable: true
		mes nullable: true
		dia nullable: true
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
	}
}
