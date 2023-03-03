package com.groupdocs.ui.comparison.compose.settings.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.groupdocs.comparison.options.style.DetalisationLevel
import com.groupdocs.ui.comparison.compose.settings.SettingsViewModel
import com.groupdocs.ui.comparison.compose.theme.spaces

@Composable
fun OptionsScreen(modifier: Modifier = Modifier, viewModel: SettingsViewModel) {
    val state = viewModel.state.value

    Column(
        modifier = modifier
            .padding(horizontal = MaterialTheme.spaces.medium, vertical = MaterialTheme.spaces.small),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .padding(start = MaterialTheme.spaces.small),
                style = MaterialTheme.typography.h6,
                text = "License:",
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
            TextField(
                modifier = Modifier
                    .width(350.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current,
                value = state.licensePath ?: "",
                onValueChange = {
                    viewModel.onLicenseChanged(it)
                },
            )
            Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
            Button(
                modifier = Modifier,
                onClick = viewModel::selectLicense
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spaces.medium),
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.W600,
                    ),
                    text = "...",
                    color = MaterialTheme.colors.onBackground
                )
            }
            Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
            Button(
                modifier = Modifier,
                onClick = viewModel::resetLicense
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spaces.medium),
                    style = MaterialTheme.typography.subtitle1.copy(
                        fontWeight = FontWeight.W600,
                    ),
                    text = "X",
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.extraLarge))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier = Modifier
                    .padding(start = MaterialTheme.spaces.small),
                style = MaterialTheme.typography.h6,
                text = "A few of additional options, will work only for licensed version",
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f)
            )
            Text(
                modifier = Modifier
                    .clickable { viewModel.openDocumentation() },
                style = MaterialTheme.typography.body1,
                text = "(much more Comparison options are described in documentation)",
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f, blue = 0.8f),
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(modifier = Modifier.height(MaterialTheme.spaces.small))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier
                    .padding(start = MaterialTheme.spaces.small),
                style = MaterialTheme.typography.h6,
                text = "Detalization level:",
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),

                )
            Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .padding(MaterialTheme.spaces.small)
                        .clickable {
                            viewModel.onDetalisationLevelChanged(DetalisationLevel.LOW)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = MaterialTheme.spaces.small),
                        style = MaterialTheme.typography.h6,
                        text = "Low",
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                    )
                    RadioButton(
                        selected = state.detalisationLevel == DetalisationLevel.LOW,
                        onClick = {
                            viewModel.onDetalisationLevelChanged(DetalisationLevel.LOW)
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(MaterialTheme.spaces.small)
                        .clickable {
                            viewModel.onDetalisationLevelChanged(DetalisationLevel.MIDDLE)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = MaterialTheme.spaces.small),
                        style = MaterialTheme.typography.h6,
                        text = "Middle",
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                    )
                    RadioButton(
                        selected = state.detalisationLevel == DetalisationLevel.MIDDLE,
                        onClick = {
                            viewModel.onDetalisationLevelChanged(DetalisationLevel.MIDDLE)
                        }
                    )
                }
                Row(
                    modifier = Modifier
                        .padding(MaterialTheme.spaces.small)
                        .clickable {
                            viewModel.onDetalisationLevelChanged(DetalisationLevel.HIGH)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier
                            .padding(start = MaterialTheme.spaces.small),
                        style = MaterialTheme.typography.h6,
                        text = "High",
                        color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
                    )
                    RadioButton(
                        selected = state.detalisationLevel == DetalisationLevel.HIGH,
                        onClick = {
                            viewModel.onDetalisationLevelChanged(DetalisationLevel.HIGH)
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(MaterialTheme.spaces.small))
        Row(
            modifier = Modifier
                .padding(MaterialTheme.spaces.small)
                .clickable {
                    viewModel.onGenerateSummaryPageChanged(!state.generateSummaryPage)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = state.generateSummaryPage,
                onCheckedChange = {
                    viewModel.onGenerateSummaryPageChanged(it)
                }
            )
            Text(
                modifier = Modifier
                    .padding(start = MaterialTheme.spaces.small),
                style = MaterialTheme.typography.h6,
                text = "Generate summary page",
                color = MaterialTheme.colors.onPrimary.copy(alpha = 0.8f),
            )
        }

    }
    Spacer(modifier = Modifier.height(MaterialTheme.spaces.large))
}