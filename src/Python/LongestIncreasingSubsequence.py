# SOLUTION DOESN'T WORK
# def lengthOfLIS(nums):
#
#     dp = {}
#
#     dp[nums[len(nums)-1]] = 1
#     for i in range(len(nums)-2, -1, -1):
#         if nums[i] not in dp.keys():
#             if nums[i] < nums[i+1]:
#                 dp[nums[i]] = 1+dp[nums[i+1]]
#             else:
#                 dp[nums[i]] = 1+dp[nums[i+1]]
#         else:
#             dp[nums[i]] = 1+dp[nums[i+1]]
#
#
#     return dp[nums[0]]
#
# def test():
#     nums=[0,1,0,3,2,3]
#     lengthOfLIS(nums)