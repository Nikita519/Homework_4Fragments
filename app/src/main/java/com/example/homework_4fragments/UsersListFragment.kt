package com.example.homework_4fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_4fragments.databinding.FragmentUsersListBinding

class UsersListFragment: Fragment(), UsersAdapter.OnListItemClickListener {

    private lateinit var usersAdapter: UsersAdapter
    private var _binding: FragmentUsersListBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        usersAdapter = UsersAdapter(Data.users, this)
        with(binding.recyclerViewUsers) {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false)
            adapter = usersAdapter
        }
    }

    interface EditUserClickListener {
        fun onEditUserClicked(user: User)
    }

    override fun onItemClicked(user: User) {
        (requireActivity() as EditUserClickListener).onEditUserClicked(user)
    }

    companion object {
        const val FRAGMENT_USERSLIST_TAG = "FRAGMENT_USERSLIST_TAG"
        fun newInstance() = UsersListFragment()
    }
}