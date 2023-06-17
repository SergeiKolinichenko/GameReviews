package info.sergeikolinichenko.models.game

import info.sergeikolinichenko.models.base.ListItem

/** Created by Sergei Kolinichenko on 14.06.2023 at 21:46 (GMT+3) **/

data class GameThinItem(
   val id: Long,
   val title: String
): ListItem
