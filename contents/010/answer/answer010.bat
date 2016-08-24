@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM answer010.bat
@REM author: jswaf
@REM -------------------------------------------------------

SET CLASSES=classes
SET JARFILE=answer010.jar

IF NOT EXIST %CLASSES% (
    MKDIR %CLASSES%
    IF ERRORLEVEL 1 GOTO FAILURE
)

javac -sourcepath src -d %CLASSES% -encoding UTF-8 src\Answer010.java
IF ERRORLEVEL 1 GOTO FAILURE

jar cfe %JARFILE% Answer010 -C %CLASSES% Answer010.class
IF ERRORLEVEL 1 GOTO FAILURE

java -jar %JARFILE%
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
