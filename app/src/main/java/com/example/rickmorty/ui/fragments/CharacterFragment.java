package com.example.rickmorty.ui.fragments;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.rickmorty.R;
import com.example.rickmorty.databinding.FragmentCharacterBinding;
import com.example.rickmorty.ui.App;
import com.example.rickmorty.ui.data.models.MainResponse;
import com.example.rickmorty.ui.data.models.Result;
import com.example.rickmorty.ui.fragments.AdapterCharacter;
import com.example.rickmorty.ui.fragments.detailsFragment.DetailsFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CharacterFragment extends Fragment {

    private FragmentCharacterBinding binding;
    private AdapterCharacter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCharacterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new AdapterCharacter();
        App.service.fetchCharacters().enqueue(new Callback<MainResponse<Result>>() {
            @Override
            public void onResponse(Call<MainResponse<Result>> call, Response<MainResponse<Result>> response) {
                if (response.body() != null) {
                    adapter.setList(response.body().getResults());
                } else {
                    Toast.makeText(requireContext(), "аовылрпшдгурйгпшцшгпийшцп", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MainResponse<Result>> call, Throwable t) {
                Toast.makeText(requireContext(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
        binding.characterRecycler.setAdapter(adapter);
        adapter.onItemClickListener(new AdapterCharacter.OnItemClickListener() {
            @Override
            public void onClick(Result model) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("key",model);
                DetailsFragment detailsFragment = new DetailsFragment();
//                NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);
//                navController.navigate(R.id.detailsFragment);
                detailsFragment.setArguments(bundle);
                Log.e(TAG, "onClick: " + model.getName());
                getParentFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, detailsFragment).commit();

            }
        });

    }
}