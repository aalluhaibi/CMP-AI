package com.plcoding.bookpedia.di

import com.plcoding.bookpedia.book.data.network.KtorRemotePlaceDataSource
import com.plcoding.bookpedia.book.data.network.RemotePlaceDataSource
import com.plcoding.bookpedia.book.domain.PlaceRepository
import com.plcoding.bookpedia.book.presentation.book_detail.BookDetailViewModel
import com.plcoding.bookpedia.book.presentation.book_list.BookListViewModel
import com.plcoding.bookpedia.book.presentation.SelectedBookViewModel
import com.plcoding.bookpedia.core.data.HttpClientFactory
import com.plcoding.bookpedia.book.data.repository.PlaceRepositoryImpl
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemotePlaceDataSource).bind<RemotePlaceDataSource>()
    singleOf(::PlaceRepositoryImpl).bind<PlaceRepository>()
    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}