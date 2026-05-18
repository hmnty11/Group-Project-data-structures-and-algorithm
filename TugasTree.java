import java.util.Scanner;
import java.util.Stack;

public class TugasTree {

    // ==========================================
    // BAGIAN 1: EXPRESSION TREE
    // ==========================================
    static class ExpNode {
        String value;
        ExpNode left, right;

        ExpNode(String item) {
            value = item;
            left = right = null;
        }
    }

    static class ExpressionTree {
        
        // Membangun Expression Tree dari ekspresi Postfix
        public ExpNode buildTree(String postfix) {
            Stack<ExpNode> stack = new Stack<>();
            String[] chars = postfix.split(" ");

            for (String c : chars) {
                if (c.isEmpty()) continue;

                // Jika operand (angka), push ke stack
                if (!isOperator(c)) {
                    stack.push(new ExpNode(c));
                } 
                // Jika operator, pop 2 node teratas, jadikan anak, lalu push sub-tree
                else {
                    ExpNode node = new ExpNode(c);
                    node.right = stack.pop();
                    node.left = stack.pop();
                    stack.push(node);
                }
            }
            return stack.pop();
        }

        // Evaluasi rekursif (Secara teori menggunakan Postorder: Kiri -> Kanan -> Root)
        public int evaluate(ExpNode root) {
            if (root == null) return 0;

            // Jika leaf node (angka), kembalikan nilainya
            if (root.left == null && root.right == null) {
                return Integer.parseInt(root.value);
            }

            // Evaluasi subtree kiri dan kanan
            int leftVal = evaluate(root.left);
            int rightVal = evaluate(root.right);

            // Terapkan operator
            switch (root.value) {
                case "+": return leftVal + rightVal;
                case "-": return leftVal - rightVal;
                case "*": return leftVal * rightVal;
                case "/": return leftVal / rightVal;
            }
            return 0;
        }

        // Traversal Inorder (Kiri -> Root -> Kanan)
        public void inorder(ExpNode root) {
            if (root != null) {
                if (isOperator(root.value)) System.out.print("(");
                inorder(root.left);
                System.out.print(root.value);
                inorder(root.right);
                if (isOperator(root.value)) System.out.print(")");
            }
        }

        private boolean isOperator(String c) {
            return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
        }

        public void printVisualTree(ExpNode root) {
            System.out.println("        (" + root.value + ")");
            System.out.println("       /   \\");
            System.out.println("     (" + root.left.value + ")    " + root.right.value);
            System.out.println("     / \\");
            System.out.println("    " + root.left.left.value + "   " + root.left.right.value);
        }
    }

    // Fungsi utilitas Infix ke Postfix untuk memudahkan pembuatan tree
    public static String infixToPostfix(String infix) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isWhitespace(c)) continue;
            
            if (Character.isDigit(c)) {
                result.append(c).append(" ");
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(" ");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(" ");
        }
        return result.toString();
    }

    private static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
        }
        return -1;
    }

    // ==========================================
    // BAGIAN 2: BINARY SEARCH TREE (BST)
    // ==========================================
    static class BSTNode {
        int key;
        BSTNode left, right;

        public BSTNode(int item) {
            key = item;
            left = right = null;
        }
    }

    static class BinarySearchTree {
        BSTNode root;

        // 1. Insert Rekursif
        void insert(int key) {
            root = insertRec(root, key);
        }

        BSTNode insertRec(BSTNode root, int key) {
            if (root == null) {
                root = new BSTNode(key);
                return root;
            }
            if (key < root.key) root.left = insertRec(root.left, key);
            else if (key > root.key) root.right = insertRec(root.right, key);
            return root;
        }

        // 2. Search Rekursif
        boolean search(int key) {
            return searchRec(root, key) != null;
        }

        BSTNode searchRec(BSTNode root, int key) {
            if (root == null || root.key == key) return root;
            if (root.key > key) return searchRec(root.left, key);
            return searchRec(root.right, key);
        }

        // 3. Delete Rekursif
        void delete(int key) {
            root = deleteRec(root, key);
        }

        BSTNode deleteRec(BSTNode root, int key) {
            if (root == null) return root;

            if (key < root.key) root.left = deleteRec(root.left, key);
            else if (key > root.key) root.right = deleteRec(root.right, key);
            else {

                if (root.left == null) return root.right;
                else if (root.right == null) return root.left;

                root.key = minValue(root.right);
                root.right = deleteRec(root.right, root.key);
            }
            return root;
        }

        int minValue(BSTNode root) {
            int minv = root.key;
            while (root.left != null) {
                minv = root.left.key;
                root = root.left;
            }
            return minv;
        }
    }

    // ==========================================
    // MAIN METHOD
    // ==========================================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan ekspresi matematika: ");
        String infix = scanner.nextLine();
        
        // Konversi dan Build Tree
        String postfix = infixToPostfix(infix);
        ExpressionTree et = new ExpressionTree();
        ExpNode root = et.buildTree(postfix);
        
        System.out.println("Ekspresi dalam bentuk tree:");
        et.printVisualTree(root);
        
        System.out.print("Traversal Inorder: ");
        et.inorder(root);
        System.out.println();
        
        int hasil = et.evaluate(root);
        System.out.println("Hasil Evaluasi: " + hasil);
        
        scanner.close();
    }
}