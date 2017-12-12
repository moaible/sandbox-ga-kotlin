package io.github.moaible.kotlinexample.model.net

import io.github.moaible.kotlinexample.model.entity.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * GitHub API
 * Created by moaible on 2017/12/13.
 */
interface GitHubApi {

    @GET("/repos/{owner}/{repo}/contributors")
    fun listContributors(@Path("owner") owner: String,
                         @Path("repo") repo: String): Single<List<User>>
}