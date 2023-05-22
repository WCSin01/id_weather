# id_weather

## Usage

To use the `id_weather` application, follow these steps:

1. Download Android Studio for your operating system:
   - For Mac: [Download Android Studio for Mac](https://developer.android.com/studio#downloads)
   - For Windows: [Download Android Studio for Windows](https://developer.android.com/studio#downloads)
   - For Linux: [Download Android Studio for Linux](https://developer.android.com/studio#downloads)

2. Install Android Studio by following the installation instructions provided on the download page.

3. Open Android Studio on your computer.

4. Import the `id_weather` project into Android Studio:
   - Click on "Open an existing Android Studio project."
   - Navigate to the location where you downloaded the `id_weather` project.
   - Select the project directory and click "OK" to import it.

5. Set up an Android Virtual Device (AVD) or connect a physical Android device to your computer.

6. Build and run the `id_weather` application:
   - Click on the green "Run" button in the toolbar.
   - Select the target device (AVD or connected device) to run the application on.
   - Click "OK" to build and deploy the application.

7. The `id_weather` application should now be running on the selected device, and you can interact with it to get weather information.

## Requirements

The `id_weather` application utilizes the standard Android Studio library. Therefore, make sure you have Android Studio installed before proceeding with the above steps.

## Dependencies

The `id_weather` application relies on the following libraries:

- androidx.appcompat:appcompat:1.6.1
- com.google.android.material:material:1.9.0
- androidx.constraintlayout:constraintlayout:2.1.4
- com.google.code.gson:gson:2.9.0
- com.squareup.okhttp3:okhttp:4.11.0
- com.google.guava:guava:31.1-android

## Testing Dependencies

The following libraries are used for testing purposes:

- junit:junit:4.13.2 (Test framework)
- org.robolectric:robolectric:4.9 (Android unit testing framework)
- androidx.test.ext:junit:1.1.5 (Android JUnit extension)
- androidx.test.espresso:espresso-core:3.5.1 (Android UI testing framework)

## Core Library Desugaring

The `id_weather` application also utilizes the following library for core library desugaring:

- com.android.tools:desugar_jdk_libs:2.0.3
