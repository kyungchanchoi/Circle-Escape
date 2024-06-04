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

        // 프레그먼트 호출
        pBinding.run {
            pBinding.button.setOnClickListener {
                setFragment(PlayFragment()) // 클래스 형식의 PlayFragment()를 객체화해서 넘겨줌
                                            // fragment_play.xml이 PlayFragment 클래스를 객체화 한 것
            }

            pBinding.button2.setOnClickListener {
                setFragment(PlayFragment2())
            }
        }
    }

    // Fragment 세팅 함수
    private fun setFragment(frag : Fragment) { // 인자로 Fragment를 받는다
        supportFragmentManager.commit {// 사용자 상호작용에 맞춰 Fragment를 추가하거나 삭제
            replace(R.id.frlayout, frag) // 액티비티의 프레임레이아웃에 인자로 받은 Fragment를
            setReorderingAllowed(true) // 애니메이션, 전환의 올바른 작동을 위해 트랜잭션 관련 Fragment의 상태 변경 최적화
            addToBackStack("") // 뒤로가기시 겹쳐진 이전 Fragment를 띄움
        }
    }

}