import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ArrayOperationDemo {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        while(testCaseCount > 0) {
            ArrayOperation arrayOperation = new ArrayOperation();
            arrayOperation.setArraySize(Integer.parseInt(scanner.nextLine()));
            arrayOperation.setArray(scanner.nextLine().split(" "));
            System.out.println(arrayOperation.getMaximumIndexDifference());
            --testCaseCount;
        }
    }
}

class ArrayOperation {
    private int arraySize;
    private List<Integer> array = new ArrayList<Integer>();
    
    public int getArraySize() {
        return arraySize;
    }
    
    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
    
    public List<Integer> getArray() {
        return array;
    }
    
    public void setArray(String[] array) {
        for(String element : array) {
            this.array.add(Integer.parseInt(element));
        }
    }
    
    //Returns maximum j-i where array[i] <= array[j]
    public int getMaximumIndexDifference() {
        int maxIndexDiff = 0;
        
        for(int i = 0; i < array.size() - 1; i++) {
            for(int j = i + 1; j < array.size(); j++) {
                if(array.get(i) <= array.get(j) && maxIndexDiff < j - i) {
                    maxIndexDiff = j - i;    
                }
            }
        }
        
        return maxIndexDiff;
    }
}
