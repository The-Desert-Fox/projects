collatz :: (Integral a) => a -> [a]
collatz 1 = [1]
collatz x
	| even x = x : collatz (x `div` 2)
	| otherwise = x : collatz((x*3)+1)
	
makeEmail x = x ++ "@student.dkit.ie"


over21 [] = []
over21 ((a,b):xs)  
	| b > 20	= a : over21 xs
	| otherwise 	= over21 xs
	
	
takeWhile' _ [] = []
takeWhile' fn (x:xs)
	|fn x	= x : takeWhile' fn xs
	|otherwise = []

dropWhile' _ [] = []
dropWhile' fn (x:xs)
	|fn x	= dropWhile' fn xs
	|otherwise = x : dropWhile' fn []
	

all' fn xs 
	| length ( filter fn xs) /= length xs 		= False
	| otherwise 								= True
	
any' fn xs 
	| length ( filter fn xs) /= 0				= True
	| otherwise 								= False
	
	
-- 6a) Gets the length of a list
getLength :: [Int] -> Int
getLength xs = sum [1 | x <- xs]

-- 6b) Get all positive divisors of a given number by 
-- checking if every number between one and the chosen number
-- are equal to zero when modded
--allPositiveDiv :: Int -> [Int]
--allPositiveDiv xs = [x | x <- [1..xs], xs `mod` x == 0]

--is_prime :: Int -> Bool
--is_prime x = if(getLength(allPositiveDiv x) <= 2)
--				then True
--				else False

--last(filter is_prime [1..x])
--sumOfPrimes x  = helper ((getEm x) tail getEm x )
--getEm x = filter is_prime [1..x]

--helper :: [Int] -> Int -> (Int, Int)
--helper [] _ = []
--helper (xs:x) target 
--	|is_prime target-x 	= (target - x, x)
--	|otherwise  			= helper xs target

goldbach a = head $
                     filter (\(x,y) -> isPrime x && isPrime y) $
                     map (\e -> (e, a - e)) [1,3..a `div` 2]
 where
 factors a = filter (isFactor a) [2..a-1]
 isFactor a b = a `mod` b == 0
 isPrime a = null $ factors a
 -- Keep going until another charachter is met
 -- Check how many charachters are passed, add to list , remove from string

--rleencode:: String -> String
--rleencode [] = []
--rleencode (x:xs) = [x] ++ show(length(getLetters x xs)) : (rleencode removeLetters [x] xs)
--	where
--	getLetters x xs = takeWhile (`elem` x) xs
	--removeLetters x xs = dropWhile (`elem` x) xs
	
	

	
	


	