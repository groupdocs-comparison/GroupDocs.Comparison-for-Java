package com.groupdocs.ui.result.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.groupdocs.ui.theme.Gray
import com.groupdocs.ui.theme.spaces

@Composable
fun SubHeaderScreen(modifier: Modifier = Modifier, onDownload: () -> Unit = {}) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Gray),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(100.dp)
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(MaterialTheme.spaces.small),
                text = "Comparison",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onBackground
            )
        }
        Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
        Image(
            modifier = Modifier
                .clickable { onDownload() }
                .padding(MaterialTheme.spaces.small)
                .size(32.dp),
            painter = painterResource("download.png"),
            contentDescription = "Download"
        )
    }
}