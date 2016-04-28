
    package com.jing.ch02;
   public class Teacher{ 
 	private long id; 
 	private String name; 
 	private int age; 

 	public teacher(){ 
 	 
 	} 
 	public teacher(long id,String name,int age){ 
 		this.id = id; 
 		this.name = name; 
 		this.age = age; 
 	} 
  
 	public void setId(long id){ 
 		this.id = id; 
 	} 
 	public long getId(){ 
 		return this.id; 
 	} 
 	public void setName(String name){ 
 		this.name = name; 
 	} 
 	public String getName(){ 
 		return this.name; 
 	} 
 	public void setAge(int age){ 
 		this.age = age; 
 	} 
 	public int getAge(){ 
 		return this.age; 
 	} 
 	public String toString(){ 
 		return "teacher[id:"+this.id+",name:"+this.name+",age:"+this.age+"]"; 
 	} 
 } 
package com.jing.ch02; 
  
 import java.util.Scanner; 

 public class Tms { 
 	/
 	private teacher[] ters = new teacher[3]; 
 	private int index = 0; 
 	 
 	public void add(teacher ter){ 
 		 
 		if(index>=ters.length){ 
 			
 			teacher[] demo = new teacher[ters.length+3]; 
 			
 			System.arraycopy(ters,0,demo,0,ters.length); 
 			ters= demo; 
 		} 
 		ters[index++] = ter; 
 	} 
 	 
 	public void deleteById(long id){ 
 		//���÷�����ȡidΪָ�����������������е�λ�� 
 		int terIndex = queryIndexById(id); // 1 
 		if(terIndex!=-1){ 
 			for(int i=terIndex;i<index-1;i++){ 
 				ters[i] = ters[i+1]; 
 			} 
 			ters[--index] = null; 
 		} 
 	} 
 	 
 	
 	private int queryIndexById(long id){ 
 		intterIndex= -1; 
 		for(int i=0;i<index;i++){ 
 			if(ters[i].getId() == id){ 
 				terIndex = i; 
 				break; 
 			} 
 		} 
 		return terIndex; 
 	} 
 	
 	public teacher queryById(long id){ 
 	
 		int terIndex = queryIndexById(id); 
 		return terIndex==-1?null:ters[terIndex]; 
 	} 
  
 
 	public teacher[] queryAll(){ 
 		teacher[] demo = new teacher[index]; 
 		System.arraycopy(ters,0,demo,0,index); 
 		return demo; 
 	} 
 	
 	public void update(teacher ter){ 
 		for(int i=0;i<index;i++){ 
 			if(ter.getId() == ters[i].getId()){ 
 				ters[i].setName(ter.getName()); 
 				ters[i].setAge(ter.getAge()); 
 			} 
 		} 
 	} 
 
 	public void menu(){ 
 		System.out.println("********��ʦ����ϵͳ*******"); 
 		System.out.println("*1���鿴������ʦ��Ϣ*"); 
 		System.out.println("*2�������ʦ��Ϣ*"); 
 		System.out.println("*3��ɾ����ʦ��Ϣ*"); 
 		System.out.println("*4����ѯ��ʦ��Ϣ*"); 
 		System.out.println("*5���޸���ʦ��Ϣ*"); 
 		System.out.println("*exit���˳�*"); 
 		System.out.println("*help������*"); 
 		System.out.println("***************************"); 
 	} 
  
 	public static void main(String[] args){ 
 		
 		Tms tms = newTms(); 
 		tms.menu();	 
 		Scanner scanner = new Scanner(System.in); 
 		while(true){ 
 			System.out.print("�����빦�ܱ�ţ�"); 
 			
 			String option = scanner.nextLine(); 
 			switch(option){ 
 				case "1":
 					System.out.println("������������ʦ����Ϣ��"); 
 					teacher[] ters = ter.queryAll(); 
 					for(teacher ter : ters){ 
 						System.out.println(ter); 
 					} 
 					System.out.println("�ܼƣ�"+ters.length+" ��"); 
 					break; 
 				case "2": 
 					while(true){ 
 						System.out.println("��������ʦ��Ϣ��id#name#age����������break�ص���һ��Ŀ¼"); 
 						String terStr = scanner.nextLine(); 
 						if(terStr.equals("break")){ 
 							break; 
 						} 
 						String[] terArr = terStr.split("#"); 
 						long id = Long.parseLong(terArr[0]); 
 						String name = terArr[1]; 
 						int age = Integer.parseInt(terArr[2]); 
 						
 						teacher ter = new teacher(id,name,age); 
 						 
 						teacher dbTers = tms.queryById(id); 
 						if(dbTer!=null){ 
 							System.out.println("��id�Ѿ�����ռ�ã�������¼�룡"); 
 							continue; 
 						} 
  
 						sms.add(ter); 
 						System.out.println("��ӳɹ���"); 
 					} 
 					 
 					break; 
 				case "3": 
 					while(true){ 
 						System.out.print("��������Ҫɾ����ʦ��id��break������һ��Ŀ¼:"); 
 						String id = scanner.nextLine(); 
 						if(id.equals("break")){ 
 							break; 
 						} 
 						tms.deleteById(Long.parseLong(id)); 
 						System.out.println("ɾ���ɹ�����ʦ����Ϊ��"+tms.index); 
 					} 
 					break; 
 				case "4":
 					while(true){ 
 						System.out.print("��������Ҫ��ѯ��ʦ��id��break������һ��Ŀ¼:"); 
 						String id = scanner.nextLine(); 
 						if(id.equals("break")){ 
 							break; 
 						} 
 						teacher ter = tms.queryById(Long.parseLong(id)); 
 						System.out.println("��������Ҫ���ҵ���ʦ����Ϣ��"); 
 						System.out.println(ter!=null?ter:"not found!"); 
 					} 
 					break; 
 				case "5": 
 					while(true){ 
 						System.out.print("��������Ҫ�޸���ʦ��id��break������һ��Ŀ¼:"); 
 						String id = scanner.nextLine(); 
 						if(id.equals("break")){ 
 							break; 
 						} 
 						teacher ter = tms.queryById(Long.parseLong(id)); 
 						if(ter == null){ 
 							System.out.println("����ʦ�����ڣ�"); 
 							continue; 
 						} 
 						System.out.println("ԭ��ϢΪ��"+stu); 
 						System.out.println("��������Ҫ�޸ĵ���Ϣ��name#age��"); 
 						String terStr = scanner.nextLine(); 
 						String[] terArr = terStr.split("#"); 
  
 						String name = terArr[0]; 
 						int age = Integer.parseInt(terArr[1]); 
  
 						teacher newTer = new teacher(Long.parseLong(id),name,age); 
  
 						sms.update(newTer); 
 						System.out.println("�޸ĳɹ���"); 
 					} 
 					break; 
 				case "help": 
 					tms.menu(); 
 					break; 
 				case "exit": 
 					System.out.println("bye bye"); 
 					System.exit(0); 
 				default: 
 					System.out.println("����������������룡"); 
 			} 
 		} 
 			 
 	} 
 } 

  

