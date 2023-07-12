package com.example.homework_4fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homework_4fragments.databinding.ItemUserBinding

class UsersAdapter(
    private val users: List<User>,
    private val onListItemClickListener: OnListItemClickListener
): RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersAdapter.UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UsersAdapter.UserViewHolder, position: Int) {
        val user = users[position]
        with(holder.binding) {
            textViewName.text = user.name
            textViewLastname.text = user.lastname
            textViewPhone.text = user.phone
            Glide.with(imageViewPhoto.context)
                .load(user.photo)
                .into(imageViewPhoto)
            holder.itemView.setOnClickListener {
                onListItemClickListener.onItemClicked(user)
            }
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    interface OnListItemClickListener {
        fun onItemClicked(user: User)
    }

    class UserViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root)
}