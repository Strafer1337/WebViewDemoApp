package com.strafer.webviewapp

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kevinnzou.web.LoadingState
import com.kevinnzou.web.WebView
import com.kevinnzou.web.rememberWebViewState

@Composable
fun WebViewScreen(
    link: String
) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Log.d("MYTAG", "WebViewScreen: Connecting to $link")

        val state = rememberWebViewState(link)
        val loadingState = state.loadingState

        if (loadingState is LoadingState.Loading) {
            CircularProgressIndicator(
                progress = { loadingState.progress }
            )
        }

        WebView(
            state
        )
    }
}