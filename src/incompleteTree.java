import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsText;
import comp127graphics.ui.Button;

/**
 * Create an incomplete tree with 8 nodes
 */
public class incompleteTree {

    private CanvasWindow canvas;
    private static final int CANVAS_WIDTH = 500;
    private static final int CANVAS_HEIGHT = 500;

    private Button b0;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button bcheck;
    private Button bpre;
    private Button bin;
    private Button bpost;
    private Button reset;
    private GraphicsText txt;

    private boolean pre;
    private boolean in;
    private boolean post;

    private BinaryTree.Node n0;
    private BinaryTree.Node n1;
    private BinaryTree.Node n2;
    private BinaryTree.Node n3;
    private BinaryTree.Node n4;
    private BinaryTree.Node n5;
    private BinaryTree.Node n6;
    private BinaryTree.Node n7;

    private BinaryTree bt;
    private StringBuilder answer;
    private StringBuilder key;

    /**
     * Opens a new CanvasWindow showing this incomplete tree
     */
    public incompleteTree() {
        canvas = new CanvasWindow("Incomplete Tree!", CANVAS_WIDTH, CANVAS_HEIGHT);
        key = new StringBuilder();
        answer = new StringBuilder();
        pre = true;
        in = false;
        post = false;
        setUp();
    }

    /**
     * Add text and buttons for each node and each function to the canvas
     * Assign events to each button clicked and update the text based on the result
     */
    public void setUp(){
        b0 = new Button ("0");
        b0.setPosition(CANVAS_WIDTH/2,CANVAS_HEIGHT/3);
        n0 = new BinaryTree.Node(0);
        canvas.add(b0);

        b1 = new Button ("1");
        b1.setPosition(CANVAS_WIDTH/2-50,CANVAS_HEIGHT/3+50);
        n1 = new BinaryTree.Node(1);
        canvas.add(b1);

        b2 = new Button ("2");
        b2.setPosition(CANVAS_WIDTH/2+50,CANVAS_HEIGHT/3+50);
        n2 = new BinaryTree.Node(2);
        canvas.add(b2);

        b3 = new Button ("3");
        b3.setPosition(CANVAS_WIDTH/2-75,CANVAS_HEIGHT/3+100);
        n3 = new BinaryTree.Node(3);
        canvas.add(b3);

        b4 = new Button ("4");
        b4.setPosition(CANVAS_WIDTH/2-25,CANVAS_HEIGHT/3+100);
        n4 = new BinaryTree.Node(4);
        canvas.add(b4);

        b5 = new Button ("5");
        b5.setPosition(CANVAS_WIDTH/2+25,CANVAS_HEIGHT/3+100);
        n5 = new BinaryTree.Node(5);
        canvas.add(b5);

        b6 = new Button ("6");
        b6.setPosition(CANVAS_WIDTH/2+75,CANVAS_HEIGHT/3+100);
        n6 = new BinaryTree.Node(6);
        canvas.add(b6);

        b7 = new Button ("7");
        b7.setPosition(CANVAS_WIDTH/2+100,CANVAS_HEIGHT/3+150);
        n7 = new BinaryTree.Node(7);
        canvas.add(b7);

        bcheck = new Button("check");
        bcheck.setPosition(CANVAS_WIDTH/2-200,CANVAS_HEIGHT-100);
        canvas.add(bcheck);

        bpre = new Button("pre-order");
        bpre.setPosition(CANVAS_WIDTH/2-100,CANVAS_HEIGHT-100);
        canvas.add(bpre);

        bin = new Button("in-order");
        bin.setPosition(CANVAS_WIDTH/2,CANVAS_HEIGHT-100);
        canvas.add(bin);

        bpost = new Button("post-order");
        bpost.setPosition(CANVAS_WIDTH/2+100,CANVAS_HEIGHT-100);
        canvas.add(bpost);

        reset = new Button("reset");
        reset.setPosition(CANVAS_WIDTH/2+200, CANVAS_HEIGHT-100);
        canvas.add(reset);

        txt = new GraphicsText();
        txt.setPosition(CANVAS_WIDTH/2,CANVAS_HEIGHT-200);
        canvas.add(txt);

        canvas.draw();

        bt = new BinaryTree(0,new BinaryTree(1,new BinaryTree(3, null,null), new BinaryTree(4, null, null)),
                new BinaryTree(2, new BinaryTree(5, null, null), new BinaryTree(6, null, new BinaryTree(7, null, null))));

        b0.onClick(()->{answer.append(n0.toString());});
        b1.onClick(()->{answer.append(n1.toString());});
        b2.onClick(()->{answer.append(n2.toString());});
        b3.onClick(()->{answer.append(n3.toString());});
        b4.onClick(()->{answer.append(n4.toString());});
        b5.onClick(()->{answer.append(n5.toString());});
        b6.onClick(()->{answer.append(n6.toString());});
        b7.onClick(()->{answer.append(n7.toString());});

        bpre.onClick(()->{pre = true; in = false; post = false;});
        bin.onClick(()->{pre = false; in = true; post = false;});
        bpost.onClick(()->{pre = false; in = false; post = true;});
        reset.onClick(()->new incompleteTree());

        bcheck.onClick(()->{if (pre==true){
            bt.preOrderTraverse(bt.root,2,key);
        }
        else if (in==true){
            bt.inOrderTraverse(bt.root,2,key);
        }
        else if (post==true){
            bt.postOrderTraverse(bt.root,2,key);
        }
            System.out.println(key.toString());
            System.out.println(answer.toString());
            if (key.toString().equals(answer.toString())){
                txt.setText("Perfect:)");
            }
            else {
                txt.setText("Try again:(");
            }});

    }
}
