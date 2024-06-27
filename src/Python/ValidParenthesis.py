def testIsValid():
    s = ']'

    openVal = "({["

    stack = []

    for a in s:
        if a in openVal:
            stack.append(a)
        else:
            b = stack.pop()
            if (a == ']' and b != '[') or \
                    (a == ')' and b != '(') or \
                    (a == '}' and b != '{'):
                return False

    return len(stack) == 0