package com.bibin.twitte.base.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bibin.twitte.R
import com.bibin.twitte.di.Injectable
import javax.inject.Inject

abstract class BaseFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    abstract fun getViewModel(): BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }
    protected open fun setObservers() {
        getViewModel().getResponseSuccessLiveData().observe(viewLifecycleOwner, Observer {
            it?.let { response ->
                if (!response.success) {
                    handleError(response)
                }
            }
        })
    }

    private fun handleError(response: Response) {
        Toast.makeText(context,getString(response.message?: R.string.unknown_error),Toast.LENGTH_SHORT).show()
    }

}