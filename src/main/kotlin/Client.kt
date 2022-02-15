import kotlinx.browser.document
import kotlinx.browser.window
import react.create
import react.dom.render

/**
 * Hello World, Fellows!
 *
 * Ihr habt mich gefunden! Und ja, ich bin eine Kotlin-React-App :)
 *
 * Deswegen das Wichtigste mal vorweg:
 *
 * Mein Name ist Kotlin und mich zeichnet folgendes aus:
 *
 * 1. Ich bin eine typisierte Sprache
 *      JavaScript allerdings nicht. Sollte du also mal in untypisierte Schwierigkeiten geraten, verwende einfach
 *      `as dynamic` oder js("")
 *
 * 2. Meine Syntax besitzt Ähnlichkeiten mit TypeScript sieht wie folgt aus:
 *      var/val myName : Typ = Typ()
 *      fun myFunction(param: String) : Unit {
 *          doSomething()
 *      }
 *      oder per Type Inference ;)
 *      fun myFunction(param: String) = doSomething()
 *
 * 3. Ich bin eine funktionale Programmiersprache und unterstütze Higher Order Functions:
 *      var myFunction: (InputType) -> OutputType = { input -> ... } . Ein häufiger OutputType ist Unit, was dem Void in Java entspricht
 *
 * 4. Mit mir kannst du DSLs schreiben. Wir verwenden in unserem Beispiel eine DSL für HTML. -> In den folgenden Kapiteln
 *
 * 5. Ich bin Null-Safe:.
 *      String -> Nullsafe
 *      String? -> Nullable.
 *      Wenn ein Nullable vorliegt, dann musst du per myObject?.myVar darauf zugreifen. Alternativ kannst du myObject!!.myVar
 *      verwenden, dann würde aber im Ernstfall ein Nulli fliegen. Bei ?. wird die Anweisung einfach nicht weiter ausgeführt
 *
 * 6. Ich werde über gradle und Webpack gebaut und werde in Javascript transpiliert. Aber das Thema ein ander mal :)
 *
 * Und warum das Ganze? Ich bin auch eine React-App.
 *
 * Ich besitze also alles, was man für eine moderne Browseranwendung braucht:
 * Ein Lifecycle-Management, Bindings und noch viele andere Features. Aber diese kommen später im Detail!
 */
fun main() {
    // Funktion, welche automatisch vom Browser nach dem Laden der Seite aufgerufen wird
    window.onload = {
        render(
            // Anweisung an React, unsere Komponente (element) auf den Container (in userem Fall ein div mit der Id 'root')
            // zu rendern und den Lifecycle zu starten.
            element = step1.TodoApp.create(),
            container = document.getElementById("root")!!
        )
    }
}
