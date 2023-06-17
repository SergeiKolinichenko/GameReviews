package info.sergeikolinichenko.ui.main

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import info.sergeikolinichenko.databinding.ItemGameThinBinding
import info.sergeikolinichenko.databinding.ItemGameWideBinding
import info.sergeikolinichenko.databinding.ItemGamesHorizontalBinding
import info.sergeikolinichenko.databinding.ItemProgressThinBinding
import info.sergeikolinichenko.databinding.ItemProgressWideBinding
import info.sergeikolinichenko.models.base.ListItem
import info.sergeikolinichenko.models.game.*

/** Created by Sergei Kolinichenko on 14.06.2023 at 16:30 (GMT+3) **/

object MainScreenDelegates {

  val gamesHorizontalDelegates =
    adapterDelegateViewBinding<GamesHorizontalItem, ListItem, ItemGamesHorizontalBinding>(
      { inflater, container ->
        ItemGamesHorizontalBinding.inflate(inflater, container, false)
      }
    ) {
      // onCreateViewHolder
      binding.recycleView.adapter = ListDelegationAdapter(
        wideGameDelegate, thinGameDelegate, wideProgressDelegate, thinProgressDelegate
      )

      // onBindViewHolder
      bind {
        (binding.recycleView.adapter as ListDelegationAdapter<List<ListItem>>).apply {
          binding.tvTitleCategory.text = item.title
          items = item.games
          notifyDataSetChanged()
        }
      }

      // onViewRecycled
      onViewRecycled {
        // ...
      }
    }

  private val wideProgressDelegate = adapterDelegateViewBinding<ProgressWideItem, ListItem, ItemProgressWideBinding>(
    { inflater, container ->
      ItemProgressWideBinding.inflate(inflater, container, false)
    }) {}

  private val wideGameDelegate = adapterDelegateViewBinding<GameWideItem, ListItem, ItemGameWideBinding>(
    { inflater, container ->
      ItemGameWideBinding.inflate(inflater, container, false)
    }
  ) {
    bind {
      binding.imageView.setBackgroundColor(item.hashCode())
      binding.title = item.title
      binding.executePendingBindings()
    }
  }

  private val thinProgressDelegate = adapterDelegateViewBinding<ProgressThinItem, ListItem, ItemProgressThinBinding>(
    { inflater, container ->
      ItemProgressThinBinding.inflate(inflater, container, false)
    }) {}

  private val thinGameDelegate = adapterDelegateViewBinding<GameThinItem, ListItem, ItemGameThinBinding>(
    { inflater, container ->
      ItemGameThinBinding.inflate(inflater, container, false)
    }
  ) {
    bind {
      binding.imageView.setBackgroundColor(item.hashCode())
      binding.title = item.title
      binding.executePendingBindings()
    }
  }

}