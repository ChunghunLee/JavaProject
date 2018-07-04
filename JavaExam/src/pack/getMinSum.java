package pack;
class TryHelloWorld
{
    public int getMinSum(int []A, int []B)
    {
        int answer = 0;
        int sum=0;
	    int temp=0;
      
      for(int i=0;i<A.length;i++){
    	  for(int j=i+1;j<A.length;j++){
        if(A[i]>A[j]){
          temp = A[i];
          A[i] = A[j];
          A[j]=temp;
        }
      }
      }
      for(int k=0;k<B.length;k++){
    	  for(int l=k+1;l<B.length;l++){
        if(B[k]>B[l]){
          temp = B[k];
          B[k] = B[l];
          B[l] = temp;
        }
      }
      }
      for(int k=0;k<A.length;k++)
       sum += A[k]*B[B.length-(k+1)];
      
      return sum;
    }
    public static void main(String[] args)
    {
        TryHelloWorld test = new TryHelloWorld();
        int []A = {1,2};
        int []B = {3,4};
        System.out.println(test.getMinSum(A,B));
    }
}