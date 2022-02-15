package step2

import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3


/**
 * Als Nächstes wollen wir uns mal Gedanken über unsere Todos machen. Dafür würde es sich lohnen, eine Klasse anzulegen.
 * Tipp. verwende `data class MyClass(val myValue: MyType)`, ein Feature von Kotlin, um Boilerplate zu sparen.
 * Ein TodoElement besteht aus einer Id, einem Text und einer Information, ob es erledigt ist.
 */

// Wir brauchen unsere TodoElemente ...

val TodoApp = FC<Props> {

    // ... und eine Liste davon (listOf())

    div {
        h3 {
            +"Todos"
        }

        // Hier können wir jetzt die Liste mit den Todos ausgeben. Syntax For-Loop = for (todo in ...)
        // Alternativ: .forEach { ... } ;)
    }
    // Denke daran, diese App im Client zu rendern ;)
}