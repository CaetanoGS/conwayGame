/*
    * Nome: Gustavo Caetano de Souza
    * Algoritmo referente ao desafio 
*/

import java.util.Random;

public class game {

    // Create the initial matrix

    public int[][] getInitialMatrix( final int [][] matrix){

        final Random randomNumber = new Random();

        for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
                matrix[i][j] = randomNumber.nextInt(2);
                
			}
		}
        return matrix;
    }

    // Print the matrix

    public void printMatrix(final int [][] matrix) {
		
		for(int i = 0; i < 10; i ++) {
			for(int j = 0; j < 10; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			
			System.out.println(); // Break line
		}
		
    }

    // Verify if this is the borders

    public int getState (final int [][] matrix, final int i, final int j){
        if( i < 0 || i > 9 )
            return 0;
        if( j < 0 || j > 9 )
            return 0;
        
        return matrix[i][j];
    }

    public boolean isAlive(final int i, final int j, final int[][] matrix){

        if(matrix[i][j] == 1)
            return true;
        else
            return false;
    }

    // Count the numbers of the neighboors alive or dead

    public int getLiveNeighbourCount( int i,  int j,  int [][] matrix){

        int count = 0;

            // Top
            count += getState(matrix, i-1, j);
            // Bottom
            count += getState(matrix, i+1, j);
            // Left
            count += getState(matrix, i, j-1);
            //Right
            count += getState(matrix, i, j+1);



        return count;
    }


    // Get the next generation matrix 
    
    public int[][] getNextGeneration(int[][] matrix, int [][] newStage){

        int count = 0;

        for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {

                count = getLiveNeighbourCount(i, j, matrix);
                
                if(isAlive(i, j, matrix)){

                    if(i == 1 && j == 8)
                        System.out.println(count);

                    if(count < 2 || count > 3)
                        newStage[i][j] = 0;

                    
                    if(count == 3 || count == 2)
                        newStage[i][j] = 1;
                    

                }else{

                    if(count == 3)
                        newStage[i][j] = 1;

                }
            }
        }

        //printMatrix(newStage);

        return newStage;
    }

    public static void main(final String[] args) {

        final game myObj = new game();

        int count = 0;

        // Create a variable initial state

        //int[][] matrix = new int [10][10];
        //matrix = myObj.getInitialMatrix(matrix);

        // Create a static initial state
        

        int [][] matrix =       {   {0, 1, 1, 1, 1, 0, 1, 0, 1, 0},
                                    {0, 0, 1, 1, 1, 1, 1, 1, 0, 0},
                                    {1, 1, 1, 0, 1, 1, 1, 0, 0, 1}, 
                                    {1, 0, 1, 1, 1, 0, 1, 1, 1, 0}, 
                                    {1, 0, 1, 1, 1, 0, 1, 0, 0, 0},
                                    {0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, 
                                    {0, 1, 0, 0, 0, 0, 0, 1, 0, 1}, 
                                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 1}, 
                                    {0, 1, 0, 1, 1, 1, 0, 0, 1, 1}, 
                                    {0, 1, 1, 0, 1, 1, 1, 1, 1, 1}
                                };

        int[][] newStage = new int [10][10];

        // Print the initial state

        myObj.printMatrix(matrix);
        
        // Break line

        System.out.println();

        // get next generation

        newStage =  myObj.getNextGeneration(matrix, newStage);

        myObj.printMatrix(newStage);

    }   
}