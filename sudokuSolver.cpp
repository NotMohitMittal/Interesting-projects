#include <iostream>
#include <istream>
#include <string>
#include <ctime>
#include <vector>

using std::vector;
using std::cin;
using std::endl;
using std::cout;
using std::string;
using std::getline;

class suduku {
    public:
        // this is for printing the sudoku board:
        void drawBoard(vector<vector<int>> &board){
            for(int i=0; i<board.size(); i++){
                for(int j=0; j<board.size(); j++){
                    cout << board[i][j] << " ";
                }
                cout << endl;
            }
            cout << endl;
        }

        bool isSafe(vector<vector<int>> &board, int val, int row, int col){
            for(int i=0; i<board.size(); i++){
                if(board[row][i] == val){
                    return false;
                }
                if(board[i][col] == val){
                    return false;
                }
                if(board[3*(row/3)+i/3][3*(col/3)+i%3]==val){
                    return false;
                }
            }
            return true;
        }
        
        bool solveBoard(vector<vector<int>> &board){
            for(int row=0; row<board.size(); row++){
                for(int col=0; col<board.size(); col++){
                    if(board[row][col] == 0){
                        // putting value
                        for(int val=1; val<=9; val++){
                            if(isSafe(board, val, row, col)){   // checking if the value is ok to filled
                                board[row][col] = val;
                                // recursive call
                                bool isSolPossible = solveBoard(board);
                                if(isSolPossible){
                                    return true;
                                }
                                // backTracking
                                else{
                                    board[row][col] = 0;
                                }
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
        }
};

int main(void)
{
    
    vector<vector<int>> board = {
        {0, 0, 0, 2, 6, 0, 7, 0, 1},
        {6, 8, 0, 0, 7, 0, 0, 9, 0},
        {1, 9, 0, 0, 0, 4, 5, 0, 0},
        {8, 2, 0, 1, 0, 0, 0, 4, 0},
        {0, 0, 4, 6, 0, 2, 9, 0, 0},
        {0, 5, 0, 0, 0, 3, 0, 2, 8},
        {0, 0, 9, 3, 0, 0, 0, 7, 4}, 
        {0, 4, 0, 0, 5, 0, 0, 3, 6},
        {7, 0, 3, 0, 1, 8, 0, 0, 0},
    };

    // making a pointer to the sudoku class to access the methods of the sudoku class
    suduku *sPtr;
    cout << "The Board Before solution: " << endl;
    sPtr->drawBoard(board);

    sPtr->solveBoard(board);
    cout << "Board after solution: " << endl;
    sPtr->drawBoard(board);

    return 0;
}
