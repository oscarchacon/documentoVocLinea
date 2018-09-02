package principal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainVoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long totalTiempo;
        long tiempoInicio;
        tiempoInicio = System.currentTimeMillis();
        
        Archivo arch = new Archivo();
        
        //String rutaArchivo = "/home/ochacon/pan-plagiarism-corpus-2010/Documentos.txt"; //RUTA SERVIDOR
        //String rutaArchivo = "/mnt/c/Users/oschacon/pan-plagiarism-corpus-2010/Documentos.txt"; //RUTA BASH LINUX TRABAJO
        String rutaArchivo = "/home/marcusfenix/Escritorio/corpus/DocumentosPS.txt"; //RUTA LINUX
        //String rutaArchivo = "/Users/marcusfenix/Documents/Corpus/corpus pan10/Documentos.txt"; //RUTA MAC
        
        File archivoIn = new File(rutaArchivo);
        if(archivoIn.exists() && archivoIn.isFile())
		{	
        	//String rutaArchivoDestino = "/home/ochacon/pan-plagiarism-corpus-2010/IndiceVocDoc.txt";  //RUTA SERVIDOR
        	//String rutaArchivoDestino = "/mnt/c/Users/oschacon/pan-plagiarism-corpus-2010/IndiceVocDoc.txt";  //RUTA BASH LINUX TRABAJO
			String rutaArchivoDestino = "/home/marcusfenix/Escritorio/corpus/IndiceVocDocPS.txt";  //RUTA LINUX
			//String rutaArchivoDestino = "/Users/marcusfenix/Documents/Corpus/corpus pan10/IndiceVocDoc.txt";  //RUTA MAC
			File nombreArchivoDestino = new File(rutaArchivoDestino);
			if(nombreArchivoDestino.exists())
			{
				nombreArchivoDestino.delete();
			}
			BufferedWriter bw;
			try {
				bw = new BufferedWriter(new FileWriter(nombreArchivoDestino));
				//bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivoDestino), "UTF8"));
				//bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nombreArchivo)));
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			arch.AccedeArchivo(archivoIn, nombreArchivoDestino);
		}	
        
        totalTiempo = System.currentTimeMillis() - tiempoInicio;
		
		System.out.println("Tiempo demorado: " + (float) totalTiempo/1000 + " Segundos.");
	}

}
