apply<ApplicationPlugin>()

configure<ApplicationPluginConvention> {
    mainClassName = "com.yauhenl.pibot.Application"
}

buildscript {
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.4.1.RELEASE")
    }
}

apply {
    plugin("spring-boot")
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-freemarker")
}