package com.irfan.moviecatalogue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;

    }

    private class ViewHolder {
        private TextView tvNamaFilm, tvTglRilis, tvDeskripsi;
        private ImageView imgFoto;

        ViewHolder(View view) {
            tvNamaFilm = view.findViewById(R.id.tv_nama_film);
            tvTglRilis = view.findViewById(R.id.tv_tgl_rilis);
            tvDeskripsi = view.findViewById(R.id.tv_desc);
            imgFoto = view.findViewById(R.id.img_foto);
        }

        void bind(Movie movie) {
            tvNamaFilm.setText(movie.getNama());
            tvTglRilis.setText(movie.getTglrilis());
            tvDeskripsi.setText(movie.getDeskripsi());
            imgFoto.setImageResource(movie.getFoto());
        }
    }
}
