package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class Server {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = null;
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        //�����˿ں�
        int port = 10000;
        try {
                 //��������
        	 serverSocket = new ServerSocket(port);
        	while(true){
                
                 //�������
                 socket = serverSocket.accept();
                 //���տͻ��˷�������
                 is = socket.getInputStream();
                 byte[] b = new byte[1024];
                 int n = is.read(b);
                 //���
                 String data= new String(b,0,n);
                 StringTokenizer st=new StringTokenizer(data,"\t");
                 String userid=st.nextToken();
                 String action=st.nextToken();
                 JSONArray array=new JSONArray();
                 JSONObject json=new JSONObject();
                 json.put("id", userid);
                 json.put("action", action);
                 array.add(json);
                 JSONObject json2=new JSONObject();
                 json2.put("id", userid+2);
                 json2.put("action", action+2);
                 array.add(json2);
                 System.out.println("�ͻ��˷�������Ϊ��" +userid);
                 //��ͻ��˷��ͷ�������
                 os = socket.getOutputStream();
                 os.write(array.toString().getBytes());
        	}
        } catch (Exception e) {
                 e.printStackTrace();
        }finally{
                 try{
                          //�ر���������
                          os.close();
                          is.close();
                          socket.close();
                          serverSocket.close();
                 }catch(Exception e){}
        }
	}
}
