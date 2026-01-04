package com.reliefconnect.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.reliefconnect.app.ui.auth.LoginScreen
import com.reliefconnect.app.ui.home.HomeScreen
import com.reliefconnect.app.ui.profile.ProfileScreen
import com.reliefconnect.app.ui.request.RequestDetailScreen
import com.reliefconnect.app.ui.request.RequestListScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import com.reliefconnect.app.ui.auth.AuthViewModelFactory
import com.reliefconnect.app.ui.auth.AuthViewModel



object Routes {
    const val LOGIN = "login"
    const val REGISTER = "register"
    const val HOME = "home"
    const val REQUEST = "request"
    const val PROFILE = "profile"

    const val REQUEST_DETAIL = "request_detail/{title}"

    fun requestDetail(title: String): String =
        "request_detail/$title"
}

@Composable
fun AppNavigation() {

    val context = LocalContext.current

    val authViewModel: AuthViewModel = viewModel(
        factory = AuthViewModelFactory(context)
    )

    val navController = rememberNavController()

    val startDestination =
        if (authViewModel.isLoggedIn.value) Routes.HOME else Routes.LOGIN


    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN
    ) {

        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginClick = {
                    authViewModel.login()

                    navController.navigate(Routes.HOME) {
                        popUpTo(Routes.LOGIN) { inclusive = true }
                    }
                },
                onRegisterClick = {
                    navController.navigate(Routes.REGISTER)
                }
            )
        }

        composable(Routes.HOME) {
            HomeScreen(navController)
        }

        composable(Routes.REQUEST) {
            RequestListScreen(navController)
        }

        composable(Routes.PROFILE) {
            ProfileScreen(
                navController = navController,
                authViewModel = authViewModel
            )
        }

        composable(
            route = Routes.REQUEST_DETAIL,
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val title = backStackEntry
                .arguments
                ?.getString("title")
                ?: ""

            RequestDetailScreen(title)
        }
    }
}
