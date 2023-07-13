package com.example.homework_4fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.homework_4fragments.databinding.FragmentUserEditBinding
import com.example.homework_4fragments.databinding.FragmentUsersListBinding

class UserEditFragment: Fragment() {

    private var _binding: FragmentUserEditBinding? = null
    private val binding get() = _binding!!
    private lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         user = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             requireArguments().getParcelable(USER_EXTRA, User::class.java)
         } else {
             requireArguments().getParcelable(USER_EXTRA)
         } ?: throw RuntimeException("User is null")

        with(binding) {
            Glide.with(imageViewPhoto.context)
                .load(user.photo)
                .into(imageViewPhoto)
            editTextName.setText(user.name)
            editTextLastname.setText(user.lastname)
            editTextPhone.setText(user.phone)
            buttonSave.setOnClickListener {
                (requireActivity() as UserEditedListener).onUserEdited(
                    User(
                        id = user.id,
                        photo = user.photo,
                        name = editTextName.text.toString(),
                        lastname = editTextLastname.text.toString(),
                        phone = editTextPhone.text.toString()
                    )
                )
            }
        }
    }

    interface UserEditedListener {
        fun onUserEdited(user: User)
    }

    companion object {
        const val FRAGMENT_USEREDIT_TAG = "FRAGMENT_USEREDIT_TAG"
        private const val USER_EXTRA = "USER_EXTRA"
        fun newInstance(user: User) = UserEditFragment().apply {
            arguments = bundleOf(USER_EXTRA to user)
        }
    }
}