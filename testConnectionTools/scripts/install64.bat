@echo off

set BASEDIR=%CD%

echo install TestConnectionTools Service

set LIB_PATH=%CD%\lib
set CLASSPATH=%CLASSPATH%;%LIB_PATH%\commons-collections-3.2.1.jar
set CLASSPATH=%CLASSPATH%;%LIB_PATH%\commons-configuration-1.6.jar
set CLASSPATH=%CLASSPATH%;%LIB_PATH%\commons-email-1.2.jar
set CLASSPATH=%CLASSPATH%;%LIB_PATH%\commons-logging-1.1.1.jar
set CLASSPATH=%CLASSPATH%;%LIB_PATH%\commons-lang-2.4.jar
set CLASSPATH=%CLASSPATH%;%LIB_PATH%\log4j-1.2.14.jar
set CLASSPATH=%CLASSPATH%;%LIB_PATH%\mail.jar
set CLASSPATH=%CLASSPATH%;%LIB_PATH%\testConnection.jar

set SRV=%BASEDIR%\tools\prunsrv.exe
if "%JVM%" == "" goto findJvm
if exist "%JVM%" goto foundJvm
:findJvm
set "JVM=C:\Program Files\Java\jre6\bin\server\jvm.dll"
if exist "%JVM%" goto foundJvm
set "JVM=C:\Program Files\Java\jre6\bin\client\jvm.dll"
if exist "%JVM%" goto foundJvm
echo can not find jvm.dll automatically,
echo please use COMMAND to localation it 
echo for example : set "JVM=C:\Program Files\Java\jre6\bin\server\jvm.dll"
echo then install service
goto end
:foundJvm
%SRV% //IS//testConnection --DisplayName="Test Connection Tools" 	--Classpath=%CLASSPATH% --Install=%SRV% "--Jvm=%JVM%" --Startup=auto --StartMode=jvm --StopMode=jvm --StartPath=%BASEDIR% --StartClass=TestConnectionMain --StartMethod=windowsService --StartParams=start --StopPath=%BASEDIR% --StopClass=TestConnectionMain --StopMethod=windowsService --StopParams=stop --LogPath=%BASEDIR%\log --StdOutput=auto --StdError=auto
echo installed
:end

