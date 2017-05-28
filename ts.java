/* I "Tahreem Saleem" do verify that the submitted code is my own effort and that I have not copied it 
from any peer or any internet source that has not been acknowledged. I also understand that if my 
submission fails the similarity detection, I would be awarded zero marks not only for this submission 
but the whole evaluation component. */


/*
THIS CODE WILL FIND MY SOURCE FILE IN C: DRIVE.. NO MATTER IN WHICH DIRECTORY IT IS SAVED. 
I AM USING THE METHOD OF RECURSION FOR THIS PURPOSE
*/
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

//first making a panel to design the layout

class mypanel extends JPanel
{

	//declaring all the static variables	
	
	static JTextField tf = new JTextField("",25);
	static JTextArea ta = new JTextArea ();
	JScrollPane sp = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	static File fg = new File("C:\\"); 
	static FileInputStream fis;
	static File fnames[];
	static String fileName;
	static File ff;
	static String sourceName = new String("ts.java");
	static String ap;
		
		//setting layout
		{
			setLayout( new BorderLayout());
			add(tf,BorderLayout.NORTH);
			add(sp,BorderLayout.CENTER);
		}
		//constructor
		mypanel() throws IOException
		{
					
							if (fg.exists())
									findfile(fg);								//calling the finding file method
							else 
									tf.setText("no file");		
		}//constructor ends
	//definnig the finding file method
	public static void findfile( File file ) throws IOException
						{
								fnames = file.listFiles();										
								if (fnames !=null);
							
							try
							{																
								
								for (File fil : fnames)														//ACCESSING FILES ONE BY ONE
								{
									if (fil.isFile())																//IF IT IS A FILE
									{
										ap = fil.getAbsolutePath();
										ff = new File (ap);
										fileName = ff.getName();
										if (fileName.equals(sourceName))
										{
											
											tf.setText(""+ap);															//DISPLAYING THE PATH
											fis = new FileInputStream(fil);												
											byte [] b = new byte[(int)fil.length()];
											fis.read(b);																//READING THE FILE
											for (int i= 0;i < b.length;i++)
											{
											ta.append(""+(char)b[i]);
											}//for ends
										
										}//if ends
									}//if ends
									else if (fil.isDirectory())													//IF IT IS A DIRECTORY
									findfile(fil);															//RECURSION
								}//for ends	
							}catch(Exception e){}													//CATCHING EXCEPTION
						}//method ends
}	//panel ends
	
	
			
		//PUBLIC CLASS
	public class ts extends JFrame {	
	
		public static void main ( String args[]) throws IOException
		{
			ts mf = new ts();
			mypanel mp = new mypanel();
			mf.add (mp);
			mf.setTitle ("Source File Finder");
			mf.setBounds(100,200,700,700);
			mf.setVisible(true);

		}//main method ends
}//public class ends




