class ClimbStairs:

    def climbStairs(self, n: int) -> int:
        res = 0

        def climb(currTotal, stCnt):
            nonlocal res

            if currTotal + stCnt == n:
                res += 1
                return True

            if currTotal + stCnt > n:
                return False

            currTotal += stCnt

            return climb(currTotal, 1) or climb(currTotal, 2)

        climb(0, 1)
        climb(0, 2)

        return res


def testClimbStairs():

    climbStairs = ClimbStairs()

    climbStairs.climbStairs(3)