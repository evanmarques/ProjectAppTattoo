plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.pcstudio.pcstudioapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pcstudio.pcstudioapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

// build.gradle.kts (Module :app)
// ... (código acima, não altere)

dependencies {
    // Core KTX: Extensões Kotlin para bibliotecas AndroidX que simplificam o código.
    implementation(libs.androidx.core.ktx)
    // Lifecycle Runtime KTX: Funções para gerenciar o ciclo de vida de componentes Android.
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Jetpack Compose Dependencies (Seu projeto foi criado com Compose, então estas são necessárias)
    // Activity Compose: Integração de Activity com Jetpack Compose.
    implementation(libs.androidx.activity.compose)
    // Compose BOM (Bill of Materials): Gerencia as versões de todas as bibliotecas Compose para compatibilidade.
    implementation(platform(libs.androidx.compose.bom))
    // UI Compose: Elementos fundamentais da interface de usuário em Compose.
    implementation(libs.androidx.ui)
    // UI Graphics Compose: Ferramentas de gráficos para Compose.
    implementation(libs.androidx.ui.graphics)
    // UI Tooling Preview Compose: Ferramentas para pré-visualizar componentes Compose no Android Studio.
    implementation(libs.androidx.ui.tooling.preview)
    // Material3 Compose: Implementação do Material Design 3 para Compose.
    implementation(libs.androidx.material3)

    // --- DEPENDÊNCIAS ESSENCIAIS PARA VIEWS TRADICIONAIS (XML) ---
    // Estas já estavam no seu projeto, mas agora com comentários claros:

    // AppCompat: Fornece compatibilidade com versões mais antigas do Android para features modernas de UI (essencial para AppCompatActivity).
    implementation(libs.androidx.appcompat)
    // Material Design: Componentes de UI (botões, campos de texto, etc.) seguindo as diretrizes do Material Design.
    implementation(libs.material) // Este é o 'com.google.android.material:material'
    // Activity: Extensões Kotlin para Activities (ajuda com onCreate, etc.).
    implementation(libs.androidx.activity)
    // ConstraintLayout: Um tipo de layout flexível para organizar Views.
    implementation(libs.androidx.constraintlayout)

    // --- DEPENDÊNCIAS DE TESTES ---
    // JUnit: Framework padrão para testes de unidade em Java/Kotlin.
    testImplementation(libs.junit)
    // AndroidX JUnit: Extensões JUnit para testes de instrumentação Android.
    androidTestImplementation(libs.androidx.junit)
    // Espresso Core: Framework para testes de UI automatizados em Android.
    androidTestImplementation(libs.androidx.espresso.core)
    // Compose BOM para Testes: Garante compatibilidade de versões para testes Compose.
    androidTestImplementation(platform(libs.androidx.compose.bom))
    // UI Test JUnit4 Compose: Regras JUnit4 para testes de UI em Compose.
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // --- DEPENDÊNCIAS DE DEBUG (apenas para desenvolvimento) ---
    // UI Tooling Compose: Ferramentas adicionais de debug para Compose.
    debugImplementation(libs.androidx.ui.tooling)
    // UI Test Manifest Compose: Manifest para testes de UI em Compose.
    debugImplementation(libs.androidx.ui.test.manifest)
}
// ... (código abaixo, não altere)