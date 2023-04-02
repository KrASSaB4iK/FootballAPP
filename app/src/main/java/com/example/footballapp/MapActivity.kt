package com.example.footballapp

import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.view.get
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKit
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.layers.ObjectEvent
import com.yandex.mapkit.map.*
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.mapview.MapView
import com.yandex.mapkit.search.Response
import com.yandex.mapkit.search.SearchFactory
import com.yandex.mapkit.search.Session
import com.yandex.mapkit.user_location.UserLocationLayer
import com.yandex.mapkit.user_location.UserLocationObjectListener
import com.yandex.mapkit.user_location.UserLocationView
import com.yandex.runtime.Error
import com.yandex.runtime.image.ImageProvider
import java.io.File
import java.io.IOException
import java.util.*
import java.util.jar.Manifest

class MapActivity : AppCompatActivity(), UserLocationObjectListener, Session.SearchListener, CameraListener {

    lateinit var mapView: MapView
    lateinit var locationmapkit: UserLocationLayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("bc80e7f5-6039-4af5-84bf-ed25bb6c0201")
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_map)
        mapView = findViewById(R.id.mapview)
        mapView.map.move(CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
         Animation(Animation.Type.SMOOTH, 0.0f),
        null)
        var mapKit:MapKit = MapKitFactory.getInstance()
        requestLocationPermisson()
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
        locationmapkit = mapKit.createUserLocationLayer(mapView.mapWindow)
        locationmapkit.isVisible = true
        locationmapkit.setObjectListener(this)
        mapView.map.addCameraListener(this)

    }

    private fun requestLocationPermisson() {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION), 0)
                return
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

    override fun onObjectAdded(userLocationView: UserLocationView) {
        locationmapkit.setAnchor(
            PointF((mapView.width() * 0.5).toFloat(), (mapView.height()*0.5).toFloat()),
            PointF((mapView.width() * 0.5).toFloat(), (mapView.height()*0.5).toFloat())
        )
        userLocationView.arrow.setIcon(ImageProvider.fromResource(this, R.drawable.icons_gps))
        var picicon = userLocationView.pin.useCompositeIcon()
        picicon.setIcon("icon", ImageProvider.fromResource(this, R.drawable.icons_place), IconStyle().
        setAnchor(PointF(0f ,0f))
            .setRotationType(RotationType.NO_ROTATION).setZIndex(0f).setScale(1f))
        picicon.setIcon("pin", ImageProvider.fromResource(this, R.drawable.nothing),
        IconStyle().setAnchor(PointF(0.5f, 05f)).setRotationType(RotationType.ROTATE).setZIndex(1f).setScale(0.5f))
        userLocationView.accuracyCircle.fillColor = Color.BLUE and -0x66000001
    }

    override fun onObjectRemoved(p0: UserLocationView) {
    }

    override fun onObjectUpdated(p0: UserLocationView, p1: ObjectEvent) {
    }

    override fun onSearchResponse(p0: Response) {
    }

    override fun onSearchError(p0: Error) {
        TODO("Not yet implemented")
    }

    override fun onCameraPositionChanged(
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean
    ) {

    }
}