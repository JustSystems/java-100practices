import java.io.Serializable;

/**
 * Serializableインタフェースを実装し、シリアライズ可能なクラスとする
 */
public class SerializableClass implements Serializable {
    private String name = "hoge";
    private int id = 123;

    /**
     * @return String型のインスタンス変数name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return int型のインスタンス変数id
     */
    public int getId() {
        return this.id;
    }
}
