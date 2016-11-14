allprojects {
    configure(listOf(repositories, buildscript.repositories)) {
        gradleScriptKotlin()
    }
}