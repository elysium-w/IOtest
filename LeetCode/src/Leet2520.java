public class Leet2520 {
    /**
     * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
     *
     * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：num = 7
     * 输出：1
     * 解释：7 被自己整除，因此答案是 1 。
     * 示例 2：
     *
     * 输入：num = 121
     * 输出：2
     * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
     * 示例 3：
     *
     * 输入：num = 1248
     * 输出：4
     * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
     * @param args
     */
    public static void main(String[] args) {
        Leet2520 leet2520=new Leet2520();
        int res=0;
        res=leet2520.solution(7);
        System.out.println("num=7\n"+res+"\n");
        res=leet2520.solution(121);
        System.out.println("num=121\n"+res+"\n");
        res=leet2520.solution(1248);
        System.out.println("num=1248\n"+res+"\n");


    }
    public int solution(int num){
        int res=0;
        int temp=num;
        while(temp>0){
            int val=temp%10;
            if(val!=0&&num%val==0){
                res+=1;
            }
            temp/=10;
        }
        return res;
    }

}
