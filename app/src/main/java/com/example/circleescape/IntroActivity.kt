package com.example.circleescape

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.example.circleescape.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var introBinding: ActivityIntroBinding

    // 애니메이션을 지연 초기화하기 위해 lateinit 사용
    private lateinit var fadeinAnim: Animation
    private lateinit var fadeoutAnim: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩 완료
        introBinding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(introBinding.root)

        val warntext1 = introBinding.textView1
        val warntext2 = introBinding.textView2
        val introtitleimg = introBinding.imageView

        // 애니메이션 객체
        val fadeinAnim = AnimationUtils.loadAnimation(this, R.anim.fadeinanimation)
        val fadeoutAnim = AnimationUtils.loadAnimation(this, R.anim.fadeoutanimation)

        introtitleimg.visibility = View.INVISIBLE

        // 3초간 경고 텍스트를 보여줌
        Handler(Looper.getMainLooper()).postDelayed({
            warntext1.startAnimation(fadeinAnim)
            warntext2.startAnimation(fadeinAnim)

            warntext1.visibility = View.INVISIBLE
            warntext2.visibility = View.INVISIBLE

            introtitleimg.startAnimation(fadeoutAnim)

            introtitleimg.visibility = View.VISIBLE
        }, 5000)

    }

    // 액티비티 클래스에 터치이벤트 콜백 함수 onTouchEvent() 선언
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            // 화면에 손을 눌렀다 땠을 때(올렸을 때)
            MotionEvent.ACTION_UP-> {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

                // overrideActivityTransition(Activity.OR.anim.fadeinanimation,R.anim.fadeoutanimation)
            }
        }
        return super.onTouchEvent(event)
    }
}