package com.lucasian.nsjp.indicadores

class ProcuraduriaJusticiaAlternativa {

	String imputadoGenero
	Integer imputadoEdad
	String imputadoEscolaridad
	String imputadoEstadoCivil
	String imputadoOcupacion
	String victimaGenero
	String victimaEdad
	String victimaEscolaridad
	String victimaOcupacion
	String victimaEstadoCivil
	String municipio
	String distrito
	String delitoGrupo
	String delitoSubgrupo
	String delito
	Integer añoIngreso
	Integer mesIngreso
	Integer diaIngreso
	Integer añoTermino
	Integer mesTermino
	Integer diaTermino
	String delitoModus
	String delitoModalidad
	String unidadNombre
	String unidadClave
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
		victimaEdad nullable: true, maxSize: 200
		victimaEscolaridad nullable: true, maxSize: 200
		victimaOcupacion nullable: true, maxSize: 200
		victimaEstadoCivil nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		delitoGrupo nullable: true, maxSize: 200
		delitoSubgrupo nullable: true, maxSize: 200
		delito nullable: true, maxSize: 200
		añoIngreso nullable: true
		mesIngreso nullable: true
		diaIngreso nullable: true
		añoTermino nullable: true
		mesTermino nullable: true
		diaTermino nullable: true
		delitoModus nullable: true, maxSize: 100
		delitoModalidad nullable: true, maxSize: 100
		unidadNombre maxSize: 200
		unidadClave maxSize: 200
		nuc maxSize: 200
	}
}
