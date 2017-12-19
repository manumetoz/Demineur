import java.util.Random;

public class Demineur {
		
		int[][] T = new int[4][4];
		boolean[][] P = new boolean[4][4];
		int reste=0;
		
		public void afficherTableau()
		{
			for (int l=0;l<T.length;l++)
	        {
				System.out.print("\n");
					for (int m=0;m<T[l].length;m++)
							System.out.print("\t"+P[l][m]);
	        }	
		}	
	
		public void palcerBombes(int n)
	    {	     
		Random r =new Random();
		while (n>0)
	      {
		  	int x = Math.abs(r.nextInt())%4 ;
			int y = Math.abs(r.nextInt())%4 ;

	        if(T[x][y] != -1)
	            {
	        	 	T[x][y] = -1;
	        	 	n--;
	            }
	       }
	    }
		
		public int gagnerDemineur()
		{
			for (int m=0;m<P.length;m++)
	        {
				for (int n=0;n<P[m].length;n++)
				{
					if (P[m][n]== false) reste++;
				}
	        }
			if (reste==4)	
				return 0;
					return -1;
		}
		
		public boolean verifierMine(int i, int j)
		{
			if (T[i][j]!=-1)
				{
					P[i][j]=true;
					assigneValueToCell(i, j);
					//System.out.println("\n il vous reste "+reste);
					return true;
				}
			else
				{
					if (gagnerDemineur()==0)
					{
						System.out.println("\n Vous avez gagné");
						return false;

					}
						else
					{
						for (int k=0;k<T.length;k++)
						{
							for (int l=0;l<T[k].length;l++)
							{
								if(T[k][l]!=-1 && P[k][l]!=true)
									P[k][l]=true;
							}
						}
						
						for (int m=0;m<T.length;m++)
			            {
							System.out.print("\n");
								for (int n=0;n<T[m].length;n++)
										System.out.print("\t"+P[m][n]);
			            }	
						System.out.println("\n Vous avez perdu. Dans la cellule ("+i+","+j+") se trouve une mine");
						return false;

					}
				}
		}
		
		public void assigneValueToCell(int i, int j)
		{
			if(i>0 && j>0 && j<T.length-1 && i<T.length-1)
				{
				   countLeft(i,j);countRight(i,j);countDown(i,j);
				   countUp(i,j);countUpLeft(j,j);countUpRight(i,j);
				   countDownLeft(i,j);countDownRigth(i,j);
				}
			else 
			{
				if (i==0 && j>0 && j<T.length-1)
				{
					countRight(i,j);countDown(i,j);
					countLeft(i,j);countDownLeft(i,j);
					countDownRigth(i,j);
				}
				else 
				{
					if (i>0 && j==0 && i<T.length-1)
					{
						countRight(i,j);countDown(i,j);countUpRight(i,j);
						countUp(i,j);countDownRigth(i,j);
					}
					else 
					{
						if (j>0 && i==T.length-1 && j<T.length-1)
						{
							countLeft(i,j);countRight(i,j);
							countUp(i,j);countUpLeft(j,j);
							countUpRight(i,j);
						}
						else 
						{	
							if (i>0 && j==T.length-1 && i<T.length-1)
							{
								countLeft(i,j);countDown(i,j);
								countUp(i,j);countUpLeft(j,j);countDownLeft(i,j);
							}							
						}
					}
				}
			}

			if (i==0 && j==0)
			{
				countRight(i,j);countDown(i,j);
				countDownRigth(i,j);
			}
			if (i==T.length-1 && j==T.length-1)
			{
				countUp(i,j);countLeft(i,j);
				countUpLeft(i,j);
			}
			if (i==0 && j==T.length-1)
			{
				countLeft(i,j);countDown(i,j);
				countDownLeft(i,j);
			}
			if (i==T.length-1 && j==0)
			{
				countRight(i,j);countUp(i,j);
				countUpRight(i,j);
			}	

			
//		   for (int l=0;l<T.length;l++)
//	        {
//				System.out.print("\n");
//					for (int m=0;m<T[l].length;m++)
//							System.out.print("\t"+P[l][m]);
//	        }	
		}
		
		public void countLeft(int i,int j)
		{
			if(T[i][j-1] != -1)
				P[i][j-1]=true;
		}
		public void countRight(int i,int j)
		{
			if(T[i][j+1] != -1) 
				P[i][j+1]=true;
		}
		public void countUp(int i,int j)
		{
			if(T[i-1][j] != -1)
				P[i-1][j]=true;
		}
		public void countDown(int i,int j)
		{
	  		if(T[i+1][j] != -1) 
	  			P[i+1][j]=true;
		}
		public void countUpLeft(int i,int j)
		{
			if(T[i-1][j-1] != -1) 
				P[i-1][j-1]=true;
		}
		public void countUpRight(int i,int j)
		{
			if(T[i-1][j+1] != -1) 
				P[i-1][j+1]=true;
		}
		public void countDownRigth(int i,int j)
		{
			if(T[i+1][j+1] != -1) 
				P[i+1][j+1]=true;
		}
		public void countDownLeft(int i,int j)
		{
			if(T[i+1][j-1] != -1)
				P[i+1][j-1]=true;
		}

}
