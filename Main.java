package PaulWeber;

import org.apache.commons.cli.*;

public class Main implements Comparable {
    
    public static void main(String[] args){
        CommandLineParser parser = new DefaultParser();
        Options options = new Options();

        Option optsType = Option.builder().longOpt("type").hasArg().required(true).build();
        options.addOption(optsType);

        Option optsKey = Option.builder().longOpt("key").hasArg().required(true).build();
        options.addOption(optsKey);

        Option optsList = Option.builder().longOpt("list").hasArg().valueSeparator(' ').required(true).build();
        options.addOption(optsList);

        CommandLine commandLine = null;
        

        String type = commandLine.getOptionValue("type");
        String key = commandLine.getOptionValue("key");
        String[] list = commandLine.getOptionValues("list");
        
        int ans = -1;
        
        if(type == "i"){
            Integer[] arrayIn = new Integer[list.length];
            int iKey = Integer.parseInt(key);
            for(int i = 0;i<list.length;i++){
                arrayIn[i] = Integer.parseInt(list[i]);
            }
            ans = binSearch(arrayIn,iKey);
        }
        else if(type.equals("s")){

            ans = binSearch(list,key);
        }
        else {
            System.exit(1);
        }

        if(ans == -1){
            System.out.println("The key was not found");
        }
        else{
            System.out.println(ans);
        }

    }
    
    
    public int compareTo(Object other){
        return 0;
    }
    
    
    public static int binSearch(Comparable[] aList,Comparable key){
        int size = aList.length;
        int low = 0;
        int high = (size -1);

        while (low <= high){
            int mid = ((low + high) / 2);

            if(aList[mid].compareTo(key) == 0){
                return mid;
            }
            else if(aList[mid].compareTo(key)< 0){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return -1;
    }
}
