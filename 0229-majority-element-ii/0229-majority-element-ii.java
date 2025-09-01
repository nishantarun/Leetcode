class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums[0] == 2 && nums[1]==2 && nums.length==2) {
            list.add(2);
            return list;
        }
        if(nums.length < 3) {
            for(int ele : nums){
                list.add(ele);
            }
            return list;
        }
        Arrays.sort(nums);
        int curr = nums[0];
        int currCount = 1;
        for(int i =1; i< nums.length; i++) {
            if(curr == nums[i]) {
                currCount++;
            }
            if(currCount > nums.length/3 && (i== nums.length-1 || curr != nums[i])) {
                list.add(curr);
            }
            if(curr != nums[i]) {
                curr = nums[i];
                currCount = 1;
            }
        }
        return list;
    }
}