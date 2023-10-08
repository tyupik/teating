package com.tyupik.teating.ui.eating_list.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.tyupik.teating.R
import com.tyupik.teating.ui.eating_list.model.Side

@Composable
fun BreastDialog(
    onButtonClick: (Side) -> Unit,
    onDismiss: () -> Unit,
    onDismissWithoutScroll: () -> Unit,
) {
    Dialog(onDismissRequest = { onDismissWithoutScroll() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = stringResource(R.string.select_breast),
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    TextButton(
                        onClick = {
                            onButtonClick(Side.LEFT)
                            onDismiss()
                        },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text(stringResource(R.string.left))
                    }
                    TextButton(
                        onClick = {
                            onButtonClick(Side.RIGHT)
                            onDismiss()
                        },
                        modifier = Modifier.padding(8.dp),
                    ) {
                        Text(stringResource(R.string.right))
                    }
                }
            }
        }
    }
}