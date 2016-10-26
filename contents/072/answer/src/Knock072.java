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
        RequestProcessor processor = RequestProcessorFactory.createRequestProcessor(page);
        
        if (processor == null) {
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            
            logger.log(Level.WARNING, "param error!");
            res.getWriter().write(
                        new ErrorJson("param error:" + page).toJson());
        }
        
        try {
            // プロセスを実行.
            processor.process(req, res);
            
            // リターンコードの設定.
            res.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            // リターンコードの設定.
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}