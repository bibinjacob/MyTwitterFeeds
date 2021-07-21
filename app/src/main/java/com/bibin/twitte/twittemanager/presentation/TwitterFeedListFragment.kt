package com.bibin.twitte.twittemanager.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bibin.twitte.base.presentation.BaseFragment
import com.bibin.twitte.base.presentation.BaseViewModel
import com.bibin.twitte.databinding.FragmentTwitterFeedListBinding
import com.bibin.twitte.twittemanager.presentation.entity.MyTwitte

class TwitterFeedListFragment : BaseFragment() {
    lateinit var binding: FragmentTwitterFeedListBinding
    private lateinit var twitterFeedListViewModel: TwitterFeedListViewModel
    private lateinit var twitterListAdapter: TwitterFeedListAdapter
    private var myTwitteList = mutableListOf<MyTwitte>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwitterFeedListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        twitterFeedListViewModel =
            ViewModelProvider(this, viewModelFactory).get(TwitterFeedListViewModel::class.java)
        binding.twitterFeedListViewModel = twitterFeedListViewModel
        return binding.root
    }

    override fun getViewModel(): BaseViewModel {
        return twitterFeedListViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {
        twitterListAdapter = TwitterFeedListAdapter(myTwitteList)
        binding.recyclerViewTwitterFeedList.adapter = twitterListAdapter
        twitterFeedListViewModel.getMyTwitterFeeds()
    }

    override fun setObservers() {
        super.setObservers()
        twitterFeedListViewModel.twitterFeedsListObservable.observe(viewLifecycleOwner, Observer {
            twitterListAdapter.updateList(it)
        })
    }
}