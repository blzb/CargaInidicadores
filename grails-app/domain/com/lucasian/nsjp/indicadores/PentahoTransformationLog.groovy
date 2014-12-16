package com.lucasian.nsjp.indicadores

class PentahoTransformationLog {
        static searchable = true  
	String channelId
	String transname
	String status
	Long linesRead
	Long linesWritten
	Long linesUpdated
	Long linesInput
	Long linesOutput
	Long linesRejected
	Long errores
	Date startdate
	Date enddate
	Date logdate
	Date depdate
	Date replaydate
	String logField
        Long idBatch
        
	static mapping = {
		version false
                errores column: "ERRORS"                
	}

	static constraints = {
		transname nullable: true
		status nullable: true, maxSize: 15
		startdate nullable: true
		enddate nullable: true
		errores nullable: true
		channelId nullable: true
		linesRead nullable: true
		linesWritten nullable: true
		linesUpdated nullable: true
		linesInput nullable: true
		linesOutput nullable: true
		linesRejected nullable: true
		logdate nullable: true
		depdate nullable: true
		replaydate nullable: true
                idBatch nullable: true
		logField nullable: true, maxSize:2147483646
	}
}
