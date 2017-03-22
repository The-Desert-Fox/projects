-- 1) Is givin an integer. Prints true of false if its even or not
isEven :: Integer -> Bool
isEven x = if(x `mod` 2 == 0)
			then True
			else False
			
-- 2) Calculates area of a circle given its radius	
calc_circle_area :: Float -> Float
calc_circle_area x = pi * (x * x)

-- 3) Calculates area of a cylinder given radius and height
calc_cylinder_area :: Float -> Float -> Float
calc_cylinder_area r h = (2 * calc_circle_area r) +	(2 * pi * r * h)	

-- 4) Infix operator that decides if one number is a factor of another
($>) :: Integer -> Integer -> Bool
($>) x y = if( x `mod` y == 0)
			then True
			else False

-- 5) Takes 3 Integers and returns a touple with the two roots
-- Used where because that is the one I best know how to use
-- Also makes it easier to read
solve_quadratic_equation :: Double -> Double -> Double -> (Double,Double)
solve_quadratic_equation a b c = (x1,x2)
							where
									x1 = e + sqrt d / (2 * a) -- Needed two cause there had to be a plus
									x2 = e - sqrt d / (2 * a) -- and a minus
									d = b * b - 4 * a * c -- gets b^2 - 4ac part
									e = - b / (2 * a) -- gets -b, has to divide by 2a here as the divide by 2a 
													  -- in the main only effects the d in the sqrt

-- 6a) Gets the length of a list
getLength :: [Int] -> Int
getLength xs = sum [1 | x <- xs]

-- 6b) Get all positive divisors of a given number by 
-- checking if every number between one and the chosen number
-- are equal to zero when modded
allPositiveDiv :: Int -> [Int]
allPositiveDiv xs = [x | x <- [1..xs], xs `mod` x == 0]

-- 6) Decides if a number is a prime number
-- Its will be prime is the length of all its divisors is 1
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
-- count_instances [(1,2),(3,4)] (1,2)
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
reverseList [] = [] -- ++ joins lists
reverseList (x:xs) = reverseList xs ++ [x] 

-- 14) Finds if two numbers are coprime and returns true or false
getCommonDivisors x y =  z
				where 
				z = intersection xs ys -- Find Common divisors
				-- Getting all possiable positive divisors
				xs = allPositiveDiv x
				ys = allPositiveDiv y
				
are_coprimes x y  = z 
				where
				-- If theres a divisor other that one it cant be coprime
				-- If theres only one element in the array it must be one
				z = if(getLength(getCommonDivisors x y) == 1)
				then True
				else False
				
-- 15) Give it the month and the year and it will give the days in that month
num_days_in_month month year = if(isLeapYear year == True)
								then let days = [31,29,31,30,31,30,31,31,30,31,30,31]
								in days !! month
								else let days = [31,28,31,30,31,30,31,31,30,31,30,31]
								in days !! month

-- Decides if a year is a leap year
isLeapYear :: Int -> Bool
isLeapYear y = divisibleBy 400 || (divisibleBy 4 && not (divisibleBy 100))
    where
        divisibleBy x = mod y x == 0


-- 16) Guess

-- 17) Get a number to a power
-- Integral cause it does all whole numbers
get_power ::(Integral a)=> a -> a -> a
get_power x 0 = 1
get_power x y = x * get_power x (y-1)

-- 18) Getting second smallest element in list
-- find_second_smallest (x:xs) = x `min` find_second_smallest xs
-- find_second_smallest xs = find_minimum deleteFindMin xs
-- find_minimum [] = 1000
-- find_minimum (x:xs) = x `min` find_minimum(xs)
-- find_secon_smallest xs = find_minimum (delete_from_list xs (find_minimum xs))
-- delete_from_list xs y = [x | x <- xs , x /= y]
-- With help from michael
find_second_smallest x = minimum . filter( > minimum x) $ x

-- 19) Find an element in a list
find_element_index a xs = find 0 xs
  where
    find i [] = Nothing -- Basically null
    find i (x:xs) | a == x    = Just i
                  | otherwise = find (i + 1) xs						






