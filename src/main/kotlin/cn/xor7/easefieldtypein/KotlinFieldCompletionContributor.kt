package cn.xor7.easefieldtypein

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.editor.CaretModel
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.util.TextRange
import org.jetbrains.kotlin.lombok.utils.decapitalize
import org.jetbrains.kotlin.util.capitalizeDecapitalize.toLowerCaseAsciiOnly


class KotlinFieldCompletionContributor : CompletionContributor() {
    override fun fillCompletionVariants(parameters: CompletionParameters, result: CompletionResultSet) {
        val editor: Editor = parameters.editor
        val caretModel: CaretModel = editor.caretModel
        val offset = caretModel.offset
        val lineNumber: Int = editor.document.getLineNumber(offset)
        val lineStartOffset: Int = editor.document.getLineStartOffset(lineNumber)
        val lineEndOffset: Int = editor.document.getLineEndOffset(lineNumber)
        val currentLineText: String = editor.document.getText(TextRange(lineStartOffset, lineEndOffset))
        val cleanText = currentLineText.replace(" ", "").toLowerCaseAsciiOnly()
        val beforeCursorText = editor.document.text.substring(lineStartOffset, offset)
        val javaStyleFieldDeclaration = beforeCursorText.split(":").last().trim()
        if (cleanText.contains("val:") || cleanText.contains("var:")) {
            val fragments = javaStyleFieldDeclaration.split(" ").first().split("(?=[A-Z])".toRegex())
            for ((index, _) in fragments.withIndex()) {
                val completion = fragments.subList(index, fragments.size).joinToString("").decapitalize()
                if(completion != ""){
                    result.addElement(
                        LookupElementBuilder
                            .create(completion)
                            .withInsertHandler(KotlinFieldInsertHandler)
                    )
                }
            }
        }
    }
}