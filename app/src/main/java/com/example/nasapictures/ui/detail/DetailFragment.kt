package com.example.nasapictures.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.nasapictures.R
import com.example.nasapictures.databinding.FragmentDetailBinding
import com.example.nasapictures.model.PictureFile
import com.example.nasapictures.util.BackgroundTransitionGenerator

class DetailFragment : Fragment() {
    private lateinit var mBinding: FragmentDetailBinding

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, b: Bundle?): View {
        mBinding = FragmentDetailBinding.inflate(i, c, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val picture: PictureFile = requireArguments().getParcelable("picture") ?: return

        mBinding.ivBack.setOnClickListener { findNavController().popBackStack() }
        mBinding.ivMaximize.setOnClickListener { findNavController().popBackStack() }

        mBinding.tvTitle.text = picture.title
        mBinding.tvCopyright.text = picture.copyright
        mBinding.tvDate.text = picture.date
        mBinding.tvExplanation.text = picture.explanation

        mBinding.ivPictureDetail.apply {
            setTransitionGenerator(BackgroundTransitionGenerator().apply {
                setMinRectFactor(1F)
                setTransitionGenerator(10000, LinearInterpolator())
            })
            load(picture.hdUrl) {
                placeholder(R.drawable.ic_loading_animated)
            }
        }

    }
}