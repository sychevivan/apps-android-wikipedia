@echo off

REM Configure Java (Android Studio's JBR)
set JAVA_HOME=C:\Program Files\Android\Android Studio\jbr

REM Configure Android SDK paths
set SDK_PATH=%LOCALAPPDATA%\Android\Sdk
set PATH=%JAVA_HOME%\bin;%SDK_PATH%\cmdline-tools\latest\bin;%SDK_PATH%\platform-tools;%SDK_PATH%\emulator;%PATH%

REM Emulator configuration
set EMULATOR_NAME=emulator-5584
set EMULATOR_PORT=5584

set TEST_FAILED=0

echo ========================================
echo Android Test Automation Script
echo ========================================
echo.

echo [STEP 0] Creating emulator...
rem avdmanager delete avd -n %EMULATOR_NAME%
echo no | avdmanager create avd -n %EMULATOR_NAME% -k "system-images;android-30;google_apis;x86" -d pixel --force
if errorlevel 1 (
    echo [ERROR] Failed to create emulator
    exit /b 1
)
echo [INFO] Emulator created successfully
echo.

echo [STEP 1] Starting emulator (%EMULATOR_NAME%) in background...
start /B emulator -avd %EMULATOR_NAME% -no-snapshot -wipe-data -port %EMULATOR_PORT% -skin 720x1280 -gpu host -no-audio
if errorlevel 1 (
    echo [ERROR] Failed to start emulator
    exit /b 1
)
echo [INFO] Emulator started, waiting 90 seconds for boot...
timeout /t 90 /nobreak >nul
echo [INFO] Emulator boot wait completed
echo.

echo [STEP 2] Checking emulator connection...
adb -s emulator-%EMULATOR_PORT% wait-for-device shell getprop sys.boot_completed
echo [INFO] Emulator is ready
echo.

echo [STEP 3] Running test...
echo [INFO] Building app and running test (this may take 10-15 minutes)...
call gradlew.bat --console=plain app:connectedAlphaDebugAndroidTest -Pandroid.testInstrumentationRunnerArguments.class=org.wikipedia.lesson28.homework.SearchTest#testValidSearch
if errorlevel 1 (
    echo [ERROR] Test execution failed
    set TEST_FAILED=1
) else (
    echo [INFO] Test completed successfully
)
echo.

echo [STEP 4] Stopping emulator...
adb -s emulator-%EMULATOR_PORT% emu kill
timeout /t 3 /nobreak >nul
echo [INFO] Emulator stopped
echo.

if %TEST_FAILED%==1 (
    echo ========================================
    echo [FAILED] Test execution failed
    echo ========================================
    echo.
    echo [INFO] Test results are still available for Allure report
)

echo [STEP 5] Opening Allure report with allure serve...
allure serve app\build\allure-results
