package developer.tonmoy.jwplayer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.longtailvideo.jwplayer.configuration.PlayerConfig
import com.longtailvideo.jwplayer.media.ads.AdBreak
import com.longtailvideo.jwplayer.media.ads.AdSource
import com.longtailvideo.jwplayer.media.ads.AdType
import com.longtailvideo.jwplayer.media.ads.Advertising
import com.longtailvideo.jwplayer.media.playlists.PlaylistItem

import developer.tonmoy.jwplayer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    companion object{
        private const val TAG = "MainActivity"
        const val videoUrl = "https://cdn.jwplayer.com/manifests/GFLIf7nb.m3u8"
        const val inverViewUrl = "http://103.89.68.179:1935/mediacache/_definst_/smil:path1/67d1f04e-71a4-4744-a8c9-c1c85f08f508.smil/playlist.m3u8"

        //const val adUrl = "http://demo.jwplayer.com/android/vast-tags/preroll.xml"
       // const val adUrl = "https://pubads.g.doubleclick.net/gampad/ads?sz=640x360&iu=/6062/iab_vast_samples/skippable&ciu_szs=300x250,728x90&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&url=[referrer_url]&correlator=[timestamp]"
       // const val adUrl = ""
        const val adUrl = "https://raw.githubusercontent.com/tonmoym2mx/QuizTestStudentModule/main/ads_test_.xml"
       // const val adUrl = "https://raw.githubusercontent.com/tonmoym2mx/QuizTestStudentModule/main/ads_test_.xml"
      //  const val adUrl ="https://pubads.g.doubleclick.net/gampad/ads?sz=640x360&iu=/6062/iab_vast_samples/skippable&ciu_szs=300x250,728x90&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&url=[referrer_url]&correlator=[timestamp]"
        //const val adUrl ="https://pubads.g.doubleclick.net/gampad/ads?sz=640x480&iu=/124319096/external/single_ad_samples&ciu_szs=300x250&impl=s&gdfp_req=1&env=vp&output=vast&unviewed_position_start=1&cust_params=deployment%3Ddevsite%26sample_ct%3Dredirectlinear&correlator="
        const val adUrlInterview = "http://103.89.68.180/storage/v_a/xml/20012ea4-aa0e-4762-a21a-9a664d09e914.xml"
    }
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val video = video()
        val playlist = mutableListOf(video)
        configPlayer(playlist)
    }
    private fun advertising() =  Advertising(AdSource.VAST,ads())
    private fun ads() = mutableListOf<AdBreak>(
            AdBreak.Builder().tag(adUrl)
            .offset("pre")
            .build()
    )
    private fun video() = PlaylistItem.Builder()
            .file(inverViewUrl)
            .build()
    private fun configPlayer(playlist:MutableList<PlaylistItem>){
        val config = PlayerConfig.Builder()
                .playlist(playlist)
                .advertising(advertising())
                .autostart(true)
                .build()
        binding.jwplayer.setup(config)
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