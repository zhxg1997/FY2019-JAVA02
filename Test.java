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
				System.out.println("--------------------��ӭ��½ѧ����Ϣ����ϵͳ--------------------------"
			+"\r\n"+"1.��½"+"    "+"2.�˳�"+"\r\n"
			+"----------------------------------------------------------------------");
			}
			public static void select1(){
				Scanner sc=new Scanner(System.in); 
          String str = "" ;
          System.out.print("��ѡ��:");
          str=sc.next();
         if(str.equals("1")) {

			System.out.println("��ӭ��½!"+"\r\n");
               
          }
		  else if(str.equals("2")){
			  System.out.println("�������"); 
				System.exit(0);			
		  }else{
			  System.out.println("������������������"); 
				select1();
		  }
			}
			public static void login(Admin[] admins){
		Scanner sc1=new Scanner(System.in); 
          String str1 = "" ;
          System.out.print("�������û���:");
          str1=sc1.next();
		Scanner sc2=new Scanner(System.in); 
          String str2 = "" ;
          System.out.print("����������:");
          str2=sc2.next();  
		  for(int i = 0;i <5 ;i++){
			  if(admins[i] == null){
				  continue;
			  }
			  if(str1.equals(admins[i].username)&&str2.equals(admins[i].password)){
				  System.out.println("��½�ɹ�"+"\r\n"+"��ӭ����admin");
				  break;
			  }else{
				  login(admins);
			  }
		  }
			}
			public static void list(){
				System.out.println("**********************��ѡ��Ҫ��������Ϣ��Ӧ����******************************"
			+"\r\n"+"1.�鿴ѧ����Ϣ"+"    "+"2.���ѧ����Ϣ"+"    "+"3.ɾ��ѧ����Ϣ"+"    "+"4.�޸�ѧ����Ϣ"+"    "+"5.�˳�"+"\r\n"
			+"******************************************************************************");
			}
			public static void admin(Admin[] admins){
							Admin x1 =new Admin("admin","admin");
							admins[0] = x1;
							

			}
			public static void select2(Student[] person){
		
		Scanner sc1=new Scanner(System.in); 
          String str1 = "" ;
          System.out.print("��ѡ��:");
          str1=sc1.next();
			if(str1.equals("1")){
				view(person);
			}else if(str1.equals("5")){
				System.exit(0);
			}
			
			else{
				System.out.println("��δ�����˹���");
				select2(person);
			}
		  
			}
			public static void view(Student[] person){
			Student x1 =new Student(1,18,"�޼�","��","�߼�");
			
			Student x2 =new Student(2,21,"���","��","����");

			Student x3 =new Student(3,22,"糺�","��","�м�");

			Student x4 =new Student(4,18,"�޼�","��","�߼�");

			Student x5 =new Student(5,19,"�޼�","��","�߼�");
			System.out.println(" "+"id"+"   "+"����"+"   "+"����"+"   "+"�Ա�"+"   "+"�꼶"+"\r\n");

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

