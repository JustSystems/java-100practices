@ECHO OFF
@REM ------------------------------------------------------------------------------
@REM java-100practices
@REM answer009.bat
@REM author: jsfkdt
@REM ------------------------------------------------------------------------------

SET word="Answer038�̉�"

@REM �R���p�C��
javac Answer038.java

@REM �v���p�e�B�t�@�C���̕����R�[�h��ϊ�
native2ascii -encoding UTF-8 Japanese.properties JapaneseMap.properties
native2ascii -encoding UTF-8 English.properties EnglishMap.properties

@REM �v���O�����̎��s
java Answer038 %word%

IF ERRORLEVEL 1 GOTO FAILURE

GOTO SUCCESS

:FAILURE
EXIT /B %ERRORLEVEL%

:SUCCESS