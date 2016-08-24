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

java -Dhttp.proxyHost=proxy.example.com -Dhttp.proxyPort=80 -Dhttp.nonProxyHosts=*.noproxy.example.com -cp ${CLASSES} Answer001
errorcheck $?
