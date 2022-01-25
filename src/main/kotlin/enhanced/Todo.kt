package enhanced

import org.w3c.dom.HTMLInputElement
import react.*
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input

data class TodoElement(val id: Int, val text: String, var isDone: Boolean)


val TodoApp = FC<Props> {

    var todos by useState(listOf<TodoElement>())
    var dones by useState(listOf<TodoElement>())
    val todosInput = useRef<HTMLInputElement>()

    fun addTodo() {
        todosInput.current?.let { input ->
            todos = todos.toMutableList().apply {
                add(
                    TodoElement(
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
        TodoList {
            title = "Todos"
            this.todos = todos
            onChangeFunction = { todo ->
                todo.isDone = !todo.isDone
                todos = todos.toMutableList().apply { remove(todo) }
                dones = dones.toMutableList().apply { add(todo) }
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
        TodoList {
            title = "Dones"
            this.todos = dones
            onChangeFunction = { todo ->
                todo.isDone = !todo.isDone
                dones = dones.toMutableList().apply { remove(todo) }
                todos = todos.toMutableList().apply { add(todo) }
            }
        }

    }
}

