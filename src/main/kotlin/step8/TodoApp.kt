package step8

import org.w3c.dom.HTMLInputElement
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.ul
import react.useRef
import react.useState


data class Todo(val id: Int, val text: String, var isDone: Boolean = false)

/**
 * Herzlichen Glückwunsch. Wir haben neue Todos in unserer Liste! :)
 * Nun wollen wir aus unserer TodoListe eine eigene Komponente erstellen.
 *
 * Wie bereits angedeutet, können Componenten Props haben. Unserer neuen Liste werden wir auch ein paar
 * Props mitgeben wollen. Wir wollen den Titel, die Todos-Liste und den Change-Handler von aussen vorgeben, den
 * wir wollen das StateManagement an der App zentral behalten (hier).
 *
 * Hinweis: Props müssen in KotlinJS per external interface definiert werden. Das Warum sprengt den Rahmen ;)
 *
 * Let's Go!
 */
val TodoApp = FC<Props> {

    var todos by useState (listOf<Todo>())
    val inputField = useRef<HTMLInputElement>()

    fun addTodo() {
        inputField.current?.let { currentInput ->
            // Code wird nur ausgeführt, wenn nicht null ;)
            // toMutableList() erzeugt immer eine Kopie (neue Instanz)
            todos = todos.toMutableList().apply {
                // Scoped Functions. This ist hier jetzt die Liste ;)
                add(Todo(
                    // ?: 1 -> Wenn Null, dann 1
                    id = maxOfOrNull {it.id}?.plus(1) ?: 1,
                    text = currentInput.value
                    // isDone kann auch im Constructor auf false gesetzt werden (siehe Oben) ;)
                ))
            }
            currentInput.value = ""
        }

    }


    div {

        // Das muss weg
        h3 {
            +"Todos"
        }

        ul {
            for (todo in todos) {
                li {
                    input {
                        type = InputType.checkbox
                        checked = todo.isDone
                        onChange = {}
                    }
                    span {
                        +todo.text
                    }
                }
            }
        }
        // Bis hier
        input {
            type = InputType.text
            ref = inputField
            placeholder = "Todo Item"
        }
        button {
            onClick = { addTodo() }
            +"Add Todo"
        }

    }
    // Denke daran, diese App im Client zu rendern ;)
}