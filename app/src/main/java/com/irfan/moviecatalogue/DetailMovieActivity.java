package com.irfan.moviecatalogue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.budiyev.android.circularprogressbar.CircularProgressBar;

public class DetailMovieActivity extends AppCompatActivity {

    private TextView itemJudulFilm, itemTglRilis, itemUserScore, itemDurasi, itemKarakter, itemDeskripsi;
    private ImageView imgFoto;
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        itemJudulFilm = findViewById(R.id.item_judul_film);
        itemTglRilis = findViewById(R.id.item_tgl_rilis);
        itemUserScore = findViewById(R.id.item_user_score);
        itemDurasi = findViewById(R.id.item_durasi);
        itemKarakter = findViewById(R.id.item_karakter);
        itemDeskripsi = findViewById(R.id.item_desc);
        imgFoto = findViewById(R.id.img_foto);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String judul = movie.getNama();
        String rilis = movie.getTglrilis();
        String score = movie.getScore();
        String durasi = movie.getDurasi();
        String karakter = movie.getKarakter();
        String desc = movie.getDeskripsi();

        itemJudulFilm.setText(judul);
        itemTglRilis.setText(rilis);
        itemUserScore.setText(score);
        itemDurasi.setText(durasi);
        itemKarakter.setText(karakter);
        itemDeskripsi.setText(desc);
        imgFoto.setImageResource(movie.getFoto());
    }
}
