package com.example.amathon

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult

import kotlinx.android.synthetic.main.activity_music_play.*
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.google.android.youtube.player.internal.e


//, View.OnClickListener
class MusicPlayActivity : YouTubeBaseActivity(), View.OnClickListener {

    lateinit var youTubeView: YouTubePlayerView
    lateinit var button: ImageButton
    lateinit var listener: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_play)

        button = findViewById(R.id.youtubeButton)
        youTubeView = findViewById(R.id.youtubeView) as YouTubePlayerView

        //리스너 등록부분

        youtubeButton.setOnClickListener(this)

        listener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
                p1!!.loadVideo("k5TqNsr6YuQ") // url의 맨 뒷부분 ID 값 넣기/// QadSVWXF_ks
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }

    override fun onClick(v: View?) {
        when (v!!) {
            youtubeButton -> {
                try {
                    youTubeView.initialize("key-value", listener)
                }catch (e: SecurityException){
                    print(e)
                }
            }
        }
    }
}
