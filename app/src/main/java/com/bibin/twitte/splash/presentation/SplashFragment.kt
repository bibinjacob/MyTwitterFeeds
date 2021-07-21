package com.bibin.twitte.splash.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bibin.twitte.R
import com.bibin.twitte.base.presentation.BaseFragment
import com.bibin.twitte.base.presentation.BaseViewModel
import com.bibin.twitte.databinding.FragmentSplashBinding

class SplashFragment : BaseFragment() {

    private lateinit var binding: FragmentSplashBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        splashViewModel = ViewModelProvider(this, viewModelFactory).get(SplashViewModel::class.java)
        return binding.root
    }

    override fun setObservers() {
        splashViewModel.timerLiveData.observe(viewLifecycleOwner, Observer { timeOut ->

            if (timeOut) {
                findNavController().navigate(R.id.action_splash_to_fragmentTwiteeList)
            }
        })
    }

    override fun getViewModel(): BaseViewModel {
        return splashViewModel
    }

}