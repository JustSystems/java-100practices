[問題](../README.md)

***
# 067：解答例
## 問題点
1. 変数`releaseTicketId`がスレッドアンセーフな変数であること。
2. 複数スレッドにより、`publishConcertTicket()`メソッドが実行された場合、
変数`releaseTicketId`のインクリメント処理にて競合が発生し、
期待していた数値と異なる数値が代入されてしまう可能性がある。
3. コンストラクタはデフォルトコンストラクタであり、その修飾子はクラスの修飾子と同じく
`public`となっているため、このクラスのインスタンスを複数個生成出来る状態となっている。
そのため、`releaseTicketId`は一意に保たれなくなってしまう可能性がある。
`releaseTickedId`の一意性を保つために、デフォルトコンストラクタを`private`にして、
他からインスタンス生成できない状態にする必要がある。
4. 修正前の実装のままだと、チケット`ID`の上限設定が無いため、
`Integer`型上限のチケット`ID`に達した状態で`ID`をインクリメントすると
チケット`ID`がマイナスの値（`Integer`型の最小値）になってしまう。
それを防ぐためにチケット`ID`が上限を超えた場合に、例外が発生するよう実装する必要がある。

## 修正
```java
public class Knock067 {
    private static final Knock067 instance = new Knock067();
    
    // volatile修飾子で宣言する. #1
    private volatile Integer releaseTicketId = 0;// チケットに付与する通し番号
    
    // コンストラクタにprivate修飾子を付けることでインスタンス化を防ぐ. #3
    private Knock067() {
    }

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
            
            // チケットIDが上限を超えた場合、例外を発生させる. #4
            try {
                this.releaseTicketId += 1;
                if (this.releaseTicketId == Integer.MIN_VALUE) {
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException e) {
                System.err.println("エラー原因：チケットIDが上限を超えたため");
                e.printStackTrace();
            }
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