@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM answer003.bat
@REM author: jswaf
@REM -------------------------------------------------------

SET CLASSES=..\..\001\answer\classes

java -Dhttp.proxyHost=proxy.example.com -Dhttp.proxyPort=80 -Dhttp.nonProxyHosts=*.noproxy.example.com -cp %CLASSES% Answer001
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
