import com.google.gson.annotations.SerializedName

data class FactsOutputModel(

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("rows")
    var rows: List<RowsItem>
)