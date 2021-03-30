package developer.tonmoy.jwplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.longtailvideo.jwplayer.configuration.PlayerConfig
import com.longtailvideo.jwplayer.media.ads.AdBreak
import com.longtailvideo.jwplayer.media.ads.AdSource
import com.longtailvideo.jwplayer.media.ads.Advertising
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem
import developer.tonmoy.jwplayer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adSchedule: MutableList<AdBreak> = ArrayList()


        val adBreak = AdBreak.Builder()
                //.tag("https://www.domain.com/adtag.xml")
                .tag("http://103.89.68.180/storage/v_a/xml/20012ea4-aa0e-4762-a21a-9a664d09e914.xml")
               // .tag("http://demo.jwplayer.com/android/vast-tags/preroll.xml")
                .offset("5")
                .build()

        val adBreak1 = AdBreak.Builder()
                //.tag("https://www.domain.com/adtag.xml")
                //.tag("http://103.89.68.180/storage/v_a/xml/20012ea4-aa0e-4762-a21a-9a664d09e914.xml")
                .tag("http://demo.jwplayer.com/android/vast-tags/preroll.xml")
                .offset("10")
                .source(AdSource.VAST)
                .build()

        adSchedule.add(adBreak)
        adSchedule.add(adBreak1)

        val advertising = Advertising(AdSource.VAST, adSchedule)
        advertising.skipOffset = 3
        advertising.skipMessage = "Test message"
        advertising.skipText = "Demo C"

        //val playlistItem = PlaylistItem.Builder()
             //   .file("https://cdn.jwplayer.com/manifests/GFLIf7nb.m3u8")
               // .build()



        val video = PlaylistItem.Builder()
            .file("http://103.89.68.179:1935/mediacache/_definst_/smil:path1/67d1f04e-71a4-4744-a8c9-c1c85f08f508.smil/playlist.m3u8")
           // .file("https://cdn.jwplayer.com/manifests/GFLIf7nb.m3u8")
            //.adSchedule(adSchedule)

            .build()


        val playlist: MutableList<PlaylistItem> = ArrayList()
        playlist.add(video)





        val config = PlayerConfig.Builder()
            .playlist(playlist)
                .advertising(advertising)

                .autostart(true)
            .build()

        binding.jwplayer.setup(config);
    }

    override fun onStart() {
        super.onStart()
        binding.jwplayer.onStart()
    }

    override fun onResume() {
        super.onResume()
       binding.jwplayer.onResume()
    }

    override fun onPause() {
        super.onPause()
        binding.jwplayer.onPause()
    }

    override fun onStop() {
        super.onStop()
        binding.jwplayer.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.jwplayer.onDestroy()
    }
}