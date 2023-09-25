package com.onurdemir.cryptoapp.dependencyinjection

import com.onurdemir.cryptoapp.repository.CryptoRepository
import com.onurdemir.cryptoapp.service.CryptoAPI
import com.onurdemir.cryptoapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCryptoRepository(
        api : CryptoAPI
    ) = CryptoRepository(api)

    @Singleton
    @Provides
    fun providesCryptoApi() : CryptoAPI {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(CryptoAPI::class.java)
    }


}