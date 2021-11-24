#计201  2020310567
## 一、实验目的
1. 初步了解分析系统需求，从学生选课角度了解系统中的实体及其关系，学会定义类中的属性以及方法。
2. 掌握面对对象的类设计方法（属性、方法）。
3. 掌握通过构造方法实例化对象。
4. 学会使用数组。

## 二、业务要求
1. 学校人员分为“教师”和“学生”，教师教授“课程”，学生选择“课程”。每名教师可讲授多门课程，每名学生可选修多门课程。
2. 多门课程，可用课程数组形式表达。
3. 对象示例：教师（编号、姓名、性别、所授课程)
<br>&emsp;&emsp;&emsp;&emsp;&emsp;学生(编号、姓名、性别、所选课程)
<br>&emsp;&emsp;&emsp;&emsp;&emsp;课程(编号、课程名称、上课地点、时间)

## 三、实验要求
1. 编写上述实体类以及测试主类
2. 在测试主类中，实例化多个类实体，模拟
   <br>1)教师开设某课操作；
   <br>2)学生选课操作、退课操作
   <br>3)打印学生课表信息(包括：编号、课程名称、上课地点、时间、授课教师等
3. 编写实验报告。

## 四、实验过程
1. 编写上述三个实体类Teacher、Student、Course以及测试类Testing，把这些类放在Testing包里。 
<br>在Teacher类里设置了老师的工号id，姓名name，性别sex，Course类用来将课程加到老师的课表里，Course[]用来储存老师的课程。 
<br>在Student类里设置了学生学号id，姓名name，性别sex，年龄。 
<br>在Course类里设置了课程号id，课程名name，上课地点place，上课时间week和time，授课教师teacher，上课学生数量stu_num。并设置构造函数初始化对象参数。<br>在Simulate类里设置主函数，创建一个课程数组并实例化存入数组中。
2. 在界面有老师身份和学生身份可以选择。如果是教师登录，通过输入的老师的信息，初始化一个Teacher对象，对比课程数组中每一个课程的老师的姓名，相同则写入到该老师的课程数组里。
<br>输出该老师的课程表的话则是在Teacher类中里设置了show函数，在主函数中调用，输出储存在教师数组中的课程信息。
3. 如果是学生登录，同样通过输入的学生的信息，初始化一个Student对象，然后输出所有的课程信息让学生来选课。
在选课时通过获取学生输入的课程号，找到课程数组对应的课程号，则将该课程加入到学生个人的课程数组中。
<br>选课成功后可以有后续操作，是否进行继续选课，退课，显示课表或退出等操作。 
在选课期间若有重复选课或者课程号输入错误，同样也会提示重新操作
4. 在进行退课操作时，则是调用Student类中的drop_course函数。 采用的是用一个新的数组来存放不需要退掉的课程，需要退的课程仍放在原数组中，然后用新数组代替原数组来实现退课功能。
<br>显示课表功能通过调用Student类中的show()函数来实现。
<br>不需要继续操作时选择退出，结束程序。

## 五、主要代码
1.类名[] 数组名 = new 类名 的格式，创建课程数组，并初始化课程变量存入数组。
```java
         Course[] C = new Course[20];
        Course c1 = new Course(10101,"听力","教404","20:00-21:30",4,40,"J");
        C[0] = c1;
        Course c2 = new Course(10102,"口语","教404","20:00-21:30",3,40,"J");
        C[1] = c2;
        Course c3 = new Course(10103,"阅读","教404","20:00-21:30",2,40,"J");
        C[2] = c3;
        Course c4 = new Course(10104,"写作","教404","20:00-21:30",1,40,"J");
        C[3] = c4;
```
2. 通过Scanner in获取输入。
```java
        Scanner in = new Scanner(System.in);
        System.out.println("请选择身份：，教师请输入1，学生请输入2"); //判断身份
        int iddd = in.nextInt();
```
3.通过遍历循环，对比课程数组中每一个课程的授课老师和教师的姓名，将两个变量的值相同的项，写入该教师的课程数组里。
```java
        //循环课程数组，将某教师的课程添加到教师个人课表数组里
            for (int j = 0; j <= C.length; j++) {
                if (C[j] == null) {
                    break;
                }
                else {
                    if (tea.name.equals(C[j].teacher)) {
                        tea.add_course(C[j]);
                    }
                    else {
                        continue;
                    }
                }
            }
            tea.show();
        }
```
4.Teacher类中show函数，显示程数组项的课程信息。
```java
    //老师课表
void show(){
        System.out.println(this.name+"的课表");
        int k = 1;
        for(int i=0;i<=this.i;i++) {
            if (c[i] == null) {
                continue;
            }
            else {
                System.out.print("课程"+ k);
                System.out.print(" 课程编号："+c[i].id);
                System.out.print(" 上课时间："+c[i].name);
                System.out.print(" 上课地点："+c[i].place);
                System.out.print(" 课程人数："+c[i].stu_num);
                System.out.println(" 上课时间：周"+c[i].week +" "+ c[i].time);
                k++;
            }
```
5. Student类中选课函数，将已选课程加入学生的个人课程数组。
```java
    //学生选课函数
void add_course(int class_id,Course[] C){
        for(int a=0;a<=C.length;a++) {
            if (C[a] == null) {
                break;
            } else {
                if (class_id == C[a].id) {
                    addcourse(C[a]);
                    break;
                } else {
                    continue;
                }
```
6. 退课操作，Student类中的tuike函数。用一个新的数组来存放不需要退掉的课程，需要退的课程仍放在原数组中，然后用新数组代替原数组来实现退课功能。
```java
    //退课函数
    void drop_course(int id){
        Course[] d = new Course[5];
        int j = 0;
        for(int i=0;i<=this.i;i++) {
            if (c[i] == null) {
                continue;
            }
            else {
                System.out.println(c[i].id);
                if (id == c[i].id) {
                    continue;
                }
                else {
                    d[j] = c[i];
                    j++;
                }
                c = d;
            }
        }

    }
```
## 六、运行截图
 **教师界面**
<br> **学生界面**


## 八、实验感想
做完这次实验我发现其实不管java东西有多少，总有规律可循。 对于学习java基础的经验就是多做、多思考，
基础知识的学习不能不求甚解，要追本溯源，弄清问题的本质。这样才能举一反三，由点及面。
java的所有编程思路都是“面向对象”的编程。所以大家在往更高境界发展以前一定要打好基础，基础是王道。
我们的基础要扎实。所谓打好基础并不是说要熟悉所有的java代码。要了解java的结构，让自己在结构上对java有个立体而且整体的了解。
