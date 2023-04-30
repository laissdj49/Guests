package com.lais.study

import Repository.GuestRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    fun save(guest: GuestModel) {
        if (guest.id == 0) {
            repository.insert(guest)
        } else {
            repository.update(guest)
        }

    }

    fun get(id: Int) {
        guestModel.value = repository.get(id)
    }
}