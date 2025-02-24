package com.medicare.womenhealth.network

data class McrCareResponse(
    var patientID: Long,
    var prediction: List<Int>
)