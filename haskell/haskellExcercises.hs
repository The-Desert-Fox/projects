-- 1) Is givin an integer. Prints true of false if tis even or notElem
isEven :: Integer -> Bool
isEven x = if(x `mod` 2 == 0)
			then True
			else False
			
-- 2) Calculates area of a circle given its radius	
calc_circle_area :: Float -> Float
calc_circle_area x = pi*(x*x)

-- 3) Calculates area of a cylinder given radius and height
calc_cylinder_area :: Float -> Float -> Float
calc_cylinder_area r h = (2*calc_circle_area r) +	(2*pi*r*h)	

-- 4) Infix operator that decides if one number is a factor of another
($>) :: Integer -> Integer -> Bool
($>) x y = if( x `mod` y == 0)
			then  True
			else False

-- 5) Takes 3 Integers and returns a touple with the two roots
solve_quadratic_equation :: Double -> Double -> Double -> (Double,Double)
solve_quadratic_equation a b c = (x1,x2)
							where
									x1 = e + sqrt d / (2 * a)
									x2 = e - sqrt d / (2 * a)
									d = b * b - 4 * a * c
									e = - b / (2 * a)

-- 6a) Gets the length of a list
getLength :: [Int] -> Int
getLength xs = sum [1 | x <- xs]

-- 6b) Get all positive divisors of a given number
allPositiveDiv :: Int -> [Int]
allPositiveDiv xs = [x | x <- [1..xs], xs `mod` x == 0]

-- 6) Decides if a number is a prime number
is_prime :: Int -> Bool
is_prime x = if(getLength(allPositiveDiv x) == 2)
				then True
				else False

-- 7) Gets an infinite number of prime numbers
-- Type take x before using				
primes = [x | x <-[1..], getLength(allPositiveDiv x) == 2]

-- 8) Gets all elements that are in both the lists
intersection xs ys = [x| x <- xs,x `elem` ys]

-- 9) Removes vowels from a string
noVowels :: String -> String
noVowels xs =  [x | x <- xs,x `notElem` "aeiouAEIOU"]

-- 10) Counts the times a single tuple occurs in a list of tuples
-- tuples must be of same length
count_instances xs ys  = sum[1 | elem ys xs]

-- 11) Takes a list of tuples that are radius and heights of cylinders
-- returns the smallest
calc_smallest_cylinder_area xs = minimum [calc_cylinder_area r h| (r,h) <- xs ]

-- 12) Takes 3 lists of strings (titles, genres, certs) and returns
-- triple tuples of movies for people 15A or over
find_adult_movies titles genres certs = [x | x <- zip3 titles genres certs,getThird x `elem` ["15a","18","r"] ]

--test x y z = [q | q <-zip3 x y z, getThird q `elem` [3]]
getThird :: (a,b,c) -> c
getThird (first,second,third) = third

-- 13) Reverse a list
reverseList :: [a] -> [a]
reverseList [] = []
reverseList (x:xs) = reverseList xs ++ [x]

-- 14) Are co-primes
areCoprimes x y = 