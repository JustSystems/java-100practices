/**
 * page文字列比較を行い、各操作を行うクラスのインスタンスを生成する.
 *
 * @author jsfkdt
 */
public RequestProcessorFactory implements RequestConstants {
    
    /**
     * 省略.
     */
    private RequestProcessorFactory() {
    }
    
    /**
     * 省略.
     */
    public static RequestProcessor createRequestProcessor(String page) {
        if (page == null) {
            // pageがnullの場合、nullを返却.
            return null;
        }
        
        switch (page) {
        case OPERATION_ALL:
            return new AllRequestProcessor();
        case OPERATION_UPDATE:
            return new UpdateRequestProcessor();
        case OPERATION_DELETE:
            return new DeleteRequestProcessor();
        case OPERATION_COMPARE:
            return new CompareRequestProcessor();
        case OPERATION_TEMPLATE:
            return new TemplateRequestProcessor();
        case OPERATION_NEXTTARGET:
            return new NextTargetRequestProcessor();
        case OPERATION_VERSIONS:
            return new VersionsRequestProcessor();
        case OPERATION_ISSUE:
            return new IssueRequestProcessor();
        default:
            // pageが見つからない場合、nullを返却.
            return null;
        
        }
    }
}