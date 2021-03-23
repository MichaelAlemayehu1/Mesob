package com.example.loginmain

import com.google.gson.annotations.SerializedName

class CommentsResponseV3 {
    @SerializedName("record")
    var record = CommentsResponse()
    @SerializedName("metadata")
    var metadata = CommentsMetadata()
}