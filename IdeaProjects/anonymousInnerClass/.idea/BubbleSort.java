/**
 * Created by ScorpionOrange on 2016/11/23.
 */
public class BubbleSort //类名：冒泡排序；
{
    //整形方法：接收整形数组为参数，返回整形数组；
    public static int[] intBubbleSort(int[] array)
    {
        //外层循环，对于每一项都与后面每一项比较并移动；
        for (int i=0;i<array.length-1;i++)
        {
            //内层循环，对于第一项与后面每一项一次比较并移动；
            for (int j=0;j<array.length-1-i;j++)
            {
                //如果j项比j+1项大，则向后移；
                if(array[j]>array[j+1])
                {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }

    //双精度方法：接收双精度数组为参数，返回双精度数组；
    public static double[] doubleBubbleSort(double[] array)
    {
        //外层循环，对于每一项都与后面每一项比较并移动；
        for (int i=0;i<array.length-1;i++)
        {
            //内层循环，对于第一项与后面每一项一次比较并移动；
            for (int j=0;j<array.length-1-i;j++)
            {
                //如果j项比j+1项大，则向后移；
                if(array[j]>array[j+1])
                {
                    double temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
        return array;
    }
}

