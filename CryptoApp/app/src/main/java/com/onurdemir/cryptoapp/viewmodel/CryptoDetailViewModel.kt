package com.onurdemir.cryptoapp.viewmodel

import androidx.lifecycle.ViewModel
import com.onurdemir.cryptoapp.model.Crypto
import com.onurdemir.cryptoapp.repository.CryptoRepository
import com.onurdemir.cryptoapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository : CryptoRepository
) : ViewModel() {

    suspend fun getCrypto(id : String) : Resource<Crypto> {
        return repository.getCrypto(id)
    }

}

