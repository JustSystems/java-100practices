Q14のℓ2～5を書き換えると、
```java
private String name = "created_name" + name;
```
このときに、右辺の`name`は参照先が存在しないため初期値が入る。
また、参照型の初期値は`null`であることより、
標準出力結果：`created_name=null `となる。
