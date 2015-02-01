package com.lucasian.nsjp.indicadores

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder

class DefensoriaAtenciones implements Serializable {

	String solicitanteGrupo
	String solicitanteSubgrupo
	String solicitanteNombre
	Integer año
	Integer mes
	Integer dia
	String tipoAtencionGrupo
	String tipoAtencionSubgrupo
	String tipoAtencionNombre
	String distritoJudicial
	String municipio
	Integer valor

	static mapping = {
		id column: "id_fact"
		version false
	}

	static constraints = {
		solicitanteGrupo nullable: true, maxSize: 200
		solicitanteSubgrupo nullable: true, maxSize: 200
		solicitanteNombre nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
		tipoAtencionGrupo nullable: true, maxSize: 200
		tipoAtencionSubgrupo nullable: true, maxSize: 200
		tipoAtencionNombre nullable: true, maxSize: 200
		distritoJudicial nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
	}
}
