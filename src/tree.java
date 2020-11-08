import java.util.Random;

/**
 * The main class that runs the tree traverse testing program with a canvas window.
 */
public class tree{

    public fullTree ft;
    public completeTree ct;
    public incompleteTree ict;
    public Random rd;

    /**
     * Opens a new CanvasWindow showing a random tree (full, complete, or incomplete)
     */
    public tree() {
        rd = new Random();
        if (rd.nextInt(3)==0){
            ft = new fullTree();
        }
        else if (rd.nextInt(3)==1){
            ct = new completeTree();
        }
        else if (rd.nextInt(3)==2){
            ict = new incompleteTree();
        }
    }

    /**
     * Creates a new tree to start the program.
     */
    public static void main(String[] args) {
        new tree();
    }

}
