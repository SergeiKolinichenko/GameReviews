package info.sergeikolinichenko.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import info.sergeikolinichenko.R
import info.sergeikolinichenko.databinding.ActivityMainBinding
import info.sergeikolinichenko.ui.main.MainFragment

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .add(R.id.fragment_container_view, MainFragment())
        .commitAllowingStateLoss()
    }
  }
}