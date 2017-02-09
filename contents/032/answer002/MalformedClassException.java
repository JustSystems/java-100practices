/**
 * 不正な形式のClassであることを示す例外
 */
class MalformedClassException extends Exception {
    public MalformedClassException(String str) {
        super(str);
    }
}
