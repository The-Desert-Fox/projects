howManyTimes :: String -> String -> Integer
howManyTimes xs y = length[x| x <- xs, x `elem` y]