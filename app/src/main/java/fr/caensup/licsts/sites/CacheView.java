package fr.caensup.licsts.sites;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class CacheView {


     private TextView tvNom;
     private ImageView ivImage;
     private RatingBar rbEvaluation;


    public TextView getTvNom() {
        return tvNom;
    }

    public void setTvNom(TextView tvNom) {
        this.tvNom = tvNom;
    }

    public ImageView getIvImage() {
        return ivImage;
    }

    public void setIvImage(ImageView ivImage) {
        this.ivImage = ivImage;
    }

    public RatingBar getRbEvaluation() {
        return rbEvaluation;
    }

    public void setRbEvaluation(RatingBar rbEvaluation) {
        this.rbEvaluation = rbEvaluation;
    }
}
