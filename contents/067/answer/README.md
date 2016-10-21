[問題](../README.md)

***
# 067：解答例
## 問題点
1. 変数`releaseTicketId`がスレッドアンセーフな変数であること。
2. 複数スレッドにより、`publishConcertTicket()`メソッドが実行された場合、
変数`releaseTicketId`のインクリメント処理にて競合が発生し、
期待していた数値と異なる数値が代入されてしまう可能性がある。

## 修正
```java
public class Knock067 {
    private static final Knock067 instance = new Knock067();
    
    // int型ではなくvolatile型で宣言する. #1
    private volatile releaseTicketId = 0;// チケットに付与する通し番号

    public static Knock067 getInstance() {
        return instance;
    }

    // チケットを発行する
    public Tiket publishConcertTicket(String userName, Date date) {
        // スレッドセーフな仕組みにする必要がある. #2
        synchronized (releaseTicketId) {
        
            Tiket tiket = new ConcertTiket(userName, date, releaseTicketId);

            // チケットの登録処理（省略）
            // ...
            // ...
            // ...

            this.releaseTicketId += 1;
            return tiket;
        }
    }

    // チケットを破棄（無効化）する
    public void deleteConcertTicket(int releaseTicketId) {

        // チケットの無効化処理（省略）
        // ...
        // ...
        // ...
    }    
}
```