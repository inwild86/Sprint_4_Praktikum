
public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name == null) {
           return false;
        } else if (name.length() < 3 || name.length() > 19) {
            return false;
        } else if (Character.isWhitespace(name.charAt(0)) && Character.isWhitespace(name.charAt(name.length() - 1))) {
            return false;
        } else if (name.length() - name.replace(" ", "").length() > 1) {
            return false;
        } else if (name.contains(" ") == false) {
            return false;
        }
        return true;
    }
}
