package com.example.rahulm.android_pictureinpicture

import android.app.PictureInPictureParams
import android.content.res.Configuration
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Rational
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoView.setVideoPath("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4")
        videoView.start()
        pipButton.setOnClickListener { pictureInPictureMode() }
    }

    /**
     * Enters Picture-in-Picture mode.
     */
    private fun pictureInPictureMode() {
        // Calculate the aspect ratio of the PiP screen.
        val aspectRatio = Rational(videoView.width, videoView.height)
        val mPictureInPictureParamsBuilder = PictureInPictureParams.Builder()
        mPictureInPictureParamsBuilder.setAspectRatio(aspectRatio)
        enterPictureInPictureMode(mPictureInPictureParamsBuilder.build())
    }


    override fun onPictureInPictureModeChanged(isInPictureInPictureMode: Boolean, newConfig: Configuration?) {
        if (isInPictureInPictureMode) {
            // Hide the full-screen UI (controls, etc.) while in picture-in-picture mode.
        } else {
            // Restore the full-screen UI.
        }
    }
}
