@ECHO OFF
@REM ------------------------------------------------------------------------------
@REM java-100practices
@REM answer015.bat
@REM author: jsfkdt
@REM ------------------------------------------------------------------------------

SET CLASSES=classes

IF NOT EXIST %CLASSES% (
    MKDIR %CLASSES%
    IF ERRORLEVEL 1 GOTO FAILURE
)

javac -d %CLASSES% src\Answer015.java
IF ERRORLEVEL 1 GOTO FAILURE

java -cp %CLASSES% Answer015
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
