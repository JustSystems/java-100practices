import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.io.BufferedOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import junit.framework.JUnit4TestAdapter;

/**
 * Answer001のテストクラス。
 *
 * http://d.hatena.ne.jp/hyuki/20060818/junit
 * を参考にしています。
 * @author jswaf
 */
public class Test001 {
    /** 元に戻すために保存しておく標準出力 */
    private PrintStream originalOut;
    /** 期待値を出力するための標準出力 */
    private PrintStream expectedOut;
    /** テスト結果の文字列が入るストリーム */
    private ByteArrayOutputStream actual;
    /** 期待値の文字列が入るストリーム */
    private ByteArrayOutputStream expected;

    /**
     * テスト準備
     */
    @Before
    public void setUp() {
        originalOut = System.out;
        actual = new ByteArrayOutputStream();
        expected = new ByteArrayOutputStream();
        System.setOut(new PrintStream(new BufferedOutputStream(actual)));
        expectedOut = new PrintStream(new BufferedOutputStream(expected));
    }

    /**
     * テスト後片付け
     */
    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    /**
     * Answer001を実行。変化要因がないため唯一のテストメソッド。
     */
    @Test
    public void test001() {
        // Expected
        expectedOut.println("Hello, World!");
        expectedOut.flush();

        // Actual
        Answer001.main(new String[0]);
        System.out.flush();

        // Compare
        Assert.assertEquals(expected.toString(), actual.toString());
    }

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(Test001.class);
    }
}