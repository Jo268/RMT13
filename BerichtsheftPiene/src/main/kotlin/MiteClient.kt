import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request
import java.time.LocalDate

class MiteClient(val client: OkHttpClient, val apiKey: String) {
    fun fetchEntries(start: LocalDate, end: LocalDate): List<String> {
        // Read the api-key from file
        val request = Request.Builder()
            .url("https://smartsquare.mite.yo.lk/time_entries.json?api_key=$apiKey&from=$start&to=$end")
            .build()
        val responseBody = client.newCall(request).execute().body
        val gson = Gson()
        val wrapList : List<Wrapper> = gson.fromJson(responseBody!!.string(), object : TypeToken<List<Wrapper>>() {}.type)
        return wrapList.map { it.time_entry.note }
    }
}