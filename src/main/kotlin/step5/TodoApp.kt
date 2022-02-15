package step5

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


data class Todo(val id: Int, val text: String, var isDone: Boolean)

/**
 * Wir haben nun unseren addTodo-Handler. Jetzt wollen wir ihn mit Leben füllen. ;)
 * Hier kommt ein wenig Kotlin zum Einsatz.
 */
val TodoApp = FC<Props> {
    val todos = listOf(Todo(1, "Putzen", false))
    val inputField = useRef<HTMLInputElement>()

    fun addTodo() {
        console.log(inputField.current?.value)
        /**
         * Wir wollen hier jetzt einen Eintrag in unsere Liste hinzufügen. Dafür nehmen wir uns den Value des Inputs und
         * erstellen daraus dann ein neues TodoElement, welchen wir in unserer Todos-Liste ablegen.
         * Tip 1: Listen in Kotlin sind immutable, aber da gibt es was in der API ;)
         * Tip 2: die ID am besten per maxOfOrNull bestimmen ;)
         * Tip 3: Java kann sich von Kotlins Collection-API echt mal was abgucken......!
         */
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