package com.lais.study.ui.guests

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lais.study.GuestModel
import com.lais.study.databinding.RowGuestsBinding

class GuestsAdapter : RecyclerView.Adapter<ViewHolder>() {

    companion object{
        var countCreate = 0
        var countBind =  0
    }
    private lateinit var listener: OnGuestListener
    private var guestList: List<GuestModel> = listOf()


    //criacao do layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        countCreate++
        val item = RowGuestsBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)

        return ViewHolder(item, listener)
    }

    //Atribui os valores para o layout
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        countBind++
       holder.bind(guestList[position])
    }

    //fala o tamanho da listagem
    override fun getItemCount(): Int {
        return guestList.count()
    }

    fun updatedGuest(list: List<GuestModel>) {
        guestList = list
        notifyDataSetChanged()
    }
    fun attachListener(guestListener: OnGuestListener){
        listener = guestListener
    }

}