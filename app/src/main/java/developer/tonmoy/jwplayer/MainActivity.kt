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
        const val videoUrl = "http://103.89.68.179:1935/mediacache/_definst_/smil:path1/67d1f04e-71a4-4744-a8c9-c1c85f08f508.smil/playlist.m3u8"
        const val adUrl = "https://raw.githubusercontent.com/tonmoym2mx/SimpleJWPlayerAndroidExample/master/VAST_AD_FILE.XML"
    }
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        configPlayer()
    }
    private fun configPlayer(){
        val config = PlayerConfig.Builder()
                .playlist(playList())
                .advertising(advertising())
                .autostart(true)
                .build()
        binding.jwplayer.setup(config)
    }

    private fun advertising() = Advertising(AdSource.VAST,ads()).apply {
        skipOffset = 10
    }
    private fun ads() = mutableListOf<AdBreak>(
            AdBreak.Builder().tag(adUrl)
                    .offset("pre")
                    .build()
    )
    private fun video() = PlaylistItem.Builder()
            .file(videoUrl)
            .build()
    private fun playList() = mutableListOf(video())


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