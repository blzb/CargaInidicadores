package com.lucasian.nsjp.indicadores

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class TablasExtraidas implements Serializable {

	String tabla
	String indicador
	String distrito
	Long ultimoId
	Date fechaActualizacion

	
	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		tabla maxSize: 200
		indicador maxSize: 100
		distrito maxSize: 200
	}
}
