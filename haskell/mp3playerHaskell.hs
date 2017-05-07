-- Simon Watters D00185039
main = menuIO []

menuIO::[(String,String,String,Int,Float)] -> IO ()
menuIO xs = do
		-- Menu 
		putStrLn "1) Add an mp3"
		putStrLn "2) Remove an mp3"
		putStrLn "3) Search for an mp3"
		putStrLn "4) Space used by mp3"
		putStrLn "5) Space avalable on mp3"
		putStrLn "6) For the most played mp3" 
		putStrLn "7) For the least played mp3" 
		putStrLn "8) Play an mp3" -- Not working
		putStrLn "9) View all mp3s" 
		putStrLn "Press anything else to exit"
		putStrLn "Please enter your choice"
		let mp3size = 50
		-- Choice value to choose what to do
		choice <- getLine
		-- Using valid to find out what to do next
		let valid = check choice
		if valid == "Exit"
			then putStrLn "Exiting..."
			else if valid == "Add" 
				then do 
					-- Getting user input
					putStrLn "Enter a song"
					song <- getLine
					putStrLn "Enter an artist"
					artist <- getLine
					putStrLn "Enter a genre"
					genre <- getLine
					putStrLn "Enter number of plays"
					plays <- getLine
					putStrLn "Enter the filesize"
					filesize <- getLine
					
					let truePlays = read plays :: Int
					let trueFilesize = read filesize :: Float
					let willFit = availableSpace xs mp3size
					
					if( willFit < trueFilesize )
						then do putStrLn "The file is too big"
							menuIO xs
						else do 
							let mp3 = addMP3File xs song artist genre truePlays trueFilesize
							putStrLn "Added MP3"
							menuIO mp3

				else if valid == "Remove"
					then do putStrLn "Removing MP3"
						
						putStrLn "Please enter a song"
						song <- getLine
						putStrLn "Please enter an artist"
						artist <- getLine
				
						let mp3 = removeMP3File [] song artist
						putStrLn "File Removed Successfully"
						menuIO mp3 
						
					else if valid == "Search"
						
						then do putStrLn "Searching"
							putStrLn "Please enter the word song, artist or singer"
							result <- getLine
							if result == "song"
								then do putStrLn "Please enter a song"
									song <- getLine
						
									let mp3 = searchBysong [] song
									--mapM_ putStrLn mp3 
									menuIO xs
								
								else if result == "artist"
									then do putStrLn "Please enter an artist"
										artist <- getLine
							
										let mp3 = searchByArtist [] artist
										--let print = mapM_ putStrLn mp3 -- Outputs the contents of mp3
										menuIO xs
									else if result == "genre"
										then do putStrLn "Please enter a genre"
											genre <- getLine

											let mp3 = searchByGenre [] genre
											--let print = mapM_ putStrLn mp3 -- Outputs the contents of mp3
											
											menuIO xs
										else do 
											putStrLn "Not valid try again"
											menuIO xs
						
						
						else if valid == "UsedSpace"
							then do 
								putStrLn "Finding used space"
								let space = usedSpace xs 
								putStrLn (show space)
								menuIO xs
							else if valid == "AvailableSpace"
								then do 
									putStrLn "finding available space"
									let space = availableSpace xs mp3size
									putStrLn (show space)
									menuIO xs
								else if valid == "MostPlayed"
									then do 
										putStrLn "finding most played"
										-- Must be put inside a list as that is how display expects it
										let played = [mostPlayed xs]
										display played
										menuIO xs
									else if valid == "LeastPlayed"
										then do 
											putStrLn "finding least played"
											-- Must be put inside a list as that is how display expects it
											let played = [leastPlayed xs]
											display played
											menuIO xs
										else if valid == "Play"
											then do 
												putStrLn "Playing an mp3"
												-- Gotta do it 
												menuIO xs
											else if valid == "DisplayAll"
											then do putStrLn "displaying all"
												display xs
												menuIO xs
											else do 
												putStrLn "Try again"
												menuIO xs

-- check ensures the user enter a number between 1 and 9. Anything else will end the programme
-- Returned strings tell main what to do
-- All Strings because it easier for me to track what each will do
-- Done with help from Michael McFadden
check :: String -> String
check choice
	| choice == "1"	= "Add"
	| choice == "2"	= "Remove"
	| choice == "3"	= "Search"
	| choice == "4"	= "UsedSpace"
	| choice == "5"	= "AvailableSpace"
	| choice == "6"	= "MostPlayed"
	| choice == "7"	= "LeastPlayed"
	| choice == "8"	= "Play"
	| choice == "9"	= "DisplayAll"
	| otherwise	= "Exit"
	
-- Takes a preexisting list and a load of values. Turns values into a tuple, concat with the list. Returns the list.
addMP3File::[(String,String,String,Int,Float)] -> String -> String -> String -> Int -> Float -> [(String,String,String,Int,Float)]
addMP3File xs song artist genre plays filesize = xs ++ [(song,artist,genre,plays,filesize)]

-- Takes a list, a song, and the artist. Returns a list w/o the tuple containing that song and artist. 
removeMP3File::[(String,String,String,Int,Float)] -> String -> String -> [(String,String,String,Int,Float)]
removeMP3File x t a = [(song,artist,genre,plays,filesize) | (song,artist,genre,plays,filesize) <- x , (song /= t && artist /= a)]

searchBysong :: [(String,String,String,Int,Float)] -> String -> [(String,String,String,Int,Float)]
searchBysong x s = [(song,artist,genre,plays,size) | (song,artist,genre,plays,size) <- x, song == s]

searchByArtist :: [(String,String,String,Int,Float)] -> String -> [(String,String,String,Int,Float)]
searchByArtist x a = [(song,artist,genre,plays,size) | (song,artist,genre,plays,size) <- x, artist == a]

searchByGenre :: [(String,String,String,Int,Float)] -> String -> [(String,String,String,Int,Float)]
searchByGenre x g = [(song,artist,genre,plays,size) | (song,artist,genre,plays,size) <- x, genre == g]

usedSpace::[(String,String,String,Int,Float)] -> Float
usedSpace xs = sum [filesize | (song,artist,genre,plays,filesize) <- xs]

-- Takes total space from the used space
availableSpace::[(String,String,String,Int,Float)] -> Float -> Float
availableSpace xs mp3size = mp3size - (usedSpace xs)

-- Takes a list of tuples. Displays the contents then returns to menu
display :: [(String,String,String,Int,Float)] -> IO ()
display [] = return ()
display ((song,artist,genre,plays,size):xs) = do
	putStrLn ""
	putStrLn( "Song: " ++ song)
	putStrLn( "Artist: " ++ artist)
	putStrLn( "Genre: " ++ genre)
	putStrLn( "Plays: " ++ show plays)
	putStrLn( "Size: " ++ show size)
	putStrLn ""
	display xs

-- Only ever returns a tuple with the first lowest amount of plays
leastPlayed :: [(String,String,String,Int,Float)] -> (String,String,String,Int,Float)
leastPlayed (x:xs) = findmin x xs
	where 
	findmin currentmin [] = currentmin
	findmin (song,artist,genre,plays,size) ((song2,artist2,genre2,plays2,size2):qs)
	--       currenet minimum               -- thing to test current min
	-- If plays2 is smaller it will be used as the current min
		|plays > plays2 = findmin (song2,artist2,genre2,plays2,size2) qs
		|otherwise		= findmin (song,artist,genre,plays,size) qs

-- Only returns a tuple with the first hightest amount of plays		
mostPlayed :: [(String,String,String,Int,Float)] -> (String,String,String,Int,Float)
mostPlayed (x:xs) = findmin x xs
	where 
	findmin currentmin [] = currentmin
	findmin (song,artist,genre,plays,size) ((song2,artist2,genre2,plays2,size2):qs)
	--       currenet minimum               -- thing to test current min
		|plays < plays2 = findmin (song2,artist2,genre2,plays2,size2) qs
		|otherwise		= findmin (song,artist,genre,plays,size) qs

sort :: Ord a=> [a] ->[a]
sort [] = []
sort (x:xs) = (sort lesser) ++ [x] ++ (sort greater)
    where
        lesser  = filter (< x) xs
        greater = filter (>= x) xs