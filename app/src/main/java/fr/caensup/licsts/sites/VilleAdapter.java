package fr.caensup.licsts.sites;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.Callable;

public class VilleAdapter extends BaseAdapter  {
    private LayoutInflater inflater = null;
    private Context context;
    private List<Ville> lesVilles;
    private int currentItemPosition;

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
        if ( view == null ) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.ville_layout, viewGroup, false);
            CacheView cache = new CacheView();
            // Créer les composants de itemView
            cache.setTvNom( view.findViewById(R.id.tvNom) );
            cache.setIvImage(view.findViewById(R.id.ivImage) );
            cache.setRbEvaluation(view.findViewById(R.id.rbEvaluation));
            view.setTag( cache);
        }

        // Rchercher la ville en position i
        Ville v = (Ville)getItem( i );
        // Créer une couleur avec les 3 composantes RVB
        int couleurVille =  Color.rgb(v.getRouge(),v.getVert(),v.getBleu());
        // Ventiler les valeurs de la ville dans les composants de la vue
        CacheView cache = (CacheView)view.getTag();
        cache.getTvNom().setText( v.getNom() );
        cache.getIvImage().setBackgroundColor( couleurVille );
        cache.getRbEvaluation().setRating( (float)v.getEvaluation() );
        // Ecouteur sur le RatingBar


        return view;
    }


}
