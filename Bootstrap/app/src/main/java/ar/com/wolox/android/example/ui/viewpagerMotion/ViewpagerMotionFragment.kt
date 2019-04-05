package ar.com.wolox.android.example.ui.viewpagerMotion

import android.os.Handler
import android.support.constraint.motion.MotionLayout
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import android.support.v4.view.ViewPager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.ui.viewpagerMotion.page1.Page1Fragment
import ar.com.wolox.android.example.ui.viewpagerMotion.page2.Page2Fragment
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import javax.inject.Inject

class ViewpagerMotionFragment @Inject constructor(): WolmoFragment<ViewpagerMotionPresenter>(){


    @Inject lateinit var page2Fragment: Page2Fragment
    @Inject lateinit var page1Fragment: Page1Fragment
    private lateinit var fragmentPagerAdapter: SimpleFragmentPagerAdapter
    private lateinit var motionLayout:MotionLayout
    private lateinit var vViewPager: ViewPager
    private lateinit var vHometabs: TabLayout
    private  var numberOfPages:Int = 0
    override fun layout(): Int = R.layout.fragment_viewpagermotion

    override fun init() {
         motionLayout= activity!!.findViewById(R.id.motionLayout)
         initViewPager()
         vViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
             override fun onPageScrollStateChanged(state: Int) {
             }

             override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                 Handler().postDelayed({
                     motionLayout.progress=(position + positionOffset) / (numberOfPages-1)
                 }, 10)

             }

             override fun onPageSelected(position: Int) {
             }

         })
    }
    fun initViewPager(){
        vViewPager=activity!!.findViewById(R.id.vViewPagerMotion)
        vHometabs=activity!!.findViewById(R.id.vHomeTabsMotion)
        fragmentPagerAdapter= SimpleFragmentPagerAdapter(childFragmentManager)
        fragmentPagerAdapter.addFragments(
                Pair<Fragment, String>(page1Fragment,"page1"),
                Pair<Fragment, String>(page2Fragment, "page2"))
        vViewPager.adapter=fragmentPagerAdapter
        vHometabs.setupWithViewPager(vViewPager)
        vHometabs.getTabAt(0)?.setIcon(R.drawable.news_tab_icon)
        vHometabs.getTabAt(1)?.setIcon(R.drawable.news_profile_tab)
        numberOfPages=2
    }
}



