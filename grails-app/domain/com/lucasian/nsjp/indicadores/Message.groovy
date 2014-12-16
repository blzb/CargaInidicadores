package com.lucasian.nsjp.indicadores

class Message  implements Serializable {
    String code
    String text
    static constraints = {
        code nullable:false
        text nullable:false
    }
}
