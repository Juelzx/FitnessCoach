package julian.scholler.fitnesscoach.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

//@Composable
//fun BottomNavigationBar(navigationItems: List<BottomNavigationItem>) {
//    var selectedItemIndex by rememberSaveable {
//        mutableIntStateOf(0)
//    }
//    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//        Scaffold(bottomBar = {
//            NavigationBar {
//                navigationItems.forEachIndexed { index, bottomNavigationItem ->
//                    NavigationBarItem(selected = selectedItemIndex == index,
//                        onClick = { selectedItemIndex = index }, //navcontroller.nav(item.title)
//                        icon = {
//
//                        })
//                }
//            }
//        }) {
//
//        }
//    }
//}