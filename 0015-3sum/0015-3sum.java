class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int target = 0;
        while(target <= nums.length-3) {
            int left = target + 1;
            int right = nums.length -1;
            while(nums[target] == nums[target+1] && target <= nums.length-3){
                target++;
                continue;
            }
            while(left < right) {
                if(nums[left] + nums[right] < -nums[target]){
                    left++;
                }
                else if (nums[left] + nums[right] > -nums[target]){
                    right--;
                }
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[target]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    left++;
                    right--;
                    while(left<right && nums[left] == nums[left-1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                    res.add(temp);
                }
            }
            target++;
            
        }
        return res;
    }
}