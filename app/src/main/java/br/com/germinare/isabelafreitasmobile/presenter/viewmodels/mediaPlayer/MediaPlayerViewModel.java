package br.com.germinare.isabelafreitasmobile.presenter.viewmodels.mediaPlayer;

import android.content.Context;
import android.media.MediaPlayer;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MediaPlayerViewModel extends ViewModel {

    private MediaPlayer mediaPlayer;
    private final MutableLiveData<Boolean> isPlaying = new MutableLiveData<>(false);
    private Context context;
    private int currentRawResourceId;

    public void init(Context context) {
        this.context = context;
    }

    public void playPause(int rawResourceId) {
        if (mediaPlayer == null || currentRawResourceId != rawResourceId) {
            if (mediaPlayer != null) {
                mediaPlayer.release();
            }
            mediaPlayer = MediaPlayer.create(context, rawResourceId);
            currentRawResourceId = rawResourceId;
        }

        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
        isPlaying.setValue(mediaPlayer.isPlaying());
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

}