import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.student.manage.CheckClass;
import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to add Student");
			System.out.println("Press 2 to delete Student");
			System.out.println("Press 3 to display Student");
			System.out.println("Press 4 to Exit App");
			int c=Integer.parseInt(br.readLine());
			if(c==1) {
				System.out.println("Enter UserName:");
				String name=br.readLine();
				System.out.println("Enter Student Phone:");
				String phone=br.readLine();
				System.out.println("Enter Student City:");
				String city=br.readLine();
				Student st=new Student(name,phone,city);
				boolean answer=StudentDao.insertStudentToDB(st);
				CheckClass.check(answer);
				//System.out.println(st);
			}
			else if(c==2) {
				System.out.println("Enter Student Id");
				int userId=Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				CheckClass.check(f);
			}else if(c==3) {
				System.out.println("Students Table Data");
				boolean f=StudentDao.displayStudent();
				CheckClass.check(f);
			}else if(c==4) {
				break;
			}
			else if(c==5){
				System.out.println("Enter Student Id For Updation:");
				int userId=Integer.parseInt(br.readLine());
				System.out.println("Enter the Student New Phone Number:");
				String nphone=br.readLine();
				boolean f=StudentDao.updateStudent(userId,nphone);
				CheckClass.check(f);
			}
			else {
				
			}
			
		}
		System.out.println("Thank You For Using My Application");
	}
	
}
