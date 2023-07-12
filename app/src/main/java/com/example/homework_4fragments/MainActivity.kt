package com.example.homework_4fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.homework_4fragments.UserEditFragment.Companion.FRAGMENT_USEREDIT_TAG
import com.example.homework_4fragments.UsersListFragment.Companion.FRAGMENT_USERSLIST_TAG
import com.example.homework_4fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UsersListFragment.EditUserClickListener
, UserEditFragment.UserEditedListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, UsersListFragment.newInstance(), FRAGMENT_USERSLIST_TAG)
                .commit()
        }
    }

    override fun onEditUserClicked(user: User) {
        with(supportFragmentManager) {
            commit {
                replace(R.id.container, UserEditFragment.newInstance(user), FRAGMENT_USEREDIT_TAG)
                addToBackStack(FRAGMENT_USERSLIST_TAG)
            }
        }
    }

    override fun onUserEdited(user: User) {
        Data.updateUser(user)
        supportFragmentManager.popBackStack()
    }
}