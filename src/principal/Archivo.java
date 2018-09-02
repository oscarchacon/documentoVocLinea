package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Archivo {
	
	public void AccedeArchivo(File ArchivoIn, File ArchivoOut)
	{
		String linea;
		int doc = 1;
		try {
			BufferedReader br = new BufferedReader(new FileReader(ArchivoIn));
			while((linea=br.readLine())!=null)
			{
				String[] LineaCompleta = linea.trim().split(";");
				String nombreDoc = LineaCompleta[0].trim();
				
				Map<String,Integer>MapaVocabulario = new HashMap<String,Integer>();
				String[] aux = LineaCompleta[1].trim().split("\\s+");
				for(int i=0; i<aux.length; i++)
				{
					if(MapaVocabulario.containsKey(aux[i].trim()))
					{
						MapaVocabulario.replace(aux[i].trim(), MapaVocabulario.get(aux[i].trim())+1);
					}
					else
					{
						MapaVocabulario.put(aux[i].trim(), 1);
					}
				}
				aux=null;
				if(MapaVocabulario.size() > 0)
				{
					this.GuardarVocDocs(ArchivoOut, nombreDoc, MapaVocabulario);
				}
				doc++;
			}
			br.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void GuardarVocDocs(File ArchivoOut, String NombreDoc, Map<String,Integer> Vocabulario)
	{
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(ArchivoOut,true));
			String linea;
			
			linea = NombreDoc+" ";
			for(Map.Entry<String, Integer> entrada : Vocabulario.entrySet())
			{
				linea+= entrada.getKey()+","+entrada.getValue()+" ";
			}
			linea = linea.trim();
			out.write(linea);
			out.newLine();
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
