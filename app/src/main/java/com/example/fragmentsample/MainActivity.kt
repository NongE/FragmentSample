package com.example.fragmentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fragmentsample.databinding.ActivityMainBinding

enum class FragmentInfo(val tag: String) {
    RED_FRAGMENT("red"),
    BLUE_FRAGMENT("blue")
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFragment(FragmentInfo.RED_FRAGMENT)

        binding.changeRedFragment.setOnClickListener {
            changeFragment(FragmentInfo.RED_FRAGMENT)
        }

        binding.changeBlueFragment.setOnClickListener {
            changeFragment(FragmentInfo.BLUE_FRAGMENT)
        }
    }

    private fun changeFragment(fragmentInfo: FragmentInfo) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(fragmentInfo.tag)

        Log.d("ASP", "${fragmentInfo.tag} Fragment is called")

        if (fragment == null) {
            Log.d("ASP", "Fragment with tag is null")

            fragment = when (fragmentInfo) {
                FragmentInfo.RED_FRAGMENT -> RedFragment()
                FragmentInfo.BLUE_FRAGMENT -> BlueFragment()
            }

            fragmentTransaction.add(R.id.frame, fragment, fragmentInfo.tag)
        }

        fragmentTransaction.show(fragment)

        FragmentInfo.values()
            .filterNot { it == fragmentInfo }
            .forEach {
                when (val pastFragment = supportFragmentManager.findFragmentByTag(it.tag)) {
                    null -> {
                        Log.d("ASP", "${it.tag} Fragment is null, pass")
                        return@forEach
                    }
                    else -> {
                        Log.d("ASP", "${it.tag} Fragment is not null, hide")
                        fragmentTransaction.hide(pastFragment)
                    }
                }
            }

        fragmentTransaction.commit()
    }
}
