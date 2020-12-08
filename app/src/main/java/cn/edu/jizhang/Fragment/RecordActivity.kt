package cn.edu.jizhang.Fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import cn.edu.jizhang.R
import cn.edu.jizhang.adapter.RecordAdapter
import com.google.android.material.tabs.TabLayout
import java.util.*

class RecordActivity : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        //1.查找控件
        tabLayout = findViewById(R.id.record_tabs)
        viewPager = findViewById(R.id.record_vp)
        //2.设置ViewPager加载页面
//        initPager()
    }

    private fun initPager() {
//        初始化ViewPager页面的集合
        val fragmentList: MutableList<Fragment> = ArrayList()
        //        创建收入和支出页面，放置在Fragment当中
        val outFrag = outcomingFragment() //支出
        val inFrag = IncomeFragment() //收入
        fragmentList.add(outFrag)
        fragmentList.add(inFrag)

//        创建适配器
        val pagerAdapter = RecordAdapter(supportFragmentManager, fragmentList)
        //设置适配器
        viewPager!!.adapter = pagerAdapter
        //将TabLayout和ViwePager进行关联
        tabLayout!!.setupWithViewPager(viewPager)
    }

    /* 点击事件*/
    fun onClick(view: View) {
        when (view.id) {
            R.id.record_iv_back -> finish()
        }
    }
}