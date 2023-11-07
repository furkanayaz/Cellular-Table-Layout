package com.fa.cellular.models

data class Properties(
    var tableProperties: TableProperties = TableProperties(),
    var headerProperties: HeaderProperties = HeaderProperties(),
    var contentProperties: ContentProperties = ContentProperties()
)