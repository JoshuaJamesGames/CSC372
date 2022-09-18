import java.util.ArrayList;
import java.util.Comparator;

//This would be simpler if the requirements were not an ArrayList of Students
//Need to convert to an Array and back to an ArrayList
public class MergeSort {
    public static ArrayList<Student> sort(ArrayList<Student> arrayList, Comparator<Student> comparator){
        
        Student sortArray[] = arrayList.toArray(new Student[arrayList.size()]);
        
        mergeSort(sortArray, arrayList.size(), comparator);

        return convertToArrayList(sortArray);//Converting to ArrayList from Student[]

    }

    //Classic array Merge - called by mergeSort
    public static <T> void merge(T[] leftArray,T[] rightArray, T[] sortArray,int leftArraySize, int rightArraySize, Comparator<T> comparator){
      
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
    
    //Classic mergeSort with Comparator
    public static <T> void mergeSort(T[] sortArray, int arrayLength, Comparator<T> comparator){
        if (arrayLength < 2){return;}
        
        int middle = arrayLength / 2;
        
        //Need to create Arraylist of type T to and set size
        //for Casting shenanigans
        ArrayList<T> leftArrayList = new ArrayList<T>();
        for(int i = 0; i< middle; i++){
            leftArrayList.add(null);
        }
        ArrayList<T> rightArrayList = new ArrayList<T>();
        for(int i = middle; i< arrayLength; i++){
            rightArrayList.add(null);
        }

        T[] leftArray =  (T[]) leftArrayList.toArray();
        T[] rightArray = (T[]) rightArrayList.toArray();
        
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

    public static ArrayList<Student> convertToArrayList(Student[] array){
        ArrayList<Student> arrayList = new ArrayList<Student>();
        
        for(int i = 0; i < array.length; i++){
            arrayList.add(array[i]);
        }
                
        return arrayList;
    }   

    
}
