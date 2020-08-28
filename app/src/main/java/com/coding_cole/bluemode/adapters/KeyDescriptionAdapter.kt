package com.coding_cole.bluemode.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.coding_cole.bluemode.R
import com.coding_cole.bluemode.models.SoftwareKey
import kotlinx.android.synthetic.main.key_discription_item.view.*

class KeyDescriptionAdapter : RecyclerView.Adapter<KeyDescriptionAdapter.KeyDescriptionViewHolder>() {

    class KeyDescriptionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<SoftwareKey>() {
        override fun areItemsTheSame(oldItem: SoftwareKey, newItem: SoftwareKey): Boolean {
            return oldItem.windows == newItem.windows
        }

        override fun areContentsTheSame(oldItem: SoftwareKey, newItem: SoftwareKey): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeyDescriptionViewHolder {
        return KeyDescriptionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.key_discription_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: KeyDescriptionViewHolder, position: Int) {
        val softwareKey = differ.currentList[position]
        holder.itemView.apply {
            key.text = softwareKey.windows
            discription.text = softwareKey.description
        }
    }

}