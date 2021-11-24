package Testing3;

public class Student extends People {
    private int age;
    //private Course course;
    private Course[] c = new Course[5];
    private int i;

    public Student(int id,String name,String sex,int age){
        super(name,id,sex);
        setAge(age);
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void add_course(int class_id, Course[] C){
        int q = 0;
        for (int a = 0; a < C.length; a++) {
            if (C[a] == null) {
                break;
            }
            else if (class_id == C[a].getId()) {
                for (int b=0; b<c.length; b++){
                    if(c[0] == null) {
                        c[i] = C[a];
                        i++;
                        System.out.println("您已成功选上该课程！");
                        break;
                    }
                    else if(c[0] != null){
                        if(class_id == c[b].getId()){
                            System.out.println("重复选择，请重新操作！");
                            break;
                        }
                        else if (c[b] == null){
                            break;
                        }

                        else{
                            c[i] = C[a];
                            i++;
                            System.out.println("您已成功选上该课程！");
                            break;
                        }
                    }
                }
                q = 1;
                break;
            }
            else {
                continue;
            }
        }
        if(q == 0){
            System.out.println("课程号输入错误，请重新操作！");
        }
    }

    public void adde_course(int class_id, Course[] C){
        for(int a=0;a<=C.length;a++) {
            if (C[a] == null) {
                break;
            } else {
                int id = C[a].getId();
                if (class_id == id) {
                    addcourse(C[a]);
                    break;
                } else {
                    continue;
                }
            }
        }
        System.out.println("您已成功选上该课程");
    }
    private void addcourse(Course cc){
        c[i] = cc;
        i++;
    }

    public void drop_course(int id){
        Course[] d = new Course[5];
        int j = 0;
        for(int i=0;i<this.i;i++) {
            int a = c[i].getId();
            //System.out.println(a);
            if (id == a) {
                continue;
            }
            else {
                d[j] = c[i];
                j++;
            }
        }
        c = d;
        System.out.println("您已成功退出该课程");
    }

    public void show(){
        System.out.println("学生课表");
        int k = 1;
        for(int i=0;i<=this.i;i++) {
            if (c[i] == null) {
                continue;
            }
            else {
                System.out.print("课程"+ k);
                System.out.print(" 课程编号："+c[i].getId());
                System.out.print(" 课程名称："+c[i].getTime());
                System.out.print(" 授课教师："+c[i].getTeacher());
                System.out.print(" 上课地点："+c[i].getPlace());
                System.out.print(" 课程人数："+c[i].getStu_num());
                System.out.println(" 上课时间：周"+c[i].getWeek() +" "+ c[i].getTime());
                k++;
            }
        }
    }

}
