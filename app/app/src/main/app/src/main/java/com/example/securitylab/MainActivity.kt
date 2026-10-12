package com.example.securitylab

import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = TextView(this).apply {
            textSize = 16f
            setPadding(48, 48, 48, 48)
        }

        val info = packageManager.getPackageInfo(
            packageName,
            PackageManager.GET_PERMISSIONS
        )
        val requested = info.requestedPermissions?.joinToString("\n")
            ?: "Разрешений не запрошено"

        textView.text = "SecurityLab\n\nЗапрошенные разрешения:\n$requested"
        setContentView(textView)
    }
}
