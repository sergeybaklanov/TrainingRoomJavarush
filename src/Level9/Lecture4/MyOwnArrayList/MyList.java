package Level9.Lecture4.MyOwnArrayList;

public class MyList {
    private Object[] list;

    private void chekSize() {
        if (list == null) {
            list = new Object[5];
            System.out.println("Mass was created");
            return;
        }
        if(list [0]==null)
        {
            return;
        }
        if (list[list.length-1] != null) {
            Object[] listTemp = new Object[list.length + 5];
            System.arraycopy(list, 0, listTemp, 0, list.length);
            list = listTemp;
            System.out.println("Mass length was added at 5 elements");
        }
    }


    public void set(int index, Object element) throws Exception {
        if (list == null) {
            throw new Exception();
        } else if (index > list.length || index < 0) {
            throw new IndexOutOfBoundsException("Out of bound exception");
        }
        list[index] = element;
        System.out.println("Element was added at "+index+" position");
    }

    public void add(Object e) {
        if(e!=null) {
            chekSize();

            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    list[i] = e;
                    System.out.println("Element was added");
                    return;
                }
            }
        } else
            System.out.println("Object is null!!!");
    }
    public void printListInfo(){
        for (var element: list) {
            System.out.print(" "+element);

        }
    }


}
