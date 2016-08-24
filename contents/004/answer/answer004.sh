#!/bin/sh
# -------------------------------------------------------
# java-100practices
# answer004.sh
# author: jswaf
# -------------------------------------------------------

errorcheck()
{
    if [ $1 -ne 0 ]; then
        exit $1
    fi
}

CLASSES=../../001/answer/classes

java -cp ${CLASSES} Answer001
errorcheck $?
