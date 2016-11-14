import org.gradle.internal.impldep.org.apache.ivy.plugins.repository.ssh.SshRepository

apply<ApplicationPlugin>()

configure<ApplicationPluginConvention> {
    mainClassName = "com.yauhenl.pibot.Application"
}

buildscript {
    repositories {
        maven {
            setUrl("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath("org.hidetake:gradle-ssh-plugin:2.7.0")
    }
}

apply {
    plugin("org.hidetake.ssh")
}

repositories {
    maven {
        setUrl("https://oss.sonatype.org/content/groups/public/")
    }
}

dependencies {
    compile("com.pi4j:pi4j-core:1.2-SNAPSHOT")
    compile("org.glassfish.jersey.containers:jersey-container-jdk-http:2.23.2")
}