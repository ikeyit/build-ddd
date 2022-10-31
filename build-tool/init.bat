@echo off
set DIRHOME=%~dp0
set LINK="%HOMEPATH%\.gradle\init.gradle.kts"
del /f "%LINK%"
mklink "%LINK%" "%DIRHOME%init.gradle.kts"