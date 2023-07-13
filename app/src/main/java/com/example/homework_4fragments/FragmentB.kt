package com.example.homework_4fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.homework_4fragments.databinding.FragmentBBinding

class FragmentB: Fragment() {

    private var _binding: FragmentBBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonToFragmentC.setOnClickListener {
                (requireActivity() as FragmentBClickListener).onNavToCClicked(PHRASE_TO_C_FRAGMENT)
            }
            buttonBack.setOnClickListener {
                (requireActivity() as FragmentBClickListener).onBackToAClicked()
            }
        }
    }

    interface FragmentBClickListener {
        fun onNavToCClicked(phrase: String)
        fun onBackToAClicked()
    }

    companion object {
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"
        const val PHRASE_TO_C_FRAGMENT = "Hello from FragmentB"
        fun newInstance() = FragmentB()
    }
}