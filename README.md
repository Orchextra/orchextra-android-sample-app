[![Build Status](https://travis-ci.org/Orchextra/orchextra-android-sample-app.svg?branch=master)](https://travis-ci.org/Orchextra/orchextra-android-sample-app) 
![Platform](https://img.shields.io/badge/Platform-Android-brightgreen.svg)
![Language](https://img.shields.io/badge/Language-Java-brightred.svg)

# Orchextra Android-sample-app
 
The aim of this project is to help you with your first integration of Orchextra SDK and also to show you the capabilities of the SDK with a sample project. 

## Features
1. Geofences detection
2. Beacons detection
3. Barcode and QR Scan
4. Image Recognition

## Getting started

First of all, you need to create a project in [Orchextra dashboard][dashboard]. Go to "Setting" > "SDK Configuration" to get the **api key** and **api secret**, you need to replace these values into MyApplication
```java
  private final String API_KEY = "YOUR_API_KEY";
  private final String API_SECRET = "YOUR_API_SECRET";
```
## Project Overview

<img src="https://github.com/Orchextra/orchextra-android-demo-app/blob/master/resources/main.png" width="300">

Initialization:

 * You MUST call init inside app onCreate, otherwise this sdk won't work
 ```java
    Orchextra.init(this, orchextraCallback);
 ```
 
 * After init you can add a `ustomSchemeReceiver` and `mageRecognitionImplementation` if you would like:
  
  ```java
    Orchextra.setCustomSchemeReceiver(customSchemeReceiver);
  ```
  
  * Don't forget to add dependency for Vuforia implementation:

   ```groovy
      compile 'com.github.GigigoGreenLabs.imgRecognition:vuforiaimplementation:1.0'
   ```
  
  ```java
      Orchextra.setImageRecognitionModule(new ImageRecognitionVuforiaImpl())
  ```
  
  * And then you could start Orchextra whenever you want calling:
   
   ```java
      Orchextra.start(API_KEY, API_SECRET);
  ```
  
  * You can set an user as well, as recommended best practice use this method after login in your app for instance:
  ```java
    private ORCUser orchextraUser = new ORCUser(ORCHEXTRA_CRM_USER_ID, ORCHEXTRA_USER_BORN_DATE,
              ORCUser.Gender.ORCGenderMale, new ArrayList<>(Arrays.asList(ORCHEXTRA_USER_TAGS)));          
    Orchextra.setUser(orchextraUser);
  ```  
  If you want to know more details about how to initialize and start Orchextra, have a look at [MyApplication class](https://github.com/Orchextra/orchextra-android-sample-app/blob/master/app/src/main/java/com/gigigo/orchextra/orchextrasampleappandroid/MyApplication.java).
  
  * You can then call barcode Scanner and Image Recognition whenever you want using:
    ```java
        Orchextra.startScannerActivity();
        Orchextra.startImageRecognition();
   ```
   
   If you want to know more details about how to use Image Recognition and Scanner, have a look at [MainActivity class](https://github.com/Orchextra/orchextra-android-sample-app/blob/master/app/src/main/java/com/gigigo/orchextra/orchextrasampleappandroid/MainActivity.java).
   
   If you want to have more info about how to override Styles and resources for customization and full details about how to make your integration have a look at [Orchextra SDK Readme](https://github.com/Orchextra/orchextra-android-sdk).
   
[dashboard]: https://dashboard.orchextra.io/home/
[googleurl]: https://console.developers.google.com
