def numIslands(grid):
    total_island = 0

    def addIsland(i, j, grid):

        if 0 <= i < len(grid) and 0 <= j < len(grid[0]):
            if i + 1 < len(grid) and grid[i + 1][j] == '1':
                grid[i + 1][j] = 0
                addIsland(i + 1, j, grid)
            if i - 1 >= 0 and grid[i - 1][j] == '1':
                grid[i - 1][j] = 0
                addIsland(i - 1, j, grid)
            if j + 1 < len(grid[0]) and grid[i][j + 1] == '1':
                grid[i][j + 1] = 0
                addIsland(i, j + 1, grid)
            if j - 1 >= 0 and grid[i][j - 1] == '1':
                grid[i][j - 1] = 0
                addIsland(i, j - 1, grid)

        return grid

    for i in range(len(grid)):
        for j in range(len(grid[0])):

            if grid[i][j] == '1':
                total_island += 1
                grid = addIsland(i, j, grid)

    return total_island


def test():
    grid = [
        ["0","1","1","1","0"],
        ["0","1","0","1","0"],
        ["1","1","0","0","0"],
        ["0","0","0","0","0"]
    ]

    numIslands(grid)
