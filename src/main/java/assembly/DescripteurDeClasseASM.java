package assembly;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import descripteurDeClasse.DescripteurDeClasse;

public class DescripteurDeClasseASM {

	public DescripteurDeClasseASM(FileWriter writer, ArrayList<DescripteurDeClasse> listeDdc) {	
		//ecriture dans la zone de code statique
		String bloc = "\ndescriptifClasses_\n";	
		for(DescripteurDeClasse ddc : listeDdc) {
			bloc = bloc.concat(String.format("	LDW R1, #%d		//taille %s\n	ADQ -2, SP\n	STW R1, (SP)\n", ddc.taille,ddc.type)+
					String.format("	LDW R1, #%d		//nbMethodes %s\n	ADQ -%d, SP\n	STW R1, (SP)\n",ddc.nbMethodes,ddc.type, ddc.listeAttributStatique.size()*2+2));
				bloc = bloc+
						"	ADQ -"+(ddc.adressesMethodes.size())*2+", SP\n";
		}
		bloc = bloc.concat("	JSR @initAdressesMethodes_\n\n\n");
		try {
			writer.write(bloc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
