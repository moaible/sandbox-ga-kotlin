package io.github.moaible.kotlinexample.model.dao

import android.content.Context
import io.github.moaible.kotlinexample.model.entity.OrmaDatabase

/**
 * OrmaDatabaseをラップするだけのクラス
 * kaptの制限のために必要
 *
 * Created by moaible on 2017/12/13.
 */
class OrmaHolder(val context: Context) {

    val ormaDatabase: OrmaDatabase = OrmaDatabase.builder(context).build()

}