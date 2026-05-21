package com.example.train0.core.ui.preview

import androidx.compose.runtime.Composable
import com.example.train0.core.theme.Train0Theme

/**
 * Single place to wrap @Preview composables so previews match production theming.
 */
@Composable
fun TrainPreview(content: @Composable () -> Unit) {
    Train0Theme(content = content)
}
