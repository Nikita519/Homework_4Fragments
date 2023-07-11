package com.example.homework_4fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_4fragments.databinding.FragmentABinding

class FragmentA: Fragment() {

    interface FragmentAClickListener {
        fun onNavToBClicked()
    }

    private var _binding: FragmentABinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentABinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonToFragmentB.setOnClickListener {
            (requireActivity() as FragmentAClickListener).onNavToBClicked()
        }
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"

        @JvmStatic
        fun newInstance() = FragmentA()
    }
}