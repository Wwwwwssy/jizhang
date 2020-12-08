package cn.edu.jizhang.adapter

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter



@Suppress("DEPRECATION")
class RecordAdapter(fm: FragmentManager, fragmentList: ArrayList<Fragment>) : FragmentPagerAdapter(fm){
    var fmList = arrayListOf<Fragment>()
    init {
        fmList = fragmentList
    }
    var titles = arrayOf("支出", "收入")
    override fun getItem(p0: Int): Fragment = fmList[p0]
    override fun getCount(): Int {
        val size = fmList.size
        return size
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}





