function NumCheck(e, field, dec) {
    key = e.keyCode ? e.keyCode : e.which
    // backspace
    if (key == 8) return true

    // 0-9 a partir del .decimal  
    if (field.value != "") {
        if (dec) {
            if ((field.value.indexOf(",")) > 0) {
                //si tiene un punto valida dos digitos en la parte decimal
                if (key > 47 && key < 58) {
                    if (field.value == "") return true
                    //regexp = /[0-9]{1,10}[\.][0-9]{1,3}$/
                    regexp = /[0-9]{6}$/
                    return !(regexp.test(field.value))
                }
            }
            // ,
            if (key == 44) {
                if (field.value == "") return false
                regexp = /^[0-9]+$/
                return regexp.test(field.value)
            }
        }
    }
    // 0-9 
    if (key > 47 && key < 58 || key == 9) {
        if (field.value == "") return true
        regexp = /[0-9]{15}/
        return !(regexp.test(field.value))
    }
    // other key
    return false
}

