package br.com.germinare.isabelafreitasmobile.presenter.fragments.bichos;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import br.com.germinare.isabelafreitasmobile.R;
import br.com.germinare.isabelafreitasmobile.presenter.viewmodels.mediaPlayer.MediaPlayerViewModel;

public class BichosFragment extends Fragment {

    private MediaPlayerViewModel mediaPlayerViewModel;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference cachorroClickCountRef = database.getReference("click_count_cachorro");
    DatabaseReference gatoClickCountRef = database.getReference("click_count_gato");
    DatabaseReference leaoClickCountRef = database.getReference("click_count_leao");
    DatabaseReference macacoClickCountRef = database.getReference("click_count_macaco");
    DatabaseReference ovelhaClickCountRef = database.getReference("click_count_ovelha");
    DatabaseReference vacaClickCountRef = database.getReference("click_count_vaca");

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
        cachorro.setOnClickListener(v -> {
            mediaPlayerViewModel.playPause(R.raw.cachorro);
            addClickCachorro();
        });
        gato.setOnClickListener(v -> {
            mediaPlayerViewModel.playPause(R.raw.gato);
            addClickGato();
        });
        leao.setOnClickListener(v -> {
            mediaPlayerViewModel.playPause(R.raw.leao);
            addClickLeao();
        });
        macaco.setOnClickListener(v -> {
            mediaPlayerViewModel.playPause(R.raw.macaco);
            addClickMacaco();
        });
        ovelha.setOnClickListener(v -> {
            mediaPlayerViewModel.playPause(R.raw.ovelha);
            addClickOvelha();
        });
        vaca.setOnClickListener(v -> {
            mediaPlayerViewModel.playPause(R.raw.vaca);
            addClickVaca();
        });
        return view;
    }

    private void addClickCachorro() {
        cachorroClickCountRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Long valorAtual = mutableData.getValue(Long.class);
                if (valorAtual == null) {
                    valorAtual = 0L;
                }
                mutableData.setValue(valorAtual + 1);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                if (databaseError != null) {
                    Log.e("PlacarFragment", "Erro ao incrementar contador: " + databaseError.getMessage());
                }
            }
        });
    }

    private void addClickGato() {
        gatoClickCountRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Long valorAtual = mutableData.getValue(Long.class);
                if (valorAtual == null) {
                    valorAtual = 0L;
                }
                mutableData.setValue(valorAtual + 1);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                if (databaseError != null) {
                    Log.e("PlacarFragment", "Erro ao incrementar contador: " + databaseError.getMessage());
                }
            }
        });
    }

    private void addClickLeao() {
        leaoClickCountRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Long valorAtual = mutableData.getValue(Long.class);
                if (valorAtual == null) {
                    valorAtual = 0L;
                }
                mutableData.setValue(valorAtual + 1);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                if (databaseError != null) {
                    Log.e("PlacarFragment", "Erro ao incrementar contador: " + databaseError.getMessage());
                }
            }
        });
    }

    private void addClickMacaco() {
        macacoClickCountRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Long valorAtual = mutableData.getValue(Long.class);
                if (valorAtual == null) {
                    valorAtual = 0L;
                }
                mutableData.setValue(valorAtual + 1);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                if (databaseError != null) {
                    Log.e("PlacarFragment", "Erro ao incrementar contador: " + databaseError.getMessage());
                }
            }
        });
    }

    private void addClickOvelha() {
        ovelhaClickCountRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Long valorAtual = mutableData.getValue(Long.class);
                if (valorAtual == null) {
                    valorAtual = 0L;
                }
                mutableData.setValue(valorAtual + 1);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                if (databaseError != null) {
                    Log.e("PlacarFragment", "Erro ao incrementar contador: " + databaseError.getMessage());
                }
            }
        });
    }

    private void addClickVaca() {
        vacaClickCountRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData mutableData) {
                Long valorAtual = mutableData.getValue(Long.class);
                if (valorAtual == null) {
                    valorAtual = 0L;
                }
                mutableData.setValue(valorAtual + 1);
                return Transaction.success(mutableData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean b, @Nullable DataSnapshot dataSnapshot) {
                if (databaseError != null) {
                    Log.e("PlacarFragment", "Erro ao incrementar contador: " + databaseError.getMessage());
                }
            }
        });
    }

}