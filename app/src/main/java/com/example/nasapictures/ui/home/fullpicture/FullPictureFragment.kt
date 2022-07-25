package com.example.nasapictures.ui.fullpicture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.nasapictures.R
import com.example.nasapictures.databinding.FragmentFullPictureBinding
import com.example.nasapictures.model.PictureFile

class FullPictureFragment : Fragment() {
    private lateinit var mBinding: FragmentFullPictureBinding

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, b: Bundle?): View {
        mBinding = FragmentFullPictureBinding.inflate(i, c, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val picture: PictureFile = requireArguments().getParcelable("picture") ?: return

        mBinding.ivBack.setOnClickListener { findNavController().popBackStack() }

        mBinding.ivPictureFull.load(picture.hdUrl) {
            placeholder(R.drawable.ic_loading_animated)
        }
    }
}