package step4

import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h3
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul


data class Todo(val id: Int, val text: String, var isDone: Boolean)

/**
  Lass uns nun schauen, dass wir ein TodoElement zu der Liste hinzufügen!
 * Unser Inputfield haben wir ja bereits. Wir brauchen also noch einen Button, einen onClick Handler und die Möglichkeit,
 * auf die Inhalte unseres Input Elements zuzugreifen.
 *
 * Hier kommt das erste mal das Konzept der React Hooks zum Einsatz.
 * Hooks sind Methoden von react, welche in den Functional Components aufgerufen werden können,
 * um Features von React zu nutzen. In unserem Fall wollen wir jetzt zum ersten Mal das Binding von React verwenden.
 * Der dafür benötigte Hook ist der useRef<HtmlElement>() Hook.
 * Hinweis. Es ist kein echtes Two-Way-Binding. Lediglich die Referenz auf das HTMLElement. Wollen wir es im Code dynamisch
 * halten, müssen wir uns was anderes überlegen, aber das kommt später...
 *
 */
val TodoApp = FC<Props> {
    val todos = listOf(Todo(1, "Putzen", false))

    /**
     * wir wollen hier ein Value anlegen, welches das Ref beinhaltet. Aber vielleicht legen wir lieber erst einmal das
     * Inputfield an. Danach können wir den Hook für ein HtmlInputElement anlegen (Typesafetyness ;))
     */


    /**
     * Ähnlich wie in JS können wir hier, innerhalb dieser Methode
     * weitere Methoden definieren. Das liegt daran, dass Kotlin mit Higher Order Functions arbeiten kann.
     * Lass uns hier nun unseren onClickHandler definieren, welcher den Wert des inputFields auf der Console aus gibt.
     * Wir werden ihn später weiter ergänzen, deshalb nennen wir ihn am besten direkt addTodo ;)
     */


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
            // ref hier eintragen
            placeholder = "Todo Item"
        }
        /**
         * Button mit onclick anlegen. Tip: onclick erwartet einen MouseEventHandler. Wir wollen unser addTodo aber nicht speziell
         * als MouseEventHandler definieren, sondern soll allgemein gültig sein. Wir können jedoch ein anonyme Implementierung an
         * der Stelle wählen ;) onClick = {}
         * Der Funktionsparameter (das Event) wird in Kotlin automatisch als 'it' an die Funktion übergeben, wenn man nichts anderes angibt
         * und wenn es nur einer ist. Alternativ kann man den Parameter auch explizit mit 'event ->' angeben.
         *
         * Noch ein Tip: Auch einem Button gibt man den Text mit +"" mit ;)
         */
    }
    // Denke daran, diese App im Client zu rendern ;)
}