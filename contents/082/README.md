[目次](../toc.md)
[前の問題](../081/README.md)　[次の問題](../083/README.md)


***
## 082：ライブラリ：JPA, Ebean
* JPAまたはEbeanを使用して、以下のテーブル構造のデータを示すエンティティを作成し、INSERT/UPDATE/DELETEの各操作をするためのサンプルコードを実装せよ。(下記SQLはPostgreSQL用だが、他のDB用に変更してよい)

```sql
CREATE TABLE item (
    id bigserial primary key,
    name varchar(20) NOT NULL,
    description text
)
```

