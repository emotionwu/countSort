//颜色分类问题
public class solution75 {

    public void sortColors(int[] nums){

        //处理元素取值范围是[0,R)的计数排序,将其一般化
        int R=3;
        int[] cnt=new int[R];
        for(int num: nums)
            cnt[num]++;

        //分别排序归类
        //index[i],index[i+1]的值为i
        int[]index =new int[R+1];
        for(int i=0;i<R;R++)
            index[i+1] =index[i]+cnt[i];

        for(int i =0;i+1<index.length;i++)
            for(int j=index[i];j<index[i+1];j++)
                nums[j]=i;

    }
/*      //特殊化，只能处理三种颜色
        //一个数组放三个元素？
        int[] cnt=new int[3];
        //遍历数组，统计有多少0，1，2
        for(int num: nums)
            cnt[num]++;

        //分别排序归类
        for(int i= 0;i<cnt[0]; i++)
            nums[i]=0;

        for(int i =cnt[0]; i<cnt[0]+cnt[1];i++)
            nums[i]=1;

        for(int i =cnt[0]+cnt[1];i<cnt[0]+cnt[1]+cnt[2];i++)
            nums[i]=2;
    }

 */
}
