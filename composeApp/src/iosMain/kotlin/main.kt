import androidx.compose.ui.window.ComposeUIViewController
import org.company.app.Root
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { Root() }
