package step10

import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.span
import react.dom.html.ReactHTML.ul

external interface TodoListProps : Props {
    var title: String
    var todos: List<Todo>
    var onChange: (Todo) -> Unit
}

val TodoList = FC<TodoListProps> { props ->
    div {
        h3 {
            +props.title
        }
        ul {
            for (todo in props.todos) {
                li {
                    input {
                        type = InputType.checkbox
                        checked = todo.isDone
                        onChange = {
                            props.onChange(todo)
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