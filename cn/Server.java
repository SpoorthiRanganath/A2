import java.net.*;
import java.io.*;
import java.util.*;
public class Server
{
public static void main(String args[]) throws Exception
{
ServerSocket server=new ServerSocket(2081);
System.out.println("Server established.");
Socket client=server.accept();
ObjectOutputStream oos=new ObjectOutputStream(client.getOutputStream());
ObjectInputStream ois=new ObjectInputStream(client.getInputStream());
System.out.println("Client is now connected.");
int x=(Integer)ois.readObject();
int k=(Integer)ois.readObject();
int j=0;
int i=(Integer)ois.readObject();
boolean flag=true;
{
int c=k;
for(int h=1;h<=x;h++)
{
System.out.print("|"+c+"|");
c++;
}
System.out.println();
System.out.println();
if(k==j)
{
System.out.println("Frame "+k+" recieved"+"\n"+"Data:"+j);
j++;
}
else if(k==j-1)
{
oos.writeObject(k);
System.out.println("Acknowledgement sent");
}
else
System.out.println("Frames recieved not in correct order”+”\n”+” Expected farme:” + j +”\n”+ ” Recieved frame no :"+ k);
System.out.println();
System.out.println();
oos.writeObject(-1);
}
}



