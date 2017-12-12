package io.github.moaible.kotlinexample.model.dao

import io.github.moaible.kotlinexample.model.dao.OrmaHolder
import io.github.moaible.kotlinexample.model.entity.OrmaDatabase
import io.github.moaible.kotlinexample.model.entity.User
import io.github.moaible.kotlinexample.model.entity.User_Relation
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * DAO for user
 * Ormaをラップしています
 *
 * Created by moaible on 2017/12/13.
 */
@Singleton
class UserDao @Inject constructor(ormaHolder: OrmaHolder) {

    val ormaDatabase: OrmaDatabase = ormaHolder.ormaDatabase

    private fun relation(): User_Relation {
        return ormaDatabase.relationOfUser()
    }

    fun findById(id: Long): Single<User> {
        return relation().selector()
                .idEq(id)
                .executeAsObservable()
                .firstOrError()
    }

    fun findAll(): Single<List<User>> {
        return relation().selector()
                .executeAsObservable()
                .toList()
    }

    fun insertAll(users: Iterable<User>): Single<List<Long>> {
        return relation().inserter()
                .executeAllAsObservable(users)
                .toList()
    }

    fun deleteAll(): Single<Int> {
        return relation().deleter()
                .executeAsSingle()
    }
}