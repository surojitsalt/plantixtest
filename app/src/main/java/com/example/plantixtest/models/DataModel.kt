package com.example.plantixtest.models

import java.lang.StringBuilder

open class DataModel() : BaseModel() {
    private lateinit var mText:String

    constructor(pText :String) : this(){
        this.mText = pText
    }

    public var Text:String
    get() {
        return mText
    }
    set(pValue) {
        this.mText = pValue
    }

    open fun getTitleCaseText(): String? {
        return toTitleCase(this.mText)
    }

    open fun toTitleCase(pText: String?): String? {

        if (pText == null) {
            return null
        }
        var vWhiteSpace = true
        val vBuilder = StringBuilder(pText)
        val vBuilderLength = vBuilder.length

        for (i in 0 until vBuilderLength) {
            val vChar = vBuilder[i]
            if (vWhiteSpace) {
                if (!Character.isWhitespace(vChar)) {
                    vBuilder.setCharAt(i, Character.toTitleCase(vChar))
                    vWhiteSpace = false
                }
            } else if (Character.isWhitespace(vChar)) {
                vWhiteSpace = true
            } else {
                vBuilder.setCharAt(i, Character.toLowerCase(vChar))
            }
        }
        return vBuilder.toString()
    }
}