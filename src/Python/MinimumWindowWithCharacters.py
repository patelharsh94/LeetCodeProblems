def testMinWindow():
    s="x"
    t="xy"
    sCount = {}
    tCount = {}

    for a in s:
        sCount[a] = 1 + sCount.get(a, 0)

    for a in t:
        tCount[a] = 1 + tCount.get(a, 0)

    for b in t:
        if b not in s or tCount[b] > sCount[b]:
            return ""

    startIdx = -1
    tLst = list(t)
    result = ""

    potential = []
    i = 0
    while i < len(s):

        if s[i] in tLst and startIdx == -1:
            startIdx = i

        if s[i] in tLst and startIdx != -1:
            ti = tLst.index(s[i])
            tLst.pop(ti)

        if len(tLst) == 0:
            if result == "" or len(result) > len(s[startIdx: i+1]):
                result = s[startIdx: i+1]

            i = startIdx
            startIdx = -1
            tLst = list(t)

        i += 1

    print('RESULT: ', result)
    return result