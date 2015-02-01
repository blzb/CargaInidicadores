package com.lucasian.nsjp.indicadores

class TribunalesBeneficios {

	String sentenciadoNombre
	String sentenciadoGenero
	String sentenciadoEscolaridad
	String sentenciadoEdad
	String sentenciadoOcupacion
	String nuc
	String tipoBeneficio
	String status
	String municipio
	String distrito
	Integer año
	Integer mes
	Integer dia
        String numeroExpediente

	static mapping = {
		id column: "id_fact"
		version false
                numeroExpediente column: "numeroExpediente"
	}

	static constraints = {
		sentenciadoNombre nullable: true, maxSize: 200
		sentenciadoGenero nullable: true, maxSize: 200
		sentenciadoEscolaridad nullable: true, maxSize: 200
		sentenciadoEdad nullable: true, maxSize: 200
		sentenciadoOcupacion nullable: true, maxSize: 200
		nuc nullable: true, maxSize: 200
		tipoBeneficio nullable: true, maxSize: 200
		status nullable: true, maxSize: 200
		municipio nullable: true, maxSize: 200
		distrito nullable: true, maxSize: 200
		año nullable: false
		mes nullable: false
		dia nullable: false
                numeroExpediente nullable: true, maxSize: 200
	}
}
