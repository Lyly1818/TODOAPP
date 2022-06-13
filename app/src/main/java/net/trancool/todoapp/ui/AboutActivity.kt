package net.trancool.todoapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.trancool.todoapp.R
import net.trancool.todoapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
// private lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    val binding : ActivityAboutBinding = ActivityAboutBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.toolbar.title = getString(R.string.app_name)

//        val path : String = Uri.parse("file:///android_asset/about.html").toString()
        binding.about.loadUrl("file:///android_asset/index.html") //TODO: error -> Unresolved reference: loadUrl
//        loadUrl("file:///android_asset/about.html")
    }
}