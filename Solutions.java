import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;


 // Definition of TreeNode that is uses in the BST closest value method
 public class Node {
      public int data;
     public Node left, right;
      public TreeNode(int val) {
          this.data = val;
          this.left = this.right = null;
      }
  }
//Class that contains solutions to many interesting coding problems.
public class Solutions{


  /*
  / An efficent solution to the two-sum problem that makes use of sorting.
  / This method needs to return true if there are two numbers in the array that
  / add up to k. The efficent solution below uses a hash set and only
  / goes through the array once. This makes this solution be faster than
  / O(n^2).
  /
  /
  */
  private boolean sumsToTarget(int[] arr, int k) {
    HashSet<Integer> values = new HashSet<Integer>();
    for (int i = 0; i < arr.length; i++) {
        if (values.contains(k – arr[i])) {
          return true;
        }

        values.add(arr[i]);
    }
    return false;
  }
  /*
  / An efficent solution to the threesum problem that makes use of sorting.
  / This method is supposed to find three numbers in the nums array whose
  / sum is equal to 0. It returns a list of integer arrays that have three
  / numbers that add up to 0. Each integer array must be unique.
  / This solution uses three pointers. It stops looking for triplets if the value
  //at the smallest index is negative. That is why this solution has time
  /complexity that is better than O(n^2)
  /
  /
  */
  public List<List<Integer>> threeSum(List<List<Integer>> tripletsList) {
      List<List<Integer>> jok1;

      Arrays.sort(nums);
      jok1= new java.util.ArrayList<>();
      for(int i=0; i< nums.length-2; i++){
          int a = nums[i];
          if(a>0){

              return jok1;
          }
          int ib = i+1;
          int ic = nums.length-1;
          while(ib < ic){
              int b= nums[ib];
              int c= nums[ic];
              int sum = (a+b+c);
              if((a+b+c)==0 ){
                  List<Integer> triplet = new ArrayList<Integer>();
                  triplet.add(new Integer(a));
                  triplet.add(new Integer(b));
                  triplet.add(new Integer(c));
                  if(!jok1.contains(triplet)){
                      tripletsList.add(triplet);
                  }
              }
              if(sum>=0){
                        while(ic>0&&nums[ic-1]==c){
                            ic--;
                        }
                        ic--;

                    }
              if (sum<=0){
                        while(ib<(nums.length-1)&&nums[ib+1]==b){
                            ib++;
                        }
                        ib++;
                    }
          }
      }
      return jok1;
  }
  /*
  / Given two strings, this method finds out if the first string is a
  / subsequence of the second string. A subsequence is a sequence that can be
  / derived from another sequence by deleting some elements without
  / changing the order of the remaining elements
  /
  */
  public boolean isSubsequence(String s, String t) {
        int subindex = -1000;

        for(int i =0;i<s.length(); i++)
        {
            if(subindex != -1000){
                if(t.indexOf(s.charAt(i),subindex+1)!= (-1)){
                    subindex = t.indexOf(s.charAt(i),subindex+1);

                }
                else{
                    return false;
                }

            }
            else{
                if(t.indexOf(s.charAt(i))!= (-1)){
                    subindex = t.indexOf(s.charAt(i),subindex+1);

                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
    // Return the minimum absolute difference between any tree node and the integer K
    //This solution uses recursion and is efficent because it does not check
    //every value in the binary search tree.
      static int maxDiff(Node  root, int K)
      {
          if(root==null){
              return K;
          }
          int dif = root.data;
          int ldif=Math.abs(root.data-K);
          int rdif=Math.abs(root.data-K);

              if(root.data>=K){
                  if(root.left!=null){
                      //System.out.println("A "+root.data);
                    rdif=  maxDiff(root.left,K);
                  }
                  else{
                      //System.out.println("C "+root.data);
                      return Math.abs(root.data-K);

                  }
              }
              else{
                  if(root.right!=null){
                      //System.out.println("B "+root.data);
                      ldif= maxDiff(root.right,K);
                  }
                  else{
                      //System.out.println("D " +root.data);
                      return Math.abs(root.data-K);
                  }

              }


          if(rdif<ldif){
              //System.out.println("E "+ rdif);
              return Math.abs(rdif);
          }
          else{
              //System.out.println("F "+ldif);
              return Math.abs(ldif);
          }



      }
    /*
    // You are given a two-dimensional array of potentially unequal height and width.
    //It contains only 0s and 1s. This array represents a map: 0s are land, and 1s are water.
    // A "island" on this map consists of any number of contiguous, adjacent water squares, where
    //"adjacent" means "above", "below", "to the left of", or "to the right of" (that is,
    // diagonal squares are not adjacent). Write a function which returns an array of
    //the sizes of all islands represented in the input matrix. Note that
    //these sizes do not need to be in any particular order.
    //For example:
    //int [][] input = {
    //{1, 0, 0, 1, 0},
    //{1, 0, 1, 0, 0},
    //{0, 0, 1, 0, 1},
    //{1, 0, 1, 0, 1},
    //{1, 0, 1, 1, 0}};
    /  island(input); // returns [1, 2, 2, 2, 5]
    /This solution only goes through the given 2-d array once. It uses recursion
    /to determine how many islands are connected to the neighbors of a island.
    /It also uses a hash set to prevent the same island from being counted
    /twice. The use of recursion, hashing and the set data structure makes
    /this solution very efficent.
    */
    public int numIslands(char[][] grid) {
        int retlist=0;
        ArrayList<Integer> rivloc = new ArrayList<Integer>();
        HashSet<Integer> allriv = new HashSet<Integer>();
        int mapsize = grid.length;

        int arrlength;
        if(mapsize>0){
            arrlength= grid[0].length;
        }
        else{
            return 0;
        }
        int loc=0;

        for(int i=0; i<mapsize;i++){

            for(int j=0; j<arrlength;j++){
                if(((grid[i][j])=='1')&&(!allriv.contains(new Integer(loc)))){

                    HashSet<Integer> sizes0= new HashSet<Integer>();

                    if(i!=(mapsize-1)&&(grid[i+1][j])=='1'){
                        System.out.println(loc+arrlength);
                        allriv.add(new Integer(loc+arrlength));
                        sizes0.addAll(findRivers(loc+arrlength,grid,allriv));

                    }
                    if(j!=(arrlength-1)&&(grid[i][j+1])=='1'){
                         System.out.println(loc+1);
                        allriv.add(new Integer(loc+1));
                        sizes0.addAll(findRivers(loc+1,grid,allriv));

                    }

                    if(j!=(0)&&(grid[i][j-1])=='1'){
                         System.out.println(loc-1);
                        allriv.add(new Integer(loc-1));
                        sizes0.addAll(findRivers(loc-1,grid,allriv));

                    }
                    if(i!=(0)&&(grid[i-1][j])=='1'){
                         System.out.println(loc-arrlength);
                        allriv.add(new Integer(loc-arrlength));
                        sizes0.addAll(findRivers(loc-arrlength,grid,allriv));

                    }
                    HashSet<Integer> comb = new HashSet<Integer>();
                    comb.addAll(sizes0);
                    comb.add(new Integer(loc));
                    int count=comb.size();

                    allriv.addAll(comb);
                    if(count>0){
                        retlist++;



            }

        }
        loc++;

        }





    }
        return retlist;
}

    /*  Function to check if two strings are anagram
   *   a, b: input string
   */
private static int CHARACTER_RANGE= 256;

 public boolean isAnagram(String string1, String string2) {
     if (string1.length() != string2.length()) {
         return false;
     }
     int count[] = new int[CHARACTER_RANGE];
     for (int i = 0; i < string1.length(); i++) {
         count[string1.charAt(i)]++;
         count[string2.charAt(i)]--;
     }
     for (int i = 0; i < CHARACTER_RANGE; i++) {
         if (count[i] != 0) {
             return false;
         }
     }
     return true;
 }
   //Given an ascending sorted rotated array Arr of distinct integers of size N.
   // The array is right rotated K times. Find the value of K.
   //Input:
   //N = 5
  //Arr[] = {5, 1, 2, 3, 4}
  //Output: 1
  //Explanation: The given array is 5 1 2 3 4.
  //The original sorted array is 1 2 3 4 5.
  //We can see that the array was rotated
  //1 times to the right.
   int findKRotation(int arr[], int n) {
        //System.out.println(Arrays.toString(arr));
        for(int i=0; i<(n-1);i++){
            if(arr[i]>arr[i+1]){
                return i+1;
            }
        }
        return 0;
        // code here
    }

//Given two array of integers(the first array is array A, the second array is array B),
//now we are going to find a element in array A which is A[i], and another element in array
//B which is B[j], so that the difference between A[i] and B[j] (|A[i] - B[j]|) is as small
// as possible, return their smallest difference.
    static int findSmallestDifference(int A[], int B[],
                                      int m, int n)
    {
        // Sort both arrays
        // using sort function
        Arrays.sort(A);
        Arrays.sort(B);

        int a = 0, b = 0;

        // Initialize result as max value
        int result = Integer.MAX_VALUE;

        // Scan Both Arrays upto
        // sizeof of the Arrays
        while (a < m && b < n)
        {
            if (Math.abs(A[a] - B[b]) < result)
                result = Math.abs(A[a] - B[b]);

            // Move Smaller Value
            if (A[a] < B[b])
                a++;

            else
                b++;
        }

        // return final sma result
        return result;
  }
//An array is monotonic if it is either monotone increasing or monotone decreasing.
//An array A is monotone increasing if for all i <= j, A[i] <= A[j].
// An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
//Return true if and only if the given array A is monotonic.
//The solution below is efficent because it only passes through the array one
// time.
  public boolean isMonotonic(int[] A) {
        if(A.length<=1){
            return true;
        }
        int incr =1;
        int decr =1;
        if(A[0]<=A[1]||(A[0]>=A[1])){
            for(int ii = 0;ii<(A.length-1);ii++){
                if(incr==1){
                    if(A[ii]>=A[ii+1]){

                    }
                    else{
                        incr=0;
                    }

                }
                if(decr==1){
                    if(A[ii]<=A[ii+1]){

                    }
                    else{
                        decr=0;
                    }

                }

            }
        }
        return(incr==1||(decr==1));

    }
    //Recursive function that finds all the islands that are conencted to the
    //island located at index rivloci.
    private HashSet<Integer> findRivers(int rivloci,char [][] map2,HashSet<Integer> ha){
        HashSet<Integer> sizes = new HashSet<Integer>();
        int len= map2[0].length;
        int mapsize= map2.length;
        int cjj = ((rivloci+1)%len);

        //Not in last column

        if((rivloci%len)!=(len-1)){
                int ii = ((rivloci+1)/len);
                int jj = ((rivloci+1)%len);

                if((map2[ii][jj]=='1')&&!ha.contains(rivloci+1)){
                    System.out.println(rivloci+1);
                    ha.add(new Integer(rivloci+1));
                   sizes.addAll(findRivers(rivloci+1,map2,ha));

                }

        }
            //Not in last row
             if(rivloci/len!=(mapsize-1)){
                int ii = ((rivloci+len)/len);
                int jj = ((rivloci+len)%len);

                if((map2[ii][jj]=='1')&&!ha.contains(rivloci+len)){
                    System.out.println(rivloci+1);
                     ha.add(new Integer(rivloci+len));
                   sizes.addAll(findRivers(rivloci+len,map2,ha));

                }

            }
            if(rivloci/len!=(0)){
                int ii = ((rivloci-len)/len);
                int jj = ((rivloci-len)%len);

                if((map2[ii][jj]=='1')&&!ha.contains(rivloci-len)){
                    System.out.println(rivloci+1);
                     ha.add(new Integer(rivloci-len));
                   sizes.addAll(findRivers(rivloci-len,map2,ha));

                }

            }
            if(rivloci%len!=(0)){
                int ii = ((rivloci-1)/len);
                int jj = ((rivloci-1)%len);

                if((map2[ii][jj]=='1')&&!ha.contains(rivloci-1)){
                    System.out.println(rivloci+1);
                     ha.add(new Integer(rivloci-1));
                   sizes.addAll(findRivers(rivloci-1,map2,ha));

                }

            }

                    sizes.add(new Integer(rivloci));
                    return sizes;

    }
}
