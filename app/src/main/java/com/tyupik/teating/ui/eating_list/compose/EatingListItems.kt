package com.tyupik.teating.ui.eating_list.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tyupik.teating.R
import com.tyupik.teating.ui.eating_list.model.EatingItem
import com.tyupik.teating.ui.theme.BackgroundCard
import com.tyupik.teating.ui.theme.TeatingTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EatingListItems(
    uiData: List<EatingItem>,
    listState: LazyListState,
    onRemoveClick: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp)
    ) {
        if (uiData.isNotEmpty()) {
            LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
                itemsIndexed(items = uiData, key = { _, item -> item.id }) { index, item ->
                    val color = if (index == 0) BackgroundCard else White
                    Column(Modifier.animateItemPlacement()) {
                        Spacer(modifier = Modifier.height(4.dp))
                        Row(
                            Modifier
                                .clip(shape = RoundedCornerShape(20.dp))
                                .background(color = color)
                                .padding(horizontal = 8.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = item.dateAndTime,
                                modifier = Modifier
                                    .weight(6f)
                                    .padding(top = 12.dp, start = 16.dp)
                            )
                            Text(
                                text = item.side,
                                modifier = Modifier
                                    .weight(3f)
                                    .padding(top = 12.dp, start = 6.dp),
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(1.5f),
                                verticalArrangement = Arrangement.Center
                            ) {
                                if (item.blobExist) {
                                    Image(
                                        modifier = Modifier.padding(top = 6.dp),
                                        painter = painterResource(id = R.drawable.blob),
                                        contentDescription = stringResource(R.string.blob)
                                    )
                                }
                            }
                            IconButton(
                                modifier = Modifier.weight(0.7f),
                                onClick = { onRemoveClick(item.id) }
                            ) {
                                Icon(
                                    Icons.Filled.Clear,
                                    contentDescription = stringResource(R.string.remove)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        } else {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.click_plus),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    fontSize = 19.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    TeatingTheme {
        EatingListItems(
            uiData = listOf(
                EatingItem(
                    id = "123",
                    dateAndTime = "20:40 10/10/2023",
                    side = "Правая",
                    blobExist = false
                ),
                EatingItem(
                    id = "6798",
                    dateAndTime = "20:40 10/10/2023",
                    side = "Левая",
                    blobExist = true
                ),
            ),
            listState = rememberLazyListState(),
            onRemoveClick = {}
        )
    }
}


    
