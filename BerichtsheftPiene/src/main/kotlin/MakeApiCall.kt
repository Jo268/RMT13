@file:Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.time.LocalDate

//Get Mite data
fun makeApiCall(client: OkHttpClient, mondays: LocalDate): List<String> {
    val   fridays = mondays.plusDays(4)
// Read the api-key from file
    val inputString = object {}.javaClass.getResource("API.txt").readText()
    val request = Request.Builder()
        .url("https://smartsquare.mite.yo.lk/time_entries.json?api_key=$inputString&from=$mondays&to=$fridays")
        .build()
    val responseBody = client.newCall(request).execute().body
    val gson = Gson()
    val wrapList : List<Wrapper> = gson.fromJson(responseBody!!.string(), object : TypeToken<List<Wrapper>>() {}.type)
    return wrapList.map { it.time_entry.note }
}