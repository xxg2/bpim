@echo off

set BASEDIR=%CD%

echo start TestConnectionTools Service
sc start TestConnectionTools
rem start %BASEDIR%\tools\prunsrv.exe //MR//TestConnectionTools