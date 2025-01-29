import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bank 
{
    private static double balance = 0.0; 
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Banking App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);  
        frame.setLayout(new BorderLayout());

        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(Color.CYAN);
        JLabel labelTitle = new JLabel("Welcome to Bank!", SwingConstants.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 18));
        labelTitle.setForeground(Color.DARK_GRAY);
        panelNorth.add(labelTitle);

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));  
        panelCenter.setBackground(Color.WHITE);

        
        panelCenter.add(Box.createVerticalStrut(50)); 

        JLabel labelBalance = new JLabel("Current Balance: $0.00");
        labelBalance.setFont(new Font("Arial", Font.PLAIN, 16));
        labelBalance.setForeground(Color.BLACK);
        panelCenter.add(labelBalance);

        panelCenter.add(Box.createVerticalStrut(20)); 

        JLabel labelAmount = new JLabel("Enter Amount:");
        labelAmount.setFont(new Font("Arial", Font.BOLD, 14));  
        labelAmount.setForeground(Color.BLACK);
        panelCenter.add(labelAmount); 

        JTextField textAmount = new JTextField();
        textAmount.setFont(new Font("Arial", Font.PLAIN, 16));
        textAmount.setForeground(Color.BLACK);
        textAmount.setPreferredSize(new Dimension(150, 30));
        panelCenter.add(textAmount);

        panelCenter.add(Box.createVerticalStrut(10));

        JButton btnDeposit = new JButton("Deposit");
        JButton btnWithdraw = new JButton("Withdraw");
        JButton btnCheckBalance = new JButton("Check Balance");
        JButton btnExit = new JButton("Exit");

        styleButton(btnDeposit);
        styleButton(btnWithdraw);
        styleButton(btnCheckBalance);
        styleButton(btnExit);

        
        panelCenter.add(btnDeposit);
        panelCenter.add(Box.createVerticalStrut(10));
        panelCenter.add(btnWithdraw);
        panelCenter.add(Box.createVerticalStrut(10)); 
        panelCenter.add(btnCheckBalance);
        panelCenter.add(Box.createVerticalStrut(10)); 
        panelCenter.add(btnExit);

        
        frame.add(panelNorth, BorderLayout.NORTH);
        frame.add(panelCenter, BorderLayout.CENTER);

       
        btnDeposit.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
             {
                try 
                {
                    double depositAmount = Double.parseDouble(textAmount.getText());
                    if (depositAmount > 0) 
                    {
                        balance += depositAmount;
                        labelBalance.setText("Current Balance: $" + balance);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive amount to deposit.");
                    }
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a valid number.");
                }
            }
        });

        btnWithdraw.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    double withdrawAmount = Double.parseDouble(textAmount.getText());
                    if (withdrawAmount > 0 && withdrawAmount <= balance) 
                    {
                        balance -= withdrawAmount;
                        labelBalance.setText("Current Balance: $" + balance);
                    } 
                    else if (withdrawAmount > balance)
                     {
                        JOptionPane.showMessageDialog(frame, "Insufficient funds!");
                    } else 
                    {
                        JOptionPane.showMessageDialog(frame, "Please enter a positive amount to withdraw.");
                    }
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a valid number.");
                }
            }
        });

        btnCheckBalance.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                labelBalance.setText("Current Balance: $" + balance);
            }
        });

        btnExit.addActionListener(new ActionListener()
         {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                frame.dispose(); 
            }
        });

        frame.setVisible(true);
    }


    private static void styleButton(JButton button)
     {
        button.setFont(new Font("Arial", Font.BOLD, 12)); 
        button.setBackground(new Color(0, 122, 255));  
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(120, 30));  
        button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));  
    }
}
