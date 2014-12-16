package com.lucasian.nsjp.indicadores

class PentahoStepLog {
        static searchable = true  
	String channelId
	Date logDate
	String transname
	String stepname
	Integer stepCopy
	Long linesRead
	Long linesWritten
	Long linesUpdated
	Long linesInput
	Long linesOutput
	Long linesRejected
	Long errores
        Long idBatch

	static mapping = {
		version false
                errores column: "ERRORS"
	}

	static constraints = {
		transname nullable: true
		stepname nullable: true
		logDate nullable: true
		linesWritten nullable: true
		errores nullable: true
		channelId nullable: true
		stepCopy nullable: true
		linesRead nullable: true
		linesUpdated nullable: true
		linesInput nullable: true
		linesOutput nullable: true
		linesRejected nullable: true
                idBatch nullable: true
	}
        public String toString(){
            stepname
        }
}
