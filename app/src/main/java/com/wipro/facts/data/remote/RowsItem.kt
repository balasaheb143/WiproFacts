package com.wipro.facts.data.remote

import com.google.gson.annotations.SerializedName

data class RowsItem(

    @field:SerializedName("imageHref")
    var imageHref: String? = null,

    @field:SerializedName("description")
    var description: String? = null,

    @field:SerializedName("title")
    var title: String? = null
)
