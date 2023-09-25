package com.onurdemir.cryptoapp.repository

import com.onurdemir.cryptoapp.model.Crypto
import com.onurdemir.cryptoapp.model.CryptoList
import com.onurdemir.cryptoapp.service.CryptoAPI
import com.onurdemir.cryptoapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository@Inject constructor(
    private val api: CryptoAPI
) {

    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList()
        } catch(e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto()
        } catch(e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}

/*
@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api : CryptoAPI
) {

    suspend fun getCryptoList() : Resource<CryptoList> {
        val response = try {

            api.getCryptoList(API_KEY)

        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id : String) : Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY, id, CALL_ATTRIBUTES)
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

}

 */