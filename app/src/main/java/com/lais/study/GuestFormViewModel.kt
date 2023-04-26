package com.lais.study

import Repository.GuestRepository
import android.app.Application
import androidx.lifecycle.AndroidViewModel

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

 private  val repository = GuestRepository.getInstance(application)

 fun insert(guest:GuestModel){
  repository.insert(guest)
 }
}