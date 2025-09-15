package com.study.compose_ui_practice.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.Nonnull

@Entity(tableName = "products")
class Product {

    @PrimaryKey(autoGenerate = true)
    @Nonnull
    @ColumnInfo(name = "productId")
    var id: Int = 0

    @ColumnInfo(name = "productName")
    var productName: String = ""
    var quantity: Int = 0

    constructor()

    constructor(productname:String, quantity:Int) {
        this.productName = productname
        this.quantity = quantity
    }

}