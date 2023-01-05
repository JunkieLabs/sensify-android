

# Sensify : Sensor Visualizer in Jetpack Compose


[![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=for-the-badge)](https://android-arsenal.com/api?level=24) ![Compose Version](https://img.shields.io/badge/Compose-1.2.0-brightgreen?style=for-the-badge)

> Help in analysing your Android phone's sensors with graphs and visuals.



![](images/sensify-all.png)


## [Download it on Google Play here](https://play.google.com/store/apps/details?id=io.sensify.sensor)



## Feature Roadmap
- 2022: configure sensor delay
- 2023: Beautiful Visuals of for each sensors.


## Goals
- A very good UI for user to interact.
- Use of android sensors for different utilities.
- [Use Cases](https://github.com/JunkieLabs/sensify-android/wiki/Use-Cases)

## Features:

Whole sensors functionality is implemented inside domain folder, where SensorProvider used for listing available sensors and SensorPacketProvider for get packets .

* Realtime **sensor outputs** into charts.
* Implemented in Jetpack Compose.
* MVVM Architecture used for this App.
* Usage of Kotlin Flow, Jetpack State, Singletons etc.
* Theming in M3 for Light and Dark.

## Tech Stack

This project takes advantage of best practices of common libraryies and tools in android.

* [Kotlin](https://kotlinlang.org/)  
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - for background operations  
* [Flow](https://developer.android.com/kotlin/flow) - alternate of RxJava
* [Jetpack Compose](https://developer.android.com/jetpack/compose)
* [Jetpack libraries](https://developer.android.com/jetpack):
   * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - in-app navigation
   * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
   * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
* [Material Design 3](https://m3.material.io/develop/android/jetpack-compose) 



<br>

## Show your love :heart: by giving a :star: on this project.

<br>


# Open Source Credits


- Charts: [MpAndroidChart](https://github.com/PhilJay/MPAndroidChart)
- Thank you to everyone who tried out this app and opened issues, suggested features, provided translations, or tested debug builds for me
- Thanks to @KunwarManish2008 for helping in several features



# License

[![License](https://img.shields.io/:license-mit-blue.svg?style=for-the-badge)](https://badges.mit-license.org)

- **[MIT license](LICENSE)**
