package ePortfolio;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;

public class Portfolio extends JFrame{

   ArrayList<Investment> investments = new ArrayList<Investment>(); // initialize ArrayList for stocks
   HashMap <String, ArrayList<Integer>> keyWords = new HashMap<>(); // initialize hash map; string as key and int as value
   
   JFrame frame = new JFrame(); // create frame
   JMenuItem buyItem = new JMenuItem("Buy"); // create items in menu bar
   JMenuItem sellItem = new JMenuItem("Sell");
   JMenuItem updateItem = new JMenuItem("Update");
   JMenuItem getGainItem = new JMenuItem("getGain");
   JMenuItem searchItem = new JMenuItem("Search");
   JMenuItem quitItem = new JMenuItem("Quit");

   JTextArea textArea = new JTextArea(10, 80);
   JScrollPane scrollPane = new JScrollPane(textArea);

   boolean checkUpdate = false;
   int counter = 0;
   double totalGain = 0.0;

   public Portfolio() {
 
      super();
      prepareGUI();
      displayGUI();

   }

   private void prepareGUI() { // initialize the gui with welcome screen

      textArea.setEditable(false);
      frame.setTitle("ePortfolio"); // sets title of gui
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // enables close off X button
      frame.setSize(900, 600);
      frame.setLayout(new BorderLayout());

      JMenuBar menuBar = new JMenuBar(); // create menu bar
      JMenu commandMenu = new JMenu("Commands");

      commandMenu.add(buyItem);
      commandMenu.add(sellItem);
      commandMenu.add(updateItem);
      commandMenu.add(getGainItem);
      commandMenu.add(searchItem);
      commandMenu.add(quitItem);
      menuBar.add(commandMenu);
      frame.setJMenuBar(menuBar);

      JPanel textPanel = new JPanel(); // create text labels
      textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));

      JLabel textLabel = new JLabel("Welcome to ePortfolio.");
      textLabel.setFont(new Font("", Font.PLAIN, 35));
      JLabel textLabel2 = new JLabel("Choose a command from the \"Commands\" menu to buy or sell an investment, update prices for");
      JLabel textLabel3 = new JLabel("all investments, get gain for the portfolio, search for relevant investments, or quit the program. ");
      textLabel2.setFont(new Font("", Font.PLAIN, 16));
      textLabel3.setFont(new Font("", Font.PLAIN, 16));

      textPanel.add(Box.createRigidArea(new Dimension(50, 50)));
      textPanel.add(textLabel);
      textPanel.add(Box.createRigidArea(new Dimension(0, 200)));
      textPanel.add(textLabel2);
      textPanel.add(textLabel3);
      frame.add(textPanel);
      frame.setResizable(false);
      frame.setVisible(true);

   }

   private void displayGUI() { // provides functions after interacting with command menu

      buyItem.addActionListener(new ActionListener() { // if users selects buy command

         public void actionPerformed(ActionEvent e) {

            frame.getContentPane().removeAll(); // clear frame and prepare for new interface
            frame.repaint();
            
            JPanel textPanels = new JPanel();
            textPanels.setLayout(new BoxLayout(textPanels, BoxLayout.PAGE_AXIS));
            textPanels.setBounds(0, 0, 200, 350);

            JLabel textLabel = new JLabel("Buying an investment");
            JLabel typeLabel = new JLabel("Type");
            JLabel symbolLabel = new JLabel("Symbol");
            JLabel nameLabel = new JLabel("Name");
            JLabel quantityLabel = new JLabel("Quantity");
            JLabel priceLabel = new JLabel("Price");
            JLabel msgLabel = new JLabel("Messages");

            textLabel.setFont(new Font("", Font.PLAIN, 20));
            typeLabel.setFont(new Font("", Font.PLAIN, 16));
            symbolLabel.setFont(new Font("", Font.PLAIN, 16));
            nameLabel.setFont(new Font("", Font.PLAIN, 16));
            quantityLabel.setFont(new Font("", Font.PLAIN, 16));
            priceLabel.setFont(new Font("", Font.PLAIN, 16));
            msgLabel.setFont(new Font("", Font.PLAIN, 20));

            textPanels.add(Box.createRigidArea(new Dimension(10, 0)));
            textPanels.add(textLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 30)));
            textPanels.add(typeLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 30)));
            textPanels.add(symbolLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 30)));
            textPanels.add(nameLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 30)));
            textPanels.add(quantityLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 30)));
            textPanels.add(priceLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 28)));
            textPanels.add(msgLabel);
            
            frame.add(textPanels);

            JPanel inputPanels = new JPanel();
            inputPanels.setLayout(new BoxLayout(inputPanels, BoxLayout.PAGE_AXIS));
            inputPanels.setBounds(200, 0, 400, 300);

            String[] type = {"stock", "mutualfund"};

            JComboBox typeBox = new JComboBox(type);
            typeBox.setBackground(Color.white);

            JTextField symbolField = new JTextField(30);
            JTextField nameField = new JTextField(30);
            JTextField quantityField = new JTextField(30);
            JTextField priceField = new JTextField(30);

            inputPanels.add(Box.createRigidArea(new Dimension(0, 60)));
            inputPanels.add(typeBox);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 30)));
            inputPanels.add(symbolField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 30)));
            inputPanels.add(nameField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 30)));
            inputPanels.add(quantityField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 30)));
            inputPanels.add(priceField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 30)));

            frame.add(inputPanels);

            JPanel buttonPanels = new JPanel();
            buttonPanels.setLayout(new BoxLayout(buttonPanels, BoxLayout.PAGE_AXIS));
            buttonPanels.setBounds(600, 0, 300, 300);

            JButton resetButton = new JButton("Reset");
            JButton buyButton = new JButton("Buy");

            buttonPanels.add(Box.createRigidArea(new Dimension(80, 80)));
            buttonPanels.add(resetButton);
            buttonPanels.add(Box.createRigidArea(new Dimension(0, 100)));
            buttonPanels.add(buyButton);

            frame.add(buttonPanels);

            JPanel outputPanels = new JPanel();
            outputPanels.setBounds(0, 350, 900, 300);

            outputPanels.add(scrollPane);

            frame.add(outputPanels);

            frame.add(new JPanel());
            
            frame.setVisible(true); // interface is ready and shown

            resetButton.addActionListener(new ActionListener() { // if user presses the reset button

               public void actionPerformed(ActionEvent e) {

                  symbolField.setText(""); //reset all text fields
                  nameField.setText("");
                  quantityField.setText("");
                  priceField.setText("");

               }

            });

            buyButton.addActionListener(new ActionListener() { // if user presses the buy button

               public void actionPerformed(ActionEvent e) {

                  boolean stock = false;
                  boolean mutual = false;
                  boolean exists = false;
                  int quantityNew = 0;
                  int quantityTotal = 0;
                  double price = 0.0;
                  double bookValue = 0.0;

                  String str = typeBox.getSelectedItem().toString();
                  String symbol = symbolField.getText();
                  String name = nameField.getText();
                  String quantityStr = quantityField.getText();
                  String priceStr = priceField.getText();
               

                  if (name.isEmpty() || symbol.isEmpty()) {

                     textArea.append("Failed to buy, please input all values.\n");
                     return;

                  }

                  try {

                     quantityNew = Integer.parseInt(quantityStr);

                  } catch (NumberFormatException ex) {

                     textArea.append("Failed to buy, quantity is invalid.\n");
                     return;

                  }

                  try {

                     price = Double.parseDouble(priceStr);

                  } catch (NumberFormatException ex) {

                     textArea.append("Failed to buy, price is invalid.\n");
                     return;

                  }

                  if (quantityNew < 0 || price < 0) {

                     textArea.append("Failed to buy, negative values are invalid.\n");
                     return;
                     
                  }

                  symbol = symbol.toUpperCase();

                  if (str.equals("stock") || str.equals("s")) { // if user inputs stock
      
                     stock = true;
      
                  } else if (str.equals("mutualfund") || str.equals("m")) { // if user inputs mutualfund
      
                     mutual = true;
      
                  }

                  if (stock == true || mutual == true) {

                     for (int i = 0; i < investments.size(); ++i) {
      
                        if (investments.get(i).getSymbol().equals(symbol)) { // check list for existing symbols
      
                           exists = true;
 
                           textArea.append("\nExisting Investment Found. Quantity was added. \n");

                           quantityTotal = quantityNew + investments.get(i).getQuantity();
      
                           bookValue = investments.get(i).calculateBookValue(quantityNew, price);
      
                           textArea.append("Current BookValue: " + bookValue + "\n");
      
                           investments.get(i).setQuantity(quantityTotal);
                           investments.get(i).setPrice(price);
                           investments.get(i).setBookValue(bookValue);
      
                        }
      
                     }

                  }

                  if (exists == false) {

                     if (stock == true) {
   
                        try {
   
                           Stock investment = new Stock (symbol, name, quantityNew, price);
                           bookValue = investment.calculateBookValue(quantityNew, price);
   
                           investment.setBookValue(bookValue);
   
                           investments.add(investment);
   
                        } catch (Exception ex) {
   
                           textArea.append(ex.getMessage());
   
                        }
   
                     } else if (mutual == true) {
   
                        try {
   
                           MutualFund investment = new MutualFund (symbol, name, quantityNew, price);
                           bookValue = investment.calculateBookValue(quantityNew, price);
   
                           investment.setBookValue(bookValue);
   
                           investments.add(investment);
   
                        } catch (Exception ex) {
   
                           textArea.append(ex.getMessage());
   
                        }
   
                     }
   
                     textArea.append("Current BookValue: " + bookValue + "\n");

                     name = name.toLowerCase();
   
                     String keys[] = name.split("[ ]+");
   
                     for (int i = 0; i < keys.length; ++i) {
   
                        ArrayList<Integer> values = new ArrayList<Integer>();
   
                        if (keyWords.containsKey(keys[i])) {
   
                           values = keyWords.get(keys[i]);
   
                        }
   
                     values.add(investments.size() - 1);
   
                     keyWords.put(keys[i], values);
   
                     }
    
                  }
                  
               }

            });
            
          }

      });

      sellItem.addActionListener(new ActionListener() { // if user selects sell command

         public void actionPerformed(ActionEvent e) {

            frame.getContentPane().removeAll();
            frame.repaint();
            
            JPanel textPanels = new JPanel();
            textPanels.setLayout(new BoxLayout(textPanels, BoxLayout.PAGE_AXIS));
            textPanels.setBounds(0, 0, 200, 350);

            JLabel textLabel = new JLabel("Selling an investment");
            JLabel symbolLabel = new JLabel("Symbol");
            JLabel quantityLabel = new JLabel("Quantity");
            JLabel priceLabel = new JLabel("Price");
            JLabel msgLabel = new JLabel("Messages");


            textLabel.setFont(new Font("", Font.PLAIN, 20));
            symbolLabel.setFont(new Font("", Font.PLAIN, 16));
            quantityLabel.setFont(new Font("", Font.PLAIN, 16));
            priceLabel.setFont(new Font("", Font.PLAIN, 16));
            msgLabel.setFont(new Font("", Font.PLAIN, 20));

            textPanels.add(Box.createRigidArea(new Dimension(10, 0)));
            textPanels.add(textLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 50)));
            textPanels.add(symbolLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 50)));
            textPanels.add(quantityLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 50)));
            textPanels.add(priceLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 70)));
            textPanels.add(msgLabel);
            
            frame.add(textPanels);

            JPanel inputPanels = new JPanel();
            inputPanels.setLayout(new BoxLayout(inputPanels, BoxLayout.PAGE_AXIS));
            inputPanels.setBounds(200, 0, 400, 300);

            JTextField symbolField = new JTextField(30);
            JTextField quantityField = new JTextField(30);
            JTextField priceField = new JTextField(30);

            inputPanels.add(Box.createRigidArea(new Dimension(0, 80)));
            inputPanels.add(symbolField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 55)));
            inputPanels.add(quantityField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 55)));
            inputPanels.add(priceField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 55)));


            frame.add(inputPanels);

            JPanel buttonPanels = new JPanel();
            buttonPanels.setLayout(new BoxLayout(buttonPanels, BoxLayout.PAGE_AXIS));
            buttonPanels.setBounds(600, 0, 300, 300);

            JButton resetButton = new JButton("Reset");
            JButton sellButton = new JButton("Sell");

            buttonPanels.add(Box.createRigidArea(new Dimension(80, 80)));
            buttonPanels.add(resetButton);
            buttonPanels.add(Box.createRigidArea(new Dimension(0, 100)));
            buttonPanels.add(sellButton);

            frame.add(buttonPanels);

            JPanel outputPanels = new JPanel();
            outputPanels.setBounds(0, 350, 900, 300);

            outputPanels.add(scrollPane);

            frame.add(outputPanels);

            frame.add(new JPanel());
            
            frame.setVisible(true);

            resetButton.addActionListener(new ActionListener() { // if user presses reset button

               public void actionPerformed(ActionEvent e) {

                  symbolField.setText("");
                  quantityField.setText("");
                  priceField.setText("");

               }

            });

            sellButton.addActionListener(new ActionListener() { // if user presses sell button

               public void actionPerformed(ActionEvent e) {

                  boolean exists = false;
                  int quantityNew = 0;
                  int quantityTotal = 0;
                  int i = 0;
                  double price = 0.0;
                  double bookValue = 0.0;

                  String symbol = symbolField.getText();
                  String quantityStr = quantityField.getText();
                  String priceStr = priceField.getText();
               

                  if (symbol.isEmpty()) {

                     textArea.append("Failed to sell, please input all values.\n");
                     return;

                  }

                  try {

                     quantityNew = Integer.parseInt(quantityStr);

                  } catch (NumberFormatException ex) {

                     textArea.append("Failed to sell, quantity is invalid.\n");
                     return;

                  }

                  try {

                     price = Double.parseDouble(priceStr);

                  } catch (NumberFormatException ex) {

                     textArea.append("Failed to sell, price is invalid.\n");
                     return;

                  }

                  if (quantityNew < 0 || price < 0) {

                     textArea.append("Failed to sell, negative values are invalid.\n");
                     return;
                     
                  }

                  symbol = symbol.toUpperCase();

                  for (i = 0; i < investments.size(); ++i) {

                     if (investments.get(i).getSymbol().equals(symbol)) {
      
                        exists = true;
                        break;
      
                     }
      
                  } // end of for loop

                  if (exists == false) { // if no match was found

                     textArea.append("The investment with the symbol " + symbol + " does not exist. Returning to menu... \n");
      
                  } else if (exists == true) {
      
                     if (investments.get(i).getQuantity() >= quantityNew) { // checks if there are enough stocks to sell
      
                        quantityTotal = investments.get(i).getQuantity() - quantityNew;
      
                        if (quantityTotal > 0) { // if there are more than 0 stocks
      
                           bookValue = investments.get(i).getBookValue() * (investments.get(i).getQuantity() / quantityTotal);
      
                           investments.get(i).setQuantity(quantityTotal);
                           investments.get(i).setBookValue(bookValue);
                           investments.get(i).setPrice(price);
      
                           textArea.append(investments.get(i).payment(quantityNew, price)); // prints payment recieved
      
      
                        } else if (quantityTotal == 0) { // if there are no more stocks left
      
                           ArrayList<String> strings = new ArrayList<String>();
      
                           for (int index = 0; index < investments.size(); ++index) {
       
                              String investName = investments.get(index).getName();
                            
                              investName = investName.toLowerCase();
          
                              String keys[] = investName.split("[ ]+");
       
                              for (int j = 0; j < keys.length; ++j) {
       
                                 if (!strings.contains(keys[j])) {
      
                                    strings.add(keys[j]); // retrieve all keys into arraylist
      
                                 }
      
                              }
      
                           }
      
                           for (int k = 0; k < strings.size(); ++k) {
      
                              ArrayList<Integer> values = keyWords.get(strings.get(k));
      
                              values.remove(Integer.valueOf(i));
      
                              if (values.isEmpty()) {
      
                                 keyWords.remove(strings.get(k));
      
                              } else {
      
                                 for (int l = 0; l < values.size(); ++l) {
      
                                    if (values.get(l) > i) { // all values greater than index being removed decreased by 1        
      
                                       values.set(l, values.get(l) - 1);
      
                                    }
      
                                 }
      
                                 keyWords.put(strings.get(k), values);
      
                              }
      
                           }

                           textArea.append(investments.get(i).payment(quantityNew, price)); // prints payment recieved
      
                           investments.remove(i); // remove the investment
      
                        }
      
      
                     } else { // if you are trying to sell stocks above what you currently have
      
                        textArea.append("Invalid... Not enough investments. \n");
      
                     }
      
                  }

               }

            });

            
          }

      });

      updateItem.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            frame.getContentPane().removeAll();
            frame.repaint();
            
            JPanel textPanels = new JPanel();
            textPanels.setLayout(new BoxLayout(textPanels, BoxLayout.PAGE_AXIS));
            textPanels.setBounds(0, 0, 200, 350);

            JLabel textLabel = new JLabel("Updating investments");
            JLabel symbolLabel = new JLabel("Symbol");
            JLabel nameLabel = new JLabel("Name");
            JLabel priceLabel = new JLabel("Price");
            JLabel msgLabel = new JLabel("Messages");


            textLabel.setFont(new Font("", Font.PLAIN, 20));
            symbolLabel.setFont(new Font("", Font.PLAIN, 16));
            nameLabel.setFont(new Font("", Font.PLAIN, 16));
            priceLabel.setFont(new Font("", Font.PLAIN, 16));
            msgLabel.setFont(new Font("", Font.PLAIN, 20));

            textPanels.add(Box.createRigidArea(new Dimension(10, 0)));
            textPanels.add(textLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 50)));
            textPanels.add(symbolLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 50)));
            textPanels.add(nameLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 50)));
            textPanels.add(priceLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 70)));
            textPanels.add(msgLabel);
            
            frame.add(textPanels);

            JPanel inputPanels = new JPanel();
            inputPanels.setLayout(new BoxLayout(inputPanels, BoxLayout.PAGE_AXIS));
            inputPanels.setBounds(200, 0, 400, 300);

            JTextField symbolField = new JTextField(30);
            JTextField nameField = new JTextField(30);
            JTextField priceField = new JTextField(30);

            symbolField.setEditable(false);
            symbolField.setBackground(Color.white);
            nameField.setEditable(false);
            nameField.setBackground(Color.white);

            inputPanels.add(Box.createRigidArea(new Dimension(0, 80)));
            inputPanels.add(symbolField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 55)));
            inputPanels.add(nameField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 55)));
            inputPanels.add(priceField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 55)));

            frame.add(inputPanels);

            JPanel buttonPanels = new JPanel();
            buttonPanels.setLayout(new BoxLayout(buttonPanels, BoxLayout.PAGE_AXIS));
            buttonPanels.setBounds(600, 0, 300, 300);

            JButton prevButton = new JButton("Prev");
            JButton nextButton = new JButton("Next");
            JButton saveButton = new JButton("Save");

            buttonPanels.add(Box.createRigidArea(new Dimension(80, 55)));
            buttonPanels.add(prevButton);
            buttonPanels.add(Box.createRigidArea(new Dimension(0, 70)));
            buttonPanels.add(nextButton);
            buttonPanels.add(Box.createRigidArea(new Dimension(0, 70)));
            buttonPanels.add(saveButton);
            frame.add(buttonPanels);

            JPanel outputPanels = new JPanel();
            outputPanels.setBounds(0, 350, 900, 300);

            outputPanels.add(scrollPane);

            frame.add(outputPanels);

            frame.add(new JPanel());
            
            frame.setVisible(true);

            if (counter == 0) {

               prevButton.setEnabled(false);

            }

            if (counter == investments.size() || investments.size() == 1) {

               nextButton.setEnabled(false);

            }

            if (investments.size() == 1) {

               nextButton.setEnabled(false);

            }

            if (investments.size() > 0) {

               symbolField.setText(investments.get(counter).getSymbol());
               nameField.setText(investments.get(counter).getName());

            }

            prevButton.addActionListener(new ActionListener() {

               public void actionPerformed(ActionEvent e) {

                  --counter;

                  symbolField.setText(investments.get(counter).getSymbol());
                  nameField.setText(investments.get(counter).getName());

                  if (counter == 0) {

                     prevButton.setEnabled(false);
      
                  }

                  if (counter < investments.size() - 1) {

                     nextButton.setEnabled(true);
      
                  }

               }

            });

            nextButton.addActionListener(new ActionListener() {

               public void actionPerformed(ActionEvent e) {

                  ++counter;

                  symbolField.setText(investments.get(counter).getSymbol());
                  nameField.setText(investments.get(counter).getName());

                  if (counter == investments.size() - 1) {

                     nextButton.setEnabled(false);
      
                  }

                  if (counter > 0) {

                     prevButton.setEnabled(true);
      
                  }

               }

            });


            saveButton.addActionListener(new ActionListener() {

               public void actionPerformed(ActionEvent e) {

                  double price = 0.0;
                  String priceStr = priceField.getText();
               
                  try {

                     price = Double.parseDouble(priceStr);

                  } catch (NumberFormatException ex) {

                     textArea.append("Failed to update, price is invalid.\n");
                     return;

                  }

                  if (price < 0) {

                     textArea.append("Failed to update, negative values are invalid.\n");
                     return;
                     
                  }

                  investments.get(counter).setPrice(price); // update price of each investment

                  textArea.append("Price Updated for " + investments.get(counter).getSymbol() + ".\n");

                  checkUpdate = true; // for getGain function

               }


            });
            
          }

      });

      getGainItem.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

            frame.getContentPane().removeAll();
            frame.repaint();
            
            JPanel textPanels = new JPanel();
            textPanels.setLayout(new BoxLayout(textPanels, BoxLayout.PAGE_AXIS));
            textPanels.setBounds(0, 0, 200, 350);

            JLabel textLabel = new JLabel("Getting total gain");
            JLabel gainLabel = new JLabel("Total gain");
            JLabel msgLabel = new JLabel("Individual gains");

            textLabel.setFont(new Font("", Font.PLAIN, 20));
            gainLabel.setFont(new Font("", Font.PLAIN, 16));
            msgLabel.setFont(new Font("", Font.PLAIN, 20));

            textPanels.add(Box.createRigidArea(new Dimension(10, 0)));
            textPanels.add(textLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 50)));
            textPanels.add(gainLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 212)));
            textPanels.add(msgLabel);
            
            frame.add(textPanels);

            JPanel inputPanels = new JPanel();
            inputPanels.setLayout(new BoxLayout(inputPanels, BoxLayout.PAGE_AXIS));
            inputPanels.setBounds(200, 0, 400, 200);

            JTextField gainField = new JTextField(30);
            gainField.setEditable(false);
            gainField.setBackground(Color.white);

            inputPanels.add(Box.createRigidArea(new Dimension(0, 80)));
            inputPanels.add(gainField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 100)));

            frame.add(inputPanels);

            JPanel outputPanels = new JPanel();
            outputPanels.setBounds(0, 350, 900, 300);
            
            outputPanels.add(scrollPane);

            frame.add(outputPanels);

            frame.add(new JPanel());
            
            frame.setVisible(true);

            if (checkUpdate == true) { // if investment prices were updated

               for (int i = 0; i < investments.size(); ++i) {

                  int quantity = investments.get(i).getQuantity();
                  double price = investments.get(i).getPrice();

                  totalGain += investments.get(i).getGain(quantity, price);
                  double gain = investments.get(i).getGain(quantity, price);

                  textArea.append("\nIndividual gain for " + investments.get(i).getSymbol() + ": $" + gain + "\n");

               }

               gainField.setText("$" + totalGain);

               checkUpdate = false; // set to false until the next update; ensures that totalGain will only gain after updates

            } else if (checkUpdate == false) {

               gainField.setText("$0.00");

            }
            
          }

      });

      searchItem.addActionListener(new ActionListener() { // if user selects search command

         public void actionPerformed(ActionEvent e) {

            frame.getContentPane().removeAll();
            frame.repaint();
            
            JPanel textPanels = new JPanel();
            textPanels.setLayout(new BoxLayout(textPanels, BoxLayout.PAGE_AXIS));
            textPanels.setBounds(0, 0, 200, 350);

            JLabel textLabel = new JLabel("Searching investment");
            JLabel symbolLabel = new JLabel("Symbol");
            JLabel nameLabel = new JLabel("Name Keywords");
            JLabel lowLabel = new JLabel("Low price");
            JLabel highLabel = new JLabel("High price");
            JLabel msgLabel = new JLabel("Search Results");

            textLabel.setFont(new Font("", Font.PLAIN, 20));
            symbolLabel.setFont(new Font("", Font.PLAIN, 16));
            nameLabel.setFont(new Font("", Font.PLAIN, 16));
            lowLabel.setFont(new Font("", Font.PLAIN, 16));
            highLabel.setFont(new Font("", Font.PLAIN, 16));
            msgLabel.setFont(new Font("", Font.PLAIN, 20));

            textPanels.add(Box.createRigidArea(new Dimension(10, 0)));
            textPanels.add(textLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 40)));
            textPanels.add(symbolLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 40)));
            textPanels.add(nameLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 40)));
            textPanels.add(lowLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 40)));
            textPanels.add(highLabel);
            textPanels.add(Box.createRigidArea(new Dimension(0, 40)));
            textPanels.add(msgLabel);
            
            frame.add(textPanels);

            JPanel inputPanels = new JPanel();
            inputPanels.setLayout(new BoxLayout(inputPanels, BoxLayout.PAGE_AXIS));
            inputPanels.setBounds(200, 0, 400, 300);

            JTextField symbolField = new JTextField(30);
            JTextField nameField = new JTextField(30);
            JTextField lowField = new JTextField(30);
            JTextField highField = new JTextField(30);

            inputPanels.add(Box.createRigidArea(new Dimension(0, 70)));
            inputPanels.add(symbolField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 40)));
            inputPanels.add(nameField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 40)));
            inputPanels.add(lowField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 40)));
            inputPanels.add(highField);
            inputPanels.add(Box.createRigidArea(new Dimension(0, 40)));

            frame.add(inputPanels);

            JPanel buttonPanels = new JPanel();
            buttonPanels.setLayout(new BoxLayout(buttonPanels, BoxLayout.PAGE_AXIS));
            buttonPanels.setBounds(600, 0, 300, 300);

            JButton resetButton = new JButton("Reset");
            JButton searchButton = new JButton("Search");

            buttonPanels.add(Box.createRigidArea(new Dimension(80, 80)));
            buttonPanels.add(resetButton);
            buttonPanels.add(Box.createRigidArea(new Dimension(0, 100)));
            buttonPanels.add(searchButton);

            frame.add(buttonPanels);

            JPanel outputPanels = new JPanel();
            outputPanels.setBounds(0, 350, 900, 300);

            outputPanels.add(scrollPane);

            frame.add(outputPanels);

            frame.add(new JPanel());
            
            frame.setVisible(true);

            resetButton.addActionListener(new ActionListener() {

               public void actionPerformed(ActionEvent e) {

                  symbolField.setText("");
                  nameField.setText("");
                  lowField.setText("");
                  highField.setText("");

               }

            });            

            searchButton.addActionListener(new ActionListener() {

               public void actionPerformed(ActionEvent e) {
      
                  ArrayList<ArrayList<Integer>> keyWordIndex = new ArrayList<ArrayList<Integer>>();

                  ArrayList<Integer> intersection = new ArrayList<Integer>();

                  String priceRange = "";

                  String symbol = symbolField.getText();
                  String keyWord = nameField.getText();
                  keyWord = keyWord.toLowerCase();
                  symbol = symbol.toUpperCase();
                  String lowStr = lowField.getText();
                  String highStr = highField.getText();
   
                  if (lowStr.isEmpty() && !highStr.isEmpty()) {

                     priceRange = "-" + highStr;

                  } else if (!lowStr.isEmpty() && highStr.isEmpty()) {

                     priceRange = lowStr + "-";

                  } else if (lowStr.isEmpty() && highStr.isEmpty()) {

                     priceRange = "";

                  } else if (!lowStr.isEmpty() && !highStr.isEmpty()) {

                     priceRange = lowStr + "-" + highStr;

                  }
                  
                  for (int i = 0; i < investments.size(); ++i) {

                     keyWord = keyWord.toLowerCase();
      
                     String keys[] = keyWord.split("[ ]+");
      
                     for (int j = 0; j < keys.length; ++j) {
      
                        ArrayList<Integer> values = keyWords.get(keys[j]);
      
                        keyWordIndex.add(values);
      
                     }
      
                  }
      
                  if (keyWord.isEmpty()) { // if no keywords
      
                  } else if (keyWordIndex.size() == 1) { // if only one keyword
      
                     intersection = keyWordIndex.get(0);
      
                  } else if (keyWordIndex.size () > 1){ // if more than 1 keyword
      
                     intersection = keyWordIndex.get(0);
      
                     for (int i = 0; i < keyWordIndex.size() - 1; ++i) {
      
                        intersection = intersection(intersection, keyWordIndex.get(i + 1));
      
                     }
      
                  }

                  if (symbol.isEmpty()) { // if all inputs are empty
      
                     if (keyWord.isEmpty()) {
      
                        if (priceRange.isEmpty()) {
      
                           textArea.append(investments.toString().replace("[","").replace("]","").replace(",","") + "\n"); // if all inputs are empty print all investments
      
                        } // if range empty
      
                     } // if keyword empty
      
                  } // if symbol empty
      
                  if (priceRange.isEmpty()) { // if only keywords are entered
                     
                     if (symbol.isEmpty()) {

                        for (int i = 0; i < intersection.size(); ++i) {

                           textArea.append(investments.get(intersection.get(i)).toString() + "\n");

                        }
      
                     }
      
                  }
      
                  if (keyWord.isEmpty()) {// if user inputs only symbol
      
                     if (priceRange.isEmpty()) {
      
                        for (int i = 0; i < investments.size(); ++i) {
      
                           if (investments.get(i).getSymbol().equals(symbol)) { 
      
                              textArea.append(investments.get(i).toString() + "\n");
      
                           }
      
                        }
      
                     }
      
                  }
      
                  if (symbol.isEmpty()) { // if user inputs only price range
      
                     if (keyWord.isEmpty()) {
      
                        for (int i = 0; i < investments.size(); ++i) {
      
                           if (investments.get(i).inRange(priceRange)) {
      
                              textArea.append(investments.get(i).toString() + "\n");
      
                           }
      
                        }
      
                     }
      
                  }
      
                  if (keyWord.isEmpty()) { // if user inputs symbol and price range with no keywords
      
                     for (int i = 0; i < investments.size(); ++i) {
      
                        if (investments.get(i).getSymbol().equals(symbol)) {
      
                           if (investments.get(i).inRange(priceRange)) {
      
                              textArea.append(investments.get(i).toString() + "\n");
      
                           }
      
                        }
      
                     }
      
                  }
      
                  if (priceRange.isEmpty()) { //if user inputs keywords and symbol
      
                     for (int i = 0; i < intersection.size(); ++i) {
      
                        if (investments.get(intersection.get(i)).getSymbol().equals(symbol)) {
      
                           textArea.append(investments.get(intersection.get(i)).toString() + "\n");
      
                        }
      
                     }
      
                  }
      
                  if (symbol.isEmpty()) { //if user inputs keywords and price range
      
                     for (int i = 0; i < intersection.size(); ++i) {
      
                        if (investments.get(intersection.get(i)).inRange(priceRange)) {
      
                           textArea.append(investments.get(intersection.get(i)).toString() + "\n");
      
                        }
      
                     }
      
                  }
      
                  for (int i = 0; i < intersection.size(); ++i) { //if user inputs all
      
                     if (investments.get(intersection.get(i)).getSymbol().equals(symbol)) {
      
                        if (investments.get(intersection.get(i)).inRange(priceRange)) {
      
                           textArea.append(investments.get(intersection.get(i)).toString() + "\n");
      
                        }
      
                     }
      
                  }
               
                 
               }
      
             });
            
          }

      });
      

      quitItem.addActionListener(new ActionListener() {

         public void actionPerformed(ActionEvent e) {

           System.exit(-1);
           
         }

       });

   }

   public static ArrayList<Integer> intersection(ArrayList<Integer> values1, ArrayList<Integer> values2) { // intersection function for option 8

      ArrayList<Integer> intersectionValues = new ArrayList<>();
  
      for (Integer i : values1) {

          if (values2.contains(i)) {

              intersectionValues.add(i);
          }

      }
  
      return intersectionValues;
      
   }   
   public static void main (String[] args) {

      new Portfolio();

   } // end of main

} // end of class

