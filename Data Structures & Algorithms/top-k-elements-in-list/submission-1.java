class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            frequencyMap.put(
                num,
                frequencyMap.getOrDefault(num, 0) + 1
            );
        }

        // Step 2: Create buckets based on frequency
        List<Integer>[] buckets = new List[nums.length + 1];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Put each number into its frequency bucket
        for (int num : frequencyMap.keySet()) {

            int frequency = frequencyMap.get(num);

            buckets[frequency].add(num);
        }

        // Step 4: Get k most frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int frequency = buckets.length - 1;
             frequency >= 1 && index < k;
             frequency--) {

            for (int num : buckets[frequency]) {

                result[index] = num;
                index++;

                if (index == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
