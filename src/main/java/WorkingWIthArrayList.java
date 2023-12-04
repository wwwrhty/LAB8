import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkingWIthArrayList extends ArrayList<String>{
    private ArrayList<String> arrayList;

    public WorkingWIthArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public WorkingWIthArrayList(String filePath){
        this.arrayList = initializeListFromTextFile(filePath);
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public void addElement(String string){
        arrayList.add(string);
        System.out.println("Element is added");
    }

    public void deleteElement(int position){
        if (position>=0 && position<arrayList.size()){
            arrayList.remove(position);
            System.out.println("Element is deleted");
        }else System.out.println("Error");
    }

    public void deleteElement(String string){
        arrayList.remove(string);
    }

    public void saveArrayListToXML(String xmlFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(xmlFilePath))) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<arrayList>\n");
            for (String element : arrayList) {
                writer.write("    <element>" + element + "</element>\n");
            }
            writer.write("</arrayList>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reverseAllStrings() {
        for (int i = 0; i < arrayList.size(); i++) {
            String original = arrayList.get(i);
            String reversed = new StringBuilder(original).reverse().toString();
            arrayList.set(i, reversed);
        }
        System.out.println("Strings are reversed");
    }

    public Map<Character, Integer> getCharacterStatistics() {
        Map<Character, Integer> statistics = new HashMap<>();

        for (String str : arrayList) {
            for (char c : str.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    statistics.put(c, statistics.getOrDefault(c, 0) + 1);
                }
            }
        }

        return statistics;
    }

    public void findSubstring(String substring) {
        for (String str : arrayList) {
            if (str.contains(substring)) {
                System.out.println(str);
            }
        }
    }

    public ArrayList<String> initializeListFromTextFile(String filePath) {
        ArrayList<String> temp = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                temp.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public Map<Integer, List<String>> countAndSortStringLengths() {
        Map<Integer, List<String>> lengthToStringsMap = new HashMap<>();

        for (String str : arrayList) {
            int length = str.length();
            lengthToStringsMap
                    .computeIfAbsent(length, k -> new ArrayList<>())
                    .add(str);
        }

        List<Integer> sortedLengths = lengthToStringsMap.keySet().stream()
                .sorted()
                .collect(Collectors.toList());

        Map<Integer, List<String>> sortedMap = new HashMap<>();
        for (int length : sortedLengths) {
            sortedMap.put(length, lengthToStringsMap.get(length));
        }

        return sortedMap;
    }

    public void printArrayList() {
        for (String element : arrayList) {
            System.out.println(element);
        }
    }

    public boolean compareInnerObjects(int firstIndex, int secondIndex) {
        if (firstIndex >= 0 && firstIndex < arrayList.size() && secondIndex >= 0 && secondIndex < arrayList.size()) {
            return arrayList.get(firstIndex).equals(arrayList.get(secondIndex));
        } else {
            System.out.println("error");
            return false;
        }
    }
}
