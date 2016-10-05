@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM answer004.bat
@REM author: jsfkdt
@REM -------------------------------------------------------

SET CLASSES=..\..\001\answer002

java -cp %CLASSES% Answer001
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS