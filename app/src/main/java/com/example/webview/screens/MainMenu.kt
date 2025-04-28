package com.example.webview.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.webview.ui.theme.NAVS

@Composable
fun MainMenu(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    Row(
        modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Column {
            Text("Wikis")
            Button({ navController.navigate(NAVS.ArchWiki) }) { Text("Arch Wiki") }
            Button({ navController.navigate(NAVS.ValaWiki) }) { Text("Vala Wiki") }
        }
        Column {
            Text("Forums")
            Button({ }) { Text("") }
            Button({ }) { Text("") }
        }
        Column {
            Text("Docs")
            Button({ navController.navigate(NAVS.ValaDocs) }) { Text("Vala Docs") }
            Button({ navController.navigate(NAVS.GtkDocs) }) { Text("Gtk Do") }
        }
    }
}
