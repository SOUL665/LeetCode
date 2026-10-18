class Solution {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        int k = queries.length;
        int n = rooms.length;
        int[] answer = new int[k];

        int[][] sortedQueries = new int[k][3];
        for (int i = 0; i < k; i++) {
            sortedQueries[i][0] = queries[i][0];
            sortedQueries[i][1] = queries[i][1];
            sortedQueries[i][2] = i;
        }

        Arrays.sort(rooms, (a, b) -> Integer.compare(b[1], a[1]));
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(b[1], a[1]));

        TreeSet<Integer> roomIds = new TreeSet<>();
        int roomIdx = 0;

        for (int[] query : sortedQueries) {
            int preferred = query[0];
            int minSize = query[1];
            int originalIdx = query[2];

            while (roomIdx < n && rooms[roomIdx][1] >= minSize) {
                roomIds.add(rooms[roomIdx][0]);
                roomIdx++;
            }

            if (roomIds.isEmpty()) {
                answer[originalIdx] = -1;
            } else {
                Integer floor = roomIds.floor(preferred);
                Integer ceiling = roomIds.ceiling(preferred);

                if (floor == null) {
                    answer[originalIdx] = ceiling;
                } else if (ceiling == null) {
                    answer[originalIdx] = floor;
                } else {
                    int distFloor = preferred - floor;
                    int distCeiling = ceiling - preferred;

                    if (distFloor <= distCeiling) {
                        answer[originalIdx] = floor;
                    } else {
                        answer[originalIdx] = ceiling;
                    }
                }
            }
        }

        return answer;
    }
}