@ECHO OFF
@REM ------------------------------------------------------------------------------
@REM java-100practices
@REM answer009.bat
@REM author: jsfkdt
@REM ------------------------------------------------------------------------------

javac Answer009_2.java

@REM 変換前プロパティファイルのロード
java Answer009_2 sample.properties

@REM 
native2ascii -encoding UTF-8 sample.properties sample2.properties

@REM 変換後プロパティファイルのロード
java Answer009_2 sample2.properties

IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
