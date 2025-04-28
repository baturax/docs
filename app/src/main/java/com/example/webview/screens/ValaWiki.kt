package com.example.webview.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.atrii.composewebkit.ComposeWebView
import dev.atrii.composewebkit.configureWebSettings
import dev.atrii.composewebkit.rememberComposeWebViewState
import dev.atrii.composewebkit.rememberWebViewNavigator

@Composable
fun ValaWiki(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxSize(),
    ) {
        val navigator = rememberWebViewNavigator()
        val state =
            rememberComposeWebViewState(
                url = "https://docs.vala.dev/",
                onBackPress = {
                    if (navigator.canGoBack()) {
                        navigator.navigateBack()
                    }
                },
            ) {
                configureWebSettings {
                    javaScriptEnabled = true
                }
            }

        ComposeWebView(
            modifier = Modifier,
            state = state,
            navigator = navigator,
            pull2Refresh = false,
        )
    }
}
