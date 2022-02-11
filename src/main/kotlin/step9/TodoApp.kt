package step9

import org.w3c.dom.HTMLInputElement
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.useRef
import react.useState


data class Todo(val id: Int, val text: String, var isDone: Boolean = false)

/**
 * Es wird Zeit unsere Todos als erledigt zu markieren und das Tutorial abzuschließen!
 *
 * Wir werden jetzt den onChange implementieren und eine 2. Instanz unserer Liste hinzufügen ;)
 *
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

        TodoList {
            this.title = "My Todos"
            this.todos = todos
            this.onChange = {}
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
        // Hier sollen die erledigten hin.

    }
    // Denke daran, diese App im Client zu rendern ;)
}