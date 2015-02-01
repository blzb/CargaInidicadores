package com.lucasian.nsjp.indicadores

class ProcuraduriaDeterminaciones {

	String imputadoGenero
	String imputadoEdad
	String imputadoEscolaridad
	String imputadoOcupacion
	String nuc
	String municipio
	String distrito
	String tipoDaterminacionNombre
	Integer año
	Integer mes
	Integer dia
	String imputadoEstadoCivil
	String victimaGenero
	Integer victimaEdad
	String victimaEstadoCivil
	String victimaEscolaridad
	String victimaOcupacion
	String delitoGrupo
	String delitoSubgrupo
	String delitoNombre
	String delitoModus
	String delitoModalidad
	String unidadClave
	String unidadNombre
	String funcionarioNombre
	String funcionarioPuesto
	String funcionarioUnidad
	String funcionarioInstitucion

	static mapping = {
		version false
                unidadClave column:"unidadClave"
                unidadNombre column:"unidadNombre"
                funcionarioNombre column:"funcionarioNombre"
                funcionarioPuesto column:"funcionarioPuesto"
                funcionarioUnidad column:"funcionarioUnidad"
                funcionarioInstitucion column: "funcionarioInstitucion"
                id column: "id_fact"
                
	}

	static constraints = {
		imputadoGenero nullable: true, maxSize: 200
		imputadoEdad nullable: true, maxSize: 200
		imputadoEscolaridad nullable: true, maxSize: 200
		imputadoOcupacion nullable: true, maxSize: 200
		nuc nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		tipoDaterminacionNombre nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
		imputadoEstadoCivil nullable: true, maxSize: 200
		victimaGenero nullable: true, maxSize: 200
		victimaEdad nullable: true
		victimaEstadoCivil nullable: true, maxSize: 100
		victimaEscolaridad nullable: true, maxSize: 100
		victimaOcupacion nullable: true, maxSize: 100
		delitoGrupo nullable: true, maxSize: 200
		delitoSubgrupo nullable: true, maxSize: 200
		delitoNombre nullable: true, maxSize: 200
		delitoModus nullable: true, maxSize: 200
		delitoModalidad nullable: true, maxSize: 200
		unidadClave nullable: true, maxSize: 100
		unidadNombre nullable: true, maxSize: 200
		funcionarioNombre nullable: true, maxSize: 200
		funcionarioPuesto nullable: true, maxSize: 200
		funcionarioUnidad nullable: true, maxSize: 200
		funcionarioInstitucion nullable: true, maxSize: 200
	}
}
 