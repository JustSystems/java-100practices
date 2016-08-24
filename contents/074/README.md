[目次](../toc.md)
[前の問題](../073/README.md)　[次の問題](../075/README.md)


***
## 074：複合(14)
* 以下は、ある商品レコードを検索し、結果を出力するJSTLである。問題点を指摘し、修正せよ。

```java:Item.java
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
}
```

```jsp:item.jsp
<html>
<head>
<title>商品検索結果画面</title>
</head>
<body>
商品ID：<c:out value="${item.id}" /><br>
商品名：<%
    //10文字を超えたら、省略表記にする
    Item item = (Item)request.getAttribute("item");
    String name = item.getName();
    if (name.length() <= 10) {
        out.println(name);
    } else {
        out.println(name.substring(0, 10) + "...");
    }
%>;

価格：<c:out value="${item.price}"/>円<br>
<c:choose>
    <c:when test="${item.price >= 1000}">
    ※送料は無料です。
    </ c:when>
    <c:otherwise>
    ※送料が別途250円かかります。
    </c:otherwise>
</c:choose>
紹介文：
<%
    //100文字を超えたら、省略表記にする
    String description = item.getDescription();
    if (description.length() <= 100) {
        out.println(description);
    } else {
        out.println(description.substring(0, 100) + "...");
    }
%><br>

</body>
</html>
```

