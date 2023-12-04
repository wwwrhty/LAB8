import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws JAXBException {
        WorkingWIthArrayList newArrayList = new WorkingWIthArrayList(new ArrayList<>());

        newArrayList.addElement("Tanya");
        newArrayList.addElement("Vanya");
        newArrayList.addElement("Andrew");
        newArrayList.addElement("Alesya");
        newArrayList.addElement("Dasha");

        workWithFunctions(newArrayList);
    }

    public static void workWithFunctions(WorkingWIthArrayList newArrayList) throws JAXBException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            clearConsole();
            System.out.println("Select an action: \n" +
                    "1.Add an element\n" +
                    "2.Delete an element\n" +
                    "3.Reverse all strings\n" +
                    "4.Character statistic\n" +
                    "5.Find the substring\n" +
                    "6.Initialization with TxtDocument\n" +
                    "7.Count and sort strings\n" +
                    "8.Dynamic opportunity\n" +
                    "9.Comparison of strings\n" +
                    "10.Save to XML\n" +
                    "11.Output of elements\n" +
                    "12.Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    String temp;
                    System.out.print("Enter the string: ");
                    temp = scanner.next();
                    newArrayList.addElement(temp);
                    break;
                }
                case 2: {
                    int position;
                    System.out.print("Enter the position of the element? that you want to delete: ");
                    position = scanner.nextInt();

                    newArrayList.deleteElement(position);
                    break;
                }
                case 3: {
                    newArrayList.reverseAllStrings();
                    break;
                }
                case 4: {
                    System.out.println(newArrayList.getCharacterStatistics());
                    break;
                }
                case 5: {
                    String substring;
                    System.out.print("Enter the substring: ");
                    substring = scanner.next();
                    newArrayList.findSubstring(substring);
                    break;
                }
                case 6: {
                    WorkingWIthArrayList workingWithTxtList = new WorkingWIthArrayList("people.txt");
                    workingWithTxtList.printArrayList();
                    break;
                }
                case 7: {
                    System.out.println(newArrayList.countAndSortStringLengths());
                    break;
                }
                case 8: {
                    LimitedSizeCollection<Integer> collection = new LimitedSizeCollection<>(5);
                    for (int i = 1; i <= 10; i++) {
                        collection.add(i);
                        System.out.println("Added: " + i);
                        System.out.println("Collection: " + collection.getCollection());
                    }
                    break;
                }
                case 9: {
                    int position1, position2;
                    System.out.println("Enter the position of the elements that you want to compare: ");
                    position1 = scanner.nextInt();
                    position2 = scanner.nextInt();

                    if(newArrayList.compareInnerObjects(position1, position2)){
                        System.out.println("Elements with indexes:" + position1 + " and " + position2 +
                                "the same");
                    }else{
                        System.out.println("Elements with indexes:" + position1 + " and " + position2 +
                                " different");
                    }

                    break;
                }
                case 10: {
                    newArrayList.saveArrayListToXML("people.xml");
                    break;
                }
                case 11: {
                    newArrayList.printArrayList();
                    break;
                }
                case 12: {
                    return;
                }
                default: {
                    System.out.println("Try again");
                }
            }
        }

    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}