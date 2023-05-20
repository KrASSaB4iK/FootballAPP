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
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader
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
        var mapObjects = mapView.map.mapObjects.addCollection()
        val image = ImageProvider.fromResource(this,R.drawable.icons_place32)
        var placemark = mapObjects.addPlacemark(Point(55.67482487835571, 37.68544421535417), image)
        var i = 0
        val numbers: Array<Double> = arrayOf(
            55.686961222400676, 37.68850103289731,
            55.68076463080227, 37.70231260159853,
            55.678290561599404, 37.70052763701322,
            55.6692174502178, 37.721291658519064,
            55.68958669231008, 37.728561595146324,
            55.66926151201974, 37.72169514043334,
            55.702623637609825, 37.663448403038004,
            55.702430178807155, 37.639759134278194,
            55.69613612423123, 37.60642273851621,
            55.641270799904675, 37.697604510118396,
            55.65146569323036, 37.71413992463744,
            55.64466939256199, 37.718631024877176,
            55.64956515167789, 37.72373454787689,
            55.651235329470275, 37.73679956675613,
            55.65363140518636, 37.752098330612796,
            55.72241121820711, 37.66188994676151,
            55.737757065190515, 37.66678932884122,
            55.64183992709665, 37.6742007130882,
            55.634953576277084, 37.66480462760945,
            55.62862023127601, 37.6742007130882,
            55.62656167374093, 37.65232326033171, 55.6251364551817, 37.650079419023356, 55.622206676494365, 37.66620702842717, 55.62157318203865, 37.663542466873494, 55.616267264045455, 37.645311256243104, 55.62268179061756, 37.646292936815506,
            55.604227294601806, 37.619927799324394,55.6057324927473, 37.61880587902071, 55.60097903811295, 37.61081219435969, 55.59994904701773, 37.599032027490814, 55.60929720571688, 37.58823354119435, 55.62806601467685, 37.605342831200396, 55.64168163381865, 37.611653634805585,
55.64366025435941, 37.59552602540177, 55.64706324788888, 37.613616995950395, 55.650861589093154, 37.61389747611394, 55.65893184091234, 37.610531714151406, 55.657428685737116, 37.58009961622033, 55.66644675673224, 37.6248362023057,
            55.68257917209141, 37.59608698554238, 55.69538546928931, 37.6167022775629, 55.69601777035291, 37.62006803952544, 55.69585969604585, 37.60632451151175, 55.706765323962365, 37.58388609904716,
            55.708424609228786, 37.593001704362365,
            55.71916875094773, 37.57575217430436,
            55.71363904706477, 37.63409204832165,
            55.7214593992083, 37.634092048716894,
            55.72272314748675, 37.635774929698165,
            55.72351296939361, 37.63437252888044,
            55.722249246674764, 37.66157910474427,
            55.722091278757595, 37.68878568573136,
            55.74064817092297, 37.68976736630377,
            55.74822632122536, 37.70238897366328,
            55.74546362440575, 37.706175455871126,
            55.718457833440795, 37.73604659328863,
            55.71703595847208, 37.73941235525117,
            55.71427105341089, 37.75259492293776,
            55.70328849833872, 37.75988740718992,
            55.69886299941096, 37.77054565340462,
            55.74135868503697, 37.760448367517014,
            55.74096395657071, 37.774332135612475,
            55.749883845418395, 37.782185580191715,
            55.76037986410207, 37.69285264390422,
            55.73749017465392, 37.66718870893989,
            55.76219467849831, 37.67462143327383,
            55.76093220785938, 37.67181663163837,
            55.77434386854971, 37.70070608848347,
            55.79003753980708, 37.68570039973383,
            55.79926152172037, 37.687383280715096,
            55.79437387178007, 37.66326198665026,
            55.77718339298137, 37.64418933552923,
            55.75880169597153, 37.63563469054112,
            55.76613963580873, 37.61908636089199,
            55.7772622657069, 37.64418933552923,
            55.78341384649982, 37.6220314026092,
            55.77655240543065, 37.610671955985644,
            55.737083667414325, 37.57592000817553,
            55.74545188803116, 37.555865676482085,
            55.74916175127165, 37.5917671374158,
            55.7479777906913, 37.56736536318741,
            55.750661383094005, 37.56147527975298,
            55.76447107094829, 37.56666416277856,
            55.779222305, 37.57493832760312,
            55.78663525561911, 37.576340728420845,
            55.78592556607966, 37.590364736598076,
            55.79002581609197, 37.59387073864239,
            55.791445032855314, 37.62065659426089,
            55.79097196658101, 37.53959782500533,
            55.78750263662307, 37.52094589412962,
            55.79105081139817, 37.52753717797292,
            55.793100720626114, 37.52627501723696,
            55.79317956113421, 37.51926301314835,
            55.79751554324534, 37.555585192343656,
            55.74111011092325, 37.47158138336205,
            55.74410993589695, 37.49121499481017,
            55.749161751439054, 37.50425732241499,
            55.749635325610754, 37.49808675881702,
            55.75484426208953, 37.51042788601298,
            55.77109798449888, 37.49163571505549,
            55.774174382808184, 37.4951417170998,
            55.779143436408624, 37.473965464752176,
            55.780168717820246, 37.47663002630585,
            55.780010983974286, 37.45671593469418,
            55.791760407503276, 37.45110633142329,
            55.72467091257624, 37.44536627597842,
            55.7235651902224, 37.46654252832603,
            55.721985532546356, 37.46710348865312,
            55.719378957680235, 37.438634752053346,
            55.712743254792755, 37.45868908374679,
            55.71732517010307, 37.509876713593684,
            55.71384928355793, 37.502443989259746,
            55.70041681562566, 37.533296807249656,
            55.69772976789505, 37.50805359253064,
            55.69109038739355, 37.47818245511314,
            55.69069515061517, 37.494871024844045,
            55.68010131651065, 37.536241848966874,
            55.677887317030226, 37.446908916877916,
            55.67084912928845, 37.45939028415565,
            55.66926733982229, 37.47397525265997,
            55.66879279051313, 37.48561517944707,
            55.66863460613117, 37.48519445920176,
            55.67140274049475, 37.523199521362045,
            55.671086392193175, 37.536382089048644)
        while (i < 248) {
            placemark = mapObjects.addPlacemark(Point(numbers[i], numbers[i+1]), image)
            i = i +2
        }
        placemark.isVisible = true
        placemark.isDraggable = false
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

    private companion object {
        const val FILE_NAME = "football.txt"
    }

    override fun onCameraPositionChanged(
        map: Map,
        cameraPosition: CameraPosition,
        cameraUpdateReason: CameraUpdateReason,
        finished: Boolean
    ) {

    }
}