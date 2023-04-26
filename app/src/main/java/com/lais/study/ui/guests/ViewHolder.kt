package com.lais.study.ui.guests

import android.app.AlertDialog
import android.app.Dialog
import androidx.recyclerview.widget.RecyclerView
import com.lais.study.GuestModel
import com.lais.study.databinding.RowGuestsBinding

class ViewHolder(private val bind: RowGuestsBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        bind.nameGuest.text = guest.name
        bind.nameGuest.setOnClickListener {
            listener.onClick(guest.id)
        }

        bind.nameGuest.setOnLongClickListener {

            AlertDialog.Builder(itemView.context)
                .setTitle("Remoção de convidado")
                .setMessage("Tem certeza que deseja remover?")
                .setPositiveButton(
                    "Sim") { dialog, which ->
                    listener.onDelete(guest.id)
                }
                .setNegativeButton("Não", null)
                .create()
                .show()

            true
        }
    }
}