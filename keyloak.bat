@echo off
title Keycloak Manager
cd /d "C:\Users\home\Desktop\UdemyCourse\Udemy-OAuth2\keycloak-26.5.5\bin"

:: 1. Start Keycloak MINIMIZED in its own window
echo Starting Keycloak Server (check taskbar)...
start /min "Keycloak Server" cmd /c "kc.bat start-dev & pause"

:: 2. Wait for 5 seconds for the server to warm up
echo Waiting 5 seconds for initialization...
timeout /t 5 /nobreak > NUL

:: 3. Open the browser
echo Opening Admin Console at http://localhost:8080/
start http://localhost:8080/

:: 4. Close this launcher script automatically
exit