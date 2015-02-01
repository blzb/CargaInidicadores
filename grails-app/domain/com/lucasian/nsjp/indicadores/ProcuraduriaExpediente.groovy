package com.lucasian.nsjp.indicadores

class ProcuraduriaExpediente {

	String funcionario
	String puesto
	String institucion
	String unidad
	String municipio
	String distrito
	Integer año
	Integer mes
	Integer dia
	String estatus
	String etapa
	String nuc
	String unidadClave

	static mapping = {
                id column: "id_fact"
		version false
                unidadClave column:"unidadClave"
                unidadNombre column:"unidadNombre"
                
	}

	static constraints = {
		funcionario nullable: true, maxSize: 150
		puesto nullable: true, maxSize: 150
		institucion nullable: true, maxSize: 150
		unidad nullable: true, maxSize: 150
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
		estatus nullable: true, maxSize: 150
		etapa maxSize: 150
		nuc maxSize: 200
		unidadClave nullable: true, maxSize: 200
	}
}
