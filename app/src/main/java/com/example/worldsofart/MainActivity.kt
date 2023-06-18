package com.example.worldsofart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.worldsofart.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(Menu.NONE, 1 , Menu.NONE, "Dark Mode")
        menu?.add(Menu.NONE, 2 , Menu.NONE, "Light Mode")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            2 -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceFragment(Home())
                R.id.popular -> replaceFragment(Popular())
                R.id.profile -> replaceFragment(Profile())

                else ->{

                }
            }
            true

        }

        val museumList = listOf<Museum>(
            Museum(
                R.drawable.centre,
                namemuseum = "The Centre Pompidou",
                descmuseum = "Paris \n" +
                        "\n" +
                        "Berasal dari nama pemimpin Negara Prancis di awal tahun 1970'an, George Pampidou. Museum ini terkenal akan arsitekturnya yang berkonsep kontemporer. \n"
                , url = "https://www.centrepompidou.fr/en/"
            ),
            Museum(
                R.drawable.david,
                namemuseum = "David Zwirner",
                descmuseum = "NYC, London, Hong Kong \n" +
                        "\n" +
                        "Galeri seni David Zwirner terletak di tiga kota besar dunia, New York, London dan Hong Kong. Galeri ini menampilkan eksibisi seni dari sekitar 60 seniman dari berbagai belahan dunia. \n"
                , url = "https://www.davidzwirner.com/ "
            ),
            Museum(
                R.drawable.dee,
                namemuseum = "Musee d'Orsay",
                descmuseum = "Paris \n" +
                        "\n" +
                        "Museum d'Orsay terletak di tepi kiri Sungai Seine di arrondissement VII. Menyimpan karya seni Prancis dari tahun 1848 sampai 1914. \n"
                , url = "https://www.musee-orsay.fr/en"
            ),
            Museum(
                R.drawable.nga,
                namemuseum = "National Gallery of Art",
                descmuseum = "Washington DC \n" +
                        "\n" +
                        "NGA memiliki keunikannya sendiri dibandingkan museum lainnya, Sculpture Garden. \n"
                , url = "https://www.nga.gov/"
            ),
            Museum(
                R.drawable.moma,
                namemuseum = "Metropolitan Museum of Art",
                descmuseum = "New York \n" +
                        "\n" +
                        "Metropolitan Museum of Art atau biasa disingkat MoMA merupakan salah satu museum terbesar di benua Amerika. Menghadirkan karya seni modern kontemporer dari beberapa seniman besar yang dikurasi secara eksklusif. \n"
                , url = "https://www.metmuseum.org/"
            ),
            Museum(
                R.drawable.institution,
                namemuseum = "Smithsonian Institution",
                descmuseum = "Washington \n" +
                        "\n" +
                        "Sesuai namanya, Smithsonian Institution menghadirkan belasan Museum dengan tema berbeda, juga Galeri seni dan Kebun Binatang. \n"
                , url = "https://www.si.edu/"
            ),
            Museum(
                R.drawable.lovre,
                namemuseum = "Musee d'Louvre",
                descmuseum = "Paris \n" +
                        "\n" +
                        "Selain terkenal dengan Menara Eiffel, Paris juga memiliki tempat ikonic yang tidak pernah sepi pengunjung. Museum Louvre, menyajikan sejarah, seni, sekaligus budaya warga Eropa. Terdapat banyak tempat fotogenik dan apik yang menjadikan tempat ini selalu ramai. \n"
                , url = "https://www.louvre.fr/en "
            ),
            Museum(
                R.drawable.tate,
                namemuseum = "Tate",
                descmuseum = "London \n" +
                        "\nMuseum Tate di London adalah salah satu museum seni terkemuka di dunia yang terkenal dengan koleksi seni modern dan kontemporer. Terletak di tepi Sungai Thames, museum ini memiliki empat lokasi utama: Tate Britain, Tate Modern, Tate Liverpool, dan Tate St Ives.\n" +
                        "\n" +
                        "Tate Britain, yang terletak di Millbank, adalah rumah bagi koleksi seni Britania Raya dari abad ke-16 hingga seni modern. Museum ini menampilkan karya-karya terkenal dari seniman Britania seperti J.M.W. Turner, William Blake, John Constable, dan banyak lainnya. Pengunjung dapat menikmati pemandangan yang indah dari sungai Thames saat mereka menjelajahi ruang pameran yang luas."
                , url = "https://www.tate.org.uk/ "
            ),
            Museum(
                R.drawable.vatican,
                namemuseum = "Museum Vatican",
                descmuseum = "Vatikan \n" +
                        "\nMuseum Vatikan, yang terletak di Kota Vatikan di Roma, adalah salah satu museum terkenal di dunia dan menjadi rumah bagi salah satu koleksi seni dan arkeologi terbesar di dunia. Museum ini terletak di dalam kompleks Vatikan yang juga mencakup Basilika Santo Petrus dan Kapel Sistina yang terkenal.\n" +
                        "\n" +
                        "Museum Vatikan didirikan pada abad ke-16 oleh Paus Julius II dan telah berkembang pesat sejak saat itu. Koleksi museum ini mencakup lebih dari 20.000 karya seni yang meliputi lukisan, patung, fresko, artefak arkeologi, peta, dan harta karun sejarah yang tak ternilai harganya.\n" +
                        "\n" +
                        "Pengunjung museum akan mengalami perjalanan yang luar biasa melalui sejarah seni dan peradaban manusia. Ruang pameran museum meliputi berbagai galeri yang indah dan terawat dengan baik, seperti Galeri Pio-Clementino, yang menampilkan patung-patung Romawi kuno yang menakjubkan, dan Galeri Kartografi, yang menampilkan peta-peta langka dari seluruh dunia."
                , url = "https://m.museivaticani.va/content/museivaticani-mobile/en.html"
            )
        )
    }

    private fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}