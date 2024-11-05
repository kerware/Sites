package fr.caensup.licsts.sites;

import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Ville> chargerVilles(Context context, String filename) {
        List<Ville> villes = new ArrayList<>();

        try (InputStream is = context.getAssets().open(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is)))
        {
             String line;
             while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 5) {
                    String nom = fields[0];
                    int rouge = Integer.parseInt(fields[1]);
                    int vert = Integer.parseInt(fields[2]);
                    int bleu = Integer.parseInt(fields[3]);
                    double evaluation = Double.parseDouble(fields[4]);

                    // Vérification des valeurs
                    if (rouge >= 0 && rouge <= 255 &&
                            vert >= 0 && vert <= 255 &&
                            bleu >= 0 && bleu <= 255 &&
                            evaluation >= 0 && evaluation <= 5) {

                        Ville ville = new Ville(nom, rouge, vert, bleu, evaluation);
                        villes.add(ville);
                    }
                }
            }

        } catch (IOException e) {
            Log.e("CsvReader", "Erreur lors de la lecture du fichier CSV", e);
        }


        return villes;
    }
}

