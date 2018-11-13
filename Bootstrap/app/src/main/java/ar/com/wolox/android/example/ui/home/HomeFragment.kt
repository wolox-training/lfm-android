package ar.com.wolox.android.example.ui.home
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment @Inject constructor(): WolmoFragment<BasePresenter<Any>>(){

    @Inject lateinit var newsFragment : NewsFragment
    @Inject lateinit var profileFragment:ProfileFragment
    private lateinit var fragmentPagerAdapter: SimpleFragmentPagerAdapter

    override fun layout(): Int = R.layout.fragment_home

    override fun init() {
        fragmentPagerAdapter= SimpleFragmentPagerAdapter(childFragmentManager)
        fragmentPagerAdapter.addFragments(
                Pair<Fragment, String>(newsFragment, activity!!.resources.getString(R.string.home_newsTab)),
                Pair<Fragment, String>(profileFragment, activity!!.resources.getString(R.string.home_profileTab)))
        vViewPager.adapter=fragmentPagerAdapter
        vHomeTabs.setupWithViewPager(vViewPager)
        vHomeTabs.getTabAt(0)?.setIcon(R.drawable.news_tab_icon)
        vHomeTabs.getTabAt(1)?.setIcon(R.drawable.news_profile_tab)
    }

}
