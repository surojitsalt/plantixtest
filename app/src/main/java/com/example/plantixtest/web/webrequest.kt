package com.example.plantixtest.web

import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.plantixtest.utility.GenericUtility
import org.json.JSONException
import org.json.JSONObject

open class webrequest() {
    open lateinit var  mDelegate : IWebrequestDelegate

    fun fetchData(pRequest: String, pContext: AppCompatActivity){
        // Instantiate the RequestQueue.
        val vQueue = Volley.newRequestQueue(pContext)
        val vUrl = getUrl(pRequest) //"https://api.agify.io/?name=$pRequest"
        val vStringRequest = StringRequest(
            Request.Method.GET, vUrl,
            Response.Listener<String>
            { vResponse ->
                var vResponse = parse(vResponse)
                if(vResponse?.has("name") == true){
                    var vName = vResponse.getString("name")
                    mDelegate.webrequestResponse(vName)
                }
            },
            Response.ErrorListener
            {

            })

        vQueue.add(vStringRequest)
        vQueue.start()
    }

    fun getUrl(pRequest: String): String{
        return "${GenericUtility.mServerAddress}$pRequest"
    }

    fun parse(pJson: String): JSONObject? {
        var vJsonObject: JSONObject? = null
        try {
            vJsonObject = JSONObject(pJson)
        } catch (pException: JSONException) {
            pException.printStackTrace()
        }
        return vJsonObject
    }
}