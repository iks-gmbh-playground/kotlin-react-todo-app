import kotlinx.browser.document
import kotlinx.browser.window
import react.create
import react.dom.render


fun main() {
    window.onload = {
        render(
            element = TodoApp.create(),
            container = document.getElementById("root")!!
        )
    }
}
