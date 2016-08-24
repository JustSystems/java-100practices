#!/bin/sh
# -------------------------------------------------------
# java-100practices
# answer061.sh
# author: jswaf
# -------------------------------------------------------

errorcheck()
{
    if [ $1 -ne 0 ]; then
        exit $1
    fi
}

CLASSES=classes

if [ ! -d ${CLASSES} ]; then
    mkdir ${CLASSES}
    errorcheck $?
fi

javac -sourcepath src -d ${CLASSES} -encoding UTF-8 src/Answer061.java
errorcheck $?

java -cp ${CLASSES} -Xms8m -Xmx8m -XX:NewSize=1536k -XX:MaxNewSize=1536k -verbose:gc -XX:+PrintGCTimeStamps -XX:+PrintGCDetails Answer061
errorcheck $?
