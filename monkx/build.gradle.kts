plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.jeluchu.monkx"
    compileSdk = 35

    defaultConfig {
        minSdk = 23

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
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"])
            }

            groupId = "com.jeluchu"
            artifactId = "monkx"
            version = "1.1.0"
        }
    }
}

dependencies {
    testImplementation(libs.junit)
    implementation(libs.bundles.ktor)
    implementation(libs.bundles.jsoup)
    implementation(libs.bundles.logger)
    implementation(libs.androidx.webkit)
    implementation(libs.bundles.jeluchu)
    implementation(libs.androidx.monitor)
    testImplementation(libs.junit.jupiter)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.jupiter.junit.api)
    testRuntimeOnly(libs.jupiter.junit.engine)
    implementation(libs.bundles.kotlin.coroutines)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}