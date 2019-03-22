import java.util.Scanner;
public class Test{
	
	public static void main(String[] args){
		
		welcome();
		select1();
		Admin[] admins =new Admin[5];
		admin(admins);
		login(admins);
		list(); 
		Student[] person =new Student[5];
		select2(person);

         
	
}
			public static void welcome(){
				System.out.println("--------------------欢迎登陆学生信息管理系统--------------------------"
			+"\r\n"+"1.登陆"+"    "+"2.退出"+"\r\n"
			+"----------------------------------------------------------------------");
			}
			public static void select1(){
				Scanner sc=new Scanner(System.in); 
          String str = "" ;
          System.out.print("请选择:");
          str=sc.next();
         if(str.equals("1")) {

			System.out.println("欢迎登陆!"+"\r\n");
               
          }
		  else if(str.equals("2")){
			  System.out.println("程序结束"); 
				System.exit(0);			
		  }else{
			  System.out.println("输入有误，请重新输入"); 
				select1();
		  }
			}
			public static void login(Admin[] admins){
		Scanner sc1=new Scanner(System.in); 
          String str1 = "" ;
          System.out.print("请输入用户名:");
          str1=sc1.next();
		Scanner sc2=new Scanner(System.in); 
          String str2 = "" ;
          System.out.print("请输入密码:");
          str2=sc2.next();  
		  for(int i = 0;i <5 ;i++){
			  if(admins[i] == null){
				  continue;
			  }
			  if(str1.equals(admins[i].username)&&str2.equals(admins[i].password)){
				  System.out.println("登陆成功"+"\r\n"+"欢迎您：admin");
				  break;
			  }else{
				  login(admins);
			  }
		  }
			}
			public static void list(){
				System.out.println("**********************请选择要操作的信息对应数字******************************"
			+"\r\n"+"1.查看学生信息"+"    "+"2.添加学生信息"+"    "+"3.删除学生信息"+"    "+"4.修改学生信息"+"    "+"5.退出"+"\r\n"
			+"******************************************************************************");
			}
			public static void admin(Admin[] admins){
							Admin x1 =new Admin("admin","admin");
							admins[0] = x1;
							

			}
			public static void select2(Student[] person){
		
		Scanner sc1=new Scanner(System.in); 
          String str1 = "" ;
          System.out.print("请选择:");
          str1=sc1.next();
			if(str1.equals("1")){
				view(person);
			}else if(str1.equals("5")){
				System.exit(0);
			}
			
			else{
				System.out.println("尚未构建此功能");
				select2(person);
			}
		  
			}
			public static void view(Student[] person){
			Student x1 =new Student(1,18,"无忌","男","高级");
			
			Student x2 =new Student(2,21,"悟空","男","初级");

			Student x3 =new Student(3,22,"绯红","男","中级");

			Student x4 =new Student(4,18,"无忌","男","高级");

			Student x5 =new Student(5,19,"无忌","男","高级");
			System.out.println(" "+"id"+"   "+"年龄"+"   "+"姓名"+"   "+"性别"+"   "+"年级"+"\r\n");

			person[0] = x1;
			person[1] = x2;
			person[2] = x3;
			person[3] = x4;
			person[4] = x5;
			for(int i=0;i<5;i++){  
            System.out.println(" "+person[i].id+"     "+
			 person[i].age+"    "+
			 person[i].name+"    "+
			 person[i].sex+"    "+
			 person[i]._class);
		}
		list();
		select2(person);
	}
}

class Admin{
	
	public String username;
	public String password;

	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
		public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
		public Admin(String username,String password){
		this.username = username;
		this.password = password;
	}
}

class Student{
	public int id;
	public int age;
	public String name;
	public String sex;
	public String _class;
	public String address;
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
	public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
	public String get_Class() {
        return _class;
    }
    public void set_Class(String _class) {
        this._class = _class;
    }


	public Student(int id,int age,String name,String sex,String _class){
		super();
		this.id = id;
        this.age = age;
		this.name = name;
		this.sex = sex;
		this._class = _class;
	}
	
}

