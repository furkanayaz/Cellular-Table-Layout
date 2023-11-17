<img src="https://raw.githubusercontent.com/furkanayaz/Cellular-TableLayout/master/cellular.png" width="180" height="180" title="Logo" align="middle" alt="Cellular Library">

# Cellular is a Table Library on Android!

## SCREENSHOT

<img src="https://raw.githubusercontent.com/furkanayaz/Cellular-TableLayout/master/layout.jpeg" title="Logo" align="middle" alt="Cellular Library">

## How To Install?

**Step 1.** Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```
dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		mavenCentral()
		/*
        	 * If you are currently using Kotlin DSL
        	 * you must replace with maven { url = uri("https://www.jitpack.io" ) } in below code.
		 * 
        	 */
		maven { url 'https://jitpack.io' }
	}
}
```

**Step 2.** Add the dependency

```
dependencies {
	      implementation 'com.github.furkanayaz:Cellular-TableLayout:1.6'
}
```

## How You Can Use?

**Step 1.** You can use this library with xml:

```
<com.fa.cellular.Cellular
        android:id="@+id/cellular"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:contentBgColor="@color/content_bg"
        app:contentBgEffectColor="@color/content_effect_bg"
        app:contentSpacing="5"
        app:contentTextAllCaps="true"
        app:contentTextColor="@color/black"
        app:contentTextGravity="center"
        app:contentActionAnimation="both"
        app:contentTextMaxLines="1"
        app:contentTextSize="14"
        app:enableDivider="true"
        app:headerBgColor="@color/header_bg"
        app:headerSpacing="10"
        app:headerTextAllCaps="true"
        app:headerTextColor="@color/white"
        app:headerTextGravity="center"
        app:headerTextSize="14"
        app:layout_constraintBottom_toTopOf="@+id/btnAddContentItem"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

**Step 1.1.** Don't forget to set items for Cellular :)

```
binding.cellular.setItems(headerItems = headerItems, contentItems = contentItems)
binding.cellular.setContentItem(
      item = listOf(
            "Item $contentCounter",
            "Item $contentCounter",
            "Item $contentCounter",
            "Item $contentCounter"
      )
)
binding.cellular.setOnRowClickListener { items: List<String> ->
      Log.e("Items", items.joinToString(separator = "-"))
}
binding.cellular.build()
```

**Step 2.** You can use this library with programmatically:

```
val cellular = Cellular(context = this@MainActivity, properties = Properties())
cellular.setItems(headerItems = headerItems, contentItems = contentItems)
cellular.setOnRowClickListener { 
      Log.e("Items", items.joinToString(separator = "-"))
}
binding.clMain.addView(cellular.build())
```

## Cellular IN ADDITION

* Contains header columns.
* Contains content rows.
* Contains multi properties for views.

### That's it! I hope you enjoy it with Cellular :)

#### Latest Update

17 Nov, 2023 - Furkan Ayaz
