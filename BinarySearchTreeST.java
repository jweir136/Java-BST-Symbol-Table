public class BinarySearchTreeST<Key extends Comparable, Value> {
  public Node root;

  public BinarySearchTreeST() {
    this.root = null;
  }

  public void put(Key key, Value val) {
    this.root = put(key, val, this.root);
  }

  private Node put(Key key, Value val, Node node) {
    if (node == null)
      return new Node(key, val);
    else if (node.key.compareTo(key) == 0)
      node.value = val;
    else if (node.key.compareTo(key) < 0)
      node.left = put(key, val, node.left);
    else if (node.key.compareTo(key) > 0)
      node.right = put(key, val, node.right);
    
    return node;
  }

  public Value get(Key key) {
    return get(key, this.root);
  }

  private Value get(Key key, Node node) {
    if (node == null)
      return null;
    else if (node.key.compareTo(key) == 0)
      return node.value;
    else if (node.key.compareTo(key) < 0)
      return get(key, node.left);
    else
      return get(key, node.right);
  }

  private class Node {
    public Key key;
    public Value value;
    public Node left, right;

    public Node(Key key, Value val) {
      this.key = key;
      this.value = val;
    }
  }
}
