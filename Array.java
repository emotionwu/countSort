
//import org.omg.CORBA.Object;
//E为类型名
public class Array<E> {
    private  E[]data;
    private int size;
    //构造函数。传入数组的容量capacity构造Array
    public Array(int capacity){
        //不能直接new一个E类型的，只能先new object，然后强制转换
        data =(E[]) new Object[capacity];
        size=0;
    }
    //无参构造函数，默认数组的容量capacity=10
    public Array(){
        this(10);
    }
    //获得数组个数
    public int getSize(){
        return size;
    }
    //获得数组容量
    public int getCapacity(){
        return data.length;
    }
    //返回数组是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //像所有元素后添加一个新元素
    public void addLast(E e) {
        /*
        if (size == data.length)
            throw new IllegalArgumentException("Add failed.Array is full. ");
        data[size] = e;
        size++;
         */
        add(size,e);
    }
    //在所有元素前插入一个新元素e
    public void addFirst(E e){
        add(0,e);
    }
    //在第index个位置插入一个新元素e
    public void add(int index,E e){
        if(size==data.length)
            // throw new IllegalArgumentException("Add failed.Array is full. ");
            //增加容量
            resize(2 * data.length);
        if(index<0||index>size)
            throw new IllegalArgumentException("Add failed. Require index>=0 and index<=size");
        //data[size-1]为数组中最后一个元组，所以将data[i]往后挪动
        for(int i= size-1;i>=index;i--)
            data[i+1]=data[i];
        data[index]=e;
        size++;
    }
    //获取index索引位置的元素,用户只能通过get函数获取数组值
    public E get(int index){
        if(index<0||index>size)
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        return data[index];
    }
    //修改index索引位置的元素为e
    public void set(int index,E e){
        if(index<0||index>size)
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        data[index]=e;
    }
    //查找数组中是否有元素e
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if( data[i].equals(e))
                return true;
        }
        return false;
    }
    //查找元素e所在索引，如果不存在元素e，则返回-1
    public int find(E e){
        for(int i=0;i<size;i++){
            if( data[i].equals(e))
                return i;
        }
        return -1;
    }
    public E getLast(){
        return get(size-1);
    }
    public E getFirst(){
        return get(0);
    }
    //从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if(index<0||index>size)
            throw new IllegalArgumentException("Get failed.Index is illegal.");
        E ret=data[index];
        for(int i=index+1;i<size;i++)
            data[i-1]=data[i];
        size --;
        //利于回收，loitering objects!=memory leak
        data[size]=null;
        //当减少到容量的一半时，减少capacity为原来的一半
        if(size==data.length/4&&data.length/2!=0)
            resize(data.length/2);
        return ret;
    }
    //从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return  remove(0);
    }
    //从数组中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }
    //删除值为e的元素
    public void removeElement(E e){
        int index =find(e);
        if(index!=-1)
            remove(index);
    }
    @Override   //覆盖父类
    public String toString(){
        StringBuilder res =new StringBuilder();
        //append()函数用于在列表末尾添加元素
        res.append(String.format("Array:size=%d,capacity=%d \n",size,data.length));
        //添加输出的格式为[data1,data2...]
        res.append('[');
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }
    //扩容，动态变化
    private void resize(int newCapacity){
        E []newData= (E[])new Object[newCapacity];
        for(int i=0;i<size;i++)
            newData[i]=data[i];
        data =newData;
    }
}
