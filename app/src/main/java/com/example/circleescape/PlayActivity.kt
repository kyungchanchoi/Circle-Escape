package com.example.circleescape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.circleescape.databinding.ActivityPlayBinding
import com.example.circleescape.databinding.FragmentPlayBinding

class PlayActivity : AppCompatActivity() {

    // 바인딩
    private lateinit var pBinding: ActivityPlayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_play)

        // 액티비티 바인딩
        pBinding = ActivityPlayBinding.inflate(layoutInflater)
        setContentView(pBinding.root)

    }
}