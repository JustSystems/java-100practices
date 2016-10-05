@ECHO OFF
@REM ------------------------------------------------------------------------------
@REM java-100practices
@REM answer015.bat
@REM author: jsfkdt
@REM ------------------------------------------------------------------------------

javac answer015.java
java answer015

IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
