package com.study.compose_ui_practice.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

//Room DB example
@Entity(tableName = "customers")
class Customer {
    @PrimaryKey(autoGenerate = true)
    @Nonnull
    @ColumnInfo(name = "customerId")
    var id : Int = 0

    @ColumnInfo(name = "customerName")
    var name: String? = null

    // @ColumnInfo가 없으면 db에 저장은 되는데 SQL 구문에서 참조될 필요는 없음을 의미
    var address: String? = null

    constructor() {}

    constructor(id:Int, name:String, address:String) {
        this.id = id
        this.name = name
        this.address = address
    }

    constructor(name:String, address:String) {
        this.name = name
        this.address = address
    }

}