package info.sergeikolinichenko.viewmodels.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import info.sergeikolinichenko.models.base.ListItem
import info.sergeikolinichenko.models.game.*
import info.sergeikolinichenko.viewmodels.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/** Created by Sergei Kolinichenko on 15.06.2023 at 21:13 (GMT+3) **/

class MainScreenViewModel: BaseViewModel() {

  private val _data = MutableLiveData<List<ListItem>>()
  val data: LiveData<List<ListItem>> = _data

  init {
    viewModelScope.launch {
      _data.value = getLoaders()
      delay(3000)
      _data.value = getItems()
    }

  }

  private fun getItems(): List<ListItem> {
    return listOf(
      GamesHorizontalItem(
        title = "Title Wide Items",
        games = IntRange(1,20).map { GameWideItem(id = it.toLong(), title = "Title $it") }),
      GamesHorizontalItem(
        title = "Title Thin Items",
        games = IntRange(1,20).map { GameThinItem(id = it.toLong(), title = "Title $it") }),
      GamesHorizontalItem(
        title = "Title Wide Items",
        games = IntRange(1,20).map { GameWideItem(id = it.toLong(), title = "Title $it") })
    )
  }

  private fun getLoaders(): List<ListItem> {

    return listOf(
      GamesHorizontalItem(
        title = "Title Wide Items",
        games = IntRange(1,2).map { ProgressWideItem }),
      GamesHorizontalItem(
        title = "Title Thin Items",
        games = IntRange(1,4).map { ProgressThinItem }),
      GamesHorizontalItem(
        title = "Title Wide Items",
        games = IntRange(1,2).map { ProgressThinItem })
    )
  }
}