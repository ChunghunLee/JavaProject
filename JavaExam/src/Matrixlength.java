

public class Matrixlength {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int twob[][]=new int[4][];
		  twob[0]= new int[1];
		  twob[1]= new int[2];
		  twob[2]= new int[3];
		  twob[3]= new int[4];
		  
		  int leng = twob.length;
		  int i=0,j,k,n=0;
		  System.out.println("2차원 배열의 행의 길이는: "+leng);
		  
		  for(j=0;j<twob.length;j++){
		   for(k=0;k<twob[j].length;k++)
		   {
		    twob[j][k]=n;
		    n++;
		   }
		  }
		  
		  for(j=1;j<=twob.length;j++){
	
		   System.out.println(j+"번째 행의 요소 수는: "+twob[i].length);
		  }
		  
		  // 배열 초기화
		  
		  //배열 출력
		  
		  for(i=0;i<leng;i++){
		   for(int val : twob[i])
		    System.out.print(val+" ");
		   System.out.println();
		  }
		 }
		 
}
