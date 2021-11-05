package cz.mendelu.pjj.hangman;


public class PictureBuilder {

    private final StringBuilder sb = new StringBuilder();

    private boolean end = false;

    public boolean isEnd() {
        return end;
    }

    public String getPicture(int missed) {
        switch (missed) {
            case 0:
                sb.append("     ___________\n");
                break;
            case 1:
                sb.replace(5,6, "/").replace(15,16, "\\");
                sb.insert(0, "       _______\n      /       \\\n");
                break;
            case 2:
                sb.replace(10,11, "|");
                sb.insert(0, "          |\n          |\n          |\n          |\n");
                break;
            case 3:
                sb.replace(21,22, "\\").replace(8,9, "\\");
                break;
            case 4:
                sb.insert(0, "     ______\n");
                break;
            case 5:
                sb.replace(17, 18, "|");
                break;
            case 6:
                sb.replace(29,30,"o");
                break;
            case 7:
                sb.replace(41, 42, "|");
                break;
            case 8:
                sb.replace(40, 41, "/");
                break;
            case 9:
                sb.replace(42,43, "\\");
                break;
            case 10:
                sb.replace(52, 53, "/");
                break;
            case 11:
                sb.replace(54,55, "\\");
                end = true;
                break;
            default:
                throw new IllegalArgumentException("Number is too high, player is hanged.");
        }
        return sb.toString();
    }
}
