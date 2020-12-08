@file:Suppress("DEPRECATION")

package cn.edu.jizhang.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class RecordAdapter(fm: FragmentManager, fragmentList: List<Fragment>) :
    FragmentPagerAdapter(fm) {
    var fragmentList: List<Fragment>
    var titles = arrayOf("支出", "收入")
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
    init {
        this.fragmentList = fragmentList
    }
}
