import java.util.Scanner;

class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;

  public TreeNode(int value) {
    this.value = value;
  }
}

class BinaryTree {
  TreeNode root;

  public void insert(int value) {
    root = insertRec(root, value);
  }

  private TreeNode insertRec(TreeNode root, int value) {
    if (root == null) {
      root = new TreeNode(value);
      return root;
    }
    if (value < root.value) {
      root.left = insertRec(root.left, value);
    } else if (value > root.value) {
      root.right = insertRec(root.right, value);
    }
    return root;
  }

  public void delete(int value) {
    root = deleteRec(root, value);
  }

  private TreeNode deleteRec(TreeNode root, int value) {
    if (root == null) {
      return root;
    }
    if (value < root.value) {
      root.left = deleteRec(root.left, value);
    } else if (value > root.value) {
      root.right = deleteRec(root.right, value);
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }
      root.value = minValue(root.right);
      root.right = deleteRec(root.right, root.value);
    }
    return root;
  }

  private int minValue(TreeNode root) {
    int minValue = root.value;
    while (root.left != null) {
      root = root.left;
      minValue = root.value;
    }
    return minValue;
  }

  public void inorderTraversal() {
    inorderRec(root);
    System.out.println();
  }

  private void inorderRec(TreeNode root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.value + " ");
      inorderRec(root.right);
    }
  }

  public void displayLeafNodes() {
    System.out.print("Leaf nodes: ");
    displayLeafNodesRec(root);
    System.out.println();
  }

  private void displayLeafNodesRec(TreeNode root) {
    if (root != null) {
      if (root.left == null && root.right == null) {
        System.out.print(root.value + " ");
      }
      displayLeafNodesRec(root.left);
      displayLeafNodesRec(root.right);
    }
  }

  public void displayMinMax() {
    if (root == null) {
      System.out.println("Tree is empty.");
    } else {
      System.out.println("Minimum value: " + minValue(root));
      System.out.println("Maximum value: " + maxValue(root));
    }
  }

  private int maxValue(TreeNode root) {
    int maxValue = root.value;
    while (root.right != null) {
      root = root.right;
      maxValue = root.value;
    }
    return maxValue;
  }
}

public class UAS_23051130053 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    BinaryTree tree = new BinaryTree();

    while (true) {
      System.out.println("\nPilihan Menu:");
      System.out.println("1. Masukkan Data");
      System.out.println("2. Hapus Data");
      System.out.println("3. Traversal (Inorder)");
      System.out.println("4. Tampilkan Leaf");
      System.out.println("5. Tampilkan Data Terendah dan Tertinggi");
      System.out.println("6. Keluar");
      System.out.print("Masukkan pilihan: ");

      int pilihan = scanner.nextInt();
      scanner.nextLine(); // Consume newline character

      switch (pilihan) {
        case 1:
          System.out.print("Masukkan nilai: ");
          int nilai = scanner.nextInt();
          tree.insert(nilai);
          System.out.println("Nilai " + nilai + " ditambahkan ke tree.");
          break;

        case 2:
          System.out.print("Masukkan nilai yang akan dihapus: ");
          int nilaiHapus = scanner.nextInt();
          tree.delete(nilaiHapus);
          System.out.println("Nilai " + nilaiHapus + " dihapus dari tree.");
          break;

        case 3:
          System.out.print("Traversal Inorder: ");
          tree.inorderTraversal();
          break;

        case 4:
          tree.displayLeafNodes();
          break;

        case 5:
          tree.displayMinMax();
          break;

        case 6:
          System.out.println("Terima kasih telah menggunakan aplikasi Binary Tree.");
          System.exit(0);

        default:
          System.out.println("Pilihan tidak valid!");
      }
    }
  }
}

