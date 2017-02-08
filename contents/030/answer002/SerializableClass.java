import java.io.Serializable;

/**
 * Serializableインタフェースを実装し、シリアライズ可能なクラスとする
 */
public class SerializableClass implements Serializable {
    private String name;
    private int id;

    /**
     * name setter
     * @param String name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * id setter
     * @param int id
     */
    public void setId(int id) {
        this.id = id;
    }

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
