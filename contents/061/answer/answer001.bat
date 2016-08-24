@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM answer061.bat
@REM author: jswaf
@REM -------------------------------------------------------

SET CLASSES=classes

IF NOT EXIST %CLASSES% (
    MKDIR %CLASSES%
    IF ERRORLEVEL 1 GOTO FAILURE
)

javac -sourcepath src -d %CLASSES% -encoding UTF-8 src\Answer061.java
IF ERRORLEVEL 1 GOTO FAILURE

java -cp %CLASSES% -Xms8m -Xmx8m -XX:NewSize=1536k -XX:MaxNewSize=1536k -verbose:gc -XX:+PrintGCTimeStamps -XX:+PrintGCDetails Answer061
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
