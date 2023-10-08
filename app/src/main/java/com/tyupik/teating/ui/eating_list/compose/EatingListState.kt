package com.tyupik.teating.ui.eating_list.compose

import com.tyupik.teating.ui.eating_list.model.EatingItem

sealed class EatingListState {

    data class DataShowState(val items: List<EatingItem>) : EatingListState()
    object LoadingState : EatingListState()

}