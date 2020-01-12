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
    else if (node.key.compareTo(key) > 0)
      node.left = put(key, val, node.left);
    else if (node.key.compareTo(key) < 0)
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
    else if (node.key.compareTo(key) > 0)
      return get(key, node.left);
    else
      return get(key, node.right);
  }

  public Key min() {
    Node result = min(this.root);

    if (result != null)
      return result.key;

    return null;
  }

  private Node min(Node node) {
    if (node == null)
      return null;
    else if (node.left == null)
      return node;
    else
      return min(node.left);
  }

  public Key max() {
    return max(this.root);
  }

  private Key max(Node node) {
    if (node == null)
      return null;
    else if (node.right == null)
      return node.key;
    else
      return max(node.right);
  }

  public void deleteMin() {
    this.root = deleteMin(this.root);
  }

  private Node deleteMin(Node node) {
    if (node.left == null) {
      return node.right;
    } else {
      node.left = deleteMin(node.left);
      return node;
    }
  }

  public void delete(Key key) {
    this.root = delete(key, this.root);
  }

  public Node delete(Key key, Node node) {
    if (node == null)
      return null;
    else if (key.compareTo(node.key) < 0)
      node.left = delete(key, node.left);
    else if (key.compareTo(node.key) > 0)
      node.right = delete(key, node.right);
    else {
      if (node.right == null)
        return node.left;
      else if (node.left == null)
        return node.right;
      
      Node temp = node;

      node = min(temp.right);
      node.right = deleteMin(node.right);
      node.left = deleteMin(node.left);
    }

    return node;
  }

  private class Node {
    public Key key;
    public Value value;
    public Node left, right;

    public Node(Key key, Value val) {
      this.key = key;
      this.value = val;
    }

    @Override
    public String toString() {
      return "{ " + this.key + " : " + this.value + " }";
    }
  }
}
