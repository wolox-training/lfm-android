package ar.com.wolox.android.example.ui.home.news;

import android.app.Activity;

import net.natura.cards.sdk.models.responses.Card;
import net.natura.cards.sdk.models.widgets.ButtonWidget;
import net.natura.cards.sdk.models.widgets.TitleWidget;
import net.natura.cards.sdk.utils.CardActionsDelegate;
import net.natura.cards.sdk.utils.CardsApi;
import net.natura.cards.sdk.utils.CardsApiConfig;
import net.natura.cards.sdk.utils.CardsApiDevConfig;
import net.natura.cards.sdk.views.CardsFragment;

import java.util.List;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.INewsView;
import ar.com.wolox.android.example.ui.home.NewsPresenter;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class NewsFragment2 extends WolmoFragment<NewsPresenter> implements INewsView,CardActionsDelegate {
    @Override
    public void setErrorCode(int i) {

    }

    @Override
    public int layout() {
        return R.layout.fragment_news;
    }

    @Override
    public void init() {
        CardsApiConfig.init(getContext(),new CardsApiDevConfig());
        CardsFragment fragment=new CardsFragment();
        fragment.setCardActionsDelegate(this);
        CardsApiConfig.getCurrentConfig().setIdUserLogged(SingletonCon);
    }

    @Override
    public boolean onCardClicked(Card card) {
        return false;
    }

    @Override
    public boolean onTitleOptionsClicked(Card card, TitleWidget titleWidget) {
        return false;
    }

    @Override
    public boolean handleException(Activity activity, Throwable throwable) {
        return false;
    }

    @Override
    public boolean forwardCard(Card card) {
        return false;
    }

    @Override
    public void onItensReloaded(List<Card> list) {

    }

    @Override
    public void onButtonClicked(Card card, ButtonWidget buttonWidget) {

    }

    @Override
    public void startLoading(Activity activity) {

    }

    @Override
    public void stopLoading(Activity activity) {

    }
}
