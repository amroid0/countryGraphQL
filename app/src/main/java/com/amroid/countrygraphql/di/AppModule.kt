package com.amroid.countrygraphql.di

import com.amroid.countrygraphql.data.ApolloCountryClient
import com.amroid.countrygraphql.domain.usecases.GetCountryDetailUseCase
import com.amroid.countrygraphql.domain.usecases.GetCountryListUseCase
import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder().serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideApolloCountryClient(apolloClient: ApolloClient): ApolloCountryClient {
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideListUseCase(apolloCountryClient: ApolloCountryClient): GetCountryListUseCase {
        return GetCountryListUseCase(apolloCountryClient)
    }

    @Provides
    @Singleton
    fun provideDetailUseCase(apolloCountryClient: ApolloCountryClient): GetCountryDetailUseCase {
        return GetCountryDetailUseCase(apolloCountryClient)
    }

}