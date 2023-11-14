package br.com.germinare.isabelafreitasmobile.presenter.fragments.bichos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import br.com.germinare.isabelafreitasmobile.R;
import br.com.germinare.isabelafreitasmobile.presenter.viewmodels.mediaPlayer.MediaPlayerViewModel;

public class BichosFragment extends Fragment {

    private MediaPlayerViewModel mediaPlayerViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mediaPlayerViewModel = new ViewModelProvider(this).get(MediaPlayerViewModel.class);
        mediaPlayerViewModel.init(requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bichos, container, false);
        ImageButton cachorro = view.findViewById(R.id.cachorro);
        ImageButton gato = view.findViewById(R.id.gato);
        ImageButton leao = view.findViewById(R.id.leao);
        ImageButton macaco = view.findViewById(R.id.macaco);
        ImageButton ovelha = view.findViewById(R.id.ovelha);
        ImageButton vaca = view.findViewById(R.id.vaca);
        cachorro.setOnClickListener(v -> mediaPlayerViewModel.playPause(R.raw.cachorro));
        gato.setOnClickListener(v -> mediaPlayerViewModel.playPause(R.raw.gato));
        leao.setOnClickListener(v -> mediaPlayerViewModel.playPause(R.raw.leao));
        macaco.setOnClickListener(v -> mediaPlayerViewModel.playPause(R.raw.macaco));
        ovelha.setOnClickListener(v -> mediaPlayerViewModel.playPause(R.raw.ovelha));
        vaca.setOnClickListener(v -> mediaPlayerViewModel.playPause(R.raw.vaca));
        return view;
    }

}