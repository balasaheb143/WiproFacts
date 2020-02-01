
package com.wipro.facts.data.model.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ApiError(private val errorCode: Int, @field:Expose
@field:SerializedName("status_code")
val statusCode: String?, @field:Expose
               @field:SerializedName("message")
               val message: String?) {

    override fun equals(`object`: Any?): Boolean {
        if (this === `object`) {
            return true
        }
        if (`object` == null || javaClass != `object`.javaClass) {
            return false
        }

        val apiError = `object` as ApiError?

        if (errorCode != apiError!!.errorCode) {
            return false
        }
        if (if (statusCode != null)
                    statusCode != apiError.statusCode
                else
                    apiError.statusCode != null) {
            return false
        }
        return if (message != null) message == apiError.message else apiError.message == null

    }

    override fun hashCode(): Int {
        var result = errorCode
        result = 31 * result + (statusCode?.hashCode() ?: 0)
        result = 31 * result + (message?.hashCode() ?: 0)
        return result
    }
}
