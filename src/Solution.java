//Given an unsorted array of nonnegative integers, find if a continuous subarray with a sum equal to a given number exists.

//*Example*:
//   *Input:*
//      a[] = {9, 2, 4, 1}. {2,9,4,1} 
//      sum = 6

//   *Output:* 
//      true

//The overall approach is important, while the concern is not the programming language, detailed syntax, or finding the optimal solution.

//The question is asking to implement a findSubArrayWithSum function like below:


public class Solution  
{ 
    /*
    * 1. Iterate through array
    * 2. if current element is less than sum
    * 3. if yes find number to find / desiredNumber
    * 4. check if desiredNumber = next element
    */
    
    
    // 9, 2, 4, 1
    //  9, 3, 5, 2, 2  
    //           ^
    // counter += 6
    public static boolean findSubArrayWithSum(int a[], int sum)  
    { 
        int counter = 0;
        for(int i=0; i<a.length; i++){
            if(a[i]<sum) {
                counter += a[i];
                if(counter >= sum){
                    if(counter==sum){
                         return true;
                    }
                    counter = a[i];
                    
                }
            }
                       
        }
        return false;
    } 
  
    public static void main(String[] args)  
    { 
        int a[] = {9, 2, 4, 1}; 
        boolean found = Solution.findSubArrayWithSum(a, 6); 
        System.out.println(found);
    } 
} 

//
