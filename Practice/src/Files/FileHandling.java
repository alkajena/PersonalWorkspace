package Files;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.net.ssl.StandardConstants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileHandling {

	public static void main(String[] args) throws IOException {
		File file=new File("\\DHL\\GIT\\alka.txt");
		File file1=new File("\\DHL\\GIT\\neha.txt");
		System.out.println(file.getAbsolutePath());//will give exact path C:\DHL\GIT(if "" is given then it will give eclipse path)
		System.out.println(file.getPath());//\DHL\GIT
		System.out.println(file.getName());
		System.out.println(file.exists());
		System.out.println(file.canRead());
		System.out.println(file.canWrite());
		
		if(file.exists()){
			Path dest=Paths.get("");
			Path source=Paths.get("");
			if(!file1.exists()){
				source=Paths.get("\\DHL\\GIT\\neha.txt");
				Files.createFile(source);
				System.out.print(file1.canWrite());
			}
			FileReader reader=new FileReader(file);
			FileWriter writer=new FileWriter(file1);
			int i=0;
			while((i=reader.read())!=-1){
				//System.out.print((char)i);
				writer.write((char)i);
			}
			writer.close();
			//file1.delete();
			//file.renameTo(new File("\\DHL\\GIT"));
			//reader.close();
			
			BufferedReader br=new BufferedReader(new FileReader(file));
			String st="";
			while((st=br.readLine())!=null){
				System.out.print(st);
			}
			
			//Files.move(source, dest, StandardCopyOption.REPLACE_EXISTING);
			
			FileInputStream fis=new FileInputStream(new File("\\DHL\\GIT\\alka.txt"));
			FileOutputStream fos=new FileOutputStream(new File("\\DHL\\GIT\\pupu.txt"));
			
			int i1=0;
			while((i1=fis.read())!=-1){
				System.out.print((char)i1);
				fos.write((char)i1);
			}
			fos.close();
			
			BufferedReader buff1=new BufferedReader(new FileReader(file));
			
			BufferedWriter buff2=new BufferedWriter(new FileWriter("\\DHL\\GIT\\pupu.txt"));
			
			String st1="";
			String st2="";
			boolean flag=false;
			while((st1=buff1.readLine())!=null){
				BufferedReader buff3=new BufferedReader(new FileReader("\\DHL\\GIT\\pupu.txt"));
				while((st2=buff3.readLine())!=null){
					if(st1.equals(st2)){
						flag=true;
						break;
					}	
				}
				//st1=st1.concat('\n');
				if(!flag){
					buff2.write(st1);
					buff2.write("\r\n");
					buff2.flush();//it will write in to the file immediately
				}
				else
					flag=false;
			}
			buff2.close();//it will write at last
			
		}

	}

}
