package com.lucasian.nsjp.indicadores

class ProcuraduriaDelitos {

	Integer dia
	Integer mes
	Integer año
	String entreCalle
	Double latitud
	Double longitud
	String numero
	String calle
	String colonia
	String municipio
	String imputadoGenero
	Integer imputadoEdad
	String imputadoEscolaridad
	String imputadoOcupacion
	String victimaGenero
	Integer victimaEdad
	String victimaEscolaridad
	String victimaOcupacion
	String tipoDelitoGrupo
	String tipoDelitoNombre
	String tipoDelitoSubgrupo
	String codigoPostal
	String nuc
	String modus
	String modalidad
	String victimaEstadoCivil
	String imputadoEstadoCivil
	String claveUnidad
	String nombreUnidad
	String distrito

	static mapping = {
                id column: "id_fact"
		version false
                claveUnidad column:"claveUnidad"
                nombreUnidad column:"nombreUnidad"                
	}

	static constraints = {
		dia nullable: false
		mes nullable: false
		año nullable: false
		entreCalle nullable: true, maxSize: 150
		latitud nullable: true, scale: 7
		longitud nullable: true, scale: 7
		numero nullable: true, maxSize: 100
		calle nullable: true, maxSize: 100
		colonia nullable: true, maxSize: 100
		municipio nullable: true, maxSize: 100
		imputadoGenero nullable: true, maxSize: 100
		imputadoEdad nullable: true
		imputadoEscolaridad nullable: true, maxSize: 100
		imputadoOcupacion nullable: true, maxSize: 100
		victimaGenero nullable: true, maxSize: 100
		victimaEdad nullable: true
		victimaEscolaridad nullable: true, maxSize: 100
		victimaOcupacion nullable: true, maxSize: 100
		tipoDelitoGrupo nullable: true, maxSize: 250
		tipoDelitoNombre nullable: true, maxSize: 250
		tipoDelitoSubgrupo nullable: true, maxSize: 250
		codigoPostal nullable: true, maxSize: 200
		nuc nullable: true, maxSize: 100
		modus nullable: true, maxSize: 250
		modalidad nullable: true, maxSize: 250
		victimaEstadoCivil nullable: true, maxSize: 100
		imputadoEstadoCivil nullable: true, maxSize: 100
		claveUnidad nullable: true, maxSize: 200
		nombreUnidad nullable: true, maxSize: 250
		distrito maxSize: 200
	}
}
