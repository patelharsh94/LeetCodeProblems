def testThreeSum():
    nums = [-1,0,1,2,-1,-4]

    nums.sort()
    results = []

    for i in range(len(nums)):

        if i > 0 and nums[i] == nums[i-1]:
            continue

        j = i+1
        k = len(nums) - 1

        while j < k:

            if nums[i] + nums[j] + nums[k] < 0:
                j += 1
            elif nums[i] + nums[j] + nums[k] > 0:
                k -= 1
            else:
                results.append([nums[i], nums[j], nums[k]])

    return results
