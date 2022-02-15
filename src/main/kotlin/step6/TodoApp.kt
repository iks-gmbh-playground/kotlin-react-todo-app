package step6

import org.w3c.dom.HTMLInputElement
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul
import react.useRef


data class Todo(val id: Int, val text: String, var isDone: Boolean = false)

/**
 * Leider sehen wir immer noch nichts. Warum ist das so?
 *
 * Richtig. Die Liste hat sich zwar verändert, aber React hat davon nichts mitbekommen und rendert den Dom entsprechend
 * nicht neu. Abhilfe verschafft der State. Wir können hier nun einen zweiten Hook kennenlernen. useState().
 * Nun müssen wir unsere Liste mit den Todos etwas anpassen.
 */
val TodoApp = FC<Props> {
    /*
     * Hier kommt nun wieder ein Kotlin-Feature zum Einsatz: Delegated Properties.
     * Indem wir nicht todos = useState() sondern todos by useState() verwenden, geben wir die Initialisierung des Objekts,
     * aus unseren Händen. Darüber hinaus wird nun jedes mal, wenn wir eine neuzuweisung machen wie z.B. todos =
     * neueTodos nicht einfach nur die Property neu gesetzt, sondern geht durch einen Setter, der von React zur
     * Verfügung gestellt wird und welcher sich out-of-the-box darum kümmert, dass ein re-rendering geschieht.
     * Im original Javascript würde man an dieser Stelle folgendes sehen
     * const [count, setCount] = useState(0);
     * Da finde ich den Ansatz schöner, den Setter im delegated Property zu "verstecken" ;)
     *
     * Tip: Damit wir den Setter aufrufen können val -> var
     */
    val todos = listOf(Todo(1, "Putzen", false))
    val inputField = useRef<HTMLInputElement>()

    fun addTodo() {
        inputField.current?.let { currentInput ->
            // Code wird nur ausgeführt, wenn nicht null ;)
            todos.toMutableList().apply {
                // Scoped Functions. This ist hier jetzt die Liste ;)
                add(Todo(
                    // ?: 1 -> Wenn Null, dann 1
                    id = maxOfOrNull {it.id}?.plus(1) ?: 1,
                    text = currentInput.value
                    // isDone kann auch im Constructor auf false gesetzt werden (siehe Oben) ;)
                ))
            }
        }
    }


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