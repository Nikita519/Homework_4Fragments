package com.example.homework_4fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.homework_4fragments.FragmentA.Companion.FRAGMENT_A_TAG
import com.example.homework_4fragments.FragmentB.Companion.FRAGMENT_B_TAG
import com.example.homework_4fragments.FragmentC.Companion.FRAGMENT_C_TAG
import com.example.homework_4fragments.FragmentD.Companion.FRAGMENT_D_TAG
import com.example.homework_4fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FragmentA.FragmentAClickListener,
    FragmentB.FragmentBClickListener, FragmentC.FragmentCClickListener,
    FragmentD.FragmentDClickListener{

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                   add(R.id.container, FragmentA.newInstance(), FRAGMENT_A_TAG)
                }
            }
        }

    override fun onNavToBClicked() {
        with(supportFragmentManager) {
            commit {
                replace(R.id.container, FragmentB.newInstance(), FRAGMENT_B_TAG)
                addToBackStack(FRAGMENT_A_TAG)
            }
        }
    }

    override fun onNavToCClicked(phrase: String) {
        with(supportFragmentManager) {
            commit {
                replace(R.id.container, FragmentC.newInstance(phrase), FRAGMENT_C_TAG)
                addToBackStack(FRAGMENT_B_TAG)
            }
        }
    }

    override fun onBackToAClicked() {
        supportFragmentManager.popBackStack()
    }

    override fun onNavToDClicked() {
        with(supportFragmentManager) {
            commit {
                replace(R.id.container, FragmentD.newInstance(), FRAGMENT_D_TAG)
                addToBackStack(FRAGMENT_C_TAG)
            }
        }
    }

    override fun onNavBackToAClicked() {
        supportFragmentManager
            .popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun onNavBackToBClicked() {
        supportFragmentManager
            .popBackStack(FRAGMENT_B_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}