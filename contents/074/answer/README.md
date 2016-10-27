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
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    // 送料に関する文字列を返すメソッド.
    public String getPostage() {
        if (price == 0) {
            return "※商品情報が取得できません。";
        } else if (price >= 1000) {
            return "※送料は無料です。";
        } else {
            return "※送料が別途250円かかります。";
        }
}
```

```jsp
<html>
<head>
<title>商品検索結果画面</title>
</head>
<body>
商品ID：<c:out value="${item.id}" escapeXml="true"/><br> <%-- エスケープ処理を実施 --%>
商品名：&lt;\%
    Item item = (Item)request.getAttribute("item");
    if (item != null) { <%-- itemがnullでない場合 --%>
        String name = item.getName();
        if (name != null) { <%-- nameがnullでない場合 --%>
            if (name.length() &lt;= 10) {
                out.println(name);
            } else {
                out.println(name.substring(0, 10) + "...");
            }
        }
    }
%\>;

価格：<c:out value="${item.price}" escapeXml="true"/>円<br> <%-- エスケープ処理を実施 --%>
&lt;\%
    <%--送料を取得--%>
    String postage = item.getPostage();
    out.println(postage);
%\>;

紹介文：
&lt;\%
    String description = item.getDescription();
    if (description != null) { <%-- descriptionがnullでない場合 --%>
        if (description.length() &lt;= 100) {
            out.println(description);
        } else {
            out.println(description.substring(0, 100) + "...");
        }
    }
%\><br>

</body>
</html>
```