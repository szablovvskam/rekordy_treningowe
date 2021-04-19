package com.example

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.video.*
import java.util.regex.Pattern

class VideoStrictPress: YouTubeBaseActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video)

        intilizePlayer(getYoutubeVideoIdFromUrl("https://www.youtube.com/watch?v=94pwgUPhdrE&ab_channel=SPCStrengthandConditioning")!!)
    }
    private fun intilizePlayer(videoId:String) {
        youtubeplayer.initialize(getString(R.string.api_key),
                object : YouTubePlayer.OnInitializedListener {
                    override fun onInitializationSuccess(
                            p0: YouTubePlayer.Provider?,
                            p1: YouTubePlayer?,
                            p2: Boolean
                    ) {
                        p1!!.loadVideo(videoId)
                        p1.play()
                    }

                    override fun onInitializationFailure(
                            p0: YouTubePlayer.Provider?,
                            p1: YouTubeInitializationResult?
                    ) {
                        Toast.makeText(applicationContext, "error occured", Toast.LENGTH_LONG).show()
                    }
                })
    }

    fun getYoutubeVideoIdFromUrl(inUrl: String):String? {
        if (inUrl.toLowerCase().contains("youtu.be")) {
            return inUrl.substring(inUrl.lastIndexOf("/") + 1)
        }
        val pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*"
        val compiledPattern = Pattern.compile(pattern)
        val matcher = compiledPattern.matcher(inUrl)
        return if (matcher.find()) {
            matcher.group()
        } else null

    }
}