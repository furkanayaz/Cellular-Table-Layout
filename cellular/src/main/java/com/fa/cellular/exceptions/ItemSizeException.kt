package com.fa.cellular.exceptions

data class ItemSizeException(override val message: String = "ItemSizeException - Add a list equal to the header list size.") :
    Exception(message)
