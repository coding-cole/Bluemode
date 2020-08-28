package com.coding_cole.bluemode.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coding_cole.bluemode.R
import com.coding_cole.bluemode.models.Shortcuts
import kotlinx.android.synthetic.main.shortcut_keys_list_item.view.*

class ShortcutsListAdapter : RecyclerView.Adapter<ShortcutsListAdapter.ShortcutsViewHolder>() {

    class ShortcutsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Shortcuts>() {
        override fun areItemsTheSame(oldItem: Shortcuts, newItem: Shortcuts): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Shortcuts, newItem: Shortcuts): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortcutsViewHolder {
        return ShortcutsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.shortcut_keys_list_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ShortcutsViewHolder, position: Int) {
        val shortcuts = differ.currentList[position]
        holder.itemView.apply {
            software_name.text = shortcuts.softwareTittle
            Glide
                .with(software_img.context)
                .load(shortcuts.id)
                .circleCrop()
                .error(R.mipmap.ic_launcher)
                .into(software_img)

            setOnClickListener {
                onItemClickListener?.let { it(shortcuts) }
            }
        }
    }

    private var onItemClickListener: ((Shortcuts) -> Unit)? = null

    fun setOnItemClickListener(listener: (Shortcuts) -> Unit) {
        onItemClickListener = listener
    }

}