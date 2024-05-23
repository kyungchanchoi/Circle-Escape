package com.example.circleescape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.circleescape.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var introBinding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 완료
        introBinding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(introBinding.root)

        // 화면 터치시 메인으로 이동



    }
}