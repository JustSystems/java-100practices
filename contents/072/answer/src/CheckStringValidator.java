/**
 * page文字列比較を行い、各操作を行うクラス.
 *
 * @author jsfkdt
 */
public class CheckStringValidator extends PageOperationProcess implements Validator 
    private final static Logger logger = Logger.getLogger("SampleCodeLogger");
    
    /**
     * {@inheritDoc}
     */
    public boolean isValidAndProcess (HttpServletRequest req, HttpServletResponse res)
                        throws ServletException, IOException {
        final String page = req.getParameter("page");
        
        if (page == null) {
            logger.log(Level.WARNING, "param error!");
            res.getWriter().write(new ErrorJson("param error").toJson());
            return false;
            
        // if-else switchイディオムで記載.
        } else switch (page) {
            case OPERATION01:
                super.allRequest(res);
                break;
            case OPERATION02:
                super.updateRequest(req, res);
                break;
            case OPERATION03:
                super.deleteRequest(req, res);
                break;
            case OPERATION04:
                super.compareRequest(req, res);
                break;
            case OPERATION05:
                super.templateRequest(req, res);
                break;
            case OPERATION06:
                super.nextTargetRequest(req, res);
                break;
            case OPERATION07:
                super.versionsRequest(req, res);
                break;
            case OPERATION08:
                super.issueRequest(req, res);
                break;
            default:
                logger.log(Level.WARNING, "param error!");
                res.getWriter().write(
                        new ErrorJson("param error:" + page).toJson());
                return false;
        }
        return true;
    }
}