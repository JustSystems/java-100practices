[問題](../README.md)

***
# 036：解答例
```java
private List<Object> members;

// addメソッドにてスレッドセーフを行う.
synchronized public void add(Object member) {
    members.add(member);
}
public void replace(Object oldMember, Object newMember) {
    if (members.contains(oldMember)) {
        members.remove(oldMember);
        members.add(newMember);
    }
}
```