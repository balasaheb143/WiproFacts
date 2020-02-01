import androidx.databinding.ObservableField


class FactsItemViewModel(rowsItem: RowsItem) {

    val title: ObservableField<String?> = ObservableField(rowsItem.title)

    val description: ObservableField<String?> = ObservableField(rowsItem.description)

    val imageHref: ObservableField<String?> = ObservableField(rowsItem.imageHref)

}
