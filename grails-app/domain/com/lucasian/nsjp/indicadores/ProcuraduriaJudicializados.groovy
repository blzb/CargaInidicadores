package com.lucasian.nsjp.indicadores

class ProcuraduriaJudicializados {

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
	String delitoGrupo
	String delitoSubgrupo
	String delitoNombre
	String nuc
	String municipio
	String distrito
	Integer año
	Integer mes
	Integer dia
	String delitoModalidad
	String delitoModus
	String unidadNombre
	String unidadClave

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
		delitoGrupo nullable: true, maxSize: 100
		delitoSubgrupo nullable: true, maxSize: 100
		delitoNombre nullable: true, maxSize: 100
		nuc nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		delitoModalidad nullable: true, maxSize: 100
		delitoModus nullable: true, maxSize: 100
		unidadNombre nullable: true, maxSize: 200
		unidadClave nullable: true, maxSize: 200
	}
}
