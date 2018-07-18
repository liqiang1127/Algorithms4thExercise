package Chapter1_4High;

import static java.lang.Math.min;

public class LocalMinInMatrix {
    //1.4.19 返回局部最小元素的索引
    //解法错误！！！
    /**
     * 算法概述：
     * 算法过程类似于 “滑雪”，从数值较高的一侧向周围数值较小的一侧移动，直到到达“山谷”（局部最小）。
     *
     * 首先在中间行搜索最小值，再将最小值与其上下两个元素比较，如果不满足题意，则“滑向”较小的一侧，矩阵被分为了两半（上下两侧）。
     *
     * 在较小的一侧，找到中间列的最小值，再将最小值与其左右两个元素比较，如果不满足题意，类似的移动到较小的一侧（左右两侧）。
     *
     * 现在查找范围缩小到了原来矩阵的四分之一，递归的进行上述操作，最后可以得到答案。
     *
     * 每次查找最小值都是对行/列进行遍历，遍历耗时和 N 成正比。
     *
     * @param matrix
     * @return
     */

    private static int[] searchRow(int[][] matrix, int startRow,int startCol,int rowNum, int colNum){
        int[] ret = new int[2];
        //在给定的矩阵中的中间行寻找最小元素
        int mid = startRow + rowNum / 2;
        int min = matrix[mid][startCol];
        int index = -1;

        //行的长度小于3
        if(rowNum < 3){
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }

        //找到最小值
        for (int i = startCol; i < startCol + colNum; i ++){
            if(matrix[mid][i] < min ){
                min = matrix[mid][i];
                index=  i;
            }
        }

        if(matrix[mid][index] < matrix[mid-1][index] && matrix[mid][index] < matrix[mid+1][index]){
            ret[0] = mid;
            ret[1] = index;
            return ret;
        }

        //滑向较小的一侧
        if(matrix[mid+1][index] > matrix[mid-1][index])
            return searchCol(matrix, startRow, startCol, rowNum/2, colNum);
        else
            return searchCol(matrix, mid+1, startCol, min(rowNum/2, matrix.length - mid - 1), colNum );
    }

    private static int[] searchCol(int[][] matrix, int startRow,int startCol,int rowNum, int colNum){
        int[] ret = new int[2];
        //寻找中间列的最小是
        int mid = startCol + colNum / 2;
        int min = matrix[startRow][mid];
        int index = -1;

        if(colNum < 3){
            ret[0] = -1;
            ret[1] = -1;
            return ret;
        }
        //找最小值
        for (int i = startRow; i < startRow + rowNum; i++){
            if(matrix[i][mid] < min ){
                min = matrix[i][mid];
                index=  i;
            }
        }

        if(matrix[index][mid] < matrix[index][mid-1] && matrix[index][mid] < matrix[index][mid+1]){
            ret[0] = index;
            ret[1] = mid;
            return ret;
        }


        if(matrix[index][mid+1] > matrix[index][mid-1]){
            return searchRow(matrix,startRow,startCol, rowNum, colNum/2);
        }else{
            return searchRow(matrix,startRow,mid+1,rowNum,min(colNum/2,matrix[0].length - mid - 1));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 26, 3, 10 , 10, 11 },
                { 5, 1, 6, 12, 13 },
                { 10, 8, 9 , 14, 15 },
                { 16, 17, 18, 27, 20 },
                { 21, 22, 23, 24, 25 }
        };

        int[] ans = searchRow(matrix,0,0,5,5);
        System.out.println("("+ans[0]+","+ans[1]+")");
    }

}
