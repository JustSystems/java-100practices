[目次](../toc.md)
[前の問題](../067/README.md)　[次の問題](../069/README.md)


***
## 068：複合(8)
* 以下はリクエストパラメータの情報をModelクラスのインスタンスに変換し、JSON化して出力するサーブレットである。問題点を指摘し、修正せよ。なお、Modelクラスは適切な実装が与えられているものとする。

```java
public class Knock068 extends HttpServlet {
    // 2014/01/01 23:50:11なスタイルでパーズする
    private final static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        Model m = new Model();
        m.setId(req.getParameter("id"));
        m.setDate(FORMAT.parse(req.getParameter("date")));
        m.setSize(Integer.parseInt(req.getParameter("size")));
        m.setMemo(req.getParameter("memo"));

        res.getWriter().write(m.toJson());
    }
}
```

