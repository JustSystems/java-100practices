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
        
        // String型のpage変数をチェックし、各操作を行うクラスを呼び出す. 修正箇所 #1
        CheckStringValidator pageOperation = new CheckStringValidator();
        
        boolean state = pageOperation.isValidAndProcess(req, res);
        
        /* リターンコードの設定. */
        if (state) {
            res.setStatus(HttpServletResponse.SC_OK);
        } else {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}