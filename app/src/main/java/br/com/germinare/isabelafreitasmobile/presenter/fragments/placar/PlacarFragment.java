
package br.com.germinare.isabelafreitasmobile.presenter.fragments.placar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.germinare.isabelafreitasmobile.R;
import br.com.germinare.isabelafreitasmobile.presenter.viewmodels.mediaPlayer.MediaPlayerViewModel;

public class PlacarFragment extends Fragment {

    private MediaPlayerViewModel mediaPlayerViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_placar, container, false);
        return view;
    }

}