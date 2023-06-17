package info.sergeikolinichenko.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import info.sergeikolinichenko.R
import info.sergeikolinichenko.databinding.FragmentMainBinding
import info.sergeikolinichenko.ui.base.viewBinding
import info.sergeikolinichenko.viewmodels.main.MainScreenViewModel

/** Created by Sergei Kolinichenko on 13.06.2023 at 12:52 (GMT+3) **/

class MainFragment : Fragment(R.layout.fragment_main) {

  private val binding by viewBinding<FragmentMainBinding>()
  private val viewModel by viewModels<MainScreenViewModel>()

  private val adapter = ListDelegationAdapter(
    MainScreenDelegates.gamesHorizontalDelegates
  )

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.recycleView.adapter = adapter

    observeData()
  }

  private fun observeData() {
    viewModel.data.observe(viewLifecycleOwner) {
      adapter.apply {
        items = it
        notifyDataSetChanged()
      }
    }
  }
}