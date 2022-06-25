import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandler.implementation(dependencyNotation: Any) =
    add("implementation", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any) =
    add("kapt", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any) =
    add("kapt", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any) =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.debugImplementation(dependencyNotation: Any) =
    add("debugImplementation", dependencyNotation)

inline fun deps(
    crossinline block: DependencyHandler.() -> Unit
): DependencyHandlerScope.() -> Unit = {
    block()
}

object AppDependencies {
    //core
    const val core = "androidx.core:core-ktx:${Versions.androidxCore}"

    //compose
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
    const val composeUiPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navVersion}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"

    //lifecycle
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}"
    const val lifecycleViewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleVersion}"

    //serialization
    const val jsonSerializationKtx = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.jsonSerializationVersion}"

    //retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptorVersion}"

    //hilt
    const val hiltCore = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hiltComposeNavigationVersion}"

    //testing
    const val testingJunit = "junit:junit:4.13.2"
    const val testingExtJunit = "androidx.test.ext:junit:1.1.3"
    const val testingHilt = "com.google.dagger:hilt-android-testing:${Versions.hiltVersion}"
    const val testingEspresso = "androidx.test.espresso:espresso-core:3.4.0"
    const val testingJunitUi = "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
    const val testingComposeUi = "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"
}

object AppDependenciesGroups {
    val coreDeps = deps {
        implementation(AppDependencies.core)
    }
    val composeDeps = deps {
        implementation(AppDependencies.composeUi)
        implementation(AppDependencies.composeUiPreview)
        implementation(AppDependencies.composeMaterial)
        implementation(AppDependencies.composeNavigation)
        implementation(AppDependencies.composeActivity)
    }
    val lifeCycleDeps = deps {
        implementation(AppDependencies.lifecycleKtx)
        implementation(AppDependencies.lifecycleViewModelCompose)
    }
    val jsonSerializationsKtsDeps = deps {
        implementation(AppDependencies.jsonSerializationKtx)
    }
    val retrofitDeps = deps {
        implementation(AppDependencies.retrofit)
        implementation(AppDependencies.httpLoggingInterceptor)
    }
    val hiltDeps = deps {
        implementation(AppDependencies.hiltCore)
        kapt(AppDependencies.hiltCompiler)
        implementation(AppDependencies.hiltNavigationCompose)
    }
    val testDeps = deps {
        testImplementation(AppDependencies.testingHilt)
        debugImplementation(AppDependencies.testingComposeUi)
        testImplementation(AppDependencies.testingJunit)
        androidTestImplementation(AppDependencies.testingExtJunit)
        androidTestImplementation(AppDependencies.testingEspresso)
        androidTestImplementation(AppDependencies.testingJunitUi)
    }
}

object PluginDependencies {
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
}