package com.example.nasapictures.ui.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nasapictures.R
import com.example.nasapictures.databinding.FragmentHomeBinding
import com.example.nasapictures.ui.MainViewModel
import com.example.nasapictures.ui.home.adapter.PicturesAdapter
import com.example.nasapictures.util.PictureDecoration

class HomeFragment : Fragment() {
    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, b: Bundle?): View {
        mMainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        mBinding = FragmentHomeBinding.inflate(i, c, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PicturesAdapter { list, position ->
            mMainViewModel.setPosition(position)
            findNavController().navigate(R.id.action_navigation_home_to_details, null, null, null)
        }
        mBinding.rvPictures.addItemDecoration(PictureDecoration(requireContext()))
        mBinding.rvPictures.adapter = adapter

        mMainViewModel.mPictures.observe(viewLifecycleOwner) {
            mBinding.progressBar.visibility = View.GONE
            adapter.setPicturesData(it)
        }

        mMainViewModel.fetchData(view.context.assets)
    }
}