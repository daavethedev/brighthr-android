package com.brighthr.technicaltest.brightones

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Added Application class which was needed for DaggerHilt2 implementation.
 * Also added in Manifest.
* */

@HiltAndroidApp
class BrightHR : Application()