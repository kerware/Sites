package fr.caensup.licsts.sites;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class VilleAdapter extends BaseAdapter {
    private LayoutInflater inflater = null;
    private Context context;
    private List<Ville> lesVilles;

    public void setModele( List<Ville> modele ) {
        lesVilles = modele;
    }

    public VilleAdapter( Context context ) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lesVilles.size();
    }

    @Override
    public Object getItem(int i) {
        return lesVilles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.ville_layout, viewGroup, false);

        // Créer les composants de itemView
        TextView tvNom = itemView.findViewById( R.id.tvNom );
        ImageView ivImage = itemView.findViewById( R.id.ivImage );
        RatingBar rbEvaluation = itemView.findViewById( R.id.rbEvaluation );

        // Rchercher la ville en position i
        Ville v = (Ville)getItem( i );

        // Créer une couleur avec les 3 composantes RVB
        int couleurVille =  Color.rgb(v.getRouge(),v.getVert(),v.getBleu());

        // Ventiler les valeurs de la ville dans les composants de la vue
        tvNom.setText( v.getNom() );
        ivImage.setBackgroundColor( couleurVille );
        rbEvaluation.setRating( (float)v.getEvaluation() );

        return itemView;
    }
}
