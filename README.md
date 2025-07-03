PROJECT - Restaurant Order System
The problem I strived to solve was the Order System for Restaurants. The reason I felt strongly to do this is because I currently work in a restaurant environment as a server and the main screen I look at when getting the food prepared is the menu for the order.
This program solves the problem of managing restaurant orders by providing a system to track pending and completed orders effeciently.
User can add new orderse, mark orders as completed, and view the status of all orders. This system helps make sure that the data is aved and loaded between sessions giving consistency to tracking.

Arrays and Arraylists- I used the functions of Arrays and Arraylists to show that the Pending Orders are stored dynamicallyin an "Arraylist" for easy adding and removing, whilst the completed orders are stored in a fixed size array so that the orders are Archived.
Recursion- I used this to help validate the users input toi make sure that when the user enters a valid integer or strings before procedding.
File Persistence- This helps saves the pending and completed orders in seperate texts such as the .txt being "pending.txt and completed.txt" when exiting and loads them when starting to maintain data across runs.
Exception Handling- This has Try-catch blocks implented so that they can handle invalid user inpts such as non-integer choices or invalid inputs and file I/O errors to prevent the program crashing.

How to Run the program
Firstly you'd open the project in Github Codespaces
Once you have the java files in the Codespaces, you then want to access the terminal and input this command ( javac RestaurantOrderSystem.java InputValidator.java FileHandler.java )
This command helps compile all the code into one main code.
After compiling the code you then want to input ( java RestaurantOrderSystem ) and after inputting this you should be presented a menu that has a list of numbers ranging from 1-4 with a list of things you can do.
You can use these menu options to either add, complete, or view orders and whenever you are ready to exit you can input 4 and youll exit the menu.
