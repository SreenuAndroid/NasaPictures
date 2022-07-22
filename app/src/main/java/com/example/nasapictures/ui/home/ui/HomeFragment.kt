package com.example.nasapictures.ui.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nasapictures.databinding.FragmentHomeBinding
import com.example.nasapictures.ui.home.adapter.PicturesAdapter
import com.example.nasapictures.util.PictureDecoration

class HomeFragment : Fragment() {
    private lateinit var mHomeViewModel: HomeViewModel
    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, b: Bundle?): View {
        mHomeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        mBinding = FragmentHomeBinding.inflate(i, c, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = PicturesAdapter()
        mBinding.rvPictures.addItemDecoration(PictureDecoration(requireContext()))
        mBinding.rvPictures.adapter = adapter

        mHomeViewModel.mPictures.observe(viewLifecycleOwner) {
            mBinding.progressBar.visibility = View.GONE
            adapter.setPicturesData(it)
        }

        mHomeViewModel.fetchData(view.context.assets)
    }
}