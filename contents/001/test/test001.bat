@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM test001.bat
@REM author: jswaf
@REM -------------------------------------------------------

SET CLASSES=classes

IF NOT EXIST %CLASSES% (
    MKDIR %CLASSES%
    IF ERRORLEVEL 1 GOTO FAILURE
)

SET CLASSPATH=%CLASSES%;..\answer\classes;..\..\..\lib\*

javac -cp %CLASSPATH% -sourcepath src -d %CLASSES% -encoding UTF-8 src\Test001.java
IF ERRORLEVEL 1 GOTO FAILURE

java -cp %CLASSPATH% org.junit.runner.JUnitCore Test001
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
