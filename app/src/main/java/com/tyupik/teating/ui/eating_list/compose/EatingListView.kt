package com.tyupik.teating.ui.eating_list.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tyupik.teating.R
import com.tyupik.teating.ui.eating_list.EatingListViewModel
import com.tyupik.teating.ui.eating_list.compose.EatingListState.DataShowState
import com.tyupik.teating.ui.eating_list.compose.EatingListState.DialogState

@Composable
fun EatingListView(viewModel: EatingListViewModel) {
    val state: EatingListState by viewModel.composeState.collectAsState()

    Box(
        Modifier.fillMaxSize()
    ) {
        when (val viewState = state) {
            is DataShowState -> EatingListItems(viewState.items, viewModel::onRemoveClick)
            is DialogState -> {
                EatingListItems(viewModel.uiData)
                BreastDialog(viewModel::onBreastDialogSelected, viewModel::loadData)
            }
        }

        Box(modifier = Modifier
            .padding(16.dp)
            .align(Alignment.BottomEnd)
        ) {
            IconButton(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .background(color = Color(0xffffbf00))
                    .size(64.dp)
                    .align(Alignment.Center),
                onClick = viewModel::onAddClick
            ) {
                Icon(Icons.Filled.Add, contentDescription = stringResource(R.string.add))
            }
        }
    }
}