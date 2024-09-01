class Solution:
    def canFinish(self, numCourses, prerequisites):

        def dfs(node):

            if node in visiting:
                return False

            if not all_courses[node]:
                return True

            visiting.add(node)

            for nextNodes in all_courses[node]:
                if not dfs(nextNodes):
                    return False

            visiting.remove(node)
            all_courses[node] = []

            return True

        all_courses = {}
        visiting = set()

        # Create the graph
        for i in prerequisites:
            if i[0] not in all_courses.keys():
                all_courses[i[0]] = [i[1]]
            elif len(i) == 2:
                all_courses[i[0]].append(i[1])
            else:
                all_courses[i[0]] = []

        for a in range(numCourses):
            if not dfs(a):
                return False

        return True


def test():
    sol = Solution()

    print('ANS: ', sol.canFinish(2, [[0,1],[1,0]]))
    # print('ANS: ', sol.canFinish(2, [[0,1]]))