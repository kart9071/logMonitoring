@echo off



:menu
echo What would you like to do?
echo 1. Start Docker containers and spring application
echo 2. Start Docker containers only
echo 3. Stop Docker containers
echo 4. start only spring application
set /p choice="Enter your choice (1, 2, 3, or 4): "

if "%choice%"=="1" (
    rem Start Docker containers and send message
    docker-compose up -d
    echo Current directory: %cd%
    start cmd /k "cd /d logMonitoringBE && script1.bat"
) else if "%choice%"=="2" (
    rem Start Docker containers only
    docker-compose up -d
) else if "%choice%"=="3" (
    rem Stop Docker containers
    docker-compose down
) else if "%choice%"=="4" (
    rem Start only spring application
    start cmd /k "cd /d logMonitoringBE && script1.bat"
) else (
    echo Invalid choice. Please enter 1, 2, 3, or 4.
    goto menu
)
