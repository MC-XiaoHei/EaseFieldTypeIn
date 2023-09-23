package cn.xor7.easefieldtypein

import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.completion.InsertionContext
import com.intellij.codeInsight.lookup.LookupElement

object KotlinFieldInsertHandler : InsertHandler<LookupElement> {
    override fun handleInsert(context: InsertionContext, item: LookupElement) {
        val deletePoint = context.startOffset
        context.document.deleteString(deletePoint, deletePoint + item.lookupString.length)

        val insertionPoint = context.startOffset
        var offset: Int = insertionPoint - 1
        while (offset >= 0) {
            val currentChar: Char = context.document.charsSequence[offset]
            if (currentChar == ':') {
                var insertString = item.lookupString
                if (context.document.charsSequence[offset + 1] != ' ') {
                    context.document.insertString(offset + 1, " ")
                }
                if (context.document.charsSequence[offset - 1] != ' ') {
                    insertString = " $insertString"
                }
                context.document.insertString(offset, insertString)
                break
            }
            offset--
        }

        context.commitDocument()
    }
}