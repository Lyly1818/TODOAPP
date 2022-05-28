package net.trancool.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebViewClient
import net.trancool.todoapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.toolbar.title = getString(R.string.app_name)
        binding.about.loadUrl("file:///android_asset/about.html") //TODO: error -> Unresolved reference: loadUrl
//        loadUrl("file:///android_asset/about.html")
    }
}