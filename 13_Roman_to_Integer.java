/*

1. The logic behind the transition from Roman to Integer is that if 1 is before 5,
it becomes 4 = 5 - 1, while if 1 is after 5, it becomes 6 = 5 + 1. 

*/

class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
        
        int n = s.length();
        int res = map.get(s.charAt(n - 1));
        int pre = res;
        for (int i = n - 2; i >=0; i--) {
            int cur = map.get(s.charAt(i));
            if (cur < pre) {
                res -= cur;
            } else {
                res += cur;
            }
            pre = cur;
        }
        return res;
    }
}

/*
Time complexity: O(n)
Space complexity: O(1)
*/