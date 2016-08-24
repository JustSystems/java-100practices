@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM answer001.bat
@REM author: jswaf
@REM -------------------------------------------------------

SET CLASSES=classes

IF NOT EXIST %CLASSES% (
    MKDIR %CLASSES%
    IF ERRORLEVEL 1 GOTO FAILURE
)

javac -sourcepath src -d %CLASSES% -encoding UTF-8 src\Answer001.java
IF ERRORLEVEL 1 GOTO FAILURE

java -cp %CLASSES% Answer001
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
