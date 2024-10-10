import java.io.*;
import java.util.*;

class FileCreation{
	public void createFile() throws IOException {
		String fileContent = "14 Ram Ram@gmail.com 9876543433 Afghanistan\r\n" + 
    			"170 Janu Janu@gmail.com 9876543434 Albania\r\n" + 
    			"197 Karthick Karthick@gmail.com 9876543435 Algeria\r\n" + 
    			"123 Kumar Kumar@gmail.com 9876543436 Antarctica\r\n" + 
    			"166 Gobi Gobi@gmail.com 9876543443 Barbados\r\n" + 
    			"116 Guru Guru@gmail.com 8876543444 Bermuda\r\n" + 
    			"191 John John@gmail.com 9876543445 Brazil\r\n" + 
    			"70 Sri Sri@gmail.com 9876543446 Canada\r\n" + 
    			"175 Babu Babu@gmail.com 9876543447 Cuba\r\n" + 
    			"55 vishal vishal@gmail.com 8876543449 Afghanistan\r\n" + 
    			"136 Ravi Ravi@gmail.com 9876543450 Albania\r\n" + 
    			"76 Shyuam Shyuam@gmail.com 9876543451 Algeria\r\n" + 
    			"10 Seetha Seetha@gmail.com 9876543452 Antarctica\r\n" + 
    			"47 Deepa Deepa@gmail.com 9876543453 Barbados\r\n" + 
    			"15 Keethir Keethir@gmail.com 9876543454 Bermuda\r\n" + 
    			"53 Kathir Kathir@gmail.com 9876543455 Brazil\r\n" + 
    			"104 Babu Babu@gmail.com 9876543456 Canada\r\n" + 
    			"99 Prasanth Prasanth@gmail.com 9876543457 Cuba\r\n" + 
    			"79 Reeha Reeha@gmail.com 9876543437 Finland\r\n" + 
    			"97 Smith Smith@gmail.com 9876543438 India\r\n" + 
    			"173 rani rani@gmail.com 9876543439 India\r\n" + 
    			"168 Reeta Reeta@gmail.com 9876543440 India\r\n" + 
    			"32 raji raji@gmail.com 9876543441 India\r\n" + 
    			"11 vani vani@gmail.com 9876543442 India";
        
        FileWriter fileWriter = new FileWriter("File1.txt");
        fileWriter.write(fileContent);
        fileWriter.close();
	}
}
public class p2{
	public static void main(String args[]) throws IOException {
		FileCreation fc =new FileCreation();
		fc.createFile();
		FileWriter writer = new FileWriter("File2.txt");
		FileReader file = new FileReader("File1.txt");  
		BufferedReader br = new BufferedReader(file);
		int[] arr = new int[24];  
		int i=0;
		String line;
		while((line = br.readLine()) != null) 
		{  
			String words[] = line.split(" ");
			arr[i]=Integer.valueOf(words[0]);
			i++;
		}  
		Arrays.sort(arr);
		br.close(); 
		file.close();
		for(int j=0;j<24;j++)
		{
			String line1;
			FileReader file1 = new FileReader("File1.txt");
			BufferedReader br1 = new BufferedReader(file1);
			while((line1 = br1.readLine()) != null) 
			{  

				String words1[] = line1.split(" ");
				if(arr[j]==Integer.valueOf(words1[0]))
				{
					writer.write(words1[1]+" "+words1[0]+" "+words1[2]+" "+words1[3]+" "+words1[4]+"\n");
				}
			} 
			br1.close();
			file1.close();
		}
		writer.close();
        File myObj =new File("File2.txt");
		Scanner read = new Scanner(myObj);
		while(read.hasNextLine()) {
			System.out.println(read.nextLine());
        }
    }
}


         