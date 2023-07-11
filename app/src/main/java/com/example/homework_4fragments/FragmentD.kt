package com.example.homework_4fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_4fragments.databinding.FragmentDBinding

class FragmentD: Fragment() {

    interface FragmentDClickListener {
        fun onNavBackToBClicked()
    }

    private var _binding: FragmentDBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToFragmentB.setOnClickListener {
            (requireActivity() as FragmentDClickListener).onNavBackToBClicked()
        }
    }

    companion object {
        const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"

        @JvmStatic
        fun newInstance() = FragmentD()
    }
}