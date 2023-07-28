package com.saurabh.cameraxcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.saurabh.cameraxcompose.composable.CameraCompose
import com.saurabh.cameraxcompose.ui.theme.CameraxComposeTheme
import com.saurabh.cameraxcompose.utils.Commons.allPermissionsGranted
import com.saurabh.cameraxcompose.camerax.CameraX

class MainActivity : ComponentActivity() {
    private var cameraX: CameraX = CameraX(this, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CameraxComposeTheme {
                CameraCompose(this, cameraX = cameraX) {
                    if (allPermissionsGranted(this)) {
                        cameraX.capturePhoto()
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CameraxComposeTheme {

    }
}