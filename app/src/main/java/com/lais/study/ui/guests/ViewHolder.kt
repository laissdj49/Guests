package com.lais.study.ui.guests

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.lais.study.GuestModel
import com.lais.study.R
import com.lais.study.databinding.RowGuestsBinding

class ViewHolder(private val bind: RowGuestsBinding, private val listener: OnGuestListener ): RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel){
        bind.nameGuest.text = guest.name
        bind.nameGuest.setOnClickListener{
            listener.onClick(guest.id)
        }

        bind.nameGuest.setOnLongClickListener{
            listener.onDelete(guest.id)
            true
        }
    }
}