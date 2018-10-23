package ar.com.wolox.android.example.ui.home2

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import butterknife.BindView
import javax.inject.Inject

class ProfileFragment : WolmoFragment<ProfilePresenter>(), IProfileView {

    override fun layout(): Int = R.layout.fragment_profile

    override fun init() {

    }

}
