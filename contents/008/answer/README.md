[問題](../README.md)

***
# 008：解答例

```
javap -v -cp クラスパス 対象クラス
```

とします。例：

```
javap -v -cp classes Answer008
```

ここで、先頭の方に以下のような出力があります。

```
minor version: 0
major version: 52
```


なお、major versionを見ることで、どのバージョンのJavaをターゲットに作られたかを知ることができます。

|major version|Java version|
|:-----------:|:----------:|
|46|1.2|
|47|1.3|
|48|1.4|
|49|5|
|50|6|
|51|7|
|52|8|
