package com.coding_cole.bluemode.models

import androidx.room.Embedded
import androidx.room.PrimaryKey
import java.io.Serializable

data class Shortcuts(
    val softwareImage: String,
    val softwareTittle: String,

    @Embedded(prefix = "softwareKeyList_")
    val softwareKeyList: List<SoftwareKey>
) : Serializable{
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
}