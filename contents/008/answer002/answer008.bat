@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM answer008.bat
@REM author: jsfkdt
@REM -------------------------------------------------------

SET CLASSES=..\..\001\answer002

javap -v -cp %CLASSES% Answer001
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS

@REM -------------------------------------------------------
@REM 実行結果
@REM classファイルのバージョンを記載
@REM major version: 52
@REM -------------------------------------------------------