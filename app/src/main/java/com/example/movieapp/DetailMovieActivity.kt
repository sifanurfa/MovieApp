package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.movieapp.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gambar = intent.getIntExtra("gambar", 0)
        val judul = intent.getStringExtra("judul")
        val genre = intent.getStringExtra("genre")
        val durasi = intent.getStringExtra("durasi")
        val rating = intent.getStringExtra("rating")
        val sinopsis = intent.getStringExtra("sinopsis")

        with(binding){
            imgFilm.setImageResource(gambar)
            txtJudul.text = judul
            txtGenre.text = genre
            txtDurasi.text = durasi
            txtRating.text = rating
            txtSinopsis.text = sinopsis

            icBack.setOnClickListener{
                val intent = Intent(this@DetailMovieActivity, MainActivity::class.java)
                startActivity(intent)
            }
            booking.setOnClickListener{
                Toast.makeText(this@DetailMovieActivity, "Film $judul berhasil dipesan!", Toast.LENGTH_LONG).show()
            }
        }
    }
}