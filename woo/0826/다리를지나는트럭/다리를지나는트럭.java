import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];
            while (true) {
                if (bridge.isEmpty()) {
                    bridge.add(truck);
                    bridgeWeight += truck;
                    time++;
                    break;
                } else if (bridge.size() == bridge_length) {
                    bridgeWeight -= bridge.poll();
                } else {
                    if (bridgeWeight + truck <= weight) {
                        bridge.add(truck);
                        bridgeWeight += truck;
                        time++;
                        break;
                    } else {
                        bridge.add(0);
                        time++;
                    }
                }
            }
        }

        time += bridge_length;

        return time;
    }
}