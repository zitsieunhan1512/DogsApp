package com.example.dogsapp.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogsapp.databinding.ItemDogsBinding
import com.example.dogsapp.model.DogBreed

class DogListAdapter(private val dogList: ArrayList<DogBreed>): RecyclerView.Adapter<DogListAdapter.DogViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateDogList(newDogList: List<DogBreed>){
        dogList.clear()
        dogList.addAll(newDogList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = ItemDogsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.binding.name.text = dogList[position].dogBreed
        holder.binding.lifeSpan.text = dogList[position].lifeSpan
    }

    override fun getItemCount() = dogList.size

    class DogViewHolder(var binding: ItemDogsBinding): RecyclerView.ViewHolder(binding.root)
}