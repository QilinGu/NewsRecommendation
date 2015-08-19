package edu.ruc.news;

import java.util.ArrayList;
import java.util.List;
import edu.ruc.data.*;

public class News {

//	News : һ�����ŵĻ�����ɺͲ�����
//  ��Ҫ�Ľӿھ��Ǹ��ݱ�ǩ����ȡattribute
//
		
    
	public long id;
	public ArrayList<Attribute> array;
	public String date;
	public String category;
	public String title;
	public String body;

//  ���캯��
 // Ψһһ�ֹ��캯����ָ��һ��id��ΪΨһ��ʶ
	public News(long id){
		this.id=id;
		array=new ArrayList<Attribute>();
	}
	
//  ����
	
	//�õ�ID
	public void setDate(String date){
		this.date=date;
	}
	public String getDate(){
		return this.date;
	}
	public void setCategory(String category){
		this.category=category;
	}
	public String getCategory(){
		return this.category;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return this.title;
	}
	public void setBody(String body){
		this.body=body;
	}
	public String getBody(){
		return this.body;
	}
	
	
	public long getID(){
		return this.id;
	}
	
	//�������� ������� �͸��� ����fasle
	public boolean setAttribute(Attribute attribute){
		for(Attribute a:array){
			if(a. getAttributeName().equals(attribute.getAttributeName())){
				array.remove(a);
				array.add(attribute);
				return false;
			}
		}
		array.add(attribute);
		return true;
	}
	
	//ɾ������ �����ڷ���false
	public boolean removeAttribute(String attribute_name){
		for(Attribute a:array){
			if(a. getAttributeName().equals(attribute_name)){
				array.remove(a);
				
				return true;
			}
		}
		return false;
	}
	
	//������������
	public int getLengthAttribute(){
		return array.size();
	}
	
	//�����������ַ�������
	public Attribute getAttribute(String attribute_name){
		
		for(Attribute a:array){
			if(a. getAttributeName().equals(attribute_name)){
				
				
				return a;
			}
		}
		System.out.println("attribute can not find");
		return null;
	}
	
	
	
	//���������б�
	public List<Attribute> getAttributeList(){
		return array;
	}
	
	//�������������б�
	public List<String> getAttributeListName(){
		ArrayList<String> arrayName=new ArrayList<String>();
		for(Attribute a:array){
			arrayName.add(a.getAttributeName());
		}
		return arrayName;
	}
	
	//�ж������Ƿ����
	public boolean isExistAttributeByName(String attribute_name){
		for(Attribute a:array){
			if(a. getAttributeName().equals(attribute_name)){		
				return true;
			}
		}
		return false;
	}
	//��ӡ
	public String printAttribute(){
		return "";
	}
	

	

	
}
