[問題](../README.md)

***
# 061：解答例

1. ソースファイル [Answer061.java](src/Answer061.java) とコンパイルおよび実行するための [answer061.bat](answer061.bat) または [answer061.sh](answer061.sh)を準備します。
2. 上記 `answer061.bat` または `answer061.sh` を使用してコンパイル・実行します。


GCに関して押さえておいて頂きたいポイント：
* ヒープはNew領域とOld領域から構成される
* New領域に余裕が無いとGCが発生してNew領域を解放する（これは普通にある）
* Old領域に余裕が無いとFull GCが発生してOld領域を開放するが、固まる（最小限にする）
* オブジェクトをたくさん作って解放しないとNew領域からOld領域に移される
* GCしても領域があまり増えず、メモリが枯渇したらOutOfMemoryエラーになる（技術者の責任）
* Full GCが頻発し始めると、OutOfMemoryエラーも近い

解答例のプログラムのポイントは、無駄なオブジェクトをたくさん作って解放しない、ということです。
このプログラムをじっこするのに、オプションでGC詳細表示してエビデンスとします。
ヒープ領域を小さくすることで再現までの時間が自覚できますが、さらに、New領域も明示的に小さくした方が手っ取り早くOutOfMemoryになります。

以下、解答例プログラムの出力例です。

```
0.054: [GC (Allocation Failure) [PSYoungGen: 512K->496K(1024K)] 512K->544K(7680K
), 0.0018035 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.070: [GC (Allocation Failure) [PSYoungGen: 1008K->492K(1024K)] 1056K->780K(768
0K), 0.0013665 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.073: [GC (Allocation Failure) [PSYoungGen: 977K->497K(1024K)] 1265K->1145K(768
0K), 0.0010100 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.075: [GC (Allocation Failure) [PSYoungGen: 1009K->501K(1024K)] 1934K->1659K(76
80K), 0.0023296 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.079: [GC (Allocation Failure) [PSYoungGen: 1013K->501K(1024K)] 2588K->2612K(76
80K), 0.0040634 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.084: [GC (Allocation Failure) [PSYoungGen: 1013K->501K(1024K)] 3749K->3757K(76
80K), 0.0035280 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.088: [GC (Allocation Failure) [PSYoungGen: 1013K->512K(1024K)] 4269K->4347K(76
80K), 0.0040145 secs] [Times: user=0.08 sys=0.00, real=0.02 secs]
0.093: [GC (Allocation Failure) [PSYoungGen: 1024K->512K(1024K)] 5797K->5861K(76
80K), 0.0054338 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.100: [GC (Allocation Failure) [PSYoungGen: 1024K->512K(1024K)] 6373K->6341K(76
80K), 0.0050538 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.105: [Full GC (Ergonomics) [PSYoungGen: 512K->0K(1024K)] [ParOldGen: 5829K->47
73K(6656K)] 6341K->4773K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.0663848
secs] [Times: user=0.13 sys=0.00, real=0.08 secs]
0.173: [Full GC (Ergonomics) [PSYoungGen: 512K->0K(1024K)] [ParOldGen: 6179K->57
52K(6656K)] 6691K->5752K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.0468304
secs] [Times: user=0.09 sys=0.00, real=0.05 secs]
0.220: [GC (Allocation Failure) [PSYoungGen: 512K->512K(1024K)] 6264K->6272K(768
0K), 0.0028334 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
0.223: [Full GC (Ergonomics) [PSYoungGen: 512K->0K(1024K)] [ParOldGen: 5760K->62
64K(6656K)] 6272K->6264K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.0363618
secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
0.261: [Full GC (Ergonomics) [PSYoungGen: 512K->511K(1024K)] [ParOldGen: 6264K->
6264K(6656K)] 6776K->6775K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030062
9 secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
0.291: [Full GC (Ergonomics) [PSYoungGen: 512K->511K(1024K)] [ParOldGen: 6264K->
6264K(6656K)] 6776K->6775K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030460
7 secs] [Times: user=0.05 sys=0.02, real=0.03 secs]
0.322: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6264K->
6264K(6656K)] 6776K->6776K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028055
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
0.351: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6265K->
6265K(6656K)] 6777K->6777K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.026180
8 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
0.377: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6266K->
6266K(6656K)] 6778K->6778K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030818
4 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
0.409: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6267K->
6267K(6656K)] 6779K->6779K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030689
8 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
0.440: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6268K->
6268K(6656K)] 6780K->6780K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030607
7 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
0.471: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6269K->
6269K(6656K)] 6781K->6781K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033085
8 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
0.505: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6270K->
6270K(6656K)] 6782K->6782K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028512
9 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
0.534: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6271K->
6271K(6656K)] 6783K->6783K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030508
7 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.565: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6272K->
6272K(6656K)] 6784K->6784K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031015
2 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.596: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6273K->
6273K(6656K)] 6785K->6785K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032985
6 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.630: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6274K->
6274K(6656K)] 6786K->6786K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028286
8 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.658: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6275K->
6275K(6656K)] 6787K->6787K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030666
6 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.690: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6276K->
6276K(6656K)] 6788K->6788K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030679
2 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.721: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6277K->
6277K(6656K)] 6789K->6789K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030826
5 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.752: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6278K->
6278K(6656K)] 6790K->6790K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032970
8 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.785: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6279K->
6279K(6656K)] 6791K->6791K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031126
0 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.817: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6280K->
6280K(6656K)] 6792K->6792K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028204
1 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.846: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6281K->
6281K(6656K)] 6793K->6793K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030599
8 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.877: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6282K->
6282K(6656K)] 6794K->6794K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030544
3 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.908: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6283K->
6283K(6656K)] 6795K->6795K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033017
9 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
0.941: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6284K->
6284K(6656K)] 6796K->6796K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028550
3 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
0.971: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6285K->
6285K(6656K)] 6797K->6797K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030674
4 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.002: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6286K->
6286K(6656K)] 6798K->6798K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033122
4 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.035: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6287K->
6277K(6656K)] 6799K->6789K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.049692
1 secs] [Times: user=0.06 sys=0.00, real=0.05 secs]
1.086: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6278K->
6265K(6656K)] 6790K->6777K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.039178
0 secs] [Times: user=0.09 sys=0.00, real=0.05 secs]
1.125: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6266K->
6266K(6656K)] 6778K->6778K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031715
2 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.157: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6267K->
6267K(6656K)] 6779K->6779K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033123
6 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.191: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6268K->
6268K(6656K)] 6780K->6780K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028255
4 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.220: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6269K->
6269K(6656K)] 6781K->6781K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030852
2 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
1.252: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6270K->
6270K(6656K)] 6782K->6782K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.029779
1 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
1.282: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6271K->
6271K(6656K)] 6783K->6783K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030541
0 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
1.313: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6272K->
6272K(6656K)] 6784K->6784K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030647
5 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
1.345: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6273K->
6273K(6656K)] 6785K->6785K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030713
9 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.376: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6274K->
6274K(6656K)] 6786K->6786K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030620
4 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.407: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6275K->
6275K(6656K)] 6787K->6787K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030969
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.438: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6276K->
6276K(6656K)] 6788K->6788K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030699
5 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.470: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6277K->
6277K(6656K)] 6789K->6789K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030713
3 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.501: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6278K->
6278K(6656K)] 6790K->6790K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030807
2 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.532: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6279K->
6279K(6656K)] 6791K->6791K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030576
6 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.563: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6280K->
6280K(6656K)] 6792K->6792K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030955
7 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.595: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6281K->
6281K(6656K)] 6793K->6793K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030362
3 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.626: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6282K->
6282K(6656K)] 6794K->6794K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030496
9 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.657: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6283K->
6283K(6656K)] 6795K->6795K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030803
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.688: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6284K->
6284K(6656K)] 6796K->6796K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030828
6 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
1.719: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6285K->
6285K(6656K)] 6797K->6797K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.024064
3 secs] [Times: user=0.06 sys=0.00, real=0.02 secs]
1.744: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6286K->
6286K(6656K)] 6798K->6798K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.024161
8 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
1.769: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6287K->
6287K(6656K)] 6799K->6799K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028322
7 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
1.797: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6288K->
6288K(6656K)] 6800K->6800K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031096
1 secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
1.829: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6289K->
6289K(6656K)] 6801K->6801K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030122
3 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.860: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6290K->
6290K(6656K)] 6802K->6802K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030733
3 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.891: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6291K->
6291K(6656K)] 6803K->6803K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030746
5 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.922: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6292K->
6292K(6656K)] 6804K->6804K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030564
8 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.953: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6293K->
6293K(6656K)] 6805K->6805K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030788
2 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
1.984: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6294K->
6294K(6656K)] 6806K->6806K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030723
6 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
2.016: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6295K->
6295K(6656K)] 6807K->6807K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030863
1 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
2.047: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6296K->
6296K(6656K)] 6808K->6808K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030676
2 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
2.078: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6297K->
6297K(6656K)] 6809K->6809K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033100
3 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
2.112: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6298K->
6298K(6656K)] 6810K->6810K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028256
3 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
2.141: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6299K->
6299K(6656K)] 6811K->6811K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033432
1 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
2.175: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6300K->
6300K(6656K)] 6812K->6812K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.029155
8 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.204: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6301K->
6301K(6656K)] 6813K->6813K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.029418
4 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
2.234: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6302K->
6302K(6656K)] 6814K->6814K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030874
5 secs] [Times: user=0.09 sys=0.00, real=0.02 secs]
2.266: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6303K->
6303K(6656K)] 6815K->6815K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032491
5 secs] [Times: user=0.09 sys=0.00, real=0.05 secs]
2.299: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6304K->
6304K(6656K)] 6816K->6816K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030731
1 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
2.330: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6305K->
6305K(6656K)] 6817K->6817K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032814
5 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
2.363: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6306K->
6306K(6656K)] 6818K->6818K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033528
9 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
2.397: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6307K->
6307K(6656K)] 6819K->6819K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.027808
7 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
2.425: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6308K->
6308K(6656K)] 6820K->6820K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030736
6 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.457: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6309K->
6309K(6656K)] 6821K->6821K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030656
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.488: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6310K->
6310K(6656K)] 6822K->6822K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030795
7 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.519: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6311K->
6311K(6656K)] 6823K->6823K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030624
6 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.550: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6312K->
6312K(6656K)] 6824K->6824K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033124
8 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.584: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6313K->
6313K(6656K)] 6825K->6825K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028332
7 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.613: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6314K->
6314K(6656K)] 6826K->6826K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033379
8 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.647: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6315K->
6315K(6656K)] 6827K->6827K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030605
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.678: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6316K->
6316K(6656K)] 6828K->6828K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030614
3 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.709: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6317K->
6317K(6656K)] 6829K->6829K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031029
4 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.740: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6318K->
6318K(6656K)] 6830K->6830K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030988
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.772: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6319K->
6319K(6656K)] 6831K->6831K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.027636
6 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
2.800: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6320K->
6320K(6656K)] 6832K->6832K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030999
8 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.831: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6321K->
6321K(6656K)] 6833K->6833K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033111
5 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.865: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6322K->
6322K(6656K)] 6834K->6834K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028133
5 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.894: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6323K->
6323K(6656K)] 6835K->6835K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035160
1 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.929: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6324K->
6324K(6656K)] 6836K->6836K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.026286
5 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.956: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6325K->
6325K(6656K)] 6837K->6837K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030625
5 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
2.987: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6326K->
6326K(6656K)] 6838K->6838K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030719
7 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
3.018: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6327K->
6327K(6656K)] 6839K->6839K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030767
4 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
3.050: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6328K->
6328K(6656K)] 6840K->6840K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030688
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
3.081: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6329K->
6329K(6656K)] 6841K->6841K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030700
4 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
3.112: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6330K->
6330K(6656K)] 6842K->6842K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033476
7 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
3.146: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6331K->
6331K(6656K)] 6843K->6843K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028433
5 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
3.175: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6332K->
6332K(6656K)] 6844K->6844K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032293
5 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
3.208: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6333K->
6333K(6656K)] 6845K->6845K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030766
2 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
3.239: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6334K->
6334K(6656K)] 6846K->6846K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030703
4 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
3.270: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6335K->
6335K(6656K)] 6847K->6847K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030701
3 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
3.301: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6336K->
6336K(6656K)] 6848K->6848K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030741
4 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
3.333: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6337K->
6337K(6656K)] 6849K->6849K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030982
6 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
3.364: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6338K->
6338K(6656K)] 6850K->6850K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030538
6 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
3.395: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6339K->
6339K(6656K)] 6851K->6851K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030708
2 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
3.426: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6340K->
6340K(6656K)] 6852K->6852K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030588
4 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
3.457: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6341K->
6341K(6656K)] 6853K->6853K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030733
6 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
3.489: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6342K->
6342K(6656K)] 6854K->6854K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031366
5 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
3.520: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6343K->
6343K(6656K)] 6855K->6855K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031033
0 secs] [Times: user=0.12 sys=0.00, real=0.02 secs]
3.552: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6344K->
6344K(6656K)] 6856K->6856K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.029764
0 secs] [Times: user=0.13 sys=0.00, real=0.05 secs]
3.582: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6345K->
6345K(6656K)] 6857K->6857K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030735
4 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
3.613: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6346K->
6346K(6656K)] 6858K->6858K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030712
1 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
3.645: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6347K->
6347K(6656K)] 6859K->6859K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030762
5 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
3.676: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6348K->
6348K(6656K)] 6860K->6860K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030678
0 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
3.707: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6349K->
6349K(6656K)] 6861K->6861K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033577
2 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
3.741: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6350K->
6350K(6656K)] 6862K->6862K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031149
2 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
3.773: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6351K->
6351K(6656K)] 6863K->6863K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.027651
1 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
3.801: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6352K->
6352K(6656K)] 6864K->6864K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030433
8 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
3.832: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6353K->
6353K(6656K)] 6865K->6865K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.038977
6 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
3.872: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6354K->
6354K(6656K)] 6866K->6866K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031007
6 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
3.903: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6355K->
6355K(6656K)] 6867K->6867K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031595
6 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
3.935: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6356K->
6356K(6656K)] 6868K->6868K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032931
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
3.969: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6357K->
6357K(6656K)] 6869K->6869K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036733
3 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
4.006: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6358K->
6358K(6656K)] 6870K->6870K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030484
8 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
4.037: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6359K->
6359K(6656K)] 6871K->6871K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031493
9 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.069: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6360K->
6360K(6656K)] 6872K->6872K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.029870
3 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.099: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6361K->
6361K(6656K)] 6873K->6873K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031193
3 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.131: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6362K->
6362K(6656K)] 6874K->6874K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030435
0 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.162: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6363K->
6363K(6656K)] 6875K->6875K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030875
1 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
4.193: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6364K->
6364K(6656K)] 6876K->6876K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030729
3 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.225: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6365K->
6365K(6656K)] 6877K->6877K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030431
7 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.255: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6366K->
6366K(6656K)] 6878K->6878K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031155
8 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.287: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6367K->
6367K(6656K)] 6879K->6879K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030312
2 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.318: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6368K->
6368K(6656K)] 6880K->6880K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031167
3 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
4.350: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6369K->
6369K(6656K)] 6881K->6881K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030961
8 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.381: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6370K->
6370K(6656K)] 6882K->6882K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030099
4 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.412: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6371K->
6371K(6656K)] 6883K->6883K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030765
0 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.443: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6372K->
6372K(6656K)] 6884K->6884K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030582
9 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.474: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6373K->
6373K(6656K)] 6885K->6885K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030749
0 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
4.505: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6374K->
6374K(6656K)] 6886K->6886K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030753
5 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.536: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6375K->
6375K(6656K)] 6887K->6887K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030824
4 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.568: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6376K->
6376K(6656K)] 6888K->6888K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030582
9 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.599: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6377K->
6377K(6656K)] 6889K->6889K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031117
5 secs] [Times: user=0.13 sys=0.00, real=0.02 secs]
4.630: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6378K->
6378K(6656K)] 6890K->6890K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030235
5 secs] [Times: user=0.12 sys=0.00, real=0.05 secs]
4.661: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6379K->
6379K(6656K)] 6891K->6891K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030495
4 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
4.692: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6380K->
6380K(6656K)] 6892K->6892K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030806
6 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
4.723: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6381K->
6381K(6656K)] 6893K->6893K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030675
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
4.755: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6382K->
6382K(6656K)] 6894K->6894K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030766
8 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
4.786: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6383K->
6383K(6656K)] 6895K->6895K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030646
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
4.817: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6384K->
6384K(6656K)] 6896K->6896K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030918
9 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
4.848: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6385K->
6385K(6656K)] 6897K->6897K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030563
3 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
4.880: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6386K->
6386K(6656K)] 6898K->6898K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033823
9 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
4.914: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6387K->
6387K(6656K)] 6899K->6899K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.027746
2 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
4.942: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6388K->
6388K(6656K)] 6900K->6900K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033501
2 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
4.976: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6389K->
6389K(6656K)] 6901K->6901K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.027691
0 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
5.004: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6390K->
6390K(6656K)] 6902K->6902K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030776
4 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
5.036: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6391K->
6391K(6656K)] 6903K->6903K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033092
5 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
5.069: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6392K->
6392K(6656K)] 6904K->6904K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030858
2 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
5.100: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6393K->
6393K(6656K)] 6905K->6905K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030891
7 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
5.132: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6394K->
6394K(6656K)] 6906K->6906K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030554
0 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
5.163: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6395K->
6395K(6656K)] 6907K->6907K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031124
8 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
5.195: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6396K->
6396K(6656K)] 6908K->6908K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030151
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.225: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6397K->
6397K(6656K)] 6909K->6909K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031325
2 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
5.257: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6398K->
6398K(6656K)] 6910K->6910K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030194
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.288: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6399K->
6399K(6656K)] 6911K->6911K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031328
2 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
5.320: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6400K->
6400K(6656K)] 6912K->6912K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030697
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.351: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6401K->
6401K(6656K)] 6913K->6913K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030384
9 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.382: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6402K->
6402K(6656K)] 6914K->6914K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031033
0 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
5.413: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6403K->
6403K(6656K)] 6915K->6915K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030416
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.444: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6404K->
6404K(6656K)] 6916K->6916K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030884
2 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
5.475: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6405K->
6405K(6656K)] 6917K->6917K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030279
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.506: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6406K->
6406K(6656K)] 6918K->6918K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030719
7 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
5.537: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6407K->
6407K(6656K)] 6919K->6919K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030908
6 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
5.569: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6408K->
6408K(6656K)] 6920K->6920K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030557
6 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.600: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6409K->
6409K(6656K)] 6921K->6921K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031403
7 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
5.632: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6410K->
6410K(6656K)] 6922K->6922K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030760
1 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.663: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6411K->
6411K(6656K)] 6923K->6923K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031114
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.695: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6412K->
6412K(6656K)] 6924K->6924K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030882
4 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.726: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6413K->
6413K(6656K)] 6925K->6925K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031230
1 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.758: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6414K->
6414K(6656K)] 6926K->6926K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031732
7 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.790: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6415K->
6415K(6656K)] 6927K->6927K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031705
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.822: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6416K->
6416K(6656K)] 6928K->6928K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032368
7 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.855: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6417K->
6417K(6656K)] 6929K->6929K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032780
7 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.888: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6418K->
6418K(6656K)] 6930K->6930K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033676
6 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.922: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6419K->
6419K(6656K)] 6931K->6931K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036676
0 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
5.960: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6420K->
6420K(6656K)] 6932K->6932K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030972
6 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
5.991: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6421K->
6421K(6656K)] 6933K->6933K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031251
2 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.023: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6422K->
6422K(6656K)] 6934K->6934K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031587
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.055: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6423K->
6423K(6656K)] 6935K->6935K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032469
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.088: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6424K->
6424K(6656K)] 6936K->6936K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032231
0 secs] [Times: user=0.14 sys=0.00, real=0.05 secs]
6.121: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6425K->
6425K(6656K)] 6937K->6937K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033599
9 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.155: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6426K->
6426K(6656K)] 6938K->6938K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.037935
6 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
6.193: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6427K->
6427K(6656K)] 6939K->6939K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030970
8 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.225: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6428K->
6428K(6656K)] 6940K->6940K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031298
6 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.256: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6429K->
6429K(6656K)] 6941K->6941K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031655
1 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.289: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6430K->
6430K(6656K)] 6942K->6942K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031813
6 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.321: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6431K->
6431K(6656K)] 6943K->6943K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032580
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.354: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6432K->
6432K(6656K)] 6944K->6944K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032957
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.387: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6433K->
6433K(6656K)] 6945K->6945K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034307
1 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.422: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6434K->
6434K(6656K)] 6946K->6946K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035698
9 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
6.458: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6435K->
6435K(6656K)] 6947K->6947K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031206
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.490: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6436K->
6436K(6656K)] 6948K->6948K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031869
4 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.522: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6437K->
6437K(6656K)] 6949K->6949K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031921
6 secs] [Times: user=0.13 sys=0.02, real=0.03 secs]
6.555: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6438K->
6438K(6656K)] 6950K->6950K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031480
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.587: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6439K->
6439K(6656K)] 6951K->6951K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032176
4 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.619: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6440K->
6440K(6656K)] 6952K->6952K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033086
1 secs] [Times: user=0.14 sys=0.00, real=0.05 secs]
6.653: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6441K->
6441K(6656K)] 6953K->6953K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033160
4 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.687: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6442K->
6442K(6656K)] 6954K->6954K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033922
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.721: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6443K->
6443K(6656K)] 6955K->6955K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035330
4 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
6.757: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6444K->
6444K(6656K)] 6956K->6956K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031623
7 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.789: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6445K->
6445K(6656K)] 6957K->6957K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032481
2 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.822: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6446K->
6446K(6656K)] 6958K->6958K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033066
8 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.856: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6447K->
6447K(6656K)] 6959K->6959K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033769
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.890: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6448K->
6448K(6656K)] 6960K->6960K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.038252
2 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
6.929: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6449K->
6449K(6656K)] 6961K->6961K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031803
9 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.961: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6450K->
6450K(6656K)] 6962K->6962K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032625
8 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
6.994: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6451K->
6451K(6656K)] 6963K->6963K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032573
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.027: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6452K->
6452K(6656K)] 6964K->6964K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033333
7 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.061: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6453K->
6453K(6656K)] 6965K->6965K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034261
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.096: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6454K->
6454K(6656K)] 6966K->6966K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035356
3 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
7.132: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6455K->
6455K(6656K)] 6967K->6967K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032487
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.165: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6456K->
6456K(6656K)] 6968K->6968K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032521
1 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.197: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6457K->
6457K(6656K)] 6969K->6969K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033664
2 secs] [Times: user=0.26 sys=0.00, real=0.05 secs]
7.232: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6458K->
6458K(6656K)] 6970K->6970K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034727
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.267: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6459K->
6459K(6656K)] 6971K->6971K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036341
5 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
7.304: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6460K->
6460K(6656K)] 6972K->6972K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032155
6 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.336: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6461K->
6461K(6656K)] 6973K->6973K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032758
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.370: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6462K->
6462K(6656K)] 6974K->6974K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033393
4 secs] [Times: user=0.27 sys=0.00, real=0.05 secs]
7.403: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6463K->
6463K(6656K)] 6975K->6975K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034564
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.438: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6464K->
6464K(6656K)] 6976K->6976K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036460
5 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
7.475: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6465K->
6465K(6656K)] 6977K->6977K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032317
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.508: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6466K->
6466K(6656K)] 6978K->6978K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033407
0 secs] [Times: user=0.14 sys=0.00, real=0.05 secs]
7.542: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6467K->
6467K(6656K)] 6979K->6979K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034338
2 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.577: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6468K->
6468K(6656K)] 6980K->6980K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.038309
3 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
7.616: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6469K->
6469K(6656K)] 6981K->6981K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032897
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.649: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6470K->
6470K(6656K)] 6982K->6982K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033322
5 secs] [Times: user=0.14 sys=0.00, real=0.05 secs]
7.683: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6471K->
6471K(6656K)] 6983K->6983K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033951
2 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.718: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6472K->
6472K(6656K)] 6984K->6984K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.037797
9 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
7.756: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6473K->
6473K(6656K)] 6985K->6985K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032473
7 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.789: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6474K->
6474K(6656K)] 6986K->6986K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033070
7 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.822: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6475K->
6475K(6656K)] 6987K->6987K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034761
1 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.858: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6476K->
6476K(6656K)] 6988K->6988K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.038216
9 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
7.896: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6477K->
6477K(6656K)] 6989K->6989K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034200
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
7.931: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6478K->
6478K(6656K)] 6990K->6990K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.038658
8 secs] [Times: user=0.26 sys=0.00, real=0.05 secs]
7.970: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6479K->
6479K(6656K)] 6991K->6991K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036505
1 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
8.007: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6480K->
6480K(6656K)] 6992K->6992K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033219
9 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.041: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6481K->
6481K(6656K)] 6993K->6993K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033893
0 secs] [Times: user=0.23 sys=0.00, real=0.05 secs]
8.075: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6482K->
6482K(6656K)] 6994K->6994K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035406
4 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.111: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6483K->
6483K(6656K)] 6995K->6995K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035855
6 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
8.148: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6484K->
6484K(6656K)] 6996K->6996K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032700
4 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.181: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6485K->
6485K(6656K)] 6997K->6997K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034128
7 secs] [Times: user=0.26 sys=0.00, real=0.05 secs]
8.215: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6486K->
6486K(6656K)] 6998K->6998K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035029
7 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.251: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6487K->
6487K(6656K)] 6999K->6999K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036249
8 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
8.288: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6488K->
6488K(6656K)] 7000K->7000K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033612
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.322: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6489K->
6489K(6656K)] 7001K->7001K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033968
7 secs] [Times: user=0.38 sys=0.00, real=0.05 secs]
8.356: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6490K->
6490K(6656K)] 7002K->7002K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035778
9 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.392: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6491K->
6491K(6656K)] 7003K->7003K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.037004
7 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
8.430: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6492K->
6492K(6656K)] 7004K->7004K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.032980
2 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.463: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6493K->
6493K(6656K)] 7005K->7005K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033781
9 secs] [Times: user=0.27 sys=0.00, real=0.05 secs]
8.498: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6494K->
6494K(6656K)] 7006K->7006K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034880
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.533: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6495K->
6495K(6656K)] 7007K->7007K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.037101
9 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
8.571: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6496K->
6496K(6656K)] 7008K->7008K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034081
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.605: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6497K->
6497K(6656K)] 7009K->7009K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034184
9 secs] [Times: user=0.14 sys=0.00, real=0.05 secs]
8.640: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6498K->
6498K(6656K)] 7010K->7010K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.039471
7 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
8.680: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6499K->
6499K(6656K)] 7011K->7011K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033229
8 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.713: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6500K->
6500K(6656K)] 7012K->7012K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034642
5 secs] [Times: user=0.25 sys=0.02, real=0.05 secs]
8.749: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6501K->
6501K(6656K)] 7013K->7013K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.039997
2 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
8.789: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6502K->
6502K(6656K)] 7014K->7014K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033057
8 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.823: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6503K->
6503K(6656K)] 7015K->7015K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034182
4 secs] [Times: user=0.27 sys=0.00, real=0.05 secs]
8.857: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6504K->
6504K(6656K)] 7016K->7016K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035273
6 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
8.893: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6505K->
6505K(6656K)] 7017K->7017K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036096
1 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
8.930: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6506K->
6506K(6656K)] 7018K->7018K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034391
9 secs] [Times: user=0.14 sys=0.00, real=0.05 secs]
8.965: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6507K->
6507K(6656K)] 7019K->7019K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034886
9 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
9.000: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6508K->
6508K(6656K)] 7020K->7020K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.038445
4 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
9.039: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6509K->
6509K(6656K)] 7021K->7021K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033619
5 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
9.073: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6510K->
6510K(6656K)] 7022K->7022K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034536
5 secs] [Times: user=0.26 sys=0.00, real=0.05 secs]
9.108: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6511K->
6511K(6656K)] 7023K->7023K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.039511
5 secs] [Times: user=0.02 sys=0.00, real=0.03 secs]
9.148: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6512K->
6512K(6656K)] 7024K->7024K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033606
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
9.182: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6513K->
6513K(6656K)] 7025K->7025K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035878
2 secs] [Times: user=0.27 sys=0.00, real=0.05 secs]
9.218: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6514K->
6514K(6656K)] 7026K->7026K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.038251
0 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
9.257: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6515K->
6515K(6656K)] 7027K->7027K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033372
3 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
9.291: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6516K->
6516K(6656K)] 7028K->7028K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035288
1 secs] [Times: user=0.25 sys=0.00, real=0.05 secs]
9.327: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6517K->
6517K(6656K)] 7029K->7029K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.039989
0 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
9.367: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6518K->
6518K(6656K)] 7030K->7030K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034306
8 secs] [Times: user=0.14 sys=0.00, real=0.05 secs]
9.402: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6519K->
6519K(6656K)] 7031K->7031K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036380
5 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
9.439: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6520K->
6520K(6656K)] 7032K->7032K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036897
5 secs] [Times: user=0.11 sys=0.02, real=0.03 secs]
9.476: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6521K->
6521K(6656K)] 7033K->7033K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034192
1 secs] [Times: user=0.14 sys=0.00, real=0.05 secs]
9.511: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6522K->
6522K(6656K)] 7034K->7034K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.035676
0 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
9.547: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6523K->
6523K(6656K)] 7035K->7035K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034078
9 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
9.582: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6524K->
6524K(6656K)] 7036K->7036K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030603
2 secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
9.613: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6525K->
6525K(6656K)] 7037K->7037K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.027009
4 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
9.640: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6526K->
6526K(6656K)] 7038K->7038K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.034391
9 secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
9.675: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6527K->
6527K(6656K)] 7039K->7039K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030783
4 secs] [Times: user=0.06 sys=0.00, real=0.03 secs]
9.707: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6528K->
6528K(6656K)] 7040K->7040K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030650
3 secs] [Times: user=0.08 sys=0.00, real=0.03 secs]
9.738: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6529K->
6529K(6656K)] 7041K->7041K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.036701
6 secs] [Times: user=0.09 sys=0.00, real=0.03 secs]
9.775: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6530K->
6530K(6656K)] 7042K->7042K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028356
8 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
9.804: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6531K->
6531K(6656K)] 7043K->7043K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.028731
7 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
9.833: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6532K->
6532K(6656K)] 7044K->7044K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.033081
3 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
9.867: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6533K->
6533K(6656K)] 7045K->7045K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.042253
2 secs] [Times: user=0.14 sys=0.00, real=0.05 secs]
9.909: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6534K->
6534K(6656K)] 7046K->7046K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.031107
5 secs] [Times: user=0.13 sys=0.00, real=0.03 secs]
9.941: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6535K->
6535K(6656K)] 7047K->7047K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030279
0 secs] [Times: user=0.12 sys=0.00, real=0.03 secs]
9.972: [Full GC (Ergonomics) [PSYoungGen: 512K->512K(1024K)] [ParOldGen: 6536K->
6536K(6656K)] 7048K->7048K(7680K), [Metaspace: 2527K->2527K(1056768K)], 0.030730
5 secs] [Times: user=0.11 sys=0.00, real=0.03 secs]
Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceede
d
10.004: [Full GC (Ergonomics) [PSYoungGen: 512K->0K(1024K)] [ParOldGen: 6539K->4
37K(6656K)] 7051K->437K(7680K), [Metaspace: 2552K->2552K(1056768K)], 0.0048510 s
ecs] [Times: user=0.00 sys=0.00, real=0.00 secs]
        at Answer061.main(Answer061.java:8)
Heap
 PSYoungGen      total 1024K, used 10K [0x00000000ffe80000, 0x0000000100000000,
0x0000000100000000)
  eden space 512K, 2% used [0x00000000ffe80000,0x00000000ffe82b20,0x00000000fff0
0000)
  from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x000000010000
0000)
  to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff8
0000)
 ParOldGen       total 6656K, used 437K [0x00000000ff800000, 0x00000000ffe80000,
 0x00000000ffe80000)
  object space 6656K, 6% used [0x00000000ff800000,0x00000000ff86d5b0,0x00000000f
fe80000)
 Metaspace       used 2558K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 275K, capacity 386K, committed 512K, reserved 1048576K

```
