package blinkingsquares;


public class BlinkingSquares {
	
	static int currentRow;    // Row currently containing the disturbance.
    static int currentColumn; // Column currently containing disturbance.

    /**
     * The main program creates the window, fills it with random colors,
     * and then moves the disturbance in a random order around the window
     * as long as the window is open.
     */
    public static void main(String[] args) {
        Mosaic.open(8,10,100,100);
        fillWithRandomColors();
        currentRow = 4;   // start at center of window
        currentColumn = 5;
        while (true) {
            changeToRandomColor(currentRow, currentColumn);
            randomMove();
            Mosaic.delay(1);  // adjust this to speed things up... The lower the number, the faster it gets.
        }
    }  // end main
    
    /**
     * Fills the window with randomly colored squares.
     * Precondition:   The mosaic window is open.
     * Postcondition:  Each square has been set to a random color. 
     */
    static void fillWithRandomColors() {
        int row, column;
        for (row=0; row <= 7; row++) {
            for (column=0; column <= 9; column++) {
                changeToRandomColor(row, column);  
            }
        }
    }  // end fillWithRandomColors

    /**
     * Changes one square to a new randomly selected color.
     * Precondition:   The specified rowNum and colNum are in the valid range
     *                 of row and column numbers.
     * Postcondition:  The square in the specified row and column has
     *                 been set to a random color.
     * @param rowNum the row number of the square, counting rows down
     *      from 0 at the top
     * @param colNum the column number of the square, counting columns over
     *      from 0 at the left
     */
    static void changeToRandomColor(int rowNum, int colNum) {
        int red = (int)(256*Math.random());    // Choose random levels in range
        int green = (int)(256*Math.random());  //     0 to 255 for red, green, 
        int blue = (int)(256*Math.random());   //     and blue color components.
        Mosaic.setColor(rowNum,colNum,red,green,blue);  
    }  // end changeToRandomColor

    /**
     * Move the disturbance.
     * Precondition:   The global variables currentRow and currentColumn
     *                 are within the legal range of row and column numbers.
     * Postcondition:  currentRow or currentColumn is changed to one of the
     *                 neighboring positions in the grid -- up, down, left, or
     *                 right from the current position.  If this moves the
     *                 position outside of the grid, then it is moved to the
     *                 opposite edge of the grid.
     */
    static void randomMove() {
        int directionNum; // Randomly set to 0, 1, 2, or 3 to choose direction.
        directionNum = (int)(4*Math.random());
        switch (directionNum) {
        case 0:  // move up 
            currentRow--;
            if (currentRow < 0)
                currentRow = 7;
            break;
        case 1:  // move right
            currentColumn++;
            if (currentColumn >= 10)
                currentColumn = 0;
            break; 
        case 2:  // move down
            currentRow ++;
            if (currentRow >= 8)
                currentRow = 0;
            break;
        case 3:  // move left  
            currentColumn--;
            if (currentColumn < 0)
                currentColumn = 9;
            break; 
        }
    }  // end randomMove
	

} //end of BlinkingSquares


