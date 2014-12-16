package com.lucasian.nsjp.indicadores

class ProcuraduriaAtencionVictimas {

	String imputadoGenero
	Integer imputadoEdad
	String imputadoEscolaridad
	String imputadoEstadoCivil
	String imputadoOcupacion
	String victimaGenero
	Integer victimaEdad
	String victimaEscolaridad
	String victimaEstadoCivil
	String victimaOcupacion
	String tipoAtencion
	Integer año
	Integer mes
	Integer dia
	String municipio
	String distrito
	String unidadClave
	String unidadNombre
	String nuc

	static mapping = {
		id column: "id_fact"
		version false
                unidadClave column:"unidadClave"
                unidadNombre column:"unidadNombre"
                
	}

	static constraints = {
		imputadoGenero nullable: true, maxSize: 200
		imputadoEdad nullable: true
		imputadoEscolaridad nullable: true, maxSize: 200
		imputadoEstadoCivil nullable: true, maxSize: 200
		imputadoOcupacion nullable: true, maxSize: 200
		victimaGenero nullable: true, maxSize: 200
		victimaEdad nullable: true
		victimaEscolaridad nullable: true, maxSize: 200
		victimaEstadoCivil nullable: true, maxSize: 200
		victimaOcupacion nullable: true, maxSize: 200
		tipoAtencion nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		unidadClave maxSize: 200
		unidadNombre maxSize: 200
		nuc maxSize: 200
	}
}
