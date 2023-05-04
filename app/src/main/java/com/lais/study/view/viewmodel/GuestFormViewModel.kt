package com.lais.study.view.viewmodel

import Repository.GuestRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lais.study.model.GuestModel
import com.lais.study.model.SuccessFailure

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository.getInstance(application)

    private val guestModel = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = guestModel

    //Recebe as atualizacoes
    private val _saveGuest = MutableLiveData<SuccessFailure>()
    val saveGuest: LiveData<SuccessFailure> = _saveGuest

    fun save(guest: GuestModel) {
        val successFailure = SuccessFailure(true, "")
        if (guest.id == 0) {
            successFailure.success = repository.insert(guest)
        } else {
            successFailure.success = repository.update(guest)
            }
        _saveGuest.value = successFailure
        }

    fun get(id: Int) {
        guestModel.value = repository.get(id)
    }
}