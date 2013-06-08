@echo off

set BASEDIR=%CD%

echo delete testConnection Service
sc delete testConnection
rem %BASEDIR%\tools\prunsrv.exe //DS//testConnection



