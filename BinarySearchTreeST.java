public class BinarySearchTreeST<Key extends Comparable, Value> {
  private Node root;
  
  public BinarySearchTreeST() {
    this.root = null;
  }

  public Value get(Key key) {
    return search(key, this.root).value;
  }

  private Node search(Key key, Node node) {
    if (node == null)
      return null;
    else if (node.key.compareTo(key) == 0)
      return node;
    else if (node.key.compareTo(key) > 0)
      return search(key, node.left);
    else
      return search(key, node.right);
  }

  public void put(Key key, Value val) {
    add(key, val, this.root);
  }

  private void add(Key key, Value val, Node node) {
    if (node == null) {
      node = new Node(key, val);
      return;
    } else if (node.key.compareTo(key) > 0) {
      add(key, val, node.left);
    } else if (node.key.compareTo(key) < 0) {
      add(key, val, node.left);
    }
  }

  private class Node {
    public Node left, right;
    public Key key;
    public Value value;

    public Node(Key key, Value val) {
      this.key = key;
      this.value = val;
      this.right = null;
      this.left = null;
    }
  }
}
