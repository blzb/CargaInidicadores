package com.lucasian.nsjp.indicadores

class ComisionDetenidos {

	String corporacion
	String imputadoGenero
	Integer imputadoEdad
	String imputadoEscolaridad
	String imputadoEstadoCivil
	String imputadoOcupacion
	String municipio
	String colonia
	String codigoPostal
	String calle
	String entrecalle
	String numero
	Double latitud
	Double longitud
	Integer año
	Integer mes
	Integer dia
	String distrito

	static mapping = {
		id column: "id_fact"
		version false
                table "comisiones_detenidos"
	}

	static constraints = {
		corporacion nullable: true, maxSize: 200
		imputadoGenero nullable: true, maxSize: 200
		imputadoEdad nullable: true
		imputadoEscolaridad nullable: true, maxSize: 200
		imputadoEstadoCivil nullable: true, maxSize: 200
		imputadoOcupacion nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		colonia nullable: true, maxSize: 200
		codigoPostal nullable: true, maxSize: 200
		calle nullable: true, maxSize: 200
		entrecalle nullable: true, maxSize: 200
		numero nullable: true, maxSize: 200
		latitud nullable: true
		longitud nullable: true
		año nullable: true
		mes nullable: true
		dia nullable: true
		distrito nullable: true, maxSize: 200
	}
}
