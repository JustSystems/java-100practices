@ECHO OFF
@REM -------------------------------------------------------
@REM java-100practices
@REM answer010.bat
@REM author: jsfkdt
@REM -------------------------------------------------------

SET CLASSES=classes
SET JARFILE=answer010.jar

IF NOT EXIST %CLASSES% (
    MKDIR %CLASSES%
    IF ERRORLEVEL 1 GOTO FAILURE
)
@REM -------------------------------------------------------
@REM クラスを生成
@REM -------------------------------------------------------
javac -sourcepath src -d %CLASSES% -encoding UTF-8 src\Answer010.java
IF ERRORLEVEL 1 GOTO FAILURE

@REM -------------------------------------------------------
@REM 実行可能jarファイルを作成（マニフェストの作成）
@REM -C classesでclasses直下に移動している。
@REM -------------------------------------------------------
jar cfe %JARFILE% Answer010 -C %CLASSES% Answer010.class
IF ERRORLEVEL 1 GOTO FAILURE

@REM -------------------------------------------------------
@REM 実行可能jarファイルの実行
@REM -------------------------------------------------------
java -jar %JARFILE%
IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
