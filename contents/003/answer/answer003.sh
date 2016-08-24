#!/bin/sh
# -------------------------------------------------------
# java-100practices
# answer003.sh
# author: jswaf
# -------------------------------------------------------

errorcheck()
{
    if [ $1 -ne 0 ]; then
        exit $1
    fi
}

CLASSES=../../001/answer/classes

java -Xms1G -Xmx1G -cp ${CLASSES} Answer001
errorcheck $?
