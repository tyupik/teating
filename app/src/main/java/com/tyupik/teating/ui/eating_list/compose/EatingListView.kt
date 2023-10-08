package com.tyupik.teating.ui.eating_list.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tyupik.teating.R
import com.tyupik.teating.ui.eating_list.EatingListViewModel
import com.tyupik.teating.ui.eating_list.compose.EatingListState.DataShowState
import com.tyupik.teating.ui.eating_list.compose.EatingListState.LoadingState
import com.tyupik.teating.ui.theme.BackgroundCommon
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun EatingListView(viewModel: EatingListViewModel) {
    val state: EatingListState by viewModel.composeState.collectAsState()
    var openDialog by remember { mutableStateOf(false) }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(
        Modifier
            .fillMaxSize()
            .background(color = BackgroundCommon)
    ) {
        when (val viewState = state) {
            is DataShowState -> {
                EatingListItems(
                    uiData = viewState.items,
                    listState = listState,
                    onRemoveClick = viewModel::onRemoveClick
                )
            }
            is LoadingState -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                )
            }
        }

        if (openDialog) {
            BreastDialog(
                onButtonClick = viewModel::onBreastDialogSelected,
                onDismiss = {
                    coroutineScope.launch {
                        delay(200)
                        listState.animateScrollToItem(0)
                    }
                    openDialog = false
                },
                onDismissWithoutScroll = { openDialog = false }
            )
        }

        Box(modifier = Modifier
            .padding(16.dp)
            .align(Alignment.BottomEnd)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(color = Color(0xffffbf00))
            .size(64.dp)
            .clickable { openDialog = true }

        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = stringResource(R.string.add),
                modifier = Modifier.align(Alignment.Center),
            )
        }
    }
}