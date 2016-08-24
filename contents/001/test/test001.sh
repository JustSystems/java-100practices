#!/bin/sh
# -------------------------------------------------------
# java-100practices
# test001.sh
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

CLASSPATH="${CLASSES}:../answer/classes"
for f in ../../../lib/* ;do
    CLASSPATH="$CLASSPATH:$f"
done
if type -path cygpath > /dev/null 2>&1 ; then
    CLASSPATH="`cygpath -wp "${CLASSPATH}"`"
fi

javac -cp ${CLASSPATH} -sourcepath src -d ${CLASSES} -encoding UTF-8 src/Test001.java
errorcheck $?

java -cp ${CLASSPATH} org.junit.runner.JUnitCore Test001
errorcheck $?
