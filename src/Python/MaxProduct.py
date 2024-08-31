def maxProduct(nums):
    maxProd = []

    for i in range(len(nums)):

        if i == 0:
            maxProd.append(nums[i])
        elif maxProd[i-1] == 0:
            maxProd.append(nums[i])
        else:
            currProd = nums[i] * nums[i-1]

            if currProd >= maxProd[i-1]:
                maxProd.append(currProd)
            else:
                maxProd.append(0)

    return max(maxProd)

def testMaxProduct():
    maxProduct([1, 2, -3, 4])