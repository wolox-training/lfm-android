package ar.com.wolox.android.example.ui.home2

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_example.*

class Home2Fragment : WolmoFragment<Home2Presenter>(), IHome2View {

    override fun layout(): Int = R.layout.fragment_home2

    override fun init() {
        vLoginButton.isEnabled = false
    }

}
