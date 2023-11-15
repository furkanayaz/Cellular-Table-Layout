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
            Person(fullName = "Furkan Ayaz", 22, "Software Developer", "Türkiye"),
            Person(fullName = "Ahmet Beyaz", 30, "Barber", "Azerbaijan"),
            Person(fullName = "Robert Koen", 52, "Business Analyst", "Germany"),
            Person(fullName = "Oliver James", 28, "Debugger", "France"),
            Person(fullName = "Kuznetsov Lebedev", 34, "YouTuber", "Russia"),
        )

        persons.forEach {
            contentItems.add(it.fullName)
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