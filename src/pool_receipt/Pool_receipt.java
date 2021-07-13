//  Author : Type-002 Fuyutsuki
package pool_receipt;

import javax.swing.JOptionPane;

public class Pool_receipt 
{
    static double pAmount, cAmount, tAmount, pPrice, reAmount;
    static int numPpl, numRent;
    static String poolType[] = {"Pool type         Price\n", 
                             "0.5 m                RM 2\n", 
                             "1    m                RM 3\n", 
                             "2    m                RM 5\n", 
                             "4.6 m                RM 6\n",
                             "Please enter pool type. (Eg. 0.5m)"},
                              name = null, ptInput, rentInput;                          // Pool Type menu and bunch of variables 
    
    public static void main(String[] args) 
    {
        exe();      // run the program
    }
    
    public static void exe()
    {
        boolean run = true;        // to keep restart program after each payment has been made
        while(run)                 // until user explicitly exit the program through 'X' button 
        {                          // at the top
            String output, start;
        
            name = JOptionPane.showInputDialog(null, "Enter your name or nickname.", "Pool service system", JOptionPane.QUESTION_MESSAGE);
                    
            StringBuilder builder = new StringBuilder();        
            for (String value: poolType)
            {
                builder.append(value);            
            }
            
            output = builder.toString();
            ptInput = JOptionPane.showInputDialog(null, output, "Pool service system", JOptionPane.QUESTION_MESSAGE);   // Print out pool type menu without brackets
        
            if (ptInput.equals("0.5m"))         // Check user input of pool type desired
            {                                   // then pass it to prCalculation method to
                prCalculation(pPrice = 2);      // to calculate the price of the pool type
            }
            else if (ptInput.equals("1m"))
            {
                prCalculation(pPrice = 3);
            }
            else if (ptInput.equals("2m"))
            {
                prCalculation(pPrice = 5);
            }
            else if (ptInput.equals("4.6m"))
            {
                prCalculation(pPrice = 6);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Wrong input message.", "Pool service system", JOptionPane.WARNING_MESSAGE);    // prompt wrong input message to the user
                exe();                                                                                                              // so the program pissed and ended
            }
        
            reFormat(name);

            start = JOptionPane.showInputDialog(null, "Enter next submission? (Eg. Yes / No)", "Next submission", JOptionPane.INFORMATION_MESSAGE);     // Ask for next submission

            switch(start)
            {
                case "YES": case "Yes":
                case "yes": case "y" :
                    run = true;
                    break;

                case "NO": case "No":
                case "no": case "n":
                    run = false;
                    break;

                default:
                    break;
            }
        }
    }
    
    public static double prCalculation(double x)
    {
        String pplInput, numrInput, payAmount;
        
        pplInput = JOptionPane.showInputDialog(null, "Please input number of people. (Eg. 5)", "Pool service system", JOptionPane.QUESTION_MESSAGE);
        numPpl = Integer.parseInt(pplInput);
        
        rentInput = JOptionPane.showInputDialog(null, "Renting equipment will charge additional fees. \n Do you want to rent? (Eg. Yes / No)", "Pool service system", JOptionPane.QUESTION_MESSAGE);
                
        switch(rentInput)
        {
            case "YES": case "Yes":
            case "yes": case "y" :                
                numrInput = JOptionPane.showInputDialog(null, "Rent how many sets? (Eg. 5)", "Pool service system", JOptionPane.QUESTION_MESSAGE);
                numRent = Integer.parseInt(numrInput);                                        // Ask user how many equipment
                cAmount = 4 * numRent;                                                        // that he want to rent for
                break;
            
            case "NO": case "No":
            case "no": case "n":
                cAmount = 0;
                break;             // no renting no charge
            
            default:
                break;
        }
        
        tAmount = numPpl * pPrice + cAmount;
        
        payAmount = JOptionPane.showInputDialog(null, "Total amount to be pay is: RM " + tAmount 
                                                    + "\n Payment amount: ", "Pool service system", JOptionPane.WARNING_MESSAGE);
        pAmount = Double.parseDouble(payAmount);
        
        reAmount = pAmount - tAmount;
        
        return reAmount;        // End of calculation
    }
    
    public static String reFormat(String x)     // method to print out receipt
    {
        String reFormat = null;
        
        JOptionPane.showMessageDialog(null, "Coolundpool Sdn. Bhd"
                                          + "\n No. 3, Lrg Mahsuri 7 Bayan Baru, "
                                          + "\n 11950 Bayan Lepas, Pulau Pinang "
                                          + "\n ======================================"
                                          + "\n Name: " + name
                                          + "\n Type of pool: " + ptInput
                                          + "\n Number of people: " + numPpl
                                          + "\n Rental of equipment: " + rentInput
                                          + "\n Number of rentals: " + numRent
                                          + "\n Total amount: RM " + tAmount
                                          + "\n Amount paid: RM " + pAmount
                                          + "\n Amount return: RM " + reAmount
                                          + "\n ==============THANK YOU===============", "Pool payment receipt", JOptionPane.INFORMATION_MESSAGE);
        
        return reFormat;
    }
}