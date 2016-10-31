[問題](../README.md)

***
# 074：解答例
## 問題点
1. `jsp`内でロジック上の問題がある。（`NullPointerException`が発生してしまう）
2. `view`内でビジネスロジックを実装してしまっている箇所がある。
3. 実装内に`XSS`の脆弱性があるので、エスケープ処理をする必要がある。

## 修正
```java
public class Item {

    private int id;
    private String name;
    private int price;
    private String description;
    private String postage; // 送料.

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        // 送料に関する文字列を設定.
        if (price <= 0) {
            postage = "※商品情報が取得できません。";
        } else if (price >= 1000) {
            postage = "※送料は無料です。";
        } else {
            postage = "※送料が別途250円かかります。";
        }
        this.price = price;
    }

    public String getName() {
    
        return name;
    }
    public void setName(String name) {
        if (name == null) {
            this.name = name;
        }
        
        if (name.length() <= 10) {
            this.name = name;
        } else {
            this.name = name.substring(0, 10) + "...";
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) { // descriptionがnullでない場合
            this.description = description;
        }
        
        if (description.length() <= 100) {
            this.description = description;
        } else {
            this.description = description.substring(0, 100) + "...";
        }
    }
    
}
```

```jsp
<html>
<head>
<title>商品検索結果画面</title>
</head>
<body>
商品ID：<c:out value="${item.id}" escapeXml="true"/><br>
商品名：<c:out value="${item.name}" escapeXml="true"/><br>
価格：<c:out value="${item.price}" escapeXml="true"/>円<br>
<c:out value="${item.postage}" escapeXml="true"/>円<br>
紹介文：<c:out value="${item.description}" escapeXml="true"/>円<br>
</body>
</html>
```