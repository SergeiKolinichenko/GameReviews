package info.sergeikolinichenko.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import info.sergeikolinichenko.R
import info.sergeikolinichenko.databinding.FragmentMainBinding
import info.sergeikolinichenko.ui.base.viewBinding

/** Created by Sergei Kolinichenko on 13.06.2023 at 12:52 (GMT+3) **/

class MainFragment: Fragment(R.layout.fragment_main) {

  private val binding by viewBinding<FragmentMainBinding>()

//  override fun onCreateView(
//    inflater: LayoutInflater,
//    container: ViewGroup?,
//    savedInstanceState: Bundle?
//  ): View {
//    binding = FragmentMainBinding.inflate(layoutInflater, container, false)
//    return binding.root
//  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
  }
}