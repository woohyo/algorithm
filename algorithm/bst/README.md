# Binary Search Tree (이진탐색트리)
## BST 란?

이진탐색트리에서 아래의 조건을 만족해야 한다.

- 왼쪽 sub tree 에는 무조건 지금 노드의 값보다 작은 값을 가진 노드만
- 오른쪽 sub tree 무조건 지금 노드의 값보다 큰 값을 가진 노드만

[이진트리](https://www.notion.so/134d255f236b8002af0df0659f5bfbbe?pvs=21)

### 이진탐색트리 일까?

![sample1.png](https://github.com/woohyo/algorithm/raw/main/image/sample1.png)

![sample2.png](https://github.com/woohyo/algorithm/raw/main/image/sample2.png)

![skewed-tree.png](https://github.com/woohyo/algorithm/raw/main/image/skewed-tree.png)

### Code

이진 트리를 Code 로 표현하면 LinkedList 와 비슷하다.

```java
class Node {
	int value;
	Node leftChild;
	Node rightChild;
}
```

이진트리의 경우 왼쪽 노드를 먼저 방문하는 DFS 를 구현하면 다음과 같다  O(n)

```java
public void dfs(Node root) {
	if (root == null) return;
	dfs(root.left);
	dfs(root.right);
}
```

BST 구현 코드 O(log n)

내가 찾고싶은 값(value)

```java
public Node findNode(Node root, int target) {
	if (root == null || root.value == target) {
		return root;
	} else if (root.value > target) {
		return findNode(root.left, target);
	} else {
		return findNode(root.right, target);
	}
}
```

### 배열 vs BST

![array.png](https://github.com/woohyo/algorithm/raw/main/image/array.png)

이진탐색 트리의 장점

- 조회 시간복잡도가 O(log n) 이 나온다 (정렬이 되지 않은 이진트리는 최악의 경우 O(n)) ⇒ 배열도 동일함
- 삽입과 삭제가 빠르다 BST = O(log n) array = O(n)

### 추가 적으로 알면 좋은것

- AVL Tree
- Red-black tree
- B tree (B- Tree, B+ Tree..)