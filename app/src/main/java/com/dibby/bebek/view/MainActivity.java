package com.dibby.bebek.view;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dibby.bebek.R;
import com.dibby.bebek.db.DatabaseHandler;
import com.dibby.bebek.pojo.Gejala;
import com.dibby.bebek.pojo.Penyakit;
import com.dibby.bebek.util.Adapter;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView btnBebek, btnPenyakit, btnDiagnosa, btnCaraBertenak;
    Toolbar toolbar;
    ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBebek = findViewById(R.id.main_button_bebek);
        btnPenyakit = findViewById(R.id.main_button_penyakit);
        btnDiagnosa = findViewById(R.id.main_button_diagnosa);
        btnCaraBertenak = findViewById(R.id.main_button_cara_bertenak);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        btnBebek.setOnClickListener(this);
        btnPenyakit.setOnClickListener(this);
        btnDiagnosa.setOnClickListener(this);
        btnCaraBertenak.setOnClickListener(this);

        mViewPager= (ViewPager) findViewById(R.id.main_view_pager);
        Adapter adapterView = new Adapter(this);
        mViewPager.setAdapter(adapterView);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);
        DatabaseHandler db = new DatabaseHandler(this);

        db.onDelete();
        Log.d("Insert: ", "Inserting ..");
        db.addGejala(new Gejala("G01","Unggas terlihat mengantuk ", 0.28));
        db.addGejala(new Gejala("G02","Keluar lendir , kental berwarna kekuningan dan berbau dari hidung",0.39));
        db.addGejala(new Gejala("G03","Muka dan mata bengkak ",0.37));
        db.addGejala(new Gejala("G04","Terdapat kerak dihidung",0.31));
        db.addGejala(new Gejala("G05","Napsu makan menurun hingga tembolok kosong saat diraba",0.48));
        db.addGejala(new Gejala("G06","Mengorok",0.44));
        db.addGejala(new Gejala("G07","Pertumbuhan lambat",0.45));
        db.addGejala(new Gejala("G08","Kotoran encer dan bercampur butiran-butiran putih seperti kapur",0.54));
        db.addGejala(new Gejala("G09","Bulu dubur melekat satu sama lain",0.23));
        db.addGejala(new Gejala("G10","sayap berwarna keabuan",0.3));
        db.addGejala(new Gejala("G11","Badan menjadi menunduk",0.46));
        db.addGejala(new Gejala("G12","Sayap terkulai",0.29));
        db.addGejala(new Gejala("G13","Mata menutup",0.25));
        db.addGejala(new Gejala("G14","Sayap berwarna biru",0.53));
        db.addGejala(new Gejala("G15","Mata unggas terlihat lesu",0.4));
        db.addGejala(new Gejala("G16","Sesak nafas",0.38));
        db.addGejala(new Gejala("G17","Berak mengalami mencret",0.36));
        db.addGejala(new Gejala("G18","Kotoran berwarna kuning, coklat atau hijau berlendir dan berbau busuk",0.33));
        db.addGejala(new Gejala("G19","Sayap dan pial bengkak serta kepala berwarna kebiruan",0.23));
        db.addGejala(new Gejala("G20","Suka menggeleng-gelengkan kepala",0.23));
        db.addGejala(new Gejala("G21","Persendian kaki dan sayap bengkak disertai kelumpuhan",0.21));
        db.addGejala(new Gejala("G22","Batuk-batuk",0.57));
        db.addGejala(new Gejala("G23","Napas berbunyi",0.24));
        db.addGejala(new Gejala("G24","Produksi telur turun",0.56));
        db.addGejala(new Gejala("G25","Bulu kasar",0.58));
        db.addGejala(new Gejala("G26","Unggas mengalami diare",0.26));
        db.addGejala(new Gejala("G27","Kornea menjadi keruh",0.29));
        db.addGejala(new Gejala("G28","Otot tubuh gemetar",0.52));
        db.addGejala(new Gejala("G29","Kelumpuhan hingga gangguan saraf yang dapat menyebabkan kejang-kejang dan leher terpuntir",0.5));
        db.addGejala(new Gejala("G30","Bulu tampak kusam",0.27));
        db.addGejala(new Gejala("G31","Peradangan di sekitar dubur dan kloaka, biasanya unggas akan mematoki duburnya sendiri",0.46));
        db.addGejala(new Gejala("G32","Jika tidur, paruhnya menempel di lantai dan keseimbangan tubuhnya terganggu",0.24));
        db.addGejala(new Gejala("G33","Bersin",0.43));
        db.addGejala(new Gejala("G34","Terengah-engah",0.31));
        db.addGejala(new Gejala("G35","Tubuh unggas menjadi kurus",0.38));
        db.addGejala(new Gejala("G36","Pertumbuhan yang lambat pada unggas muda",0.51));
        db.addGejala(new Gejala("G37","Telur menurun pada periode layer",0.59));
        db.addGejala(new Gejala("G38","Berak berwarna hijau dan encer",0.5));


        Log.d("Insert: ", "Inserting ..");
        db.addPenyakit(new Penyakit( "P01","Snot/Coryza",
                "Snot/Coryza disebabkan oleh bakteri Haemophillus gallinarum. Penyakit ini biasanya menyerang bebek akibat adanya perubahan musim.",
                "Pencegahan yang bisa dilakukan dengan memberikan antibiotika yang dicampur dalam pakan dan minum dan bisa dengan menyuntikkan obat streptomycin sulphate.",
                "Pengobatan menggunakan obat yang memang terbukti efektif adalah Max-X. Bila preparat tetrasiklin, neomisin dan streptomisin, sulfadimetoksin dll tidak terbukti efektif ."));
        db.addPenyakit(new Penyakit("P02","Berak Kapur atau Pullorum",
                "Berak kapur disebabkan oleh bakteri Salmonella pullorum. Berak kapur sering ditemukan pada anak bebek umur 1-10 hari.",
                "Pencegahan penyakit berak kapur atau pullorum Bebek yang dibeli dari distributor penetasan atau suplier harus memiliki sertifikat bebas salmonella pullorum. Melakukan desinfeksi pada kandang dengan formaldehyde 40%. Bebek yang terkena penyakit sebaiknya dipisahkan dari kelompoknya, sedangkan bebek yang parah dimusnahkan.",
                "Obat berak kapur alami adalah bawang putih, bawang putih merupakan obat alami  atau tradisional sebagai antibiotikuntuk membasmi bakteri yang terdapat pada saluran pencernaan. Cara pemberiannya cukup mudah, yaitu dengan digerus kemudian dicampurkan dengan air minum, untuk skala kecil disarankan menggunakan air hangat. Obat yang bisa digunakan selain itu adalah Therapy, Koleridin, Vita Tetra Chlor, Respiratrek, Neo Mediril atau Trimezyn-s. Bisa juga menambahkan vitamin seperti Vita Stress, Fortevit atau Strong n Fit untuk membantu mempercepat proses penyembuhan penyakit setelah pemberian obat selang beberapa menit."));
        db.addPenyakit(new Penyakit("P03","Berak Hijau",
                "Penyebab penyakit ini belum diketahui secara pasti, demikian pula pengobatannya. Selama ini penyakit ini diduga disebabkan oleh bakteri sejenis Salmonella pullorum. Penularan berak hijau sangat mudah yaitu melalui kontak langsung termasuk saat jantan mengawini betina dan melalui pakan dan minuman yang terkontaminasi dengan bebek yang sakit. Pengaruh penyakit ini dapat sampai ke DOC keturunan induk yang sakit.",
                "Upaya pencegahan merupakan hal utama antara lain dengan menjaga sanitasi kandang, memisahkan antara bebek yang sakit memberikan pakan yang yang baik. Jika bebek yang terinfeksi mengalami kematian, lebih baik bebek tersebut dibakar agar bakteri tersebut ikut mati dan tidak menular ke bebek yang lain.",
                "Pengobatan yang terbaik adalah dengan cara mencampurkan madu tawon dan obat teraphy ke minum bebek."));
        db.addPenyakit(new Penyakit("P04","Kolera",
                "Penyebab penyakit ini adalah bakteri Pasteurella gallinarum atau Pasteurella multocida. Biasanya menyerang bebek pada usia 12 minggu. Penyakit ini menyerang bebek petelur dan pedaging. Serangan penyakit ini bisa bersifat akut atau kronis. Bebek yang terserang kolera akan mengalami penurunan produktivitas bahkan mati. Bakteri ini menyerang pernapasan dan pencernaan. Kolera dapat ditularkan melalui kontak langsung, pakan, minuman, peralatan, manusia, tanah maupun hewan lain. Pada serangan akut, kematian dapat terjadi secara tiba-tiba.",
                "Tindakan pencegahan sangat penting dilakukan antara lain dengan menjaga agar litter tetap kering, mengurangi kepadatan kandang, menjaga  kebersihan peralatan kandang dan memberikan vitamin dan pakan yang cukup agar stamina bebek tetap terjaga.",
                "Pengobatan kolera dapat dilakukan dengan menggunakan obat Chloramphenicol, Tetra Cycline atau preparat sulfa."));
        db.addPenyakit(new Penyakit("P05","Chronic Respiratory",
                "Penyakit ini disebabkan oleh bakteri Mycoplasma galisepticum. Biasanya menyerang bebek pada usia 4-9 minggu. Penuluran terjadi melalui kontak langsung, peralatan kandang, tempat makan dan minum, manusia, telur tetas atau DOC yang terinfeksi.",
                "Pencegahan terhadap penyakit ini dapat dilakukan dengan berbagai cara, mulai dari cara yang paling sederhana yaitu tidak membeli DOC dari produsen yang tidak diketahui dan melakukan sanitasi kandang.",
                "Pengobatan CRD pada bebek yang sakit dapat diberikan baytrit 10% peroral, mycomas dengan dosis 0.5 ml/L air minum, tetraclorin secara oral atau bacytracyn yang diberikan pada air minum."));
        db.addPenyakit(new Penyakit("P06","Colibacillosis",
                "Penyebab penyakit ini adalah Escherichia coli. Problem yang ditimbulkan dapat infeksi akut berat dengan kematian yang tiba-tiba dan angka kematian yang tinggi hingga infeksi ringan dengan angka kesakitan dan kematian yang rendah. Infeksi dapat terjadi pada saluran pernapasan, septicemia atau enteritis karena infeksi pada gastrointestinal. Penyakit ini dapat berdiri sendiri atau diikuti oleh infeksi sekunder. Infeksi sekunder yang menyertai penyakit ini adalah Mycoplasma gallisepticum. Semua umur dapat terkena penyakit ini, namun yang paling banyak adalah bebek usia muda. Gejala yang ditimbulkan pada penyakit ini disebabkan oleh toksin yang dikeluarkan oleh bakteri akibat pertumbuhan dan multiplikasi. Invasi primer terjadi pada sistem pernapasan dan sistem gastrointestinal.Omphalitis atau infeksi pada anak bebek terjadi karena penutupan tali pusat yang kurang baik atau karena invasi bakteri melalui cangkang telur pada saat inkubasi.",
                "Pencegahan dapat dilakukan dengan menjaga sanitasi kandang seperti menjaga ventilasi udara, litter yang terjaga kebersihannya, secara teratur melakukan  esinfeksi terhadap peralatan dan fasilitas lainnya. Hal yang tidak kalah pentingnya adalah menjaga kualitas pakan dan air minum, kepadatan kandang harus diperhatikan, penanganan mesin penetas telur dan menjauhkan bebek dari stress yang dapat menurunkan daya tahan tubuh.",
                "Obat-obat yang dapat digunakan antara lainAmpicol, Collimezyn, atau Neo Meditril. Selain obat via air minum, ada pula pilihan obat yang diberikan secara injeksi/suntikan, yaitu Gentamin, Vet Strep, atau Neo Meditril-I."));
        db.addPenyakit(new Penyakit("P07","Newcastle Disease (ND)",
                "ND sangat menular, biasanya dalam 3- 4 hari seluruh ternak akan terinfeksi. Virus ini ditularkan melalui sepatu, peralatan, baju dan burung liar. Pada tahap yang mengenai pernapasan maka virus akan ditularkan melalui udara. Meskipun demikian pada penularan melalui udara, virus ini tidak mempunyai jangkauan yang luas. Unggas yang dinyatakan sembuh dari ND tidak akan dinyatakan sebagai “carrier” dan biasanya virus tidak akan bertahan lebih dari 30 hari pada lokasi pemaparan.",
                "Pencegahan yang harus dilakukan oleh para peternak mengingat penyakit ini sangat infeksius adalah dengan memelihara kebersihan kandang dan sekitarnya (Kandang harus mendapat sinar matahari yang cukup dan ventilasi yang baik) dan memisahkan bebek lain yang dicurigai dapat menularkan penyakit serta memberikan ransum jamu yang baik",
                "Untuk mengatasi penyakit ini lakukan vaksinasi ND dan untuk proses penyembuhan lakukan dengan memberikan jamu herbal yang berbahan bawang putih dan kunyit."));
        db.addPenyakit(new Penyakit("P08","Gumoro",
                "Penyakit ini menyerang kekebalan tubuh bebek, terutama bagian fibrikus dan thymus. Kedua bagian ini merupakan pertahanan tubuh bebek. Pada kerusakan yang parah, antibody bebek tersebut tidak terbentuk. Karena menyerang system kekebalan tubuh, maka penyakit ini sering disebut sebagai AIDSnya bebek. Bebek yang terkena akan menampakan gejala seperti  gangguan saraf, merejan, diare, tubuh gemetar, bulu di sekitar anus kotor dan lengket serta diakhiri dengan kematian bebek. Virus yang menyebabkan penyakit ini adalah virus dari genus Avibirnavirus. Di dalam tubuh bebek, virus ini dapat hidup hingga lebih dari 3 bulan, kemudian akan berkembang menjadi infeksius. Gumoro memang tidak menyebabkan kematian secara langsung pada bebek, tetapi infeski sekunder yang mengikutinya akan menyebabkan kematian dengan cepat karena kekebalan tubuhnya tidak bekerja. Gumoro dapat dibagi 2 yaitu gumoro klinik dan sub klinik. Gumoro klinik menyerang anak bebek berumur 3-7 minggu. Pada fase ini serangan terhadap  kekebalan tubuh bebek tersebut hanya bersifat sementara antara 2-3 minggu. Gumoro subklinik menyerang anak bebek berumur 0-3 minggu.",
                "Gumoro menyebar melalui kontak langsung, air minum, pakan, alat-alat yang sudah tercemar virus dan udara. Yang sangat menarik adalah gumoro tidak menular dengan perantaraan telur dan bebek sudah sembuh tidak menjadi “carrier”. Upaya penanggulangan gumoro ini dapat dilakukan dengan beberapa cara yaitu vaksinasi, menjaga kebersihan lingkungan kandang.atau punuk dowager.",
                "Dapat dicoba pengobatan vitamin-elektrolit yang rupa-rupanya sedikit menolong bebek yang sakit.Wabah penyakit ini akan berlangsung selama 4-7 hari, dan jika dalam ginjal sudah terdapat banyak asam urat dan ada nephritis dan nephrosis, perlu diberikan air minum yang dicampur dengan molase sebanyak kurang lebih 10%(kira-kira 1 mangkuk molase tiap-tiap 5 galon air), biasanya dapat menolong dari kematian."));
        db.addPenyakit(new Penyakit("P09","Bronchitis",
                "Penyakit ini disebabkan oleh Corona virus yang menyerang system pernapsan. Pada bebek dewasa penyakit ini tidak menyebabkan kematian, tetapi pada bebek berumur kurang dari 6 minggu dapat menyebabkan kematian. Informasi yang lain menyebutkan bahwa bebek yang terserang penyakit ini dan berumur di bawah 3 minggu, kematian dapat mencapai 30-40%. Penularan dapat terjadi melalui udara, peralatan, pakaian. Virus akan hidup selama kurang 1 minggu jika tidak terdapat ternak pada area tersebut. Virus ini mudah mati karena panas atau desinfektan.",
                "Sanitasi merupakan factor pemutus rantai penularan penyakit karena virus tersebut sangat rentan terhadap desinfektan dan panas. Pencegahan lain yang sangat umum dilakukan adalah dengan memberikan vaksinasi secara teratur.",
                "Tidak ada pengobatan khusus yang dapat menyembuhkan penyakit ini, hal ini dikarenakan penyakit ini disebabkan oleh virus. Penanganan darurat dengan cara pisahkan semua bebek sakit. Semprot kandang dgn bayclin 1 + air 9.Pemberian vitamin & antibiotik enrofloxacin setiap hari selama 5 hari untuk mengurangi infeksi sekunder dan menaikan stamina + antibody ayam untuk melawan virus."));
        db.addPenyakit(new Penyakit("P10","Avian Pox",
                "Avian pox mempunyai daya sebar yang relatif lambat. Avian pox disebabkan oleh minimal 3 strain atau tipe yaitu: fowl pox virus (virus cacar pada unggas), pigeon pox virus (virus cacar pada burung dara) dan canary pox virus (virus cacar pada burung kenari). Biasanya cacar yang terjadi pada bebek disebabkan oleh fowl pox virus. Virus ini dapat ditularkan secara langsung maupun tidak langsung. Virus ini sangat resisten pada keropeng yang kering dan dalam beberapa kondisi dapat hidup hingga beberapa bulan. Virus ini dapat ditransmisikan melalui beberapa spesies nyamuk. Nyamuk ini akan membawa virus yang infeksius ini setelah nyamuk tersebut  menggigit unggas yang terinfeksi. Meskipun fowl pox penyebarannya relatif lambat, kawanan unggas ini dapat berpengaruh selama beberapa bulan. Perjalanan penyakit ini memerlukan waktu sekitar 3-5 minggu.",
                "Langkah pencegahan yang utama adalah memberikan vaksinasi pada bebek. Pemberian vaksinasi dilakukan dengan melakukan penusukan pada sayap dengan jarum khusus.",
                "Pengobatan bagi cacar kering berupa benjolan-benjolan dapat dilakukan dengan cara mengelupasi benjolan-benjolan sampai berdarah, kemudian diolesi dengan yodium tingture (6-10%)."));
        db.addPenyakit(new Penyakit("P11","Marek (Visceral Leukosis)",
                "Marek (Visceral Leukosis) disebabkan oleh virus tipe DNA yang tergolong herpes tipe B. Marek diidentikan dengan penyakit anak bebek, meskipun demikian penyakit ini juga dapat menginfeksi bebek yang lebih tua. Anak bebek terserang adalah kelompok umur 3-10 minggu. Umur 8-9 minggu merupakan umur yang paling rawan. Penularan dapat terjadi secara kontak langsung, kotoran bebek, debu dan peralatan kandang.",
                "Pencegahan dapat dilakukan dengan memberikan vaksinasi pada DOC berumur 1 hari dengan vaksin Cryomarex HVT atau Cryomarex Rispens.Bebek yang terinfesi sebaiknya dimusnahkan agar tidak menularkan ke bebek yang sehat.",
                "Tidak ada pengobatan untuk penyakit Marek. Unggas yang sakit harus segera dimusnahkan dari kawanan. Unggas lain dalam kawanan yang mungkin terinfeksi pada tahap ini juga dimusnahkan, pengawasan yang ketat dari semua unggas adalah penting."));
        db.addPenyakit(new Penyakit("P12","Berak Darah / Koksidiosis",
                "Berak darah atau sering disebut dengan koksidiosis disebabkan oleh protozoa dari genus Eimeria. Penularan penyakit ini dapat melalui kontak secara langsung maupun tidak langsung seperti kontak dengan droplet dari unggas yang terinfeksi. Pada saat unggas memakan koksidia, organisme ini akan menginvasi usus dan mengakibatkan kerusakan dan kemudian mulai berkembang biak. Beberapa minggu setelah terjadinya infeksi, koksidia akan berubah menjadi oocyst. Oocyst masih belum cukup matur, meskipun oocyst terdapat pada droplet, oocyst ini tidak dapat menginfeksi unggas lain kecuali ia berkembang (sporulasi) menjadi bentuk yang lebih matang di litter. Bentuk inilah yang dapat menyebabkan infeksi pada unggas. Berat tidaknya penyakit ini tergantung dari jumlah protozoa yang termakan. Di dalam peternakan, penyakit ini sangat mudah ditularkan melalui alas kaki, baju, burung liar, peralatan, tempat pakan, serangga atau rodent.",
                "Pencegahan dapat dilakukan dengan cara memberikan vaksinasi pada bebek pada usia 4 hari. Biasanya diberikan vaksinasi dengan melakukan penyemprotan pada pakan. Selain itu harus dilakukan sanitasi yang baik pada kandang DOC. Pilih pakan yang sudah mengandung koksidiostat( preparat pembunuh protozoa Eimeria)",
                "Tindakan yang harus dilakukan adalah mengkarantina bebek yang terlanjur sakit dan memberi obat Antitoksi, Maladex atau yang sejenis."));



        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Gejala> contacts = db.getAllGejala();

        for (Gejala cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getNama() + " ,Angka: " + cn.getAngka() ;
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        Log.d("Reading: ", "Reading all contacts..");
        List<Penyakit> penyakits = db.getAllPenyakit();

        for (Penyakit cn : penyakits) {
            String log = "Id: "+cn.getNo()+" ,Name: " + cn.getName() + " ,Penjelasan: " + cn.getJelas()+" ,Pencegahan: " + cn.getCegah() + " ,Pengobatan: " + cn.getSolusi();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_help:
                Intent intentHelp = new Intent(this, Help.class);
                startActivity(intentHelp);
             break;
            case R.id.menu_about:
                Intent intentAbout = new Intent(this, About.class);
                startActivity(intentAbout);
             break;
        }

        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_button_bebek :
                startActivity(new Intent(this, TentangBebek.class));
                break;

            case R.id.main_button_penyakit :
                startActivity(new Intent(this, PenyakitBebek.class));
                break;

            case R.id.main_button_diagnosa :
                startActivity(new Intent(this, Diagnosa.class));
                break;

            case R.id.main_button_cara_bertenak :
                startActivity(new Intent(this, CaraBeternak.class));
                break;
        }
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(mViewPager.getCurrentItem() == 0){
                        mViewPager.setCurrentItem(1);
                    } else if(mViewPager.getCurrentItem() == 1){
                        mViewPager.setCurrentItem(2);
                    } else if(mViewPager.getCurrentItem() == 2){
                        mViewPager.setCurrentItem(3);
                    } else if(mViewPager.getCurrentItem() == 3){
                        mViewPager.setCurrentItem(4);
                    } else {
                        mViewPager.setCurrentItem(0);
                    }

                }
            });

        }
    }

}
