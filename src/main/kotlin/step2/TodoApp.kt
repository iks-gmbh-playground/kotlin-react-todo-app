package step2

import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3


/**
 * Als nächstes wollen wir uns mal Gedanken über unsere Todos machen. Dafür würde es sich lohnen, eine Klasse anzulegen.
 * Tipp. verwende data class, ein Feature von Kotlin, um Boilerplate zu sparen.
 * Ein TodoElement besteht aus einer id, einem text und einer Information, ob es erledigt ist.
 *
 */

// Wir brauchen unsere TodoElemente ...

val TodoApp = FC<Props> {

    // ... und eine Liste davon

    div {
        h3 {
            +"Todos"
        }

        // Hier können wir jetzt die Liste mit den Todos ausgeben.
    }
    // Denke daran, diese App im Client zu rendern ;)
}