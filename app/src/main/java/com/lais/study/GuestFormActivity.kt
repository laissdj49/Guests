package com.lais.study

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.lais.study.databinding.ActivityGuestFormBinding
import constants.DataBaseConstants

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)
        binding.buttonPresent.isChecked = true
    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttonSave) {
            val name = binding.spaceName.text.toString()
            val presence = binding.buttonPresent.isChecked
            val model = GuestModel(0, name, presence)
            viewModel.insert(model)
        }
    }

   private fun loadDate(){
       val bundel = intent.extras
       if (bundel != null){
           val guestId = bundel.getInt(DataBaseConstants.GUEST.ID)
           viewModel.get(guestId)
       }

    }
}