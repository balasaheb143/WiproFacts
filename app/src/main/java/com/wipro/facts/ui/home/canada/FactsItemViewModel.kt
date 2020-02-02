package com.wipro.facts.ui.home.canada

import androidx.databinding.ObservableField
import com.wipro.facts.data.remote.RowsItem


class FactsItemViewModel(rowsItem: RowsItem) {

    val title: ObservableField<String?> = ObservableField(rowsItem.title)

    val description: ObservableField<String?> = ObservableField(rowsItem.description)

    val imageHref: ObservableField<String?> = ObservableField(rowsItem.imageHref)

}
