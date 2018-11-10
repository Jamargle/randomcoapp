package com.jmlb0003.randomcoapp.presentation.userlist

import android.os.Bundle
import com.jmlb0003.randomcoapp.R
import com.jmlb0003.randomcoapp.domain.User
import com.jmlb0003.randomcoapp.presentation.BaseActivity
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : BaseActivity<MainPresenter.MainView, MainPresenter>(), MainPresenter.MainView {

    private val p:MainPresenter by lazy { MainPresenter() }
    override val presenter: MainPresenter
        get() = p

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreated()
    }

    override fun getMVPViewReference(): MainPresenter.MainView = this

    override fun showUser(user: User) {
        textView.text = "${user.name} ${user.surname}"
    }

}
