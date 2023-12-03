package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.abstraction.datasource.ActionLocalDataSource
import com.example.abstraction.datasource.ActionRemoteDataSource
import com.example.abstraction.datasource.PokedexRemoteDataSource
import com.example.abstraction.repository.ActionRepository
import com.example.abstraction.repository.PokedexRepository
import com.example.data.api.service.ActionService
import com.example.data.api.service.PokedexService
import com.example.data.database.AppDatabase
import com.example.data.database.dao.PokemonDao
import com.example.data.datasource.ActionLocalDataSourceImpl
import com.example.data.datasource.ActionRemoteDataSourceImpl
import com.example.data.datasource.PokedexRemoteDataSourceImpl
import com.example.data.repository.ActionRepositoryImpl
import com.example.data.repository.PokedexRepositoryImpl
import com.example.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataInject {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "pokedex"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(appDatabase: AppDatabase): PokemonDao {
        return appDatabase.pokemonDao()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL: String): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    @Named("action_retrofit")
    fun provideLocalRetrofit(
        okHttpClient: OkHttpClient,
        @Named("action") BASE_URL: String
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun providePokedexService(retrofit: Retrofit) = retrofit.create(PokedexService::class.java)


    @Singleton
    @Provides
    fun provideActionService(@Named("action_retrofit") retrofit: Retrofit) =
        retrofit.create(ActionService::class.java)

    @Singleton
    @Provides
    fun providePokedexRemoteDataSource(
        pokedexService: PokedexService
    ): PokedexRemoteDataSource = PokedexRemoteDataSourceImpl(
        pokedexService
    )

    @Singleton
    @Provides
    fun provideActionRemoteDataSource(
        actionService: ActionService
    ): ActionRemoteDataSource = ActionRemoteDataSourceImpl(
        actionService
    )

    @Singleton
    @Provides
    fun providePokedexRepository(
        pokedexRemoteDataSource: PokedexRemoteDataSource
    ): PokedexRepository = PokedexRepositoryImpl(
        pokedexRemoteDataSource
    )

    @Singleton
    @Provides
    fun provideActionLocalDataSource(pokemonDao: PokemonDao): ActionLocalDataSource =
        ActionLocalDataSourceImpl(pokemonDao)

    @Singleton
    @Provides
    fun provideActionRepository(
        actionRemoteDataSource: ActionRemoteDataSource,
        actionLocalDataSource: ActionLocalDataSource
    ): ActionRepository = ActionRepositoryImpl(actionRemoteDataSource, actionLocalDataSource)

    @Singleton
    @Provides
    fun provideGetPokemonsUseCase(
        pokedexRepository: PokedexRepository
    ) = GetPokemonsUseCase(pokedexRepository)

    @Singleton
    @Provides
    fun provideGetDetailPokemonUseCase(
        pokedexRepository: PokedexRepository
    ) = GetPokemonDetailUseCase(pokedexRepository)

    @Singleton
    @Provides
    fun provideGetCatchUseCase(
        actionRepository: ActionRepository
    ) = GetCatchUseCase(actionRepository)

    @Singleton
    @Provides
    fun provideGetRenameUseCase(
        actionRepository: ActionRepository
    ) = GetRenameUseCase(actionRepository)

    @Singleton
    @Provides
    fun provideGetReleaseUseCase(
        actionRepository: ActionRepository
    ) = GetReleaseUseCase(actionRepository)

    @Singleton
    @Provides
    fun provideGetPokemonsInventoryUseCase(
        actionRepository: ActionRepository
    ) = GetPokemonsInventoryUseCase(actionRepository)
}