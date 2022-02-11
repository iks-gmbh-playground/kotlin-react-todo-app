package step3

import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul


data class Todo(val id: Int, val text: String, var isDone: Boolean)

/**
 * Nun wollen wir ein weiteres Element zu der Liste hinzufügen
 */
val TodoApp = FC<Props> {
    val todos = listOf(Todo(1, "Putzen", false))

    div {
        h3 {
            +"Todos"
        }
        ul {
            for (todo in todos) {
                li {
                    +todo.text
                }
            }

        }
        // Hier soll das InputField hin. Beachte dabei die Syntax element { attr = whatever... }
    }
    // Denke daran, diese App im Client zu rendern ;)
}