class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append('#').append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            // Find the delimiter '#' to extract the length
            int j = i;
            while (s.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(s.substring(i, j)); // length before '#'
            i = j + 1; // move to start of the actual string
            String str = s.substring(i, i + len);
            result.add(str);
            i = i + len; // move to next encoded string
        }

        return result;

    }
}
