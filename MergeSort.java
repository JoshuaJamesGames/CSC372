import java.util.ArrayList;
import java.util.Comparator;

//This would be simpler if the requirements were not an ArrayList of Students
//Need to convert to an Array and back to an ArrayList
public class MergeSort {
    public static ArrayList<T> sort(ArrayList<T> arrayList, Comparator<T> comparator){
        
        T sortArray[] = arrayList.toArray(new T[arrayList.size()]);
        
        mergeSort(sortArray, arrayList.size(), comparator);

        return convertToArrayList(sortArray);//Converting to ArrayList from Student[]

    }

    //Classic array Merge - called by mergeSort
    public static void merge(T[] leftArray,T[] rightArray, T[] sortArray,int leftArraySize, int rightArraySize, Comparator<T> comparator){
      
        int i = 0;
        int left = 0;
        int right = 0;
        
        //The while loops check the conditions for merging
        while(left<leftArraySize && right<rightArraySize){
            
            if(comparator.compare(leftArray[left],rightArray[right]) < 0){
                sortArray[i++] = leftArray[left++];
            }
            else{
                sortArray[i++] = rightArray[right++];
            }
        }
        while(left<leftArraySize){
            sortArray[i++] = leftArray[left++];
        }
        while(right<rightArraySize){
          sortArray[i++] = rightArray[right++];
        }
    }
    
    //Classic mergSort with added Comparator
    public static void mergeSort(T[] sortArray, int arrayLength, Comparator<T> comparator){
        if (arrayLength < 2){return;}
        
        int middle = arrayLength / 2;
        T [] leftArray = new T[middle];
        T [] rightArray = new T[arrayLength-middle];
        
      //Dividing array into two and copying into two separate arrays
        int j = 0;
        for(int i = 0;i<arrayLength;++i){
            if(i<middle){
                leftArray[i] = sortArray[i];
            }
            else{
                rightArray[j] = sortArray[i];
                j = j+1;
            }
        }
      //Recursive call to mergeSort to divide the subarrays further
        mergeSort(leftArray, middle, comparator);
        mergeSort(rightArray, arrayLength-middle, comparator);

      //Call merge method on each subdivision to sort and assemble
        merge(leftArray, rightArray, sortArray, middle, arrayLength-middle, comparator);
    }

    public static ArrayList<T> convertToArrayList(T[] array){
        ArrayList<T> arrayList = new ArrayList<T>();
        
        for(int i = 0; i < array.length; i++){
            arrayList.add(array[i]);
        }
                
        return arrayList;
    }

    //Comparator interface for sorting by roll number
    static class Sortbyroll implements Comparator<T> {
 
        //Sort in ascending order of roll number
        public int compare(T a, T b){
 
            return a.rollno - b.rollno;
        }
    }
 
    
    //Comparator interface for sorting by name
    static class Sortbyname implements Comparator<T>{
    
        //Sort in ascending order of name
        public int compare(T a, T b){
    
            return a.name.compareTo(b.name);
        }
    }

    
}
