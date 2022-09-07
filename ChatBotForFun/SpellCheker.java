package ChatBotForFun;
//import java.util.*;
public class SpellCheker
{
    private int insertionCost;
    private int deletionCost;
    private int substitutionCost;
    private int transpositionCost;

    public SpellCheker()
    {
        insertionCost = 1;
        deletionCost = 1;
        substitutionCost = 1;
        transpositionCost = 1;
    }
    public SpellCheker(int insCost, int delCost, int subCost, int trCost)
    {
        insertionCost = insCost;
        deletionCost = delCost;
        substitutionCost = subCost;
        transpositionCost = trCost;
    }
    private int calculateInsertionDistance(int[][] matrix, int row, int col)
    {
        return matrix[row - 1 ][col] + insertionCost;
    }
    private int calculateDeletionDistance(int[][] matrix, int row, int col)
    {
        return matrix[row][col - 1] + deletionCost;
    }
    private int calculateSubstitutionDistance(String source, String target, int[][] matrix, int row, int col)
    {
        if(source.charAt(row - 1) != target.charAt(col - 1))
        {
            return matrix[row - 1][col - 1] + substitutionCost;
        }
        return matrix[row - 1][col - 1]; 
    }
    private int calcminCost(String src, String target, int[][] matrix, int row, int col)
    {
        return Math.min(calculateSubstitutionDistance(src, target, matrix, row, col), Math.min(calculateDeletionDistance(matrix, row, col), calculateInsertionDistance(matrix, row, col)));
    }
    public int MainCost(String source, String target)
    {
        int srcLenght = source.length();
        int targLenght = target.length();

        int[][] matrix = new int[srcLenght + 1][targLenght + 1];

        matrix[0][0] = 0;

        for(int row = 1; row <= srcLenght; ++row)
        {
            matrix[row][0] = row;
        }

        for(int col = 1; col <= targLenght; ++col)
        {
            matrix[0][col] = col;
        }
        	int transCost = 0;
        for(int row = 1; row <= srcLenght; ++row)
        {
            for(int col = 1; col <= targLenght; ++col)
            {
                //determine if there will be transposition cost
                if(source.charAt(row - 1) == target.charAt(col - 1))
                {
                    	transCost = 0;
                }
                else
                {
                    	transCost = transpositionCost; //the transposition cost for now,
                        
                }
                //handles deletion insertion and substitution
                matrix[row][col] = calcminCost(source, target, matrix, row, col);
                //handles transposition
                if((row > 1) && (col > 1) && (source.charAt(row - 1) == target.charAt(col - 2)) && (source.charAt(row - 2) == target.charAt(col - 1)))
                {
                    matrix[row][col] = Math.min((matrix[row][col]), (matrix[row - 2][col - 2] + transCost));
                }

            }
        }
        return matrix[srcLenght][targLenght];
    }
}
//the function to predict the mistake

