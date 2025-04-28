package com.example.webview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.webview.screens.ArchWiki
import com.example.webview.screens.GtkDocs
import com.example.webview.screens.MainMenu
import com.example.webview.screens.ValaDocs
import com.example.webview.screens.ValaWiki
import com.example.webview.ui.theme.NAVS
import com.example.webview.ui.theme.WebViewTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
            val navController = rememberNavController()
            WebViewTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    stringResource(R.string.view_docs_text),
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            },
                            navigationIcon = {
                                IconButton({ navController.navigateUp() }) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                        contentDescription = stringResource(R.string.go_back_text),
                                    )
                                }
                            },
//                            actions = {
//                                IconButton({ navController.navigateUp() }) {
//                                    Icon(
//                                        imageVector = Icons.AutoMirrored.Default.ArrowForward,
//                                        contentDescription = "go Next",
//                                    )
//                                }
//                            },
                            scrollBehavior = scrollBehavior,
                        )
                    },
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = NAVS.MainMenu) {
                        composable<NAVS.MainMenu> {
                            MainMenu(
                                Modifier.padding(innerPadding),
                                navController = navController,
                            )
                        }
                        composable<NAVS.ArchWiki> { ArchWiki(Modifier.padding(innerPadding)) }
                        composable<NAVS.ValaWiki> { ValaWiki(Modifier.padding(innerPadding)) }
                        composable<NAVS.ValaDocs> { ValaDocs(Modifier.padding(innerPadding)) }
                        composable<NAVS.GtkDocs> { GtkDocs(Modifier.padding(innerPadding)) }
                    }
                }
            }
        }
    }
}
