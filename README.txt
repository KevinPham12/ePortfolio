The user can build my program by first importing the ePortfolio directory into their compiler. When the user 
is in the directory previous to ePortfolio, they can compile the .java files by typing the following into their
compiler:

javac ePortfolio/Stock.java ePortfolio/Investment.java ePortfolio/Portfolio.java ePortfolio/MutualFund.java

   This will compile all class files, which will be used to execute the main function within Portfolio.java.
The program can be executed by typing the following into their compiler:

java ePortfolio/Portfolio



Test Plan:

Compile files using from directory previous to ePortfolio:

   javac ePortfolio/Stock.java ePortfolio/Investment.java ePortfolio/Portfolio.java ePortfolio/MutualFund.java

Execute the program:

   java ePortfolio/Portfolio

Initial Startup of GUI opens:

Command Menu: if user selects an option, new screen will appear corresponding to that function

Buy: if user inputs all values with valid inputs and presses Buy, a new investment will be added to the arraylist
     if user leaves some or all values empty, the investment will fail to be added and the user can try again
     if user presses Reset, all input fields will empty and prepare for a new input

Sell: if user inputs all values with valid inputs and presses Sell, an investment's quantity will be sold
      if the investment does not exist in the array, the program send an error message and fail to sell
      if user presses Reset, all input fields will empty and prepare for a new input

Update: if user inputs a valid price and presses Save, the displayed investment is updated with a new price
        if user presses Prev, it will go to the previous investment in the array
        if user presses Next, it will go to the next investment in the array
        if arraylist has reached the beginning or the end of the list, then the Prev and Next buttons will be inactive.

getGain: program will immediately print total gain in a text field, and will print all investments' individual gains

Search: if user inputs all three inputs and presses search, find investment that has all three attributes
        if user inputs empty string for all three inputs, find all investments in array
        if user inputs 1 or 2 inputs and leaves the others empty, find only investments corresponding to respective attributes
	if user presses Reset, all input fields will empty and prepare for a new input

Quit: exits GUI and ends the program