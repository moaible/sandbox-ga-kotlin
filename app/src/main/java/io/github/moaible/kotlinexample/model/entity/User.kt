package io.github.moaible.kotlinexample.model.entity

import com.github.gfx.android.orma.annotation.Column
import com.github.gfx.android.orma.annotation.PrimaryKey
import com.github.gfx.android.orma.annotation.Table

/**
 * Created by moaible on 2017/11/12.
 */
@Table
data class User(@PrimaryKey(auto = false) var id: Long = 0L,
                @Column var login: String = "",
                @Column var avatar_url: String = "")