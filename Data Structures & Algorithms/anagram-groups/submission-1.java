class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            String word = strs[i];

            // Count frequency of each character
            int[] count = new int[26];

            for (int j = 0; j < word.length(); j++) {

                char ch = word.charAt(j);

                int index = ch - 'a';

                count[index]++;
            }

            // Convert frequency array into a String key
            String key = Arrays.toString(count);

            // If key doesn't exist, create a new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add word to its anagram group
            map.get(key).add(word);
        }

        // Return all anagram groups
        return new ArrayList<>(map.values());
    }
}