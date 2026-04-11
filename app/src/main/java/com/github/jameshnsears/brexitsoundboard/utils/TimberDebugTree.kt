package com.github.jameshnsears.brexitsoundboard.utils

import timber.log.Timber.DebugTree

internal class TimberDebugTree : DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String =
        String.format(
            "%s.%s, %s",
            super.createStackElementTag(element),
            element.methodName,
            element.lineNumber,
        )
}
