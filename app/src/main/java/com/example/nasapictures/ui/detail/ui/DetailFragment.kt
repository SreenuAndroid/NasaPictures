package com.example.nasapictures.ui.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nasapictures.R
import com.example.nasapictures.databinding.FragmentDetailBinding
import com.example.nasapictures.model.PictureFile
import com.example.nasapictures.ui.MainViewModel
import com.example.nasapictures.ui.detail.adapter.DetailsPagerAdapter

class DetailFragment : Fragment() {
    private lateinit var mMainViewModel: MainViewModel
    private lateinit var mBinding: FragmentDetailBinding

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, b: Bundle?): View {
        mMainViewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        mBinding = FragmentDetailBinding.inflate(i, c, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pictures: List<PictureFile> = mMainViewModel.mPictures.value ?: return

        mBinding.ivBack.setOnClickListener { findNavController().popBackStack() }

        mBinding.vpDetails.adapter = DetailsPagerAdapter(pictures) { pictureFile, position ->
            mMainViewModel.setPosition(position)
            findNavController()
                .navigate(R.id.action_navigation_details_to_full_picture, bundleOf().apply {
                    putParcelable("picture", pictureFile)
                }, null, null)
        }
        mBinding.vpDetails.post {
            mBinding.vpDetails.setCurrentItem(mMainViewModel.mCurrentPosition, false)
        }
    }
}