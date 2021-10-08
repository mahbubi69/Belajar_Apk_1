package com.example.belajar_apk.activity

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.belajar_apk.R
import java.lang.ref.WeakReference

class SplassScrenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splass_scren)

        val task = MyAsyncTask(this)
        task.execute()
    }

    companion object {
        class MyAsyncTask internal constructor(context: SplassScrenActivity) :
            AsyncTask<Void, Void, Void>() {

            private val activityReference: WeakReference<SplassScrenActivity> =
                WeakReference(context)

            override fun onPreExecute() {
                val activity = activityReference.get()
                if (activity == null || activity.isFinishing) return
            }

            override fun onPostExecute(result: Void?) {
                val activity = activityReference.get()
                if (activity == null || activity.isFinishing) return
                if (activity.isFinished()) {
                    activity.startActivity(Intent(activity, MainActivity::class.java))
                    activity.finish()
                }
            }

            override fun doInBackground(vararg p0: Void?): Void? {
                try {
                    Thread.sleep(3000)
                } catch (e: Exception) {
                }
                return null
            }
        }
    }

    private fun isFinished(): Boolean {
        val pref = applicationContext.getSharedPreferences("UserData", MODE_PRIVATE)
        return pref.getBoolean("login", true)
    }
}