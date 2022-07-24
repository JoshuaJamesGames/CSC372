import java.util.ArrayList;
import java.util.Comparator;

//This would be simpler if the requirements were not an ArrayList of Students
//Need to convert to an Array and back to an ArrayList
public class MergeSort {
    public static ArrayList<Student> sort(ArrayList<Student> studentList, Comparator<Student> comparator){
        
        Student studentArray[] = studentList.toArray(new Student[studentList.size()]);
        
        mergeSort(studentArray, studentList.size(), comparator);

        return convertToArrayList(studentArray);//Converting to ArrayList from Student[]

    }

    //Classic array Merge - called by mergeSort
    public static void merge(Student[] leftArray,Student[] rightArray, Student[] studentArray,int leftArraySize, int rightArraySize, Comparator<Student> comparator){
      
        int i = 0;
        int left = 0;
        int right = 0;
        
        //The while loops check the conditions for merging
        while(left<leftArraySize && right<rightArraySize){
            
            if(comparator.compare(leftArray[left],rightArray[right]) < 0){
                studentArray[i++] = leftArray[left++];
            }
            else{
                studentArray[i++] = rightArray[right++];
            }
        }
        while(left<leftArraySize){
            studentArray[i++] = leftArray[left++];
        }
        while(right<rightArraySize){
          studentArray[i++] = rightArray[right++];
        }
    }
    
    //Classic mergSort with added Comparator
    public static void mergeSort(Student[] studentArray, int arrayLength, Comparator<Student> comparator){
        if (arrayLength < 2){return;}
        
        int middle = arrayLength / 2;
        Student [] leftArray = new Student[middle];
        Student [] rightArray = new Student[arrayLength-middle];
        
      //Dividing array into two and copying into two separate arrays
        int j = 0;
        for(int i = 0;i<arrayLength;++i){
            if(i<middle){
                leftArray[i] = studentArray[i];
            }
            else{
                rightArray[j] = studentArray[i];
                j = j+1;
            }
        }
      //Recursive call to mergeSort to divide the subarrays further
        mergeSort(leftArray, middle, comparator);
        mergeSort(rightArray, arrayLength-middle, comparator);

      //Call merge method on each subdivision to sort and assemble
        merge(leftArray, rightArray, studentArray, middle, arrayLength-middle, comparator);
    }

    public static ArrayList<Student> convertToArrayList(Student[] studentArray){
        ArrayList<Student> studentList = new ArrayList<Student>();
        
        for(int i = 0; i < studentArray.length; i++){
            studentList.add(studentArray[i]);
        }
                
        return studentList;
    }

    //Comparator interface for sorting by roll number
    static class Sortbyroll implements Comparator<Student> {
 
        //Sort in ascending order of roll number
        public int compare(Student a, Student b){
 
            return a.rollno - b.rollno;
        }
    }
 
    
    //Comparator interface for sorting by name
    static class Sortbyname implements Comparator<Student>{
    
        //Sort in ascending order of name
        public int compare(Student a, Student b){
    
            return a.name.compareTo(b.name);
        }
    }

    
}
