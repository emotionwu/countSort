public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;
        int carry=0;
        while(l1 !=null || l2!=null ){
            int x=(l1==null)?0:l1.val;
            int y=(l2==null)?0:l2.val;
            int sum=x+y+carry;
            carry=sum/10;   //判断是否进位
            sum=sum%10   ;  //取余
            cur.next=new ListNode(sum);  //从0开始
            cur=cur.next;
            if(l1 !=null) l1=l1.next;
            if(l2 !=null) l2=l2.next;
        }
        if(carry == 1){
            cur.next=new ListNode(1);
        }
        return dummyHead.next;
    }
}
