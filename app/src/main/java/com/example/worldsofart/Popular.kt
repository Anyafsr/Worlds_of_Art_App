package com.example.worldsofart

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Popular.newInstance] factory method to
 * create an instance of this fragment.
 */
class Popular : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var adapter: MuseumAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var museumList: List<Museum>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Popular.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Popular().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_popular)
        val fadeAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in)

        recyclerView.startAnimation(fadeAnimation)
        recyclerView.setHasFixedSize(true)
        adapter = MuseumAdapter(requireContext(), museumList) { museum ->
            val intent = Intent(requireContext(), DetailMuseumActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, museum)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    private fun dataInitialize() {

        museumList = listOf<Museum>(
            Museum(
                R.drawable.centre,
                namemuseum = "The Centre Pompidou",
                descmuseum = "Paris \n" +
                        "\n" +
                        "Berasal dari nama pemimpin Negara Prancis di awal tahun 1970'an, George Pampidou. Museum ini terkenal akan arsitekturnya yang berkonsep kontemporer. \n",
                url = "https://www.centrepompidou.fr/en/"
            ),
            Museum(
                R.drawable.david,
                namemuseum = "David Zwirner",
                descmuseum = "NYC, London, Hong Kong \n" +
                        "\n" +
                        "Galeri seni David Zwirner terletak di tiga kota besar dunia, New York, London dan Hong Kong. Galeri ini menampilkan eksibisi seni dari sekitar 60 seniman dari berbagai belahan dunia. \n",
                url = "https://www.davidzwirner.com/ "
            ),
            Museum(
                R.drawable.dee,
                namemuseum = "Musee d'Orsay",
                descmuseum = "Paris \n" +
                        "\n" +
                        "Museum d'Orsay terletak di tepi kiri Sungai Seine di arrondissement VII. Menyimpan karya seni Prancis dari tahun 1848 sampai 1914. \n",
                url = "https://www.musee-orsay.fr/en"
            ),
            Museum(
                R.drawable.nga,
                namemuseum = "National Gallery of Art",
                descmuseum = "Washington DC \n" +
                        "\n" +
                        "NGA memiliki keunikannya sendiri dibandingkan museum lainnya, Sculpture Garden. \n",
                url = "https://www.nga.gov/"
            ),
            Museum(
                R.drawable.moma,
                namemuseum = "Metropolitan Museum of Art",
                descmuseum = "New York \n" +
                        "\n" +
                        "Metropolitan Museum of Art atau biasa disingkat MoMA merupakan salah satu museum terbesar di benua Amerika. Menghadirkan karya seni modern kontemporer dari beberapa seniman besar yang dikurasi secara eksklusif. \n",
                url = "https://www.metmuseum.org/"
            ),
            Museum(
                R.drawable.institution,
                namemuseum = "Smithsonian Institution",
                descmuseum = "Washington \n" +
                        "\n" +
                        "Sesuai namanya, Smithsonian Institution menghadirkan belasan Museum dengan tema berbeda, juga Galeri seni dan Kebun Binatang. \n",
                url = "https://www.si.edu/"
            ),
            Museum(
                R.drawable.lovre,
                namemuseum = "Musee d'Louvre",
                descmuseum = "Paris \n" +
                        "\n" +
                        "Selain terkenal dengan Menara Eiffel, Paris juga memiliki tempat ikonic yang tidak pernah sepi pengunjung. Museum Louvre, menyajikan sejarah, seni, sekaligus budaya warga Eropa. Terdapat banyak tempat fotogenik dan apik yang menjadikan tempat ini selalu ramai. \n",
                url = "https://www.louvre.fr/en "
            ),
            Museum(
                R.drawable.tate,
                namemuseum = "Tate",
                descmuseum = "London \n" +
                        "\nMuseum Tate di London adalah salah satu museum seni terkemuka di dunia yang terkenal dengan koleksi seni modern dan kontemporer. Terletak di tepi Sungai Thames, museum ini memiliki empat lokasi utama: Tate Britain, Tate Modern, Tate Liverpool, dan Tate St Ives.\n" +
                        "\n" +
                        "Tate Britain, yang terletak di Millbank, adalah rumah bagi koleksi seni Britania Raya dari abad ke-16 hingga seni modern. Museum ini menampilkan karya-karya terkenal dari seniman Britania seperti J.M.W. Turner, William Blake, John Constable, dan banyak lainnya. Pengunjung dapat menikmati pemandangan yang indah dari sungai Thames saat mereka menjelajahi ruang pameran yang luas.",
                url = "https://www.tate.org.uk/ "
            ),
            Museum(
                R.drawable.vatican,
                namemuseum = "Museum Vatican",
                descmuseum = "Vatikan \n" +
                        "\nMuseum Vatikan, yang terletak di Kota Vatikan di Roma, adalah salah satu museum terkenal di dunia dan menjadi rumah bagi salah satu koleksi seni dan arkeologi terbesar di dunia. Museum ini terletak di dalam kompleks Vatikan yang juga mencakup Basilika Santo Petrus dan Kapel Sistina yang terkenal.\n" +
                        "\n" +
                        "Museum Vatikan didirikan pada abad ke-16 oleh Paus Julius II dan telah berkembang pesat sejak saat itu. Koleksi museum ini mencakup lebih dari 20.000 karya seni yang meliputi lukisan, patung, fresko, artefak arkeologi, peta, dan harta karun sejarah yang tak ternilai harganya.\n" +
                        "\n" +
                        "Pengunjung museum akan mengalami perjalanan yang luar biasa melalui sejarah seni dan peradaban manusia. Ruang pameran museum meliputi berbagai galeri yang indah dan terawat dengan baik, seperti Galeri Pio-Clementino, yang menampilkan patung-patung Romawi kuno yang menakjubkan, dan Galeri Kartografi, yang menampilkan peta-peta langka dari seluruh dunia.",
                url = "https://m.museivaticani.va/content/museivaticani-mobile/en.html"
            )
        )


    }
}
