package uz.artikov.modul_6_lesson_8_test2_2

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import uz.artikov.modul_6_lesson_8_test2_2.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        MyAsyncTask().execute()

    }

    inner class MyAsyncTask : AsyncTask<Void, Void, Void>() {

        override fun onPreExecute() {
            super.onPreExecute()
            binding.tv.text = "Loading..."
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)

        }

        override fun doInBackground(vararg p0: Void?): Void? {
            try {

                for (i in 0..20) {
                    binding.progressBar.progress = i
                    TimeUnit.SECONDS.sleep(1)
                }

                TimeUnit.SECONDS.sleep(5)
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return null

        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            binding.tv.text = "Welcome"
            binding.imageFon.setImageResource(R.drawable.five)
            binding.progressBar.visibility = View.INVISIBLE
        }

    }

}