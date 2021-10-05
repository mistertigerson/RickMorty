package com.example.rickmorty.ui.character;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rickmorty.R;
import com.example.rickmorty.databinding.CharacterListItemBinding;
import com.example.rickmorty.databinding.FragmentCharacterBinding;
import com.example.rickmorty.ui.data.models.MainResponse;
import com.example.rickmorty.ui.data.models.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class AdapterCharacter extends RecyclerView.Adapter<AdapterCharacter.ViewHolder> {


    private List<Result> list = new ArrayList<>();

    public void setList(List<Result> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(CharacterListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       private CharacterListItemBinding binding;


        public ViewHolder( CharacterListItemBinding itemView) {

            super(itemView.getRoot());

            binding = itemView;


        }

        public void onBind(Result mainResponse) {
            Glide.with(binding.getRoot()).load(mainResponse.getImage()).centerCrop().into(binding.profileIv);
            binding.nameTv.setText(mainResponse.getName());
            binding.surnameTv.setText(mainResponse.getStatus());
        }
    }
}
