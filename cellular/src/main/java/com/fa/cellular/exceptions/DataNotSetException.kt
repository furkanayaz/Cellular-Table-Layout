package com.fa.cellular.exceptions

internal data class DataNotSetException(
    override val message: String = "DataNotSetException - Please set header and content elements with string list."
) : Exception(message)