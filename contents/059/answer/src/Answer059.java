import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Iterator;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

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
     * 復帰値 0:正常終了
     *        1:引数に指定したURLを見直して下さい.
     *        2:引数に指定したURLのホストまたはDNS設定を見直して下さい.
     *        3:再度接続し直して下さい.
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
            errorCode = 2;
            // ホストのIPアドレス取得不可.
            e.printStackTrace();
            
        } catch (IOException e) {
            errorCode = 3;
            e.printStackTrace();
        } finally {
            System.exit(errorCode);
        }
    }
    
    /**
     * 読み込んだURLのヘッダ情報をファイルへ出力します.
     *
     * @param connectHeader URL接続オブジェクト
     */
    public final static void makeHeaderFile(HttpURLConnection connectHeader) {
        try (final BufferedWriter output = new BufferedWriter(new FileWriter("header.txt"))) {
            // ヘッダを取得.
            final Map headers = connectHeader.getHeaderFields();
            
            // Iteratorを設定.
            final Iterator header = headers.keySet().iterator();
            
            // Iteratorによる走査.
            while(header.hasNext()){
                final String headerKey = (String)header.next();
                
                // ファイルへ書き出し.
                output.write("  " + headerKey + ": " + headers.get(headerKey));
                output.newLine();
            }
            
            System.out.println(headers.get("Content-Length"));
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
        try (final BufferedInputStream input = new BufferedInputStream(connectBody.getInputStream());
             final BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("body.txt"))){
                
                /* 読み込んだバイト文字列の長さ. */
                int byteLength;
                /* 一度に読み込める最大のbyte格納数. */
                byte[] maxbyte = new byte[1024];
                
                // {@code maxbyte}の分だけ読み込み、その分だけファイルに書き込む.
                // 読み込むデータがなくなった時点でwhile文を抜ける.
                while ((byteLength = input.read(maxbyte)) != -1) {
                    output.write(maxbyte, 0, byteLength);
                }
                
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
