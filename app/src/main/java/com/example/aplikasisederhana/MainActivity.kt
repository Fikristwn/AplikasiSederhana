package com.example.aplikasisederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aplikasisederhana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menggunakan View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol untuk menghitung volume tabung
        binding.btnCalculateVolume.setOnClickListener {
            val radius = binding.inputRadius.text.toString().toDoubleOrNull()
            val height = binding.inputHeight.text.toString().toDoubleOrNull()

            if (radius != null && height != null) {
                val volume = calculateCylinderVolume(radius, height)
                binding.outputResult.text = "Volume Tabung: $volume"
            } else {
                binding.outputResult.text = "Masukkan nilai yang valid."
            }
        }

        // Tombol untuk menghitung luas permukaan tabung
        binding.btnCalculateArea.setOnClickListener {
            val radius = binding.inputRadius.text.toString().toDoubleOrNull()
            val height = binding.inputHeight.text.toString().toDoubleOrNull()

            if (radius != null && height != null) {
                val area = calculateCylinderSurfaceArea(radius, height)
                binding.outputResult.text = "Luas Permukaan Tabung: $area"
            } else {
                binding.outputResult.text = "Masukkan nilai yang valid."
            }
        }
    }

    // Fungsi untuk menghitung volume tabung
    private fun calculateCylinderVolume(radius: Double, height: Double): Double {
        return Math.PI * radius * radius * height
    }

    // Fungsi untuk menghitung luas permukaan tabung
    private fun calculateCylinderSurfaceArea(radius: Double, height: Double): Double {
        return 2 * Math.PI * radius * (radius + height)
    }
}
