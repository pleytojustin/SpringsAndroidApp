package com.springs.springs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class Home extends Fragment {
    public static final String[] TITLES= {"Hood","Full Sleeve Shirt","Shirt","Hood","Full Sleeve Shirt","Shirt"};
    public static final Integer[] IMAGES= {R.drawable.img1sample,R.drawable.img2sample,R.drawable.img3sample,R.drawable.img1sample,R.drawable.img2sample,R.drawable.img3sample};
    private static RecyclerView recyclerView;
    private static String navigateFrom;//String to get Intent Value
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.happysample,R.drawable.happysample,R.drawable.happysample,R.drawable.happysample,R.drawable.happysample};
    Context context;
    private android.support.v7.widget.Toolbar toolbar;
    public Home( ) {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_fragment,container,false);
        carouselView = (CarouselView) v.findViewById(R.id.carouselView);

        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

//        toolbar = (android.support.v7.widget.Toolbar) v.findViewById(R.id.app_bar);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        populatRecyclerView();
        return v;
    }

    private void populatRecyclerView() {
        ArrayList<Data_Model> arrayList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            arrayList.add(new Data_Model(TITLES[i],IMAGES[i]));
        }
        RecyclerView_Adapter  adapter = new RecyclerView_Adapter(getContext(), arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview
        adapter.notifyDataSetChanged();// Notify the adapter

    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            Drawable d = getResources().getDrawable(sampleImages[position]);
           // imageView.setImageResource(sampleImages[position]);
            imageView.setImageDrawable(d);

          //  imageView.setImageResource(sampleImages[position]);
        }
    };

}
