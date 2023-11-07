package com.fa.cellularexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fa.cellularexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var contentCounter: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val headerItems: MutableList<String> =
            mutableListOf("Full Name", "Age", "OCCUPATION", "Country")
        val contentItems: MutableList<String> = mutableListOf()

        val persons: List<Person> = listOf(
            Person("Furkan Ayaz", 22, "Software Developer", "Türkiye"),
            Person("Mehmet Esen", 28, "Doctor", "Türkiye"),
            Person("KEVIN WHITE", 34, "Police Officer", "USA"),
            Person("Laure Carpenter", 39, "Medicine", "UK"),
            Person("Laure Carpenter", 39, "Medicine", "UK"),
            Person("STEPHEN KING", 39, "WRITER", "USA")
        )

        persons.forEach {
            contentItems.add(it.name)
            contentItems.add(it.age.toString())
            contentItems.add(it.job)
            contentItems.add(it.country)
        }

        /*
         *  Programmatically...
            val cellular = Cellular(context = this@MainActivity, properties = Properties())
            cellular.setItems(headerItems = headerItems, contentItems = contentItems)
            binding.clMain.addView(cellular.build())
        *
        * */

        binding.cellular.setItems(headerItems = headerItems, contentItems = contentItems)
        binding.cellular.build()

        binding.btnAddContentItem.setOnClickListener {
            contentCounter++
            binding.cellular.setContentItem(
                item = listOf(
                    "Try $contentCounter",
                    "Try $contentCounter",
                    "Try $contentCounter",
                    "Try $contentCounter"
                )
            )
        }

    }
}