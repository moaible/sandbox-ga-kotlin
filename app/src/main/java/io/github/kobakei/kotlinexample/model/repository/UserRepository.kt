package io.github.moaible.kotlinexample.model.repository

import io.github.moaible.kotlinexample.model.dao.UserDao
import io.github.moaible.kotlinexample.model.entity.User
import io.github.moaible.kotlinexample.model.net.GitHubApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * user entityに対するリポジトリ
 * CRUDを提供します。
 *
 * このサンプルは機能が少ないので、ビューモデルから直接呼ばれますが
 * 規模の大きいアプリではビューモデルとリポジトリの間にユースケース層を挟む事が多いです
 *
 * Created by moaible on 2017/12/13.
 */
@Singleton
class UserRepository
@Inject constructor(private val gitHubApi: GitHubApi, private val userDao: UserDao) {

    var dirty: Boolean = true

    /**
     * 指定のユーザー／リポジトリのコントリビュータを取得する
     */
    fun findContributorsByRepo(owner: String, repo: String): Single<List<User>> {
        if (dirty) {
            return gitHubApi.listContributors(owner, repo)
                    .flatMap {
                        repos -> userDao.deleteAll().map { repos }
                    }
                    .flatMap {
                        repos -> userDao.insertAll(repos).map { repos }
                    }
                    .doOnSuccess { dirty = false }
        } else {
            return userDao.findAll()
        }
    }

    /**
     * 指定のIDのユーザーを取得する
     */
    fun findUserById(userId: Long): Single<User> {
        return userDao.findById(userId)
    }

}