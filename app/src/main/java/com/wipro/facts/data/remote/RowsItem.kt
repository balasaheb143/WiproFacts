import com.google.gson.annotations.SerializedName

data class RowsItem(

    @field:SerializedName("imageHref")
    val imageHref: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("title")
    val title: String? = null
)