--calcTripleSum [(1,2,3),(1,2,3),(2,3,4)]
calcTripleSum :: [(Int,Int,Int)] -> Int
calcTripleSum xs = sum [f + s + t | (f,s,t) <- xs]

-- Gets a list of the sums of triples. From there get the max.
largestSumList [] = []
largestSumList (x:xs) = [getSum x] ++ largestSumList xs
	where getSum (f,s,t) = f + s + t

--largestSum xs = [(f,s,t) | (f,s,t) < xs, f+s+t == max(largestSumLIst xs)

-- mergeSort[2,5,6][1,3,4]
-- only works on numbers
mergeSort :: Ord a=> [a]-> [a]-> [a]
mergeSort xs ys = sort(xs ++ ys)
	
sort :: Ord a=> [a] ->[a]
sort [] = []
sort (x:xs) = (sort lesser) ++ [x] ++ (sort greater)
    where
        lesser  = filter (< x) xs
        greater = filter (>= x) xs
		
--takeWhileGreater (>3)[(19,8),(6,5),(1,1)]	
takeWhileGreater _ [] = []
takeWhileGreater fn (x:xs)
	|fn < (fst x + snd x) = x : takeWhileGreater fn xs
	|otherwise = []
	
--notIntersection [1,2,3][1,3,4]
-- works with letters and numbers
notIntersection ::(Ord a)=> [a] -> [a] -> [a]
notIntersection xs ys = altIntersect xs ys ++ altIntersect ys xs

altIntersect:: (Ord a)=> [a] -> [a] -> [a]
altIntersect xs ys = [x| x <- xs,x `notElem` ys]

--firstThat fn xs = foldl(fn) 0 xs
calcShoppingTotal:: [(String,Int,Int)] -> Int
calcShoppingTotal xs = sum [(s * t) | (f,s,t) <- xs]