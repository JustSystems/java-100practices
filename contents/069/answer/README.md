[問題](../README.md)

***
# 069：解答例
## 問題点
1. `m.setTargetYear()`の箇所に問題がある。
もし`req.getParameter("yearParam1")`や`req.getParameter("yearParam2")`が`null`の場合、
`Integer.valueOf()`メソッドにて`NullPointerException`が発生してしまうからである。
2. 取得したyear文字列が数値表現でない場合に例外が発生してしまう。
2. 例外が発生した場合のリターンコードの設定や処理の記載が無い。
3. `Integer`は参照型なので、`==`での比較は安全では無い。
`equals()`メソッドを用いて比較する。または`Integer.parseInt()`メソッドで`int`型にしてから`==`での比較を行う。

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
        
        final String param1 = req.getParameter("yearParam1");
        final String param2 = req.getParameter("yearParam2");
        
        /* 各Paramがnullかどうかのチェックを行い、nullであればエラーを出力し、リターンコードを設定する. */
        if (param1 == null || param2 == null) {
            // リターンコードの設定.
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            // エラーの出力.
            res.getWriter().write(m.toJsonForError());
            return;
        }
        
        /* 例外を捕捉する. */
        try {
            // yearParam1とyearParam2を数値に変換したとき、同じ値の場合にtrueをいれる
            m.setTargetYear(Integer.parseInt(param1) == Integer.parseInt(param2));
            
        catch (NumberFormatException e) {
            // リターンコードの設定.
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            // エラーの出力.
            res.getWriter().write(m.toJsonForError());
            return;
        }
        
        /* 正常終了の場合のリターンコードの設定. */
        res.setStatus(HttpServletResponse.SC_OK);
        
        res.getWriter().write(m.toJson());
    }
}
```
