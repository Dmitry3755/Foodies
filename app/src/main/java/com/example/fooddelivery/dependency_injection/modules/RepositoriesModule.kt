package com.example.fooddelivery.dependency_injection.modules

import com.example.data.repositories_impl.network_impl.categories.CategoryNetRepositoriesImpl
import com.example.data.repositories_impl.network_impl.products.ProductNetRepositoriesImpl
import com.example.domain.network.categories.repositories.CategoryNetRepository
import com.example.domain.network.products.repositories.ProductNetRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module(includes = [RetrofitModule::class])
@InstallIn(ViewModelComponent::class)
interface RepositoriesModule {

    @Binds
    @ViewModelScoped
    fun bindsProductNetRepository(productNetRepositoriesImpl: ProductNetRepositoriesImpl): ProductNetRepository

    @Binds
    @ViewModelScoped
    fun bindsCategoryNetRepository(categoryNetRepositoriesImpl: CategoryNetRepositoriesImpl): CategoryNetRepository
}