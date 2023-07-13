package com.example.homework_4fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.homework_4fragments.databinding.FragmentCBinding

class FragmentC: Fragment() {

    private var _binding: FragmentCBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            buttonToFragmentD.setOnClickListener {
                (requireActivity() as FragmentCClickListener).onNavToDClicked()
            }
            buttonBack.setOnClickListener {
                (requireActivity() as FragmentCClickListener).onNavBackToAClicked()
            }
            textViewPhrase.text =
                arguments?.getString(PHRASE_EXTRA, ERROR_DEFAULT_TEXT)
        }
    }

    interface FragmentCClickListener {
        fun onNavToDClicked()
        fun onNavBackToAClicked()
    }

    companion object {
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"
        private const val PHRASE_EXTRA = "PHRASE_EXTRA"
        private const val ERROR_DEFAULT_TEXT = "Cant get $PHRASE_EXTRA from arguments"
        fun newInstance(phrase: String) = FragmentC().apply {
            arguments = bundleOf(PHRASE_EXTRA to phrase)
        }
    }
}