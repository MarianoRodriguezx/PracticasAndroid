package com.mariano.ejemplocarrusel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.imaginativeworld.whynotimagecarousel.ImageCarousel;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    ImageView img2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        img2 = findViewById(R.id.img2);

        Picasso.get()
                .load("https://lastfm.freetls.fastly.net/i/u/770x0/eef4289dc2f41c81d27545250a19f82a.jpg")
                .into(img);

        Picasso.get()
                .load("https://pbs.twimg.com/media/EmS7L-cXYAAWbOx.jpg")
                .into(img2);

        ImageCarousel carousel = findViewById(R.id.carousel);
        List<CarouselItem> list = new ArrayList<>();

        list.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"
                )
        );

        list.add(
                new CarouselItem(
                        "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"
                )
        );

        list.add(
                new CarouselItem(
                        "https://blogdesuperheroes.es/wp-content/plugins/BdSGallery/BdSGaleria/104007.jpg"
                )
        );

        carousel.setData(list);
    }
}