package com.tyupik.teating.ui.eating_list.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tyupik.teating.R
import com.tyupik.teating.ui.eating_list.model.EatingItem

@Composable
fun EatingListItems(
    uiData: List<EatingItem>,
    onRemoveClick: (String) -> Unit = {},
) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(color = Color.LightGray)
            .padding(horizontal = 16.dp)
            .padding(top = 8.dp)
    ) {
        uiData.forEach { item ->
            Column {
                Spacer(
                    modifier = Modifier
                        .height(4.dp)
                        .background(color = Color.LightGray)
                )
                Row(
                    Modifier
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = White)
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = item.dateAndTime,
                        modifier = Modifier
                            .weight(3f)
                            .padding(top = 12.dp, start = 16.dp)
                    )
                    Text(
                        text = item.side,
                        modifier = Modifier
                            .weight(1.5f)
                            .padding(top = 12.dp),
                    )
                    IconButton(
                        onClick = { onRemoveClick(item.id) }
                    ) {
                        Icon(
                            Icons.Filled.Clear,
                            contentDescription = stringResource(R.string.remove)
                        )
                    }
                }
                Spacer(
                    modifier = Modifier
                        .height(4.dp)
                        .background(color = Color.LightGray)
                )
            }

        }
    }
}


    
