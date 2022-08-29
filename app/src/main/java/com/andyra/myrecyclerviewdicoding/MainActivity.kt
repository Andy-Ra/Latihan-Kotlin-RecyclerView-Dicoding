package com.andyra.myrecyclerviewdicoding

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private val mlist = ArrayList<Hero>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        mlist.addAll(listHeroes)
        showRecyclerList()
    }

    private val listHeroes: ArrayList<Hero>
    get(){
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listhero = ArrayList<Hero>()

        for (i in dataName.indices){
            val mhero = Hero(dataName[i], dataDescription[i], dataPhoto[i])
            listhero.add(mhero)
        }
        return listhero
    }

    private fun showRecyclerList(){
        if(applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            rvHeroes.layoutManager = GridLayoutManager(this, 2)
        }
        else{
            rvHeroes.layoutManager = LinearLayoutManager(this)
        }
        val mlistHeroAdapter = ListHeroAdapter(mlist)
        rvHeroes.adapter = mlistHeroAdapter
    }
}