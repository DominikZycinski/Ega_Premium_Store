package com.example.domin.ega_premium_store;


import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class NewsFragment extends Fragment {

    ViewPager viewPager;
    ConstraintLayout constraintView;
    private Button showOnMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_news, null);

//        View mainView = getActivity().findViewById(R.id.fragment_name);
        TextView txt;
//        txt= mainView.findViewById(R.id.fragment_name);
//        txt.setText(R.string.news);

        String [] name = {"Centrum Zaopatrzenia Ega Premium","Oferta","Autoryzowany Dystrybutor"};
        String [] date = {"","",""};
        String [] text = {"Cechuje nas doświadczenie, troska o nieustanny rozwój oraz indywidualne podejście do każdego klienta. Oferujemy najwyższe standardy które podtrzymujemy w każdej płaszczyźnie naszych działań. Oferowane artykuły sprzedajemy hurtowo jak i detalicznie. Umożliwiamy możliwość płatności kartą oraz dowozu artykułów.  "+
                "João Fiadeiro belongs to the generation of choreographers who emerged in the late 1980s, who followed the american “postmodern” movement and the movements of the French and Belgian Nouvelle Danse, gave rise to the New Portuguese Dance\n",
                        "Oferujemy solidne artykuły oraz serwis, który zapewnia wysoki standard dla klientów. W naszym sklepie mają Państwo szeroki wybór artykułów przeznaczonych zarówno do amatorskiego i profesjonalnego użytku w przystępnej cenie i z dopasowanym osprzętem. W naszej ofercie znajdą Państwo sprzęt odpowiedni dla siebie – o właściwym stosunku ceny do jakości i wydajności. ",
                "Nasze artykuły pochodzą prosto od producenta, dlatego mogą mieć Państwo pewność, że są one oryginalne. Wszystkie produkty są objęte gwarancją producenta oraz serwisem po sprzedażowym. Jesteśmy oficjalnym dystrybutorem marki Ega Premium, Orlen, Higo, Yato, Faster Tools, Draumet, Forester, Tresnar, Hurry Up."};
        Double[] lng={ -8.603674,-8.609465 , -8.661093};
        Double[] lat={41.123399,41.140102, 41.136735};
        viewPager =view.findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getContext(),name, date,text,lat,lng);

        viewPager.setAdapter(viewPagerAdapter);


        return view;
    }

}
