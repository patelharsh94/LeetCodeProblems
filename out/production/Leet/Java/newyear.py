def minimumBribes(q):
    print(q)
    total_bribes = 0
    compare_num = -1
    is_compare = False
    for i in range(len(q), 1):
        curr_num = q[i]
        next_num = q[i-1]

        if curr_num < next_num and not is_compare:
            compare_num = curr_num
            is_compare = True
            continue

        if is_compare and compare_num < curr_num:
            total_bribes += 1
        elif is_compare and compare_num >= curr_num:
            is_compare = False

    print(total_bribes)
    if total_bribes > 3:
        print('Too chaotic')


