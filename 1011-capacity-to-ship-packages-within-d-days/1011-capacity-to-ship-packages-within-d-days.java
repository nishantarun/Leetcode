class Solution {
    public int shipWithinDays(int[] nums, int k) {
        int start = 0;
    int end = 0;
    for(int num : nums) {
        start = Math.max(start, num);
        end += num;
    }
    while(start < end) {
        int mid = start + (end - start) / 2;
        int sum = 0;
        int pieces = 1;
        for(int num : nums) {
            if(sum + num > mid) {
                sum = num;
                pieces++;
            }
            else {
                sum += num;
            }
        }
        if(pieces <= k) {
            end = mid;
        } else {
            start = mid + 1;
        }
    }
    return end;
    }
}