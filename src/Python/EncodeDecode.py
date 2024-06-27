class EncodeDecode:

    def encode(self, strs):
        res = ""

        for s in strs:
            res += str(len(s))
            res += '#'
            res += s

        print("Encode: ", res)

        return res


    def decode(self, s):
        res = []
        i = 0

        while i < len(s):

            numStr = ''

            while s[i] != '#':
                numStr += s[i]
                i += 1

            lenS = int(numStr)
            i += 1
            word = s[i: i+lenS]
            i += lenS
            res.append(word)

        print("DECODE: ", res)
        return res


def testEncodeDecode():
    testLst = ["we","say",":","yes","!@#$%^&*()"]

    encodeDecode = EncodeDecode()
    encodedStr = encodeDecode.encode(testLst)
    decodedLst = encodeDecode.decode(encodedStr)

    print(decodedLst)