#include <stdio.h>
#include <stdlib.h>
#include "Answer019.h"
// ランダムで返す整数の最大値
#define MAX 7

/**
 * 0からMAXの整数をランダムで返す
 */
JNIEXPORT jint JNICALL Java_Answer019_randomNum (JNIEnv *evn, jobject obj) {
    return rand() % MAX + 1;
};
