package com.tyupik.teating.di

import android.content.Context
import android.content.res.Resources
import androidx.room.Room
import com.tyupik.teating.data.db.EatingRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideResources(@ApplicationContext context: Context): Resources = context.resources

    @Singleton
    @Provides
    fun provideDb(
        @ApplicationContext
        app: Context
    ): EatingRoomDatabase = Room.databaseBuilder(
        app,
        EatingRoomDatabase::class.java,
        "eating_database"
    )
        .build()

    @Singleton
    @Provides
    fun provideDao(db: EatingRoomDatabase) = db.eatingDao()

}