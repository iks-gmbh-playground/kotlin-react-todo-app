package step10

import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input


data class Todo(val id: Int, val text: String, var isDone: Boolean = false)

/**
 * Fertig :)
 */
val TodoApp = FC<Props> {

    var todos by useState (listOf<Todo>())
    val inputField = useRef<HTMLInputElement>()

    /**
     * Gratistip!
     *
     * Ein weiterer Hook, der häufig verwendet wird, ist der useEffect Hook. Die dort definierte Methode wird ausgeführt,
     * wenn Änderungen auftreten. Dies ist hier mal Beispielsweise eingebaut.
     */
    useEffectOnce {
        console.log("Hello World. Ich wurde initial geladen.")
    }
    useEffect(todos) {
        console.log("Todos haben sich geändert")
    }
    useEffect {
        console.log("Und zack, da wurde ich neu gerendert")
        cleanup {
            console.log("Mach's gut, ich werde jetzt neu gerendert")
        }
    }

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
            this.todos = todos.filter { it.isDone.not() }
            this.onChange = {
                it.isDone = true
                todos = todos.toMutableList() // <- Ugly, aber React weiss dadurch bescheid! -> delegated property setter :)
            }
        }
        input {
            type = InputType.text
            ref = inputField
            placeholder = "Todo Item"
        }
        button {
            onClick = { addTodo() }
            +"Add Todo"
        }
        TodoList {
            this.title = "Done"
            this.todos = todos.filter { it.isDone }
            this.onChange = {
                it.isDone = false
                todos = todos.toMutableList() // <- Ugly, aber React weiss dadurch bescheid! -> delegated property setter :)
            }
        }
    }
    // Denke daran, diese App im Client zu rendern ;)
}