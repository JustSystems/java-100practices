[目次](../toc.md)
[前の問題](../071/README.md)　[次の問題](../073/README.md)


***
## 072：複合(12)
* 以下は、あるサーブレットの処理である。問題点を指摘し、修正せよ。

```java
public class Knock072 extends HttpServlet {

    private final static Logger logger = Logger.getLogger("SampleCodeLogger");

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // リクエストパラメタにエンコード指定を行う
        req.setCharacterEncoding("UTF-8");
        // レスポンスにコンテンツタイプをセット
        res.setContentType("application/json; charset=UTF-8");
        String page = req.getParameter("page");

        if (page == null) {
            logger.log(Level.WARNING, "param error!");
            res.getWriter().write(new ErrorJson("param error").toJson());
        } else {
            switch (page) {
            case "all":
                allRequest(res);
                break;
            case "update":
                updateRequest(req, res);
                break;
            case "delete":
                deleteRequest(req, res);
                break;
            case "compare":
                compareRequest(req, res);
                break;
            case "template":
                templateRequest(req, res);
                break;
            case "nextTarget":
                nextTargetRequest(req, res);
                break;
            case "versions":
                versionsRequest(req, res);
                break;
            case "issue":
                issueRequest(req, res);
                break;
            default:
                logger.log(Level.WARNING, "param error!");
                res.getWriter().write(
                        new ErrorJson("param error:" + page).toJson());
            }

        }

    }

    private void allRequest(HttpServletResponse res)  {
        // なんらかの処理（...省略...）
    }

    private void updateRequest(HttpServletRequest req, HttpServletResponse res)  {
        // なんらかの処理（...省略...）
    }

    private void deleteRequest(HttpServletRequest req, HttpServletResponse res)  {
        // なんらかの処理（...省略...）
    }

    private void compareRequest(HttpServletRequest req, HttpServletResponse res)  {
        // なんらかの処理（...省略...）
    }

    private void templateRequest(HttpServletRequest req, HttpServletResponse res)  {
        // なんらかの処理（...省略...）
    }

    private void nextTargetRequest(HttpServletRequest req, HttpServletResponse res)  {
        // なんらかの処理（...省略...）
    }

    private void versionsRequest(HttpServletRequest req, HttpServletResponse res)  {
        // なんらかの処理（...省略...）
    }

    private void issueRequest(HttpServletRequest req, HttpServletResponse res)  {
        // なんらかの処理（...省略...）
    }

}
```

