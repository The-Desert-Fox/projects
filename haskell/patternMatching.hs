
getSecondElement (x:xx:xs) = xx 

getStringLength :: String -> Int
getStringLength "" = 0
getStringLength (x:xs) = 1 + getStringLength xs

getSum :: [Int] -> Int
getSum [] = 0
getSum (x:xs) = x + getSum xs

getProduct :: [Int] -> Int
getProduct [] = 1
getProduct(x:xs) = x * getProduct xs

