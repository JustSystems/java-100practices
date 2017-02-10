# 解答
"2nd"が出力される

try句内でthrowされたExceptionは破棄されて、finally句内でthrowされたExceptionがcatchされるため

# 参考
http://docs.oracle.com/javase/specs/jls/se8/html/jls-14.html#jls-14.20.2  
If the finally block completes abruptly for reason S, then the try statement completes abruptly for reason S (and reason R is discarded).
