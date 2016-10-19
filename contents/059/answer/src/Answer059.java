import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.Writer;
import java.io.PrintStream;
import java.io.FileOutputStream;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.io.IOException;

/**
 * 059の解答です.
 *
 * @author jsfkdt
 */
public class Answer059 {
    
    /**
     * 059の解答です.
     * 引数に指定されたURLにアクセスし、
     * レスポンスコードを標準出力.
     * URLのヘッダやボディの内容はファイルに出力する.
     *
     * @param arguments 使用しません.
     */
    public static void main(final String[] args) {
        /* 復帰値. */
        int errorCode = 0;
        
        //配列に値が入っていない場合、強制終了.
        if (args.length < 1 ) {
            System.err.println("引数に URL を指定し、再実行してください。");
            System.exit(1);
        }
        
        try {
            
            // URLの設定.
            final URL url = new URL(args[0]);
            
            // 接続オブジェクトの生成.
            HttpURLConnection connect = (HttpURLConnection)url.openConnection();
            
            // URL要求メソッドを設定.
            connect.setRequestMethod("GET");
            
            // リダイレクトを自動で許可しない設定.
            connect.setInstanceFollowRedirects(false);
            
            /* レスポンスコードの出力. */
            final int responseCode = connect.getResponseCode();
            System.out.println("/***レスポンスコード***/\n" + responseCode + "\n");
            
            // レスポンスコードが200以外の場合は、強制終了.
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.exit(1);
            }
            
            /* ヘッダファイルを作成. */
            makeHeaderFile(connect);
            System.out.println("/***レスポンスヘッダを以下ファイルに出力しました***/");
            System.out.println("header.txt\n");
            
            /* 本文を作成. */
            makeBodyFile(connect);
            System.out.println("/***レスポンスボディを以下ファイルに出力しました***/");
            System.out.println("body.txt");
            
        } catch (MalformedURLException e) {
            errorCode = 1;
            // 不正な形式のURL.
            e.printStackTrace();
            
        } catch (UnknownHostException e) {
            errorCode = 1;
            // ホストのIPアドレス取得不可.
            e.printStackTrace();
            
        } catch (IOException e) {
            errorCode = 1;
            e.printStackTrace();
        } finally {
            if (errorCode == 1) {
                System.exit(errorCode);
            }
        }
    }
    
    /**
     * 読み込んだURLのヘッダ情報をファイルへ出力します.
     *
     * @param connectHeader URL接続オブジェクト
     */
    public final static void makeHeaderFile(HttpURLConnection connectHeader) {
        try (final Writer output = new FileWriter("header.txt")) {
            // ヘッダを取得.
            final Map headers = connectHeader.getHeaderFields();
            
            // Iteratorを設定.
            final Iterator header = headers.keySet().iterator();
            
            // Iteratorによる走査.
            while(header.hasNext()){
                final String headerKey = (String)header.next();
                
                // ファイルへ書き出し.
                output.write("  " + headerKey + ": " + headers.get(headerKey) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 読み込んだURLの本文をファイルへ出力します.
     *
     * @param connectHeader URL接続オブジェクト
     */    
    public final static void makeBodyFile(HttpURLConnection connectBody) {
        try (final BufferedReader bodyReader = new BufferedReader(new InputStreamReader(connectBody.getInputStream()));
             final PrintStream output = new PrintStream(new FileOutputStream("body.txt"))) {
            
            // 現在の出力先を取得.
            final PrintStream sysOut = System.out;
            
            // 標準出力の出力先を指定ファイル内へ切り替える.
            System.setOut(output);
            
            // 切り替えた先に標準出力.
            bodyReader.lines().forEach(System.out::println);
            
            // 標準の出力先を元に戻す.
            System.setOut(sysOut);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
