package com.lucasian.nsjp.indicadores

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class TablasExtraidas implements Serializable {

	String tabla
	String indicador
	String distrito
	Long ultimoId
	Date fechaActualizacion

	int hashCode() {
		def builder = new HashCodeBuilder()
		builder.append tabla
		builder.append indicador
		builder.append distrito
		builder.toHashCode()
	}

	boolean equals(other) {
		if (other == null) return false
		def builder = new EqualsBuilder()
		builder.append tabla, other.tabla
		builder.append indicador, other.indicador
		builder.append distrito, other.distrito
		builder.isEquals()
	}

	static mapping = {
		id composite: ["tabla", "indicador", "distrito"]
		version false
	}

	static constraints = {
		tabla maxSize: 200
		indicador maxSize: 100
		distrito maxSize: 200
	}
}
