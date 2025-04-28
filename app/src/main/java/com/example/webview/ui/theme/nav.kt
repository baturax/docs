package com.example.webview.ui.theme

import kotlinx.serialization.Serializable

sealed class NAVS {
    // Wikis
    @Serializable
    object ArchWiki

    @Serializable
    object ValaWiki

    // Docs
    @Serializable
    object ValaDocs

    @Serializable
    object GtkDocs

    // Extra
    @Serializable
    object MainMenu
}
