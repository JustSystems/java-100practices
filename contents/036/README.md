[目次](../toc.md)
[前の問題](../035/README.md)　[次の問題](../037/README.md)


***
## 036：排他
* 以下のプログラムをスレッドセーフにせよ。
    * 排他処理は極力短くなるようにせよ。

```java
private List<Object> members;
public void add(Object member) {
    members.add(member);
}
public void replace(Object oldMember, Object newMember) {
    if (members.contains(oldMember)) {
        members.remove(oldMember);
        members.add(newMember);
    }
}
```

