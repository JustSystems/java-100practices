[問題](../README.md)

***
# 036：解答例
```java
private List<Object> members = new ArrayList<Object>();
public void add(Object member) {
    synchrozied(members) {
        members.add(member);
    }
}
public void replace(Object oldMember, Object newMember) {
    synchrozied(members) {
        if (members.contains(oldMember)) {
            members.remove(oldMember);
            members.add(newMember);
        }
    }
}
```