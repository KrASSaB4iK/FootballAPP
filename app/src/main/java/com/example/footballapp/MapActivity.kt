package com.example.footballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import java.io.File
import java.io.IOException
import java.util.*

lateinit var mapView: MapView
class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("bc80e7f5-6039-4af5-84bf-ed25bb6c0201")
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_map)
        mapView = findViewById(R.id.mapview)
        mapView.map.move(CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
         Animation(Animation.Type.SMOOTH, 0.0f),
        null)
        var mappoint = Point(55.3, 45.2)
        var latitude = 55.676636
        var longitude = 37.681299
        var i = 0
        val numbers: Array<Double> = arrayOf(55.686879, 37.688566, 55.674861, 37.687253,55.669361,
            37.658814,55.671544, 37.657105,55.669150,37.653300,55.666091, 37.655211,
            55.682424, 37.670033,55.664737, 37.656225)
        while (i < 16) {
            latitude = numbers[i]
            i++
            longitude = numbers[i]
            i++
            mappoint = Point(latitude, longitude)
            mapView.map.mapObjects.addPlacemark(mappoint)
        }
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
    override fun onStart() {
        mapView.onStart()
        MapKitFactory.getInstance().onStart()
        super.onStart()
    }
}