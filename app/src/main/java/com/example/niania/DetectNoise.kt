package com.example.niania

import android.media.MediaRecorder
import kotlin.math.log10

class DetectNoise {
    private val EMA_FILTER = 0.6

    private var mRecorder: MediaRecorder? = null
    private var mEMA = 0.0

    fun start() {
        if (mRecorder == null) {
            mRecorder = MediaRecorder()
            mRecorder!!.setAudioSource(MediaRecorder.AudioSource.MIC)
            mRecorder!!.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            mRecorder!!.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB)
            mRecorder!!.setOutputFile("/dev/null")
            mRecorder!!.prepare()
            mRecorder!!.start()
        }
    }

    fun stop() {
        if (mRecorder != null) {
            mRecorder!!.stop()
            mRecorder!!.release()
            mRecorder = null
        }
    }

    fun getAmplitude(): Int {
        if (mRecorder != null)
            return  mRecorder!!.getMaxAmplitude();
        else
            return 0;

    }
}