package com.example.plantixtest.viewmodels

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.plantixtest.models.DataModel
import com.example.plantixtest.web.IWebrequestDelegate
import com.example.plantixtest.web.webrequest

open class DataCollectorVM() : BaseViewModel(), IWebrequestDelegate {

    private lateinit var mTextVals: MutableLiveData<List<DataModel>>
    private lateinit var mDataList: ArrayList<DataModel>
    private lateinit var mActivity: AppCompatActivity

    constructor(pActivity: AppCompatActivity): this(){
        mTextVals = MutableLiveData<List<DataModel>>()
        mDataList = ArrayList<DataModel>()
        mActivity = pActivity
    }

    open fun getTexts(): LiveData<List<DataModel>> {
        return mTextVals
    }

    open fun loadTexts() {
        for (i in 1..20) {
            var vWebRequest: webrequest = webrequest()
            vWebRequest.mDelegate = this
            vWebRequest.fetchData("testname$i", mActivity)
            //mDataList.add(DataModel("testname $i"))
        }
    }

    override fun webrequestResponse(pResponse: String) {
        mDataList.add(DataModel(pResponse))
        mTextVals.value = mDataList
    }
}