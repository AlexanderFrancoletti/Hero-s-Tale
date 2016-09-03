import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdventureUI extends JFrame
{
   static int[] Progress = new int[11];
   static int x = 0;
   static boolean hasWon = false;
   static boolean hasLost = false;
   static boolean womanAlive = true;
   static boolean animalAlive = true;
   static boolean hasRope = false;
   static boolean atForest = false;
   
   public static void main(String[]args)
   {
      JTextArea textU;
      JTextField textI;
      
      /*These variables all detail the possible paths that can be taken
      int x = 0;
      boolean hasWon = false;
      boolean hasLost = false;
      boolean womanAlive = true;
      boolean animalAlive = true;
      boolean hasRope = false;
      boolean atForest = false;
      int[] Progress = new int[11];*/
      
      //Create new frame
      JFrame frame = new JFrame("A Hero's Tale");
      
      frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
      frame.setLayout(new FlowLayout());
      frame.pack();
      frame.setSize(1060, 620);
      
      //Create JTextArea
      textU = new JTextArea("Would you like to come on an adventure?", 25, 90);
      textU.setPreferredSize(new Dimension(970, 2000));
      JScrollPane scrollPane = new JScrollPane(textU, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      textU.setLineWrap(true);
      frame.add(scrollPane);
      textU.setFocusable(false);
      textU.setEditable(false);
         
      textI = new JTextField(91);
      textI.setPreferredSize(new Dimension(970, 100));
      frame.add(textI);
      //textI.setLineWrap(true);
      textI.requestFocusInWindow();
      textI.setFocusable(true);
      
      //Note to self: This must be the last step of creating GUI
      frame.setVisible(true);
         
      
      /* This entire if/then/else iteration details the path of the game.
         In it, you can find the storylines trigger words that will activate
         the rest of the game. You can also find the moments where the story
         changes ending in here, by looking for the boolean variables
         womanAlive and animalAlive. This action will trigger whenever enter
         is pressed while the lower textfield has focus.
      */
      Action submit = 
         new AbstractAction()
         {
         //Write the actionPerformed method
            public void actionPerformed(ActionEvent e)
            {
            /*These variables all have a more permanent impact on the games outcome
            int x = 0;
            boolean hasWon = false;
            boolean hasLost = false;
            boolean womanAlive = true;
            boolean animalAlive = true;
            boolean hasRope = false;
            boolean atForest = false;
            int[] Progress = new int[11];*/
            
            //This string is the conversion of what the user types into the text field
               String textIValue = textI.getText();
            
            //These are all accessable to start the game
               if (textIValue.equals("No") && Progress[0] == 0 && (hasLost == false))
               {
                  textU.append( "\n" + "Killjoy. YOU LOSE." + "\n");
                  hasLost = true;
               }
                 
               
               else if (textIValue.equals("Yes") && Progress[0] == 0 && (hasLost == false))
               {
                  textU.append( "\n" + "Then let's have an adventure! ");
                  textU.append("Note: Only specific answers such as 'Go into town' work here. Every answer begins with a capital letter and ");
                  textU.append("is not punctuated. ");
                  textU.append("You arrive at a town just outside of a forest, you hear screams in the distance. ");
                  textU.append("You notice some villagers nearby." + "\n" + "What do you do?" + "\n");
                  Progress[0] = 1;
               }
               
               else if (Progress[0] == 0 && hasLost == false && !(textIValue.equals("Yes") && (textIValue.equals("No"))))
                  textU.append("\n" + "I'm sorry, 'Yes' or 'No'?");
               
               
               else if (Progress[0] == 1 && Progress[1] == 0 && (hasLost == false))
               {
               
                  if (textIValue.equals("Talk to the villagers"))
                  {
                     textU.append("You walk up to the villagers. You ask them about the noise. They tell you that a monster has been terrorizing the village for months, ");
                     textU.append("but no one has been able to stop it. You ask them where to find the monster, but none of them know exactly where the monster is. ");
                     textU.append("\n" + "What do you do?" + "\n");
                  }  
                  
                  else if (textIValue.equals("Go to the forest"))
                  {
                     textU.append("You wander into the forest, you see some animals and a river.");
                     textU.append("\n" + "What do you do?" + "\n");
                     atForest = true;
                  }
                  
                  else if (textIValue.equals("Cross the river") && atForest == true)
                     textU.append("The river is too large to cross. ");
                  
                  else if (textIValue.equals("Swim across the river") && atForest == true)
                  {
                     textU.append("You jump in the river, but shortly after you realise that you can't swim. You drown.");
                     textU.append( "\n" + "YOU LOSE." + "\n");
                     hasLost = true;
                  }
                     
                  else if (textIValue.equals("Go into town"))
                  {
                     textU.append("You find a strong man with a sword. No one else is in sight, and all the homes are locked.");
                     textU.append("\n" + "What do you do?" + "\n");
                     atForest = false;
                     Progress[1] = 1;
                  /* if (Progress[1] == 1 && Progress[2] == 0 && (hasLost == false))
                  {
                     if (textIValue.equals("Fight the man"))
                     {
                        textU.append("He has a sword and you don't. He slices you in half. YOU LOSE." + "\n");
                        hasLost = true;
                     }
                                  
                     else if (textIValue.equals("Talk to the man"))
                     {
                        textU.append("He asks you what you want. You ask him about the scream in the forest. ");
                        textU.append("He tells you that a monster lives in the forest on the other side of the river. ");
                        textU.append("He will give you a rope and his sword if you vow to slay the monster.");
                        textU.append("\n" + "Do you vow to slay the monster?" + "\n");
                        Progress[2] = 1;
                     }
                     //else
                       // textU.append("I don't understand that option, try a more exact respone." + "\n");
                  }*/
                  }
                  
                  else if ((Progress[0] == 1 && !(textIValue.equals("Talk to the villagers") && textIValue.equals("Go to the forest") && textIValue.equals("Go into town"))
                     || (!(textIValue.equals("Cross the river") && textIValue.equals("Swim across the river")) && atForest == true)))
                     textU.append("I don't understand that option, try a more exact response." + "\n");
               }  
               
               else if (Progress[1] == 1 && Progress[2] == 0 && (hasLost == false))
               {
                  if (textIValue.equals("Fight the man"))
                  {
                     textU.append("He has a sword and you don't. He slices you in half. YOU LOSE." + "\n");
                     hasLost = true;
                  }
                            
                  else if (textIValue.equals("Talk to the man"))
                  {
                     textU.append("He asks you what you want. You ask him about the scream in the forest. ");
                     textU.append("He tells you that a monster lives in the forest on the other side of the river. ");
                     textU.append("He will give you a rope and his sword if you vow to slay the monster.");
                     textU.append("\n" + "Do you vow to slay the monster?" + "\n");
                     Progress[2] = 1;
                  }
                  
                  else if (Progress[1] == 1 && hasLost == false && !(textIValue.equals("Fight the man") && textIValue.equals("Talk to the man")))
                     textU.append("I don't understand that option, try a more exact response." + "\n");
               }
               
               else if (Progress[2] == 1 && Progress[3] == 0 && (hasLost == false))
               {
                  if (textIValue.equals("No"))
                  {
                     textU.append("You leave the village. They never hear from you again. You live, however you do not feel right. ");
                     textU.append("You become plagued by guilt only to return to a village of ghosts. The sheer guilt of it all kills you.");
                     textU.append( "\n" + "YOU LOSE." + "\n");
                     hasLost = true;
                  }
                     
                  else if (textIValue.equals("Yes"))
                  {
                     textU.append("You now have a sword and a long rope .");
                     textU.append("You wander into the forest determined to slay the monster. You see some animals and a river.");
                     textU.append("\n" + "What do you do?" + "\n");
                     atForest = true;
                     hasRope = true;
                     Progress[3] = 1;
                  }
                  
                  else if (Progress[2] == 1 && hasLost == false && !(textIValue.equals("No") && textIValue.equals("Yes")))
                     textU.append("I don't understand that option, try a more exact response." + "\n");
               }
               
               else if (Progress[3] == 1 && Progress[4] == 0 && (hasLost == false))
               {
                  if (textIValue.equals("Swim across the river"))
                  {
                     textU.append("You jump into the river, but you realise you can't swim.");
                     textU.append( "\n" + "YOU LOSE." + "\n");
                     hasLost = true;
                  }
                           
                  else if (textIValue.equals("Cross the river"))
                  {
                     textU.append("You strap the rope to a tree, and cross the river while holding on to the rope. ");
                     textU.append("You see a woman's seemingly lifeless body on the ground.");
                     textU.append("\n" + "What do you do?" + "\n");
                     Progress[4] = 1;
                     hasRope = false;
                  }
               }
               
               else if (Progress[4] == 1 && Progress[5] == 0 && (hasLost == false))
               {
                  if (textIValue.equals("Kill her"))
                  {
                     textU.append("You take your sword and begin to chop off her limbs before finally slitting her throat. ");
                     textU.append("You feel no remorse as you walk away, you sadistic murderous villain.");
                     textU.append("\n" + "YOU LOSE." + "\n");
                     hasLost = true;
                  }
                               
                  else if (textIValue.equals("Wake her up") || textIValue.equals("Save her") || textIValue.equals("Help her"))
                  {
                     textU.append("You manage to shake her awake. Before you can ask her a question, she runs toward the village screaming. ");
                     textU.append("You look up to find a silhouette of what appears to be a hairy man. Maybe this is the monster?");
                     textU.append("\n" + "What do you do?" + "\n");
                     Progress[5] = 1;
                  }
               }
               
               else if (Progress[5] == 1 && Progress[6] == 0 && (hasLost == false))
               {
                  if (textIValue.equals("Go into town"))
                  {
                     textU.append("You run towards the town but find yourself unable to cross the river. You see the rope still wrapped around the tree. ");
                     textU.append("There is no way to get it. You look back to notice the silhouette is larger than when you looked last.");
                     textU.append("\n" + "What do you do?" + "\n");                              
                  
                     if (textIValue.equals("Swim across the river"))
                     {
                        textU.append("You jump into the river, but you realise you can't swim. ");
                        textU.append( "\n" + "YOU LOSE." + "\n");
                        hasLost = true;
                     }
                                    
                     else if (textIValue.equals("Run at the silhouette") || textIValue.equals("Run at the monster") || textIValue.equals("Go toward the monster"))
                     {
                        textU.append("You run toward the figure in the distance. As you get closer you can make out fur and bloodshot eyes.");
                        textU.append("\n" + "What do you do?" + "\n");
                        Progress[6] = 1;
                     }
                  }
                  
                  else if (textIValue.equals("Run at the silhouette") || textIValue.equals("Run at the monster") || textIValue.equals("Go toward the monster"))
                  {
                     textU.append("You run toward the figure in the distance. As you get closer you can make out fur and bloodshot eyes.");
                     textU.append("\n" + "What do you do?" + "\n");
                     Progress[6] = 1;
                  }
               }
               
               //This is where the endings change based on some choices                           
               else if (Progress[6] == 1 && Progress[7] == 0 && (hasLost == false))
               {
                  if (textIValue.equals("Attack the monster"))
                  {
                     textU.append("You take your sword and strike the tired, fur covered creature down. You hear another roar similar to the one you ");
                     textU.append("heard coming from the forest earlier. This creature was not the monster.");
                     textU.append("\n" + "What do you do?" + "\n");
                     animalAlive = false;
                     Progress[7] = 1;
                  }
                  
                  else if (textIValue.equals("Let it go") || textIValue.equals("Leave it") || textIValue.equals("Spare it"))
                  {
                     textU.append("The creature whimpers as you raise your sword, but you realise that nothing as innocent as this creature is a monster. ");
                     textU.append("You hear a scream in the distance.");
                     textU.append("\n" + "What do you do?" + "\n");
                     Progress[7] = 1;
                  }
               }                           
               
               else if (Progress[7] == 1 && Progress[8] == 0 && (hasLost == false))
               {
                  if (textIValue.equals("Run toward the scream"))
                  {
                     textU.append("You race off towards the only noise you can hear. After 100 yards of sprinting you see the woman from earlier being ");
                     textU.append("attacked by what you can only call a chupacabre.");
                     textU.append("\n" + "What do you do?" + "\n");
                     Progress[8] = 1;
                  }
                                             
                  if (textIValue.equals("Run away from the scream"))
                  {
                     textU.append("You can't run away, you vowed to slay the monster. ");
                     textU.append("You hesitate, but run toward the scream anyway, only to find the woman being attacked by he monster.");
                     textU.append("\n" + "What do you do?" + "\n");
                     womanAlive = false;
                     Progress[8] = 1;
                  }
                  
                  else
                  {
                     textU.append("I don't understand that option, try a more exact response");
                     womanAlive = false;
                  }
               }
               
               else if (Progress[8] == 1 && Progress[9] == 0 && (hasLost == false))
               {   
                  if (textIValue.equals("Attack the monster") || textIValue.equals("Attack it") || textIValue.equals("Attack"))
                  {
                     x = ((int)(Math.random()*21)-10);
                     if (x >= 0)
                     {
                        textU.append("You slice the monster across the chest, it is hurt by this attack, but it is still ready to attack. ");
                        textU.append("The monster lunges forward to attack you.");
                        textU.append("\n" + "What do you do?" + "\n");
                        Progress[9] = 1;
                     }
                     
                     else if (x < 0)
                     {
                        textU.append("You try to attack the monster, however you swing wide. The monster attacks and you get stabbed in the heart. ");
                        textU.append("You die in the final moments of your journey, tough luck.");
                        textU.append( "\n" + "YOU LOSE. But don't worry, the final battle is number generated, you should try again." + "\n");
                     }
                  }
               }
               
               else if (Progress[9] == 1 && Progress[10] == 0 && (hasLost == false))
               {                                                               
                  if (textIValue.equals("Duck") || textIValue.equals("Dodge the attack") || textIValue.equals("Dodge"))
                  {
                     x = ((int)(Math.random()*21)-10);
                     if (x >= 0)
                     {
                        textU.append("You barely avoid the attack and prepare a counterattack. You thrust your sword upward in an attempt to slice the ");
                        textU.append("monster. This almost kills the monster. One more blow would finish the monster.");
                        textU.append("\n" + "What do you do?" + "\n");
                        Progress[10] = 1;
                     }
                     
                     else if (x < 0)
                     {
                        textU.append("You try to dodge, however you misread the monsters attack and are stabbed in the heart. ");
                        textU.append("You die in the final moments of your journey, tough luck.");
                        textU.append( "\n" + "YOU LOSE. But don't worry, the final battle is number generated, you should try again." + "\n");
                        hasLost = true;
                     }
                  }
               }
               
               else if (Progress[10] == 1 && hasWon == false)
               {
                  if (textIValue.equals("Kill the monster") || textIValue.equals("Kill it") || textIValue.equals("Finish it") || textIValue.equals("Attack the monster") && animalAlive == false && womanAlive == true)
                  {
                     textU.append("With one final blow you plow your sword through its chest. You hear a piercing scream from the monster as it slowly ");
                     textU.append("wilts to a mound of flesh and blood. The woman runs into your arms and asks you to take her to the village. ");
                     textU.append("As you walk there she vomits as you come across the creature you killed. You tell her you killed it and she tells you ");
                     textU.append("that she had raised that animal since she was a child. She refuses to talk to you throughout your journey back to town ");
                     textU.append("When in town, you recieve an award from the mayor. You have saved them from parish today.");
                     textU.append("\n" + "YOU WIN! Try again to get a different ending." + "\n");
                     hasWon = true;
                  }
                  
                  else if (textIValue.equals("Kill the monster") || textIValue.equals("Kill it") || textIValue.equals("Finish it") || textIValue.equals("Attack the monster") && animalAlive == false && womanAlive == false)
                  {
                     textU.append("With one final blow you plow your sword through its chest. You hear a piercing scream from the monster as it slowly ");
                     textU.append("wilts to a mound of flesh and blood. The woman however is not quite as lucky as you, if you hadn't run away from the ");
                     textU.append("monster, she would not greviously wounded. You bury her dead body, then leave to go back to the village. On the way ");
                     textU.append("back you come across the creature you killed in cold blood. You feel remorse for your actions, but largely disregard ");
                     textU.append("them. When in town, you recieve an award from the mayor. You've at least spared them for today.");
                     textU.append( "\n" + "YOU WIN! Try again to get a different ending." + "\n");
                     hasWon = true;
                  }
                  
                  else if (textIValue.equals("Kill the monster") || textIValue.equals("Kill it") || textIValue.equals("Finish it") || textIValue.equals("Attack the monster") && animalAlive == true && womanAlive == false)
                  {
                     textU.append("With one final blow you plow your sword through its chest. You hear a piercing scream from the monster as it slowly ");
                     textU.append("wilts to a mound of flesh and blood. The woman however is not quite as lucky as you, if you hadn't run away from the ");
                     textU.append("monster, she would not be greviously wounded. You bury her dead body, then leave to go back to the village. On your way ");
                     textU.append("back, you see the creature you spared, which is beginning to look more like a dog. You take the dog back into town with ");
                     textU.append("When in town, you recieve an award from the mayor. Someone sees the dog, and tells you that the dogs owner, Ally, ");
                     textU.append("wandered into the forest after the dog. You stand in silence as you realize the dog's owner is dead because of your ");
                     textU.append("own inaction. You have saved at least one of them from perish today.");
                     textU.append( "\n" + "YOU WIN! Try again to get a different ending." + "\n");
                     hasWon = true;
                  }
                  
                  else if (textIValue.equals("Kill the monster") || textIValue.equals("Kill it") || textIValue.equals("Finish it") || textIValue.equals("Attack the monster") && animalAlive == true && womanAlive == true)
                  {
                     textU.append("With one final blow you plow your sword through its chest. You hear a piercing scream from the monster as it slowly ");
                     textU.append("wilts to a mound of flesh and blood. The woman runs into your arms and asks you to take her to the village. ");
                     textU.append("As you walk there she is delighted to find the creature you spared. The creature seems to be much more relaxed with her ");
                     textU.append("around. She tells you how she had raised this animal since she was a child. She kisses you and asks you to stay at the ");
                     textU.append("village with her. When in town, you recieve an award from the mayor. You have saved everyone and everything today. ");
                     textU.append( "\n" + "YOU WIN! You can try again to get a different ending, but this is the best one in my opinion."+ "\n");
                  }
               }
               
                                                      
                                                   
                                                            
               else if (hasWon == true)
                  textU.append("If you would like to play again, the reset button is 'F6'.");
               
               else if (hasLost == true)
                  textU.append("The reset key is 'F5'." + "\n");
            
               textI.setText("");                                                 
            }
         };
      
      //This action resets the trigger variables and both the text fields to the beginning of the game
      Action reset = 
         new AbstractAction()
         {
            public void actionPerformed(ActionEvent e)
            {
            //Reset key variables
               x = 0;
               hasWon = false;
               hasLost = false;
               womanAlive = true;
               animalAlive = true;
               hasRope = false;
               atForest = false;
            
               textU.setText("Would you like to come on an adventure?");
            
               for (int n = 0; n < Progress.length; n++)
                  Progress[n] = 0;
            
            }
         };
      
      
      
      //This is the actual keybinding declaration
      //The first line declares the key and the assigns the action name chosen to the key
      //The second line assigns the action submit to the action chosen
      textI.getInputMap().put(KeyStroke.getKeyStroke("ENTER"),
         "Chosen");
      textI.getActionMap().put("Chosen",
         submit);
         
      //This keybinding should bind the reset action to the key 'F5'
      textI.getInputMap().put(KeyStroke.getKeyStroke("F5"),
         "Reset");
      textI.getActionMap().put("Reset",
         reset);
         
      
   }
}
