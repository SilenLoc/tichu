package logui.view

import javafx.application.Platform
import javafx.scene.control.Label
import javafx.scene.control.ScrollPane
import javafx.scene.control.TextArea
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox

class MainView : BorderPane() {

    init {
        this.center = stack
    }

    companion object {
        private val stack = FlowPane()

        private val textAreas = mutableMapOf<String, TitleTextArea>()

        fun appendText(string: String, source:String) {

            Platform.runLater {

                println(textAreas)

                if(textAreas.containsKey(source)){
                    textAreas[source]?.let {
                        it.addText(string)
                    } ?: Unit

                    println("was in if")

                }else {
                    val newTextArea =  TitleTextArea(source)
                    newTextArea.addText(string)
                    textAreas[source] = newTextArea
                    this.stack.children.addAll(newTextArea)
                }
            }

        }



    }

}

private class TitleTextArea(title: String): VBox() {
    private val textArea = TextArea()

    val inner = textArea

    init {
        this.children.addAll(Label(title),textArea)
    }

}

private fun TitleTextArea.addText(string: String) {
    val newText = this.inner.text + string + "\n"
    this.inner.text = newText
}