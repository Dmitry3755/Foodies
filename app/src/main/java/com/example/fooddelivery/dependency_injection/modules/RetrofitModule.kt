package com.example.fooddelivery.dependency_injection.modules

import com.example.data.api.CategoriesApi
import com.example.data.api.ProductsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(ViewModelComponent::class)
class RetrofitModule {

    @Provides
    @ViewModelScoped
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://anika1d.github.io/WorkTestServer/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesProductApi(retrofit: Retrofit): ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }

    @Provides
    fun providesCategoriesApi(retrofit: Retrofit): CategoriesApi {
        return retrofit.create(CategoriesApi::class.java)
    }

}