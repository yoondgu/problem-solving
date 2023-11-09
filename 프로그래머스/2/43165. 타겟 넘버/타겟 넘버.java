class Solution {
    
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        recurse(numbers, 0, 0, target);
        
        return count;
    }
    
    public void recurse(int[] numbers, int index, int now, int target) {
        if (index == numbers.length) {
            if (now == target) {
                count++;
            }
            return;
        }

        recurse(numbers, index + 1, now + numbers[index], target);
        recurse(numbers, index + 1, now - numbers[index], target);
    }
}