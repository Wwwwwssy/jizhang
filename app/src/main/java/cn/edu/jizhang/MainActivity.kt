package cn.edu.jizhang

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import cn.edu.jizhang.Fragment.RecordActivity

const val ChatFile = "chatFile"
const val CHAT_INTENT = "com.example.fragment.Chart.New"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun onClick(v: View) {
        when (v.id) {
            R.id.mingxi -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
//            R.id.main_iv_search -> {
//                val intent2 = Intent(this, SearchActivity::class.java) //跳转界面
//                startActivity(intent2)
//            }
            R.id.main_btn_edit -> {
                val intent3 = Intent(this, RecordActivity::class.java) //跳转界面
                startActivity(intent3)
            }
//            R.id.main_btn_more -> {
//                val moreDialog = MoreDialog(this)
//                moreDialog.show()
//                moreDialog.setDialogSize()
//            }
//            R.id.item_mainlv_top_tv_budget -> showBudgetDialog()
//            R.id.item_mainlv_top_iv_hide ->                 // 切换TextView明文和密文
//                toggleShow()
//        }
//        if (v === headerView) {
//            //头布局被点击了
//            val intent = Intent()
//            intent.setClass(this, MonthChartActivity::class.java)
//            startActivity(intent)
//        }
        }
    }
}
