package com.lucasian.nsjp.indicadores

class ProcuraduriaDetenidos {

	String imputadoGenero
	Integer imputadoEdad
	String imputadoEscolaridad
	String imputadoEstadoCivil
	String imputadoOcupacion
	String estado
	String municipio
	String colonia
	String calle
	String entrecalle
	String numero
	Long latitud
	Long longitud
	String codigoPostal
	String corporacion
	String conclusionNombre
	Integer añor
	Integer mes
	Integer dia
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
		estado nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		colonia nullable: true, maxSize: 200
		calle nullable: true, maxSize: 200
		entrecalle nullable: true, maxSize: 200
		numero nullable: true, maxSize: 200
		latitud nullable: true
		longitud nullable: true
		codigoPostal nullable: true, maxSize: 200
		corporacion nullable: true, maxSize: 200
		conclusionNombre nullable: true, maxSize: 200
		añor nullable: true
		mes nullable: false
		dia nullable: false
		distrito nullable: true, maxSize: 200
		unidadClave nullable: true, maxSize: 200
		unidadNombre nullable: true, maxSize: 200
		nuc nullable: true, maxSize: 200
	}
}
