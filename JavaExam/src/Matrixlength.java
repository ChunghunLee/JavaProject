

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
		  System.out.println("2���� �迭�� ���� ���̴�: "+leng);
		  
		  for(j=0;j<twob.length;j++){
		   for(k=0;k<twob[j].length;k++)
		   {
		    twob[j][k]=n;
		    n++;
		   }
		  }
		  
		  for(j=1;j<=twob.length;j++){
	
		   System.out.println(j+"��° ���� ��� ����: "+twob[i].length);
		  }
		  
		  // �迭 �ʱ�ȭ
		  
		  //�迭 ���
		  
		  for(i=0;i<leng;i++){
		   for(int val : twob[i])
		    System.out.print(val+" ");
		   System.out.println();
		  }
		 }
		 
}