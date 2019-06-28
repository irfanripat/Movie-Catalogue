package com.irfan.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataNama;
    private String[] dataTglrilis;
    private String[] dataDeskripsi;
    private String[] dataKarakter;
    private String[] dataDurasi;
    private String[] dataSkor;
    private TypedArray dataFoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_item_movie);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Movie movie = new Movie();
                movie.setNama(movies.get(i).getNama());
                movie.setKarakter(movies.get(i).getKarakter());
                movie.setScore(movies.get(i).getScore());
                movie.setDurasi(movies.get(i).getDurasi());
                movie.setDeskripsi(movies.get(i).getDeskripsi());
                movie.setTglrilis(movies.get(i).getTglrilis());
                movie.setFoto(movies.get(i).getFoto());


                Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
                startActivity(intent);
            }
        });

    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i=0; i < dataNama.length; i++) {
            Movie movie = new Movie();
            movie.setNama(dataNama[i]);
            movie.setTglrilis(dataTglrilis[i]);
            movie.setDeskripsi(dataDeskripsi[i]);
            movie.setScore(dataSkor[i]);
            movie.setDurasi(dataDurasi[i]);
            movie.setKarakter(dataKarakter[i]);
            movie.setFoto(dataFoto.getResourceId(i, -1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataNama = getResources().getStringArray(R.array.data_nama);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataFoto = getResources().obtainTypedArray(R.array.data_foto);
        dataTglrilis = getResources().getStringArray(R.array.data_tglrilis);
        dataDurasi = getResources().getStringArray(R.array.data_durasi);
        dataKarakter = getResources().getStringArray(R.array.data_karakter);
        dataSkor = getResources().getStringArray(R.array.data_skor);
    }
}
