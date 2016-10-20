[問題](../README.md)

***
# 061：解答例
## 実行コマンド
```
java -Xms4m -Xmx4m -XX:NewSize=500k -XX:MaxNewSize=500k -Xloggc:./gc.txt -XX:+PrintGCDetails Answer061
```
[ソースコード(Answer061.java)](src/Answer061.java)

## 標準エラー出力...
```
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Unknown Source)
        at java.util.Arrays.copyOf(Unknown Source)
        at java.util.ArrayList.grow(Unknown Source)
        at java.util.ArrayList.ensureExplicitCapacity(Unknown Source)
        at java.util.ArrayList.ensureCapacityInternal(Unknown Source)
        at java.util.ArrayList.add(Unknown Source)
        at Answer061.main(Answer061.java:9)
```
## gc.txtの内容...
```
Java HotSpot(TM) 64-Bit Server VM (25.102-b14) for windows-amd64 JRE (1.8.0_102-b14), built on Jun 22 2016 13:15:21 by "java_re" with MS VC++ 10.0 (VS2010)
Memory: 4k page, physical 8266684k(4451360k free), swap 16531508k(12326768k free)
CommandLine flags: -XX:InitialHeapSize=4194304 -XX:MaxHeapSize=4194304 -XX:MaxNewSize=512000 -XX:NewSize=512000 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC 
0.075: [GC (Allocation Failure) [PSYoungGen: 512K->491K(1024K)] 512K->515K(3584K), 0.0010327 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
0.093: [GC (Allocation Failure) [PSYoungGen: 1003K->492K(1024K)] 1027K->780K(3584K), 0.0098167 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
0.104: [GC (Allocation Failure) [PSYoungGen: 977K->497K(1024K)] 1265K->1141K(3584K), 0.0132578 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
0.119: [GC (Allocation Failure) [PSYoungGen: 1009K->485K(1024K)] 1930K->1631K(3584K), 0.0232514 secs] [Times: user=0.09 sys=0.00, real=0.02 secs] 
0.144: [GC (Allocation Failure) [PSYoungGen: 997K->501K(1024K)] 2560K->2568K(3584K), 0.0036772 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
0.147: [Full GC (Ergonomics) [PSYoungGen: 501K->0K(1024K)] [ParOldGen: 2066K->2216K(2560K)] 2568K->2216K(3584K), [Metaspace: 2575K->2575K(1056768K)], 0.0330071 secs] [Times: user=0.06 sys=0.00, real=0.03 secs] 
0.181: [GC (Allocation Failure) [PSYoungGen: 336K->416K(1024K)] 2552K->2632K(3584K), 0.0019488 secs] [Times: user=0.08 sys=0.00, real=0.00 secs] 
0.183: [Full GC (Ergonomics) [PSYoungGen: 416K->0K(1024K)] [ParOldGen: 2216K->2551K(2560K)] 2632K->2551K(3584K), [Metaspace: 2575K->2575K(1056768K)], 0.0181096 secs] [Times: user=0.08 sys=0.00, real=0.02 secs] 
0.201: [GC (Allocation Failure) [PSYoungGen: 0K->0K(1024K)] 2551K->2551K(3584K), 0.0003314 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
0.201: [Full GC (Allocation Failure) [PSYoungGen: 0K->0K(1024K)] [ParOldGen: 2551K->2539K(2560K)] 2551K->2539K(3584K), [Metaspace: 2575K->2575K(1056768K)], 0.0276199 secs] [Times: user=0.09 sys=0.00, real=0.03 secs] 
Heap
 PSYoungGen      total 1024K, used 20K [0x00000000ffe80000, 0x0000000100000000, 0x0000000100000000)
  eden space 512K, 4% used [0x00000000ffe80000,0x00000000ffe852e0,0x00000000fff00000)
  from space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
  to   space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 ParOldGen       total 2560K, used 2539K [0x00000000ffc00000, 0x00000000ffe80000, 0x00000000ffe80000)
  object space 2560K, 99% used [0x00000000ffc00000,0x00000000ffe7acb0,0x00000000ffe80000)
 Metaspace       used 2606K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 290K, capacity 386K, committed 512K, reserved 1048576K
```
