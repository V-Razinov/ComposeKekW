plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

kapt {
    correctErrorTypes = true
}

//find the way to replace it with global property
android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }
    packagingOptions {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        resources.excludes.add("META-INF/gradle/incremental.annotation.processors")
    }
}

dependencies {
    AppDependenciesGroups.coreDeps(this)
    AppDependenciesGroups.composeDeps(this)
    AppDependenciesGroups.jsonSerializationsKtsDeps(this)
    AppDependenciesGroups.lifeCycleDeps(this)
    AppDependenciesGroups.retrofitDeps(this)
    AppDependenciesGroups.hiltDeps(this)
    AppDependenciesGroups.testDeps(this)

    implementation(project(":core"))
    implementation(project(":core-network"))
    implementation(project(":core-ui"))
    implementation(project(":core-navigation"))
}