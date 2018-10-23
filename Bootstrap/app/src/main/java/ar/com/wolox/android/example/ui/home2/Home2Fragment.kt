package ar.com.wolox.android.example.ui.home2
import android.support.v4.app.Fragment
import android.support.v4.util.Pair
import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.adapter.viewpager.SimpleFragmentPagerAdapter
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import kotlinx.android.synthetic.main.fragment_home2.*
import javax.inject.Inject

class Home2Fragment @Inject constructor(): WolmoFragment<BasePresenter<Any>>(){

    @Inject internal lateinit var newsFragment: NewsFragment
    @Inject internal lateinit var profileFragment: ProfileFragment
    private lateinit var fragmentPagerAdapter: SimpleFragmentPagerAdapter

    override fun layout(): Int = R.layout.fragment_home2

    override fun init() {
        fragmentPagerAdapter= SimpleFragmentPagerAdapter(childFragmentManager)
        fragmentPagerAdapter.addFragments(
                Pair<Fragment, String>(newsFragment,"NEWS"),
                Pair<Fragment, String>(profileFragment,"PROFILE"))
        pager.adapter=fragmentPagerAdapter
    }

}
