class Solution {
    public void setZeroes(int[][] matrix) {
       int row=matrix.length;
       int col=matrix[0].length;
       int dummy[][]=new int[row][col];
       for(int i=0;i<row;i++)
       {
        for(int j=0;j<col;j++)
        {
            dummy[i][j]=0;
        }
       }
       for(int i=0;i<row;i++)
       {
        for(int j=0;j<col;j++)
        {
            if(matrix[i][j]==0 && dummy[i][j]!=1)
            {
                for(int k=j+1;k<col;k++)
                {
                   if(matrix[i][k]!=0)
                   {
                    matrix[i][k]=0;
                    dummy[i][k]=1;
                   }
                }
                for(int k=j-1;k>=0;k--)
                {
                   if(matrix[i][k]!=0)
                   {
                    matrix[i][k]=0;
                    dummy[i][k]=1;
                   }
                }
                for(int k=i+1;k<row;k++)
                {
                   if(matrix[k][j]!=0)
                   {
                    matrix[k][j]=0;
                    dummy[k][j]=1;
                   } 
                }
                for(int k=i-1;k>=0;k--)
                {
                    if(matrix[k][j]!=0)
                   {
                     matrix[k][j]=0;
                     dummy[k][j]=1;
                   }
                }
            }
        }
       } 
              for(int i=0;i<row;i++)
       {
        for(int j=0;j<col;j++)
        {
            System.out.print(dummy[i][j]+" ");
        }
        System.out.println();
       }

    }
}