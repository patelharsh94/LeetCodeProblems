def testFindMin():

    nums = [3,4,5,6,1,2]

    if len(nums) == 1:
        return nums[0]

    if len(nums) == 2:
        if nums[0] < nums[1]:
            return nums[0]
        else:
            return nums[1]

    start = 0
    end = len(nums)-1
    mid = (start + end)//2

    while start < end:

        if nums[mid] < nums[start] and nums[mid] < nums[end]:
            print('ANS: ', nums[mid])
            return nums[mid]

        if nums[mid] > nums[end]:
            start = mid
        else:
            end = mid

        mid = (start + end) // 2

    print('ANS: ', nums[mid])
    return nums[mid]

def testFindTarget():
    nums = [1]
    target = 0
    # if len(nums) == 1:
    #         return nums[0]
    #
    # if len(nums) == 2:
    #     if nums[0] < nums[1]:
    #         return nums[0]
    #     else:
    #         return nums[1]

    start = 0
    end = len(nums)-1

    while start <= end:
        mid = start + (start + end) // 2

        if nums[mid] == target:
            return mid

        if nums[mid] > nums[end]:
            start = mid+1
        else:
            end = mid-1

    if nums[mid] == target:
        return mid
    else:
        return -1
