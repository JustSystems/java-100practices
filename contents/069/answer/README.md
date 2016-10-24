[問題](../README.md)

***
# 069：解答例
## 問題点
`m.setTargetYear()`の箇所に問題がある。
もし`req.getParameter("yearParam1")`や`req.getParameter("yearParam2")`が`null`の場合、
`Integer.valueOf()`メソッドにて`NullPointerException`が発生してしまうからである。

## 修正
```java
public class Knock069 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");

        Model m = new Model();
        // idをセットする。ただし、パラメータがない（null）の時は、空値とする。
        m.setId(req.getParameter("id") == null ? "" : req.getParameter("id"));

        // memoをメモとして取得・設定する（null値の場合はnullをセット） 
        m.setMemo(req.getParameter("memo"));
        
        
        /* 各Paramがnullかどうかのチェックを行い、nullであれば0として扱うよう修正.どちらもnullの場合trueを設定. */
        // yearParam1とyearParam2を数値に変換したとき、同じ値の場合にtrueをいれる
        m.setTargetYear((req.getParameter("yearParam1") == null ? 0 : Integer.valueOf(req.getParameter("yearParam1")))
                      ==(req.getParameter("yearParam2") == null ? 0 : Integer.valueOf(req.getParameter("yearParam2"))));

        res.getWriter().write(m.toJson());
    }
}
```
