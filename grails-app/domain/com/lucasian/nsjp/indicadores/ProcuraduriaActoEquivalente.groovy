package com.lucasian.nsjp.indicadores

class ProcuraduriaActoEquivalente {

	Double montoMulta
	String delitoGrupo
	String delitoSubgrupo
	String delito
	String municipio
	String distrito
	Integer año
	Integer mes
	Integer dia
	String delitoModalidad
	String delitoModus
	String nuc
	String unidadClave
	String unidadNombre

	static mapping = {
                id column: "id_fact"
		version false
                table "procuraduria_acto_equivaletne"
                unidadClave column:"unidadClave"
                unidadNombre column:"unidadNombre"
	}

	static constraints = {
		montoMulta nullable: true
		delitoGrupo nullable: true, maxSize: 200
		delitoSubgrupo nullable: true, maxSize: 200
		delito nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: true
		mes nullable: true
		dia nullable: true
		delitoModalidad nullable: true, maxSize: 100
		delitoModus nullable: true, maxSize: 100
		nuc nullable: true, maxSize: 200
		unidadClave nullable: true, maxSize: 200
		unidadNombre nullable: true, maxSize: 200
	}
}
