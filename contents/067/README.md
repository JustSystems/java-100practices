[目次](../toc.md)
[前の問題](../066/README.md)　[次の問題](../068/README.md)


***
## 067：複合(7)
* 以下は、チケット発行処理プログラムの一部である。問題点を指摘し、修正せよ

```java
public class Knock067 {

    private static final Knock067 instance = new Knock067();
    private int releaseTicketId = 0;// チケットに付与する通し番号

    public static Knock067 getInstance() {
        return instance;
    }

    // チケットを発行する
    public Tiket publishConcertTicket(String userName, Date date) {
        Tiket tiket = new ConcertTiket(userName, date, releaseTicketId);

        // チケットの登録処理（省略）
        // ...
        // ...
        // ...

        this.releaseTicketId += 1;        
        return tiket;
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

