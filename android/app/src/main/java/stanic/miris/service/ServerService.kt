package stanic.miris.service

import okhttp3.*
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import org.json.JSONObject
import java.io.IOException

class ServerService {

    fun sendSay(text: String) {
        val mediaType = "application/json".toMediaTypeOrNull()
        val params = JSONObject()

        val client = OkHttpClient()

        val body = RequestBody.create(mediaType, params.toString())

        val builder =
            "http://10.0.2.2:4567/say".toHttpUrlOrNull()!!.newBuilder()
        builder.addQueryParameter("text", text)

        val url = builder.build().toString()

        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println(e.message)
            }
            override fun onResponse(call: Call, response: Response) {
                println("${response.message} | ${response.body.toString()}")
            }
        })
    }

    fun sendCommand(command: String, type: Int) {
        val mediaType = "application/json".toMediaTypeOrNull()
        val params = JSONObject()

        val client = OkHttpClient()

        val body = RequestBody.create(mediaType, params.toString())

        val builder =
            "http://10.0.2.2:4567/command".toHttpUrlOrNull()!!.newBuilder()
        builder.addQueryParameter("command", command)
        builder.addQueryParameter("type", "$type")

        val url = builder.build().toString()

        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {}
        })
    }

}