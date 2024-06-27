def testDivide():
   dividend = 10
   divisor = 3
   val = 0


   while dividend > divisor:
        val += 1
        print(dividend)
        dividend -= divisor

   print("res: ", val)
   return val