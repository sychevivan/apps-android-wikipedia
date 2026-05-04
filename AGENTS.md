# AGENTS.md

This repository is the official Wikipedia app for Android, with features for reading Wikipedia articles, exploring the Wikipedia ecosystem by searching and browsing related content, as well as editing and administering Wikipedia content.

## General architecture

- The `app` directory contains all the code for the app itself.
- The `analytics/testkitchen` directory is a work-in-progress analytics engine that will eventually integrate with the app, but not yet.

### Build flavors

- The `dev` flavor is used for day-to-day development and running on local devices by developers.
- The `alpha` flavor is used for continuous integration and QA testing, both manually and using GitHub Actions.
- The `beta` flavor is for building and deploying to the [Wikipedia Beta](https://play.google.com/store/apps/details?id=org.wikipedia.beta) app on the Play Store.
- The `prod` flavor is for building and deploying to the production [Wikipedia](https://play.google.com/store/apps/details?id=org.wikipedia) app on the Play Store and other third-party app stores.
- The `fdroid` flavor is for building and deploying to the [F-Droid store](https://f-droid.org/en/packages/org.wikipedia) specifically. This flavor is configured to exclude any closed-source packages or libraries. All such code is contained in the `src/extra` directory, which is included in all other flavors, but is stubbed out in the `fdroid` flavor.

### Project organization

Classes and packages are organized roughly by "feature":
```
/app/src/main/java/org/wikipedia/
├── dataclient/      # Model classes and service layer for MediaWiki and Wikipedia APIs
├── analytics/       # Model classes and service logic for our current analytics engine (Event Platform)
├── feed/            # Fragments and Views related to the Exlore Feed
├── talk/            # Activities and Views related to Wikipedia Talk pages
├── page/            # Activities and Views for browsing Wikipedia articles in a WebView
├── edit/            # Activities and Views for editing Wikipedia articles
```
...and so on.

### Libraries and dependencies

- Jetpack Compose for any new features. View Bindings for legacy features.
  - Since the app offers four different color themes, always wrap Compose screens in the `BaseTheme` component which handles our custom themes.
  - Whenever possible, translate a legacy feature to Jetpack Compose before adding new functionality.
- Retrofit for network calls, with occasional direct usages of OkHttp.
- Kotlinx.serialization for serializing and deserializing JSON objects from remote APIs and local storage.
- Coil for loading images.
- Room for database management.
- JUnit and Robolectric for unit tests.
- Espresso for instrumented tests.

### Miscellaneous

- SharedPreferences are encapsulated in `Prefs.kt`. If adding a new preference, follow the pattern in that file.
- When setting up an A/B test for any feature, subclass from `ABTest.kt`, which automatically assigns the current user into a test bucket.

## Build environment

- The project requires **JDK 17 or later**. `sourceCompatibility`, `targetCompatibility`, and Kotlin `jvmTarget` are all set to 17 in `app/build.gradle` and `analytics/testkitchen/build.gradle`.
- The Gradle wrapper does **not** auto-provision a JDK (no `foojay-resolver` plugin is configured). Gradle uses whatever `JAVA_HOME` / `PATH` points to. If that resolves to JDK 8 or earlier, Gradle fails on startup with `Gradle requires JVM 17 or later to run. Your build is currently configured to use JVM 8.`
- Recommended JDK sources, in order of preference:
  - Android Studio's bundled JBR — already JDK 17+ on any modern Android Studio (currently JDK 21):
    - Windows: `C:\Program Files\Android\Android Studio\jbr`
    - macOS: `/Applications/Android Studio.app/Contents/jbr/Contents/Home`
    - Linux: `<Android Studio install>/jbr`
  - A JDK previously downloaded by Gradle/IDE into `~/.gradle/jdks/` (e.g. `~/.gradle/jdks/eclipse_adoptium-17-amd64-<os>/jdk-17.x.y+z`).
  - Any standalone Temurin / Zulu / Microsoft / Oracle JDK 17+.
- To override `JAVA_HOME` for a single Gradle invocation when the default is wrong:
  - bash / Git Bash / MinGW: `JAVA_HOME="/c/Program Files/Android/Android Studio/jbr" ./gradlew assembleDevDebug`
  - PowerShell: `$env:JAVA_HOME="C:\Program Files\Android\Android Studio\jbr"; .\gradlew.bat assembleDevDebug`
  - cmd.exe: `set JAVA_HOME=C:\Program Files\Android\Android Studio\jbr&& gradlew.bat assembleDevDebug`
- To verify before running Gradle: `"$JAVA_HOME/bin/java" -version` should report version `17` or higher.

## Code conventions

- To check if the app builds without errors: `./gradlew assembleDevDebug`
  - Do NOT run other static analysis tools (ktlint, checkstyle, lint) during development. This should only be done as a final step, when ready to submit a pull request.
- ALWAYS prefer Jetpack Compose for new UI features, with a corresponding backing ViewModel class that handles state.
  - Whenever possible, use the components and extensions found in the `compose/` directory.
  - Important: for Text composables that might display HTML text from spannable CharSequence strings (bold, italic, etc), use our `compose/components/HtmlText` composable instead of the standard Text() composable.
  - For new Composable, create at least one `Preview` function that showcases the corresponding composable.
- ALWAYS prefer self-documenting names of variables, functions, and fields. Don't write redundant comments that explain what the next line does.
- Avoid using deprecated APIs and classes in new code whenever possible.
- Avoid using reflection, unless all other options are exhausted.

## Release notes

- Every previous release is denoted by a git tag of the form `r/...`. Release notes must be composed based on git commits that happened after the last release tag.
- To get the hash of the last release tag: git show-ref -s <last-release-tag>
- To get a list of commits since last release: git log <last-release-hash>..HEAD --oneline --no-merges
- Do NOT include dependency updates, localization updates, or static data updates.
- Release notes should be terse, but understandable by a general audience.
- Release notes must be a single paragraph of natural, friendly text. It should NOT be a list of bullet points.
