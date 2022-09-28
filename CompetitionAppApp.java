
package competitionappapp;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * @author FULUFHELO
 */

public class CompetitionAppApp{

    public static final int VALUE = 100;
    
    public static void main(String[] args){
        
        String[] contestant_names = new String[VALUE];
        long[] contestant_ticket_number = new long[VALUE];
        double[] contestant_scores = new double[VALUE];
        
        
        String name = "";
        long ticket = 0;
        int winner = 0;
        
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        
        for(int x = 0; x < contestant_names.length; x++){
        
            System.out.print("Enter the name of the contestant: ");
            name = input.next();
            name = name.toUpperCase();
            contestant_names[x] = name;
          
            ticket = rand.nextLong(100) + 2000000;
            contestant_ticket_number[x] = ticket;
            System.out.print(contestant_names[x] + "'s ticket number is: " + contestant_ticket_number[x] + "\n");
            
            contestant_scores[x] = calcScore();
        }
        
        winner = dertemineWinner(contestant_scores);
        sortContestant(contestant_names, contestant_ticket_number, contestant_scores);
        display(contestant_names, contestant_ticket_number, contestant_scores, winner);
    }
    
    public static double calcScore(){
    
        String[] categories = {"Voval Technique", "Perfomance", "Design"};
        
        int cat = 3;
        int judges = 4;
        double categories_scores = 0;
        double categories_scores_sum = 0;
        double categories_scores_ave = 0;
        double categories_scores_ave_sum = 0;
        double judge_scores_ave = 0;
        
        Random rand = new Random();
        DecimalFormat decimal = new DecimalFormat("0.0");
        
        
            categories_scores_ave_sum = 0;
            for(int y = 0; y < judges; y++){
            
                categories_scores_sum = 0;
                System.out.print("Judge " + (y + 1) + " scores on\n");
                for(int z = 0; z < cat; z++){
                
                    categories_scores = (rand.nextDouble(30) + 70);
                    System.out.println(categories[z] + ": " + decimal.format(categories_scores));
                    categories_scores_sum += categories_scores;
                }
                categories_scores_ave = (categories_scores_sum / cat);
                categories_scores_ave_sum += categories_scores_ave;
                System.out.println("The categories avarage is: " + decimal.format(categories_scores_ave) + "\n");
            }
            judge_scores_ave = (categories_scores_ave_sum / judges);
        
        return judge_scores_ave;
    }
    
    public static int dertemineWinner(double[] contestant_scores_dertemineWinner){
    
        double highest = 0;
        int winner_index = 0;
        
        for(int x = 0; x < contestant_scores_dertemineWinner.length; x++){
        
            if(contestant_scores_dertemineWinner[x] > highest){
            
                highest = contestant_scores_dertemineWinner[x];
                winner_index = x;
            }
        }
        
        return winner_index;
    }
    
    public static void sortContestant(String[] contestant_names_sortContestant, long[] contestant_ticket_number_sortContestant, double[] contestant_scores_sortContestant){
    
        String temp_name = "";
        long temp_ticket = 0;
        double temp_score = 0;
        
        for(int x = 0; x < contestant_names_sortContestant.length; x++){
        
            for(int y = 0; y < contestant_names_sortContestant.length - 1; y++){
            
                if(contestant_scores_sortContestant[y] < contestant_scores_sortContestant[y + 1]){
                
                    temp_score = contestant_scores_sortContestant[y];
                    contestant_scores_sortContestant[y] = contestant_scores_sortContestant[y + 1];
                    contestant_scores_sortContestant[y + 1] = temp_score;
                    
                    temp_name = contestant_names_sortContestant[y];
                    contestant_names_sortContestant[y] = contestant_names_sortContestant[y + 1];
                    contestant_names_sortContestant[y + 1] = temp_name;
                    
                    temp_ticket = contestant_ticket_number_sortContestant[y];
                    contestant_ticket_number_sortContestant[y] = contestant_ticket_number_sortContestant[y + 1];
                    contestant_ticket_number_sortContestant[y + 1] = temp_ticket;
                    
                }
            }
        }
    }
    
    public static void display(String[] contestant_names_display, long[] contestant_ticket_number_display, double[] contestant_scores_display, int winner_display){
    
        String output_heading = "";
        String output_rows = "";
        String output_winner = "";
        
        DecimalFormat decimal = new DecimalFormat("0.0");
        
        output_heading = "     GOSPEL SINGING COMPETITION 2022\nCONTESTANT NAME    TICKET NO.    SCORE\n";
        for(int x = 0; x < contestant_names_display.length; x++){
        
            output_rows += contestant_names_display[x] + "               " + contestant_ticket_number_display[x] + "       " + decimal.format(contestant_scores_display[x]) + "\n";
        }
        output_winner = "\nThe winner of GOSPEL SINGING COMPETITION 2022 is " + contestant_names_display[winner_display] + " of ticket number: " + contestant_ticket_number_display[winner_display] + " with a score of: " + decimal.format(contestant_scores_display[winner_display]) + "%";
        
        
        System.out.println(output_heading + output_rows + output_winner);
    }
}
