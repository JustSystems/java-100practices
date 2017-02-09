# 解答
membersに対する変更に不整合が発生する可能性があるため、membersに対する処理に対してsynchronizedブロックを使用して排他制御をする。  
ロックを取得するオブジェクトとしてmembersを指定する。
```java
private List<Object> members;
public void add(Object member) {
    synchronized(members){
        members.add(member);
    }
}
public void replace(Object oldMember, Object newMember) {
    synchronized(members){
        if (members.contains(oldMember)) {
            members.remove(oldMember);
            members.add(newMember);
        }
    }
}
```

# 参考
https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html
