package br.com.germinare.isabelafreitasmobile.presenter.fragments.placar;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import br.com.germinare.isabelafreitasmobile.R;

public class PlacarFragment extends Fragment {

    private DatabaseReference cachorroClickCountRef;
    private DatabaseReference gatoClickCountRef;
    private DatabaseReference leaoClickCountRef;
    private DatabaseReference macacoClickCountRef;
    private DatabaseReference ovelhaClickCountRef;
    private DatabaseReference vacaClickCountRef;
    private final ArrayList<String> clickCountsList = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        cachorroClickCountRef = database.getReference("click_count_cachorro");
        gatoClickCountRef = database.getReference("click_count_gato");
        leaoClickCountRef = database.getReference("click_count_leao");
        macacoClickCountRef = database.getReference("click_count_macaco");
        ovelhaClickCountRef = database.getReference("click_count_ovelha");
        vacaClickCountRef = database.getReference("click_count_vaca");
        arrayAdapter = new ArrayAdapter<>(requireContext(), R.layout.item_placar, R.id.animal, clickCountsList);
        arrayAdapter.setDropDownViewResource(R.layout.item_placar);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_placar, container, false);
        ListView placar = view.findViewById(R.id.placar);
        placar.setAdapter(arrayAdapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        clearList();
        addClickListener(cachorroClickCountRef, "Cachorro");
        addClickListener(gatoClickCountRef, "Gato");
        addClickListener(leaoClickCountRef, "Leão");
        addClickListener(macacoClickCountRef, "Macaco");
        addClickListener(ovelhaClickCountRef, "Ovelha");
        addClickListener(vacaClickCountRef, "Vaca");
    }

    private void clearList() {
        clickCountsList.clear();
        arrayAdapter.notifyDataSetChanged();
    }

    private void addClickListener(DatabaseReference ref, final String animal) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    long clickCount = dataSnapshot.getValue(Long.class);
                    updateList(animal, clickCount);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("PlacarFragment", "Database error: " + databaseError.getMessage());
            }
        });
    }

    private void updateList(String animal, long clickCount) {
        clickCountsList.removeIf(entry -> entry.startsWith(animal + ":"));
        clickCountsList.add(animal + ": " + clickCount);
        clickCountsList.sort((o1, o2) -> {
            long count1 = Long.parseLong(o1.split(": ")[1]);
            long count2 = Long.parseLong(o2.split(": ")[1]);
            return Long.compare(count2, count1);
        });
        arrayAdapter.notifyDataSetChanged();
    }

}