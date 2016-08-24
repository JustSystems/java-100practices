@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM answer003.bat
@REM author: jswaf
@REM -------------------------------------------------------

SET CLASSES=..\..\001\answer\classes

java -Xms1G -Xmx1G -cp %CLASSES% Answer001
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
