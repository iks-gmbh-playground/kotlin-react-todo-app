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

data class Todo(val id: Int, val text: String, var isDone: Boolean)



val TodoApp = FC<Props> {

    var todos by useState(listOf<Todo>())
    var dones by useState(listOf<Todo>())
    val todosInput = useRef<HTMLInputElement>()

    fun addTodo() {
        todosInput.current?.let { input ->
            todos = todos.toMutableList().apply {
                add(
                    Todo(
                        id = maxOfOrNull { it.id }?.plus(1) ?: 1,
                        text = input.value,
                        isDone = false
                    )
                )
            }
            input.value = ""
        }
    }

    div {

        h3 {
            +"Todos"
        }

        li {
            for (todo in todos) {
                li {
                    input {
                        type = InputType.checkbox
                        checked = todo.isDone
                        onChange = {
                            todo.isDone = !todo.isDone
                            todos = todos.toMutableList().apply { remove(todo) }
                            dones = dones.toMutableList().apply { add(todo) }
                        }
                    }
                    span {
                        +todo.text
                    }
                }
            }
        }
        input {
            ref = todosInput
            onKeyDown = {
                if (it.key == "Enter") addTodo()
            }
            type = InputType.text
            placeholder = "Todo Item"

        }
        button {
            onClick = { addTodo() }
            +"Absenden"
        }

        h3 {
            +"Dones"
        }
        ul {
            for (todo in dones) {
                li {
                    input {
                        type = InputType.checkbox
                        checked = todo.isDone
                        onChange = {
                            todo.isDone = !todo.isDone
                            dones = dones.toMutableList().apply { remove(todo) }
                            todos = todos.toMutableList().apply { add(todo) }
                        }
                    }
                    span {
                        +todo.text
                    }
                }
            }
        }
    }
}

