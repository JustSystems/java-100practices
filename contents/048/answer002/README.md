# 解答
`find()`
指定のパターン（正規表現）が検索対象のどこかと一致した場合  
使用シーンの例：検索対象に「hoge」という文字が含まれているかを検索するとき  
○ : http://hoge.com  
○ : https://hoge.com  
○ : https://hoge.com/index.htm

`lookingAt()`
指定のパターン（正規表現）が検索対象の先頭から一致した場合（前方一致）  
使用シーンの例：検索対象に「https://」から始まるURLを検索するとき  
× : http://hoge.com  
○ : https://hoge.com  
○ : https://hoge.com/index.htm

`matches()`
指定のパターン（正規表現）が検索対象の全体に一致した場合（完全一致）
使用シーンの例：検索対象に「https」から始まり「.htm」で終わるURLを検索するとき  
× : http://hoge.com  
× : https://hoge.com  
○ : https://hoge.com/index.htm

# 参考
https://docs.oracle.com/javase/jp/8/docs/api/java/util/regex/Matcher.html
