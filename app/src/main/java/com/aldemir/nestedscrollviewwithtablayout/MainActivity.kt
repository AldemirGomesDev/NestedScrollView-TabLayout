package com.aldemir.nestedscrollviewwithtablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.aldemir.nestedscrollviewwithtablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTabLayout()
    }

    private fun setupTabLayout() {
        val myAdapter = TabsPagerAdapter(this)
        myAdapter.addFragment(BlankFragment.newInstance(getString(R.string.large_text)), getString(R.string.fragment_01))
        myAdapter.addFragment(BlankFragment.newInstance("Fragment 02"), getString(R.string.fragment_02))
        myAdapter.addFragment(BlankFragment.newInstance("Fragment 03"), getString(R.string.fragment_03))
        binding.viewpager.apply {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            currentItem = 0
            isUserInputEnabled = false
            adapter = myAdapter
        }
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = myAdapter.getTabTitle(position)
        }.attach()
    }
}