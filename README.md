# Orchextra Android-sample-app
 
The aim of this project is to help you with your first integration of Orchextra SDK and also to show you the capabilities of the SDK with a sample project. 

## Features
1. Geofences detection
2. Beacons detection
3. Barcode and QR code scanner

## Getting started

First of all, you need to create a project in [Orchextra dashboard][dashboard]. Go to "Setting" > "SDK Configuration" to get the **api key** and **api secret**, you need to replace these values into MyApplication
```java
  private final String API_KEY = "YOUR_API_KEY";
  private final String API_SECRET = "YOUR_API_SECRET";
```
For using geofencing feature, you must go to [Google Developers Console][googleurl] activate Google Play Services and create a new project to obtain a **sender_id**.
```java
  private final String GOOGLE_PLAY_SERVICES_SENDER_ID = "GOOGLE_PLAY_SERVICES_SENDER_ID";
```
## Project Overview

<img src="https://github.com/Orchextra/orchextra-android-demo-app/blob/master/resources/main.png" width="300">


[dashboard]: https://dashboard.orchextra.io/home/
[googleurl]: https://console.developers.google.com
