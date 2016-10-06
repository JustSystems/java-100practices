`private`コンストラクタを実装することで、他クラスからインスタンスを作成できないようにしました。
`answer016.bat`を実行すると以下のようなエラーが発生します。
```
src\Answer016.java:12: エラー: Answer016Private()はAnswer016Privateでprivateアクセスされます
        new Answer016Private();
        ^
エラー1個
```
