# Acessibilidade Audio - Projeto DOMA


This repository contains an Android application for accessibility that provides audio notifications and checks for Bluetooth audio device connectivity. The code is organized into several classes to manage audio, notifications, and text-to-speech functionalities.

## Table of Contents

- [Audio](#audio)
- [Notificacao](#notificacao)
- [Texto](#texto)
- [AudioHelpers](#audiohelpers)
- [MainActivity](#mainactivity)

## Audio

The `Audio` class handles audio-related functionalities, such as checking for the availability of audio output devices and registering audio device callbacks. It also provides a method to show Bluetooth settings.

### Methods

- `audioOutputAvailable(int type): boolean`: Checks if a specific audio output type is available.
- `registerAudioDeviceCallback()`: Registers an audio device callback to monitor device changes.
- `showBluetoothSettings()`: Opens the Bluetooth settings activity.

## Notificacao

The `Notificacao` class extends `NotificationListenerService` to listen for incoming notifications. It uses the `Texto` class to convert notification text to speech.

### Methods

- `onCreate()`: Initializes the `Texto` class.
- `onDestroy()`: Shuts down the text-to-speech engine.
- `onNotificationPosted(StatusBarNotification sbn)`: Speaks out the content of the incoming notification.
- `onNotificationRemoved(StatusBarNotification sbn)`: Logs the removal of notifications.

## Texto

The `Texto` class encapsulates the text-to-speech functionality. It initializes the text-to-speech engine, handles initialization status, and provides methods to speak and shut down the engine.

### Methods

- `onInit(int status)`: Handles the initialization of the text-to-speech engine.
- `speak(String text)`: Converts the given text to speech.
- `shutdown()`: Stops and shuts down the text-to-speech engine.

## AudioHelpers

The `AudioHelpers` class provides helper methods for audio-related operations. It is used in the `MainActivity` class.

### Methods

- `audioOutputAvailable(int type): boolean`: Checks if a specific audio output type is available.

## MainActivity

The `MainActivity` class serves as the main entry point of the application. It checks for Bluetooth A2DP audio device connectivity, displays appropriate messages, and allows users to navigate to Bluetooth settings.

### Methods

- `onCreate(Bundle savedInstanceState)`: Initializes the UI and checks for Bluetooth audio device connectivity.
- `onDestroy()`: Shuts down the text-to-speech engine.

## Usage

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the application on an Android device.

Feel free to explore and modify the code to suit your needs.
****
