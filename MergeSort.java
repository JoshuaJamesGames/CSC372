import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {
    public static Student[] sort(ArrayList<Student> studentList, Comparator<Student> comparator){
        
        Student studentArray[] = studentList.toArray(new Student[studentList.size()]);
        mergeSort(studentArray, studentList.size(), comparator);

        return studentList.addAll(studentArray);//Converting to ArrayList from Student[]

    }

    public static void merge(Student[] left_arr,Student[] right_arr, Student[] arr,int left_size, int right_size, Comparator<Student> comparator){
      
        int i=0,l=0,r = 0;
        
        //The while loops check the conditions for merging
        while(l<left_size && r<right_size){
            
            if(comparator.compare(left_arr[l],right_arr[r]) > 0){
                arr[i++] = left_arr[l++];
            }
            else{
                arr[i++] = right_arr[r++];
            }
        }
        while(l<left_size){
            arr[i++] = left_arr[l++];
        }
        while(r<right_size){
          arr[i++] = right_arr[r++];
        }
    }
  
    public static void mergeSort(Student[] arr, int len, Comparator<Student> comparator){
        if (len < 2){return;}
        
        int mid = len / 2;
        Student [] left_arr = new Student[mid];
        Student [] right_arr = new Student[len-mid];
        
      //Dividing array into two and copying into two separate arrays
        int k = 0;
        for(int i = 0;i<len;++i){
            if(i<mid){
                left_arr[i] = arr[i];
            }
            else{
                right_arr[k] = arr[i];
                k = k+1;
            }
        }
      // Recursively calling the function to divide the subarrays further
        mergeSort(left_arr,mid, comparator);
        mergeSort(right_arr,len-mid, comparator);
      // Calling the merge method on each subdivision
        merge(left_arr,right_arr,arr,mid,len-mid, comparator);
    }

    // Helper class implementing Comparator interface
    class Sortbyroll implements Comparator<Student> {
 
        // Method
        // Sorting in ascending order of roll number
        public int compare(Student a, Student b){
 
            return a.rollno - b.rollno;
        }
    }
 
    
    // Helper class implementing Comparator interface
    class Sortbyname implements Comparator<Student>{
    
        // Method
        // Sorting in ascending order of name
        public int compare(Student a, Student b){
    
            return a.name.compareTo(b.name);
        }
    }
}
