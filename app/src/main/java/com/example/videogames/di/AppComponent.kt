package com.example.videogames.di

import com.example.core_network_domain.source.PlatformPagingSource
import com.example.core_network_domain.useCase.creator.GetCreatorsUseCase
import com.example.core_network_domain.useCase.game.*
import com.example.core_network_domain.useCase.platform.GetPlatformByIdUseCase
import com.example.core_network_domain.useCase.platform.GetPlatformUseCase
import com.example.feature_main.di.MainDeps
import com.example.feature_platform_info.di.PlatformDeps
import com.example.feature_video_game_info.di.GameInfoDeps
import dagger.Component
import javax.inject.Scope

@[AppScope Component(modules = [ApiModule::class])]
interface AppComponent: MainDeps, GameInfoDeps, PlatformDeps {

    override val getGamesUseCase: GetGamesUseCase

    override val getCreatorsUseCase: GetCreatorsUseCase

    override val getGameInfoUseCase: GetGameInfoUseCase

    override val getAchievementsUseCase: GetAchievementsUseCase

    override val getScreenshotsUseCase: GetScreenshotsUseCase

    override val getDeveloperTeamUseCase: GetDeveloperTeamUseCase

    override val getTrailerUseCase: GetTrailerUseCase

    override val getPlatformUseCase: GetPlatformUseCase

    override val getPlatformByIdUseCase: GetPlatformByIdUseCase
}

@Scope
annotation class AppScope