@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.cellular.android.library.get().pluginId)
    id(libs.plugins.cellular.kotlin.android.get().pluginId)
    id(libs.plugins.cellular.maven.publish.get().pluginId)
}

android {
    namespace = "com.fa.cellular"
    compileSdk = 34

    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://www.jitpack.io" ) }
    }

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.constraintlayout)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.furkanayaz"
            artifactId = "cellular"
            version = "2.3"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}