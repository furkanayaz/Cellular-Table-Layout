package com.fa.cellularexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.fa.cellular.Cellular
import com.fa.cellular.models.HeaderProperties
import com.fa.cellular.models.Properties

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clMain: ConstraintLayout = findViewById(R.id.clMain)

        val headerItems: List<String> = listOf("Full Name", "Age", "OCCUPATION", "Country")

        val contentItems: MutableList<String> = mutableListOf()

        val persons: List<Person> = listOf(
            Person("Furkan Ayaz", 22, "Software Developer", "Türkiye"),
            Person("Mehmet Esen", 28, "Doctor", "Türkiye"),
            Person("KEVIN WHITE", 34, "Police Officer", "USA"),
            Person("Laure Carpenter", 39, "Medicine", "UK"),
            Person("STEPHEN KING", 39, "Writer", "USA")
        )

        persons.forEach {
            contentItems.add(it.name)
            contentItems.add(it.age.toString())
            contentItems.add(it.job)
            contentItems.add(it.country)
        }

        val builder: Cellular.Builder = Cellular(context = this).Builder(
            properties = Properties(
                headerProperties = HeaderProperties(headerTextSize = 15)
            )
        )
        builder.setItems(
            headerItems = headerItems,
            contentItems = contentItems
        )
        clMain.addView(builder.build())

    }
}