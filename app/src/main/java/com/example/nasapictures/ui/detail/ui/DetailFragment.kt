package com.example.nasapictures.ui.detail.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.nasapictures.databinding.FragmentDetailBinding
import com.example.nasapictures.model.PictureFile
import com.example.nasapictures.ui.detail.adapter.DetailsPagerAdapter

class DetailFragment : Fragment() {
    private lateinit var mBinding: FragmentDetailBinding

    override fun onCreateView(i: LayoutInflater, c: ViewGroup?, b: Bundle?): View {
        mBinding = FragmentDetailBinding.inflate(i, c, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pictures: ArrayList<PictureFile> =
            requireArguments().getParcelableArrayList("pictures_list") ?: return
        val position = requireArguments().getInt("position")

        mBinding.ivBack.setOnClickListener { findNavController().popBackStack() }

        mBinding.vpDetails.adapter = DetailsPagerAdapter(pictures)
        mBinding.vpDetails.post {
            mBinding.vpDetails.setCurrentItem(position, false)
        }
    }
}