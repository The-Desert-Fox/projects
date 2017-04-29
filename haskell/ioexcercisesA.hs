howManyTimes :: String -> String -> Int
howManyTimes xs y = length[x| x <- xs, x `elem` y]

howManyVowels :: String -> Int
howManyVowels xs = length[x| x <- xs, x `elem` "aeiouAEIOU"]

areaOFCircle :: Float -> Float
areaOFCircle rad = pi * (rad * rad)

hammingDistance :: String -> String -> Int
hammingDistance a b 
	| length a == length b	= countDifferences a b 0
	| otherwise				= error "String lengths are different"
	where 
		countDifferences [] [] count	= count
		countDifferences (x:xs) (y:ys) count
			| x == y	= countDifferences xs ys count
			| otherwise = countDifferences xs ys count+1
			
main = do
			putStrLn "Write a word: "
			word <- getLine
			putStrLn "Write a letter: "
			letter <- getLine
			let manyTimes = howManyTimes word letter
			putStrLn(show manyTimes)