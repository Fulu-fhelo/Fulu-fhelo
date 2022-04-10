import javax.swing.JOptionPane;

public class MasheshaneStandSales {

    public static double NORTH_STAND = 170000;
    public static double CENTER_STAND = 210000;
    public static double SOUTH_STAND = 150000;

    public static double BRICK_FENCE = 5000;
    public static double WIRED_FENCE = 3000;
    public static double VAT = 0.16;

    
    public static void main (String args []){

        String area = "";
        int areaCode = 0;
        String full_names = "";
        int confirm = 0;
        String stand_name = "";
        String response = "";
        String fence = "";
        String initials = "";
        double stand_price = 0;

        area = JOptionPane.showInputDialog(null, "Select your stand area: " + "\n" +
                                                 "1 for North Stand" + "\n" +
                                                 "2 for South Stand" + "\n" +
                                                 "3 for Center Stand", "Area Code", JOptionPane.INFORMATION_MESSAGE);
        areaCode = Integer.parseInt(area);

        if(validate_area_code(areaCode)){

            full_names = JOptionPane.showInputDialog(null, "Enter your full names", "Full Names", JOptionPane.PLAIN_MESSAGE);
            confirm = JOptionPane.showConfirmDialog(null, "Are you buying a stand for the first time in this area?", "Select an Option", JOptionPane.ERROR_MESSAGE, JOptionPane.YES_NO_OPTION);

            if(confirm == 0){
                response = "First time buyer";
            }else{
                response = "Not a first time buyer";
            }

            switch(areaCode){

                case 1:
                stand_name = "North Stand Area";
                break;
                case 2:
                stand_name = "South stand area";
                break;
                default:
                stand_name = "Center stand area";
                break;
            }

        }else{
            JOptionPane.showMessageDialog(null, "Invalid Area Code", "Error", JOptionPane.WARNING_MESSAGE);
        }

        fence = valid_fence_type();
        initials = initialize_full_names(full_names);
        stand_price = calc_stand_price(areaCode,fence);
        display(initials, response,stand_name, fence, stand_price);
    }

    public static boolean validate_area_code(int areaCode){

        boolean validAreaCode = false;

        switch(areaCode){
            case 1:
            case 2:
            case 3:
            validAreaCode = true;
            break;
            default:
            validAreaCode = false;
            break;
        }

        return validAreaCode;
    }

    public static String initialize_full_names(String full_names){

        String initials = "";
        char first_initial = 0;
        String surname = "";
        int count_space = 0;
        int counter = 0;

        for(int x = 0; x < full_names.length(); x++){

            if(full_names.charAt(x) == ' '){

                count_space++;
            }
        }

        if(count_space == 1){

            for(int i = 0; i < full_names.length(); i++){

                first_initial = full_names.charAt(0);
                
                if(full_names.charAt(i) == ' '){

                    surname = ". " + full_names.substring(i + 1, full_names.length());
                }
                
            }
            initials = first_initial + surname;
        }
        
        if(count_space == 2){

            first_initial = full_names.charAt(0);
            for(int y = 0; y < full_names.length(); y++){

                if(full_names.charAt(y) == ' ' && counter != 2){

                    counter++;
                    initials = first_initial + ". " + full_names.charAt(y + 1);
                }
                if(counter == 2){

                    initials += ". " + full_names.substring(y + 1, full_names.length());
                }
            }
        }
        

        return initials;
    }

    public static String valid_fence_type(){

        boolean validFence = false;
        String fenceType = "";
        String input = "";
        char charInput = 0;

        while (!validFence){

            input = JOptionPane.showInputDialog(null, "Specify a 'B' for brick fence or a 'W' for a wired fence around the stand", "Fence Type", JOptionPane.QUESTION_MESSAGE);
            charInput = input.charAt(0);

            switch(charInput){

                case 'B': case 'b':
                fenceType = "Brick Fence";
                validFence = true;
                break;
                case 'W': case 'w':
                fenceType = "Wired Fence";
                validFence = true;
                break;
                default:
                validFence = false;
            }

        }

        return fenceType;
    }

    public static double calc_stand_price(int areaCode, String fence){

        double amount = 0;
        double total_amount = 0;
        double stand_price = 0;
        double fence_price = 0;

        if(fence.equalsIgnoreCase("Brick fence")){
            fence_price = BRICK_FENCE;
        }else{
            fence_price = WIRED_FENCE;
        }

        switch(areaCode){

            case 1:
            stand_price = NORTH_STAND;
            break;
            case 2:
            stand_price = SOUTH_STAND;
            break;
            default:
            stand_price = CENTER_STAND;
            break;
        }

        amount = (stand_price + fence_price) * VAT;
        total_amount = (stand_price + fence_price) + amount;

        return total_amount;
    }

    public static void display(String initials, String response,String stand_name, String fence, double stand_price){

        JOptionPane.showMessageDialog(null, "Dear " + initials + " for a " + response + " in the " + stand_name + " with a " + fence + " you will pay a total amount of R" + stand_price , "OutPut", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
