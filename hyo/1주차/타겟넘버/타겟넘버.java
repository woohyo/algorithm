import java.util.*;

class 타겟넘버 {

        // bfs
        public int solutionBfs(int[] numbers, int target) {
                Queue<Node> queue = new LinkedList<>();
                queue.add(new Node(0, 0));
                int answer = 0;

                while (!queue.isEmpty()) {
                        Node currNode = queue.poll();  // 0, 0
                        if(currNode.idx == numbers.length) {
                                if(currNode.sum == target) answer++;
                        } else {
                                queue.add(new Node(currNode.idx + 1, currNode.sum + numbers[currNode.idx]));
                                queue.add(new Node(currNode.idx + 1, currNode.sum - numbers[currNode.idx]));
                        }
                }
                return answer;
        }

        class Node{
             int idx, sum;

             public Node(int idx, int sum) {
                     this.idx = idx;
                     this.sum = sum;
             }
        }


}