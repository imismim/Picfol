package com.project.picfol.app.Welcome.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.project.picfol.app.NavGraph.Dimens.MediumPadding2
import com.project.picfol.app.NavGraph.Dimens.PageIndicatorWidth
import com.project.picfol.app.NavGraph.Routes
import com.project.picfol.app.Welcome.components.PageIndicator
import com.project.picfol.app.Welcome.components.WelcomeFirstButton
import com.project.picfol.app.Welcome.components.WelcomePage
import com.project.picfol.app.Welcome.components.WelcomeSecondButton
import com.project.picfol.app.Welcome.components.pages
import com.project.picfol.ui.theme.DarkPurple
import kotlinx.coroutines.launch


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    event: (WelcomeEvent) -> Unit,
    navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = DarkPurple)
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            WelcomePage(page = pages[index])
        }
        Spacer(modifier = Modifier.fillMaxWidth(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(PageIndicatorWidth),
                pageSize = pages.size,
                selectPage = pagerState.currentPage
            )

            Row(verticalAlignment = Alignment.CenterVertically) {

                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {
                    WelcomeSecondButton(
                        text = buttonState.value[0],
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                            }
                        })
                }

                WelcomeFirstButton(text = buttonState.value[1]) {
                    scope.launch {
                        if (pagerState.currentPage == 2) {
                            event(WelcomeEvent.SaveAppEntry)
                            navController.navigate(Routes.Registration.route)
                        } else {
                            pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                        }
                    }
                }
            }
        }
    }
}
