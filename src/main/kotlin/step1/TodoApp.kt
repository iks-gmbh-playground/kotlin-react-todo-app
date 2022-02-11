package step1

import react.FC
import react.Props

/**
 * Dann wollen wir mal starten.
 *
 * Was du hier siehst ist der Rahmen für eine Functional Component.
 *
 * Es gibt in React 2 Arten, Komponenten zu Implementieren.
 * Über Klassen und über Funktionale Komponenten. Wir werden uns in diesem Tutorial erstmal nur mit den
 * FCs auseinander setzen, da diese das gleiche können wie der Klassenansatz, aber etwas leichter zu implementieren und
 * zu verstehen sind.
 *
 * Du siehst im Folgenden die Definition unserer TodoApp.

 * TodoApp ist dank Type Inference durch die Anweisung vom Typ FC (Functional Component).

 * Ähnlich wie bei Java wird in den Spitzen klammern ein Objekttyp konkretisiert. Hier siehst du jetzt eine Klasse namens Props.
 * Props agieren bei React als eine Art Übergabe-Parameter und geben an, welche Informationen einer Komponente von aussen
 * mitgegeben werden. Diese Infos sind unveränderlich, also immutable und können sowohl primitive Datentypen, als auch Objekte
 * bishin zu Funktionen enthalten. Somit ist es zum Beispiel auch möglich, einer Komponente einen Callback mitzugeben.
 *
 * Props sind die einfachste Form und enthalten von Hause aus keine weiteren Properties. Man kann aber eine eigene
 * Property erstellen, welche von Props abgeleitet wird.
 * Zu beachten ist, dass aus technischen Gründen die Properties in Kotlin external Interfaces sind.
 * Warum das so ist, würde an dieser Stelle aber den Rahmen sprengen.
 *
 *
 */

val TodoApp = FC<Props> {
    /**
     * Im ersten Schritt wollen wir erstmal nur die Überschrift unserer App ausgeben. "Todos"
     * Dafür benötigen wir ein Div und ein h3
     * In der Kotlin-HTML-DSL können wir sämtliche HTML Tags wie folgt schreiben:
     *      <p class="hello">Hello</p> -> p("hello") { +"Hello" }
     * Möchte man ein Value (wie Hello im Beispiel oben) hinzufügen, muss davor ein + gesetzt werden.
     * Das Plus ist ein überschriebener Operator und setzt (in diesem Fall "Hello") als festen Wert in das Div ein.
     * Die CSS-Klassen kommen in die Methoden-Parameter. Alles weitere kann innerhalb der des Funktionskörpers der DSL von
     * p definiert werden (z.B. onclick = ...)
     */

    // Denke daran, diese App im Client zu rendern ;)
}