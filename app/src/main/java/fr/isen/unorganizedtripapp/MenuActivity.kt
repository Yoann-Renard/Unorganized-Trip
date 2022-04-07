package fr.isen.unorganizedtripapp

import android.content.Intent
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity

open class MenuActivity: AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        val menuHome = menu?.findItem(R.id.homeButton)?.actionView
        menuHome?.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        return true
    }
}