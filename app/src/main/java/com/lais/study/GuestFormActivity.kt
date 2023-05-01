package com.lais.study

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lais.study.databinding.ActivityGuestFormBinding
import constants.DataBaseConstants

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel

    private var guestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)
        binding.buttonPresent.isChecked = true

        observe()
        loadDate()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttonSave) {
            val name = binding.spaceName.text.toString()
            val presence = binding.buttonPresent.isChecked
            val model = GuestModel(guestId, name, presence)
            viewModel.save(model)
        }
    }

    private fun observe() {
        viewModel.guest.observe(this, Observer {
            binding.spaceName.setText(it.name)
            if (it.presence) {
                binding.buttonPresent.isChecked = true
            } else {
                binding.buttonAbsent.isChecked = true
            }
        })

        viewModel.saveGuest.observe(this, Observer {

            if (it != "") {
                Toast.makeText(applicationContext, it, Toast.LENGTH_SHORT)
                    .show()
                finish()
            }
        })
    }

    private fun loadDate() {
        val bundel = intent.extras
        if (bundel != null) {
            guestId = bundel.getInt(DataBaseConstants.GUEST.ID)
            viewModel.get(guestId)
        }

    }
}