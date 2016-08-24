#!/bin/sh
# -------------------------------------------------------
# java-100practices
# answer010.sh
# author: jswaf
# -------------------------------------------------------

errorcheck()
{
    if [ $1 -ne 0 ]; then
        exit $1
    fi
}

CLASSES=classes
JARFILE=answer010.jar

if [ ! -d ${CLASSES} ]; then
    mkdir ${CLASSES}
    errorcheck $?
fi

javac -sourcepath src -d ${CLASSES} -encoding UTF-8 src/Answer010.java
errorcheck $?

jar cfe ${JARFILE} Answer010 -C ${CLASSES} Answer010.class
errorcheck $?

java -jar ${JARFILE}
errorcheck $?
