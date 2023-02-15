package com.auto.deezomatic.activities

import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import api.deezer.DeezerApi
import api.deezer.objects.Permission
import com.auto.deezomatic.R

// import androidx.car.app.CarContext
// using androidx.car.app.Screen
// using androidx.car.app.model.WebTemplate
// using androidx.car.app.model.Template


class DeezomaticMainActivity : AppCompatActivity() {

    private lateinit var web: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deezerApi = DeezerApi()

        val loginUrl: String = deezerApi.auth().getLoginUrl(
            581184,
            "https://callback.deezomatic.com",
            Permission.BASIC_ACCESS
        )

        /*
        web = findViewById(R.id.web)
        web.webViewClient = WebViewClient()
        web.settings.javaScriptEnabled = true
        web.getSettings().setUserAgentString(System.getProperty("http.agent"))
        web.loadUrl(loginUrl)
        */

        val url = "https://google.com/"
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))

        /*CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(getSession());
            builder.setToolbarColor(Color.parseColor(TOOLBAR_COLOR)).setShowTitle(true);
            prepareMenuItems(builder);
            prepareActionButton(builder);
            prepareBottombar(builder);
            builder.setStartAnimations(this, R.anim.slide_in_right, R.anim.slide_out_left);
            builder.setExitAnimations(this, R.anim.slide_in_left, R.anim.slide_out_right);
            builder.setCloseButtonIcon(
                    BitmapFactory.decodeResource(getResources(), R.drawable.ic_arrow_back));
            CustomTabsIntent customTabsIntent = builder.build();
            CustomTabsHelper.addKeepAliveExtra(this, customTabsIntent.intent);
            customTabsIntent.launchUrl(this, Uri.parse(url));*/
/*
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(loginUrl);
        startActivity(intent)
*/

//        if(intent.resolveActivity(getPackageManager()) != null) {
        //           startActivity(intent)
        //       };

    }
}

/*
class WebScreen(carContext: CarContext, uri: Uri) : Screen(carContext) {
    private val mUri: Uri = uri

    override fun onGetTemplate(): Template {
        return WebTemplate.Builder(mUri).setTitle("My Web Page").build()
    }
}
*/