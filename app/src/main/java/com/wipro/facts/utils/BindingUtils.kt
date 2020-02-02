package com.wipro.facts.utils
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.wipro.facts.R
import com.wipro.facts.data.remote.RowsItem
import com.wipro.facts.ui.home.canada.FactsAdapter


object BindingUtils {

    @JvmStatic
    @BindingAdapter("adapter")
    fun addCanadaItems(recyclerView: RecyclerView, rowsItems: List<RowsItem>) {
        val adapter = recyclerView.adapter as FactsAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addItems(rowsItems)
        }
    }


    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String) {
        if (url.isNullOrBlank()) {
            imageView.visibility = View.GONE
        } else {
            val context = imageView.context
            Glide.with(context)
                .load(url).apply(
                    RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.error_holder).placeholder(
                        R.drawable.place_holder
                    )
                )
                .override(
                    com.bumptech.glide.request.target.Target.SIZE_ORIGINAL,
                    com.bumptech.glide.request.target.Target.SIZE_ORIGINAL
                )
                .into(imageView)
        }
    }

}// This class is not publicly instantiable
