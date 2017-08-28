import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Hack {
	public static void main(String[] args) throws FileNotFoundException {
		intro();
		Scanner input = new Scanner(System.in);
		
		
		boolean condition = true;
		boolean appStatus = false;
		int userInput = 0;
		Set<String> listOfBlockedUrl = new TreeSet<String>();
		try (Scanner scanner = new Scanner(new File("C:\\Windows\\System32\\drivers\\etc\\hosts"));){
//	       	 String thisLine = null;
	//       	 System.out.println(br.readLine());
	       	 while (scanner.hasNextLine()) {
	       		 String nextLine = scanner.nextLine();
	//       		 System.out.println(thisLine + thisLine.toLowerCase().contains("#blockapp"));
	//       		 System.out.println("Hey is this line: " + br.readLine());
	       		 if (nextLine.contains("#blockapp") && !nextLine.contains("localhost")) {
	       			Scanner string = new Scanner(nextLine);
		       		string.next();
		       		listOfBlockedUrl.add(string.next());
	       		 }
	       	 }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		loop:
		while (condition) {
			try 
			{
				userInput = 0;
				System.out.println("\n-------------------------------------");
				System.out.print("\nPlease enter your choice (1 to 7): ");
//				System.out.println("first " + userInput);
				userInput = input.nextInt();
				
//				System.out.println("second " + userInput);
				while (userInput<1 || userInput > 7) {
					System.out.println("\nWrong input ");
					continue loop;
				}
//				condition = false;
				
			} catch (InputMismatchException ex) {
				System.out.println("\nNumber only");
				input.nextLine();
				continue loop;
			}
			
			// If user chooses to block an address
			if (userInput == 1) {
				if (appStatus == true) {
					try(FileWriter fw = new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts", true);
						    BufferedWriter bw = new BufferedWriter(fw);
						    PrintWriter out = new PrintWriter(bw))
						{
							System.out.print("\nEnter the hated URL address: ");
							input.nextLine();
							String addInput = input.nextLine();
						    if (!addInput.trim().isEmpty()) {
						    	out.println("\n0.0.0.0       " + addInput + "     #blockapp");
						    	listOfBlockedUrl.add(addInput);
						    }
						    //more code
						} catch (IOException e) {
							e.printStackTrace();
						    //exception handling left as an exercise for the reader
						}
					continue loop;
				} else {
					System.out.println("App is disabled");
				}
			}
			
			// List all blocked websites 
			if (userInput == 2) {
				try (Scanner scanner = new Scanner(new File("C:\\Windows\\System32\\drivers\\etc\\hosts"));){
//			       	 String thisLine = null;
			//       	 System.out.println(br.readLine());
			       	 while (scanner.hasNextLine()) {
			       		 String nextLine = scanner.nextLine();
			//       		 System.out.println(thisLine + thisLine.toLowerCase().contains("#blockapp"));
			//       		 System.out.println("Hey is this line: " + br.readLine());
			       		 if (nextLine.contains("#blockapp") && !nextLine.contains("localhost")) {
			       			Scanner string = new Scanner(nextLine);
				       		string.next();
				       		listOfBlockedUrl.add(string.next());
			       		 }
			       	 }
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				if (appStatus == true) {
					System.out.println("\nList of blocked website: ");
					Iterator<String> listIterator = listOfBlockedUrl.iterator();
					System.out.println();
					while (listIterator.hasNext()) {
						System.out.println("-    " + listIterator.next());
					}
				} else {
					System.out.println("App is disbled");
				}
			}
			
			if (userInput == 4) {
				if (appStatus == true) {
					System.out.println("App is disabled");
			        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Windows\\System32\\drivers\\etc\\hosts"));){
			        	 
			        	 String thisLine = null;
			        	 List<String> lines = new ArrayList<String>();
//			        	 System.out.println(br.readLine());
			        	 while ((thisLine = br.readLine()) != null) {
//			        		 System.out.println(thisLine + thisLine.toLowerCase().contains("#blockapp"));
//			        		 System.out.println("Hey is this line: " + br.readLine());
			        		 if (!thisLine.contains("#blockapp")) {
			        			 lines.add(thisLine);
			        		 }
			        		
			        	 }
			        	 try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Program Files\\Block Website\\hostsBackUp.txt"))) {
			        		 Set<String> backUp = new HashSet<String>();
			        		 try (Scanner scanner = new Scanner(new File("C:\\Windows\\System32\\drivers\\etc\\hosts"));){
//			        	       	 String thisLine = null;
			        	//       	 System.out.println(br.readLine());
			        	       	 while (scanner.hasNextLine()) {
			        	       		 String nextLine = scanner.nextLine();
			        	//       		 System.out.println(thisLine + thisLine.toLowerCase().contains("#blockapp"));
			        	//       		 System.out.println("Hey is this line: " + br.readLine());
			        	       		 if (nextLine.contains("#blockapp") && !nextLine.contains("localhost")) {
			        	       			Scanner string = new Scanner(nextLine);
			        		       		string.next();
			        		       		backUp.add(string.next());
			        	       		 }
			        	       	 }
			        		} 
			        		 
//			        		for (String string: backUp) {
//			        			 bw.write(string + "\n");
//			        		}
			        		 Iterator<String> listIterator = backUp.iterator();
								while (listIterator.hasNext()) {
									bw.write(listIterator.next() + " \n");
								}
			        	 }
			        	 
			        	
			        	 try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts"));) {
				        	 for (int i = 0; i <lines.size() - 1 ; i++) {
//				        		 System.out.println(lines.toString());
			        			 bw.write(lines.get(i) + "\n");
			        			 bw.flush();
			        			 
//			        			 bw.close();
			        		 }
				        	 bw.write(lines.get(lines.size() - 1));
				        	 appStatus = false;
			        	 } 
			        	 
			        } catch (Exception ex) {
			        	ex.printStackTrace();
			        }

				} else {
					System.out.println("App has already been disabled");
					
				}
				continue loop;
			}
			
			if (userInput == 3) {
				if (appStatus == false) {
					//do something to activate
					System.out.println("App is now enabled");
					try (PrintWriter bw = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts", true))); 
							Scanner backedUpBw = new Scanner(new File("C:\\Program Files\\Block Website\\hostsBackUp.txt")))
					{
						bw.println("127.0.0.1       localhost" + "     #blockapp");
						bw.println("::1             localhost" + "     #blockapp");
//						Iterator<String> listIterator = listOfBlockedUrl.iterator();
//						while (listIterator.hasNext()) {
//							bw.print("\n0.0.0.0       " + listIterator.next() + "     #blockapp");
//						}
						while (backedUpBw.hasNext()) {
							bw.print("\n0.0.0.0       " + backedUpBw.next() + "     #blockapp");
						}
						// Clear back up file
						PrintWriter writer = new PrintWriter("C:\\Program Files\\Block Website\\hostsBackUp.txt");
//						writer.print("");
						writer.close();
						bw.flush();
						bw.close();
						appStatus = true;
						
					} catch(Exception e){
				         e.printStackTrace();
				    }
				} else {
					System.out.println("App has already been activated");
				}
				continue;
			}
			
			// Clear all websites saved in the main and backed up file
			if (userInput == 5) {
				System.out.println("Everything is clear!");
				
				// Clear main file
				/*
				 * Idea: Delete all the texts in the host file, but still keep a backup of any text line without the block "#blockapp"
				 * After that, copy these backed up lines (those without "#blockapp") to a newly created host file
				 */
				try (BufferedReader br = new BufferedReader(new FileReader("C:\\Windows\\System32\\drivers\\etc\\hosts"));){
		        	 
		        	 String thisLine = null;
		        	 List<String> lines = new ArrayList<String>();
//		        	 System.out.println(br.readLine());
		        	 while ((thisLine = br.readLine()) != null) {
//		        		 System.out.println(thisLine + thisLine.toLowerCase().contains("#blockapp"));
//		        		 System.out.println("Hey is this line: " + br.readLine());
		        		 if (!thisLine.contains("#blockapp")) {
		        			 lines.add(thisLine);
		        		 }
		        		
		        	 }
		        	 /*
		        	  * Remember: 
		        	  * 
		        	  * new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts")        -            create a new host file
		        	  * 
		        	  * And:
		        	  * 
		        	  * new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts", true)            -            append new content to the old content (old file won't be deleted)
		        	  */
		        	 try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Windows\\System32\\drivers\\etc\\hosts"));) {
			        	 for (int i = 0; i <lines.size() - 1 ; i++) {
//			        		 System.out.println(lines.toString());
		        			 bw.write(lines.get(i) + "\n");
		        			 bw.flush();
		        			 
//		        			 bw.close();
		        		 }
			        	 bw.write(lines.get(lines.size() - 1));
		        	 } 
		        	 
		        	// Clear back up file
						PrintWriter writer = new PrintWriter("C:\\Program Files\\Block Website\\hostsBackUp.txt");
//						writer.print("");
						writer.close();
						listOfBlockedUrl.clear();
						
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			if (userInput == 6) {
				if (appStatus == true) {
					System.out.println("\nApp is activated");
				} else {
					System.out.println("\nApp is not activated");
				}
				continue;
			}
			
			if (userInput == 7) {
				System.out.println("Applied and exit");
				break;
			}
			
		}
		input.close();
		System.exit(0);
//		Scanner file = new Scanner(new File("C:/Windows/System32/drivers/etc/hosts"));
//		while (file.hasNext()) {
//			System.out.println(file.next());
//		}
		
	}
	
	public static void intro() {
		System.out.println("What do u wanna do?");
		System.out.println("1. Block a website");
		System.out.println("2. List all blocked website");
		System.out.println("3. Activate the app");
		System.out.println("4. Disable the app (preserve the list of blocked sites) ");
		System.out.println("5. Clear all blocked websites");
		System.out.println("6. Check the app status");
		System.out.println("7. Exit to apply");
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Note:");
		System.out.println("- INSTALL THE APP IN YOUR FIRST TIME USING IT");
		System.out.println("- Create a folder named \"Block Website\" in the address: \"C:\\Program Files\\\"");
		System.out.println("In your new \"Block Website\" folder, create the text file hostsBackUp.txt");
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\n-\tAfter openning the app, activate the app first to use any function");
		System.out.println("-\tTo make the app work, exit the app to apply");
		System.out.println("-\tAfter activating the app, the list of blocked sites (if not cleared previously) will be restored");
		System.out.println("-\tIf you choose 1 but do not want to enter anything, leave it blank and press enter");
		System.out.println("-\tType the exact URL of the website to block it");
		System.out.println("-\n\tExample: youtube.com is different from www.youtube.com");
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
//	public void blockFile(String blockedUrl) {
//		BufferedWriter bw = null;
//		try {
//	         // APPEND MODE SET HERE
//	     bw = new BufferedWriter(new FileWriter("checkbook.dat", true));
//		 bw.write("400:08311998:Inprise Corporation:249.95");
//		 bw.newLine();
//		 bw.flush();
//	      } catch (IOException ioe) {
//		 ioe.printStackTrace();
//	      } finally {                       // always close the file
//		 if (bw != null) try {
//		    bw.close();
//		 } catch (IOException ioe2) {
//		    // just ignore it
//		 }
//	      } // end try/catch/finally
//
//	}
	
}
