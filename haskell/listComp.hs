-- Maths
isEven ::(Integral a) => [a] -> [a]
isEven xs = [x | x <- xs, x `mod` 2 == 0]

isFactor :: Int -> Int -> Bool
isFactor x y = if(y `mod` x == 0)
				then True
				else False
		
multiply2Nos ::(Integral a) => a -> a -> a		
multiply2Nos x y = (x*x) + (y*y)
			
isPythagorian ::(Integral a) => a -> a -> a -> Bool
isPythagorian x y z = if((multiply2Nos x y) == (z*z))
						then True
						else False
-- List Comprehensions Excercise
vowelsInWord :: String -> Int						
vowelsInWord xs = sum [1 | x <- xs,x `elem` "aeiouAEIOU"]

allPositiveDiv :: Int -> [Int]
allPositiveDiv xs = [x | x <- [1..xs], xs `mod` x == 0]

getLength :: [Int] -> Int
getLength xs = sum [1 | x <- xs]

isPrime :: Int -> String 
isPrime x = if(getLength(allPositiveDiv x) == 2)
				then "It is prime"
				else "It is not prime"
				
sum1tox :: (Integral a) => a -> a				
sum1tox xs = sum [1..xs]

evenSum1tox :: (Integral a) => a -> a
evenSum1tox xs = sum(isEven [1..xs])

multiplesofx xs q= [x | x <- [1..xs], x `mod` q == 0]
multiplesof3and5 xs = sum(multiplesofx xs 3) + sum(multiplesofx xs 5)

infiniteMultiples xs = [x | x <- [1..], x `mod` xs == 0]

searchSubject :: (Fractional a, Ord a) => [String] -> [a] -> String -> [(String,a)]
searchSubject names grades n = [x | x <- (zip names grades), (fst x == n || snd x > 69.5)]

vowelsInWords xs = [ vowelsInWord x | x <- xs]

-- Tuples excercises

productOfList xs = (xs, product xs)

checkPass name grade = [fst x ++ " Passed" | x <- (zip name grade) ,snd x >= 40]



 

			