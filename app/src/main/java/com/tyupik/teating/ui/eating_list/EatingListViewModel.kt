package com.tyupik.teating.ui.eating_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tyupik.teating.business.EatingListInteractor
import com.tyupik.teating.ui.eating_list.compose.EatingListState
import com.tyupik.teating.ui.eating_list.compose.EatingListState.DataShowState
import com.tyupik.teating.ui.eating_list.compose.EatingListState.DialogState
import com.tyupik.teating.ui.eating_list.model.EatingItem
import com.tyupik.teating.ui.eating_list.model.Side
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EatingListViewModel @Inject constructor(
    private val interactor: EatingListInteractor,
) : ViewModel() {

    private val _composeState: MutableStateFlow<EatingListState> =
        MutableStateFlow(DataShowState(emptyList()))
    val composeState: StateFlow<EatingListState>
        get() = _composeState

    lateinit var uiData: List<EatingItem>

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            uiData = interactor.getEatingList()
            _composeState.tryEmit(DataShowState(uiData))
        }
    }

    fun onRemoveClick(id: String) {
        viewModelScope.launch {
            interactor.removeItem(id)
            loadData()
        }
    }

    fun onAddClick() {
        viewModelScope.launch {
            _composeState.tryEmit(DialogState)
        }
    }

    fun onBreastDialogSelected(side: Side) {
        viewModelScope.launch {
            interactor.postEating(side)
            loadData()
        }
    }

}