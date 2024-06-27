def testCharacterReplacement():
    s = "ABBB"
    k = 2

    l = 0
    r = 1
    maxLen = 0

    if len(s) <= k:
        return len(s)

    currK = k

    for r in range(1, len(s)):

        if s[r] != s[l]:
            currK -= 1

        if s[r] != s[l] and currK < 0:
            currK = k
            maxLen = max(maxLen, r-l)
            l = r
            r += 1

    max = max(maxLen, r-l+1)
    print(max)
    return max