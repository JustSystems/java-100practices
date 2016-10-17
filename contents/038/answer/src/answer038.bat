@ECHO OFF
@REM ------------------------------------------------------------------------------
@REM java-100practices
@REM answer009.bat
@REM author: jsfkdt
@REM ------------------------------------------------------------------------------

SET word="Answer038の解答"

@REM コンパイル
javac Answer038.java

@REM プロパティファイルの文字コードを変換
native2ascii -encoding UTF-8 language_en.properties output_en.properties
native2ascii -encoding UTF-8 language_ja.properties output_ja.properties

@REM プログラムの実行
java Answer038 %word%

IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS
