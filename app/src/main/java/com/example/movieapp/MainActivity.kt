package com.example.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterDisaster = MovieAdapter(generateDummy()) { movie ->
            val intent = Intent(this@MainActivity, DetailMovieActivity::class.java).apply {
                putExtra("gambar", movie.gambarFilm)
                putExtra("judul", movie.judulFilm)
                putExtra("genre", movie.genreFilm)
                putExtra("durasi", movie.durasiFilm)
                putExtra("rating", movie.ratingFilm)
                putExtra("sinopsis", movie.sinopsisFilm)
            }
            startActivity(intent)
        }
        with(binding) {
            rvMovie.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    fun generateDummy(): List<Movie> {
        return listOf(
            Movie(gambarFilm = R.drawable.movie_venom, judulFilm = "Venom: The Last Dance", durasiFilm = "1h 49m", ratingFilm = "R13+", genreFilm = "Action", sinopsisFilm = "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating."),
            Movie(gambarFilm = R.drawable.movie_musyrik, judulFilm = "Dosa Musyrik", durasiFilm = "1h 32m", ratingFilm = "D17+", genreFilm = "Horror", sinopsisFilm = "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating."),
            Movie(gambarFilm = R.drawable.movie_inside_out, judulFilm = "Inside Out 2", durasiFilm = "1h 36m", ratingFilm = "SU", genreFilm = "Comedy", sinopsisFilm = "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating."),
            Movie(gambarFilm = R.drawable.movie_transformer, judulFilm = "Transformer One", durasiFilm = "1h 44m", ratingFilm = "R13+", genreFilm = "Action", sinopsisFilm = "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating."),
            Movie(gambarFilm = R.drawable.movie_inside_out, judulFilm = "Inside Out 2", durasiFilm = "1h 36m", ratingFilm = "SU", genreFilm = "Comedy", sinopsisFilm = "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating."),
            Movie(gambarFilm = R.drawable.movie_transformer, judulFilm = "Transformer One", durasiFilm = "1h 44m", ratingFilm = "R13+", genreFilm = "Action", sinopsisFilm = "Journalist Eddie Brock is trying to take down Carlton Drake, the notorious and brilliant founder of the Life Foundation. While investigating one of Drake's experiments, Eddie's body merges with the alien Venom -- leaving him with superhuman strength and power. Twisted, dark and fueled by rage, Venom tries to control the new and dangerous abilities that Eddie finds so intoxicating.")
        )
    }
}