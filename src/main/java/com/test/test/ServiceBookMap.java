package com.test.test;

import org.springframework.stereotype.Component;

import java.io.*;
import java.lang.invoke.SwitchPoint;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

@Component
public class ServiceBookMap {
    public String testApp() throws IOException {
        //F:\Smart_Soft_Ehtesham_Sir\test\bookInformation.txt
        //String inputFilePath ="/Users/user/Desktop/bookInformation.txt"; \test
    	String inputFilePath ="/Smart_Soft_Ehtesham_Sir/test/bookInformation.txt";
        StringBuffer stringBuffer = new StringBuffer();
        Stack<String> lastData= new Stack<>();
        Files.newBufferedReader(Paths.get(inputFilePath)).lines().forEach(test -> {
            switch(test.toLowerCase().charAt(0)){
                case 'q':
                    if(test.contains("best_bid")){
                        Integer price=0,size=0;
                        while (!lastData.empty())
                        {
                            String lastBidData = lastData.pop();
                            if(lastBidData.contains("bid")){
                                String bidData[]=lastBidData.split(",");
                                int priceTemp = Integer.parseInt(bidData[1]);
                                int sizeTemp = Integer.parseInt(bidData[2]);
                                price = price<priceTemp?priceTemp:price;
                                size = size<sizeTemp?sizeTemp:size;
                            }
                        }
                        if(price>0){
                            stringBuffer.append(price+","+size+"\n");
                            System.out.println("Best Bid - "+price + " : "+ size+"\n");
                        }

                    }else if(test.contains("best_ask")){
                        Integer price=0,size=0;
                        while (!lastData.empty())
                        {
                            String lastBidData = lastData.pop();
                            if(lastBidData.contains("ask")){
                                String bidData[]=lastBidData.split(",");
                                int priceTemp = Integer.parseInt(bidData[1]);
                                int sizeTemp = Integer.parseInt(bidData[2]);
                                price = price<priceTemp?priceTemp:price;
                                size = size<sizeTemp?sizeTemp:size;
                            }
                        }
                        if(price>0)
                        {
                                stringBuffer.append(price+","+size+"\n");
                            System.out.println("Best Ask - "+price + " : "+ size +"\n");
                        }

                    }else{
                        while (!lastData.empty()){
                            String lastBidData = lastData.pop();
                            if(lastBidData.startsWith("o")){
                                    stringBuffer.append(lastBidData.split(",")[2]);
                            }
                        }



                    }
                    break;
                case 'u':
                case 'o':
                    lastData.push(test);
                    break;
                default:
                    System.out.println("Invalid Entry"+ test);
            }
        });
        return stringBuffer.toString();
    }

    //This is comment to see commit test
}
