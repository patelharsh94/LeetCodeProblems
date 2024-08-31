def houseRobbers(nums):

    rob1, rob2 = 0, 0

    for n in nums:
        temp = max(n+rob1, rob2)
        rob1 = rob2
        rob2 = temp

    return rob2

def houseRobbers2(nums):
    a1 = houseRobbers(nums[1:])
    a2 = houseRobbers(nums[0: len(nums-2)])

    return max(a1, a2)
def testHouseRobbers():
    # houseRobbers([1, 1, 5,1, 1, 4, 1, 1, 3, 1])
    houseRobbers([2,9,8,3,6])