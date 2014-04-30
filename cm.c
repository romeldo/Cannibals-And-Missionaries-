//
//  main.c
//  c&m
//
//  Created by Ronald Tsang on 2014-04-19.
//  Copyright (c) 2014 Ronald Tsang. All rights reserved.
//

#include <stdio.h>

// Method for setting up the initial round 0
void initialround(int numround,int cnumright,int cnumleft,int mnumright,int mnumleft,char boatposition);
// Method for running the cannibal and missionary game
void game(int numround,int cnumright,int cnumleft,int mnumright,int mnumleft,char boatposition,char entity1, char entity2);



void initialround(int numround,int cnumright,int cnumleft,int mnumright,int mnumleft,char boatposition){
    
    printf("Crossing the River\n");
    printf("\n");
    printf("--------------------------------------------------\n");
    printf("Round %d", numround);
    printf("\n");
    printf("Initial positions of the Missionaries and Cannibals\n");
    printf("LEFT                                    RIGHT\n");
    //Prints out the correct number of cannibals and missionaries on both sides and
    //the location of the boat
    for(int i = 0; i<cnumleft; i++)
    {
        printf("C ");
    }
    for(int i2 = 0;i2<mnumleft; i2++)
    {
        printf("M ");
    }
    if(boatposition == 'r')
    {
        printf(".....................<boat> ");
    }
    else if(boatposition == 'l')
    {
        printf(" <boat>.....................");
    }
    for(int j = 0; j<cnumright; j++)
    {
        printf("C ");
    }
    for(int j2 = 0; j2<mnumright; j2++)
    {
        printf("M ");
    }
    printf("\n");
    printf("--------------------------------------------------\n\n");
    
}

void game(int numround,int cnumright,int cnumleft,int mnumright,int mnumleft,char boatposition,char entity1,char entity2){
    //Runs the initial round method which prints out the initial positions of the cannibals
    //and missionaries
    initialround(numround,cnumright,cnumleft,mnumright,mnumleft,boatposition);
    
    int gameover=0;
    //While loop which runs the game until the int variable gameover does not equal 1
    while(gameover!=1){
        
    int numppl = 0,invalid=0;
    int cnumrightchk,cnumleftchk,mnumrightchk,mnumleftchk,totalleft,totalright;
    int chk=0,chk1=0;
    //Increments the number of rounds played every loop iteration
    numround++;
    //Need to have check variables to see whether the user input is valid
    //Ex. 1 cannibal on left side and boat on left side and user enters
    //missionary (invalid input)
    cnumrightchk=cnumright;
    cnumleftchk=cnumleft;
    mnumrightchk=mnumright;
    mnumleftchk=mnumleft;
    //total number of cannibals and missionaries on either side
    totalleft=cnumleftchk+mnumleftchk;
    totalright=cnumrightchk+mnumrightchk;
    
    
    printf("Round %d",numround);
    printf("\n");
    //This loop checks whether the user input is valid or not
    while (invalid!=1){
        printf("How many people are going to travel in the boat(1/2)?: ");
        scanf(" %d", &numppl);
        //Checks if there is enough cannibal + missionaries on either side for the user
        //to select to move them across
        if (numppl==1){
            if (boatposition =='l' && totalleft>=1){
                invalid=1;
            }else if (boatposition =='l' && totalleft< 1){
                printf("Not Enough People on left side!\n");
            }
            if (boatposition =='r' && totalright>=1){
                invalid=1;
            }else if (boatposition =='r' && totalright< 1){
                printf(")Not Enough People on right side!\n");
            }
        }else if (numppl==2){
            if (boatposition =='l' && totalleft>=2){
                invalid=1;
            }else if (boatposition =='l' && totalleft< 2){
                printf("Not Enough People on left side!\n");
            }
            
            if (boatposition =='r' && totalright>=2){
                invalid=1;
            }else if (boatposition =='r' && totalright< 2){
                printf("Not Enough People on right side!\n");
            }
            
        }else{
            printf("Invalid Input!\n");
        }
    }
    //If the user selects to move one cannibal or missionarie across in the boat
    if(numppl==1)
    {
        //While loop to check whether there is enough cannibals or missionaries on either side
        //to be moved across in the boat
        while (chk==0){
            printf("The passenger (c for cannibal, m for missionary):");
            scanf(" %c", &entity1);
            
            if (entity1=='c' && boatposition=='l'){
                if (cnumleftchk>0){
                    cnumleftchk--;
                    chk=1;
                    
                }else if (cnumleftchk==0){
                    printf("Invalid Input! Not enough cannibals on left side!\n");
                }
            }
            if (entity1=='c' && boatposition=='r'){
                
                if (cnumrightchk>0){
                    cnumrightchk--;
                    chk=1;
                    
                }else if (cnumrightchk==0){
                    printf("Invalid Input! Not enough cannibals on right side!\n");
                }
            }
            if (entity1=='m' && boatposition=='l'){
                if (mnumleftchk>0){
                    mnumleftchk--;
                    chk=1;
                }else if (mnumleftchk==0){
                    printf("Invalid Input! Not enough missionaries on left side!\n");
                }
            }
            if (entity1=='m' && boatposition=='r'){
                if (mnumrightchk>0){
                    mnumrightchk--;
                    chk=1;
                }else if (mnumrightchk==0){
                    printf("Invalid Input! Not enough missionaries on right side!\n");
                }
            }
        }
        //If the check passes, then the values of the cannibal or missionries will be
        //incremented or decremented according to what the user enterered and the
        //boat position will also be changed accordingly (Left to Right or Right to Left)
        if(boatposition=='l'){
            if(entity1=='c'){
                cnumright++;
                cnumleft--;
                boatposition='r';
            }
            else if(entity1=='m'){
                mnumright++;
                mnumleft--;
                boatposition='r';
            }
        }
        else if(boatposition=='r'){
            if(entity1=='c'){
                cnumright--;
                cnumleft++;
                boatposition='l';
            }
            else if(entity1=='m'){
                mnumright--;
                mnumleft++;
                boatposition='l';
            }
        }
    }
    //If the user enters 2 people will travel in the boat
    else if(numppl==2)
    {
        //User enters in the first passenger and checks whether it is valid
        while (chk==0){
            printf("First passenger (c for cannibal, m for missionary):");
            scanf(" %c",&entity1);
            
            if (entity1=='c' && boatposition=='l'){
                if (cnumleftchk>0){
                    cnumleftchk--;
                    chk=1;
                    
                }else if (cnumleftchk==0){
                    printf("Invalid Input! Not enough cannibals on left side!\n");
                }
            }
            if (entity1=='c' && boatposition=='r'){
                
                if (cnumrightchk>0){
                    cnumrightchk--;
                    chk=1;
                    
                }else if (cnumrightchk==0){
                    printf("Invalid Input! Not enough cannibals on right side!\n");
                }
            }
            if (entity1=='m' && boatposition=='l'){
                if (mnumleftchk>0){
                    mnumleftchk--;
                    chk=1;
                }else if (mnumleftchk==0){
                    printf("Invalid Input! Not enough missionaries on left side!\n");
                }
            }
            if (entity1=='m' && boatposition=='r'){
                if (mnumrightchk>0){
                    mnumrightchk--;
                    chk=1;
                }else if (mnumrightchk==0){
                    printf("Invalid Input! Not enough missionaries on right side!\n");
                }
            }
        }
        //User enters in the Second passenger and checks whether it is valid
        while (chk1==0){
            printf("Second passenger (c for cannibal, m for missionary):");
            scanf(" %c",&entity2);
            
            if (entity2=='c' && boatposition=='l'){
                if (cnumleftchk>0){
                    cnumleftchk--;
                    chk1=1;
                    
                }else if (cnumleftchk==0){
                    printf("Invalid Input! Not enough cannibals on left side!\n");
                }
            }
            if (entity2=='c' && boatposition=='r'){
                
                if (cnumrightchk>0){
                    cnumrightchk--;
                    chk1=1;
                    
                }else if (cnumrightchk==0){
                    printf("Invalid Input! Not enough cannibals on right side!\n");
                }
            }
            if (entity2=='m' && boatposition=='l'){
                if (mnumleftchk>0){
                    mnumleftchk--;
                    chk1=1;
                }else if (mnumleftchk==0){
                    printf("Invalid Input! Not enough missionaries on left side!\n");
                }
            }
            if (entity2=='m' && boatposition=='r'){
                if (mnumrightchk>0){
                    mnumrightchk--;
                    chk1=1;
                }else if (mnumrightchk==0){
                    printf("Invalid Input! Not enough missionaries on right side!\n");
                }
            }
            
        }
        //If the check passes, then the values of the cannibal or missionries will be
        //incremented or decremented according to what the user enterered and the
        //boat position will also be changed accordingly (Left to Right or Right to Left)
        if(boatposition=='l')
        {
            if(entity1=='c' && entity2=='c'){
                cnumright=cnumright+2;
                cnumleft=cnumleft-2;}
            else if(entity1=='m' && entity2=='m'){
                mnumright=mnumright+2;
                mnumleft=mnumleft-2;
            }
            else if(entity1=='c' && entity2=='m'){
                cnumright++;
                cnumleft--;
                mnumright++;
                mnumleft--;}
            else if(entity1=='m' && entity2=='c'){
                cnumright++;
                cnumleft--;
                mnumright++;
                mnumleft--;}
            boatposition='r';
        }
        
        else if(boatposition=='r')
        {
            if(entity1=='c' && entity2=='c'){
                cnumright=cnumright-2;
                cnumleft=cnumleft+2;
            }
            else if(entity1=='m' && entity2=='m'){
                mnumright=mnumright-2;
                mnumleft=mnumleft+2;
            }
            else if(entity1=='c' && entity2=='m'){
                cnumright--;
                cnumleft++;
                mnumright--;
                mnumleft++;
            }
            else if(entity1=='m' && entity2=='c'){
                cnumright--;
                cnumleft++;
                mnumright--;
                mnumleft++;
            }
            boatposition='l';
        }
        
    }
    //Print out the results of the user's movements
    printf("\nPositions of the Missionaries and Cannibals\n");
    printf("LEFT                                    RIGHT\n");
    for(int i = 0; i<cnumleft; i++)
    {
        printf("C ");
    }
    for(int i2 = 0; i2<mnumleft; i2++)
    {
        printf("M ");
    }
    if(boatposition == 'r')
    {
        printf(".....................<boat> ");
    }
    else if(boatposition == 'l')
    {
        printf(" <boat>.....................");
    }
    for(int j = 0; j<cnumright; j++)
    {
        printf("C ");
    }
    
    for(int j2 = 0; j2<mnumright; j2++)
    {
        printf("M ");
    }
    printf("\n");
    printf("--------------------------------------------------\n\n");
    //Checkks whether the number of cannibals is greater than the number of missionaries
    //on either side after each round to see if the user loses or can coontinue
    if(cnumright>mnumright){
        if(mnumright!=0){
            gameover=1;
            printf("Missionaries eaten by cannibals! You lose in %d rounds!\n\n",numround);
        }
    }
    else if(cnumleft>mnumleft)
    {
        if(mnumleft!=0){
            gameover=1;
            printf("Missionaries eaten by cannibals! You lose in %d rounds!\n\n",numround);
        }
    }
    //Checks whether the user has won the game by determining if the number of cannibals +
    //missionaries on the left side is equal to 0
    if (mnumleft==0 && cnumleft==0){
        gameover=1;
        printf(" Congratulations! You win the game in %d rounds!\n\n", numround);
    }
}
}

int main(int argc, const char * argv[])
{
    //Option is to check if the user wishes to play a new game and playon is to end the loop
    char option;
    int playon=0;
    
    // Loop that repeats the game until the user enters (y) to quit
    while (playon==0){
        //Sets up the initial values for the cannibals and missionaries on either side
        //Sets up the initial boat position defines two options for the user to enter
        int cnumright=0, cnumleft = 3, mnumright=0, mnumleft=3,numround=0,rounds;
        char boatposition = 'l';
        char entity1, entity2;
    // Runs the game method with all the initial values set up
    game(numround,cnumright,cnumleft,mnumright,mnumleft,boatposition,entity1,entity2);
        numround=rounds;
        
    printf("Would you like to quit (y) or continue playing (n)? (y/n)");
    scanf(" %c",&option);
    //Checks if the player would want to continue playing or quit
    if (option=='y'){
               playon=1;
    }else if (option=='n'){
               playon=0;
    }
}
}