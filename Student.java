import java.util.Arrays;
public class Student implements Comparable<Student>{
    private String name;
    private int score;
    public  Student(String name,int score)
    {
        this.name=name;
        this.score=score;
    }
    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }
    @Override
    public  int compareTo(Student another){
      /*  if(this.score<another.score)
            return -1;
        else if(this.score==another.score)
            return 0;
        return 1;
       */
        return this.score-another.score;
    }
    @Override
    //覆盖，如果在子类中定义和父类完全相同的方法或属性名称时，可以覆写。  当一个类中的方法被覆写后，如果实例化的是这个子类对象，则调用的方法是被覆盖后的方法。
    public boolean equals(Object student)
    //object是所有的父类
    {
        if(this==student)
            return true;
        if (student==null)
            return false;
        if(this.getClass()!=student.getClass())
            //getclass()能够得到调用该方法对象的类，然后得到类里面的相关属性和方法
            return false;
        Student another=(Student)student;
        //强制转换可能会出问题
        return this.name.toLowerCase().equals(another.name);
        //tolower把定义的name改为小写
    }
    //为了能够打印输出
    @Override
    public  String toString(){
        return String.format("Student(name:%s,score:%d)",name,score);
    }
    public static void main(String[] args){
        Array<Student> arr=new Array<>();
        arr.addLast(new Student( "Alice",100));
        arr.addLast(new Student( "Bob",66));
        arr.addLast(new Student( "Charlie",88));
        System.out.println(arr);
    }
}
