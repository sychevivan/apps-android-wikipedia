@echo off

REM [STEP 0] Environment Setup
set JAVA_HOME=C:\Program Files\Android\Android Studio\jbr
set SDK_PATH=%LOCALAPPDATA%\Android\Sdk
set PATH=%JAVA_HOME%\bin;%SDK_PATH%\cmdline-tools\latest\bin;%SDK_PATH%\platform-tools;%SDK_PATH%\emulator;%PATH%

set EMULATOR_NAME=marathon-emulator
set EMULATOR_PORT=5586

echo ========================================
echo Marathon Test Automation Script
echo ========================================
echo.

REM [STEP 1] Compilation
echo [STEP 1] Compiling app and tests...
call gradlew.bat app:assembleAlphaDebug app:assembleAlphaDebugAndroidTest
if errorlevel 1 (
    echo [ERROR] Compilation failed
    exit /b 1
)
echo [INFO] Compilation successful
echo.

REM [STEP 2] Create Emulator
echo [STEP 2] Creating emulator (%EMULATOR_NAME%)...
echo no | avdmanager create avd -n %EMULATOR_NAME% -k "system-images;android-30;google_apis;x86" -d pixel --force
if errorlevel 1 (
    echo [ERROR] Failed to create emulator
    exit /b 1
)
echo [INFO] Emulator created successfully
echo.

REM [STEP 3] Start Emulator
echo [STEP 3] Starting emulator in background...
start /B emulator -avd %EMULATOR_NAME% -no-window -no-audio -port %EMULATOR_PORT%
if errorlevel 1 (
    echo [ERROR] Failed to start emulator
    exit /b 1
)
echo [INFO] Emulator started, waiting 120 seconds for boot...
timeout /t 120 /nobreak >nul
echo [INFO] Wait completed
echo.

REM [STEP 4] Wait for Device
echo [STEP 4] Checking device connection...
adb -s emulator-%EMULATOR_PORT% wait-for-device shell getprop sys.boot_completed
echo [INFO] Emulator is ready
echo.

REM [STEP 5] Run Marathon
echo [STEP 5] Running Marathon...
call marathon.bat
if errorlevel 1 (
    echo [WARNING] Marathon execution finished with errors
) else (
    echo [INFO] Marathon execution completed successfully
)
echo.

REM [STEP 6] Stop Emulator
echo [STEP 6] Stopping emulator...
adb -s emulator-%EMULATOR_PORT% emu kill
timeout /t 5 /nobreak >nul
echo [INFO] Emulator stopped
echo.

echo ========================================
echo Script execution finished
echo ========================================
