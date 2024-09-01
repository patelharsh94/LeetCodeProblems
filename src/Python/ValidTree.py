class Solution:
    def validTree(self, n, edges):
        tree = {i: [] for i in range(n)}

        for n1, n2 in edges:
            tree[n1].append(n2)
            tree[n2].append(n1)

        visited = set()

        def dfs(node, prevNode):

            if node in visited:
                return False

            visited.add(node)

            for j in tree[node]:
                if j == prevNode:
                    continue

                if not dfs(j, node):
                    return False

            return True

        return dfs(0, -1) and n == len(visited)

def test():
    sol = Solution()
    print(sol.validTree(n=5, edges=[[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]))
