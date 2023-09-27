package com.tyupik.teating.di

import com.tyupik.teating.business.IEatingRepository
import com.tyupik.teating.data.EatingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface EatingListModule {

    @Singleton
    @Binds
    fun bindRepository(impl: EatingRepository): IEatingRepository

}