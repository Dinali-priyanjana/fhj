package com.example.prac04new.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.prac04new.R
import com.example.prac04new.models.Photo
import javax.security.auth.callback.Callback

class PhotoAdapter (
    private val photolist:List<Photo>,
    val context: Callback<List<Photo>>,
    private val onItemClicked: (position: Int) -> Unit
        ):RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    class ViewHolder(
        ItemView: view,
        private val onItemClicked: (position: Int) -> Unit

    ):RecyclerView.ViewHolder(ItemView), View.onClickListener{
        val imgView=itemView.findViewById<ImageView>(R.id.imageview)
        val tectTitle = itemView.findViewById<TextView>(R.id.textView)

        override fun onClick(p0:view?){
            val position=adapterPosition
            onItemClicked(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design,parent,false)

                return ViewHolder(view.onItemClicked)
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemViewModel =photolist[position]
        Picasso.get()
            .load(itemViewModel.thumbnailUrl)
            .into(holder.imgView)
        holder.tectTitle.text=itemViewModel.title
        holder.tectTitle.text=itemViewModel.url
    }

    override fun getItemCount(): Int {
        return photolist.size
    }
    }
}

