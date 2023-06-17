package info.sergeikolinichenko.models.game

import info.sergeikolinichenko.models.base.ListItem

/** Created by Sergei Kolinichenko on 14.06.2023 at 19:17 (GMT+3) **/

data class GamesHorizontalItem(
  val title: String,
  val games: List<ListItem>
) : ListItem