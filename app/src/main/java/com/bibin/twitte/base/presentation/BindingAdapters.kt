package com.bibin.twitte.base.presentation

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun setProgressBarVisibility(view: View, status: Status?) {
    view.visibility = if (status == Status.Loading) View.VISIBLE else View.GONE
}