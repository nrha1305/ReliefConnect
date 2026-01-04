package com.reliefconnect.app.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.reliefconnect.app.navigation.Routes
import com.reliefconnect.app.ui.auth.AuthViewModel
import com.reliefconnect.app.ui.components.AppTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController,
                  authViewModel: AuthViewModel
) {

    Scaffold(
        topBar = {
            AppTopBar("Profile")

        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Text(
                text = "Nor Hayati",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "norhayati@email.com",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    authViewModel.logout()

                    navController.navigate(Routes.LOGIN) {
                        popUpTo(0) { inclusive = true }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.error
                )
            ) {
                Text("Logout")
            }
        }
    }
}
