def canJump(nums):

    pos = 0

    while pos < len(nums)-1:

        if nums[pos] != 0:
            pos += nums[pos]
        else:
            break

    return pos >= len(nums)-1

def test():
    canJump([1,2,0,1,0])