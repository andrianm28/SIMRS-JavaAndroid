package com.qtasnim.qhopes.navigation.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.qtasnim.qhopes.R;
import com.qtasnim.qhopes.activities.MainActivity;
import com.qtasnim.qhopes.activities.MenuBeritaActivity;
import com.qtasnim.qhopes.activities.MenuHariIniActivity;
import com.qtasnim.qhopes.activities.MenuInfoActivity;
import com.qtasnim.qhopes.activities.MenuKontakActivity;
import com.qtasnim.qhopes.fragments.MenuInfoFragment;
import com.qtasnim.qhopes.fragments.MingguanFragment;
import com.qtasnim.qhopes.fragments.SpesialisFragment;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.Objects;


public class HomeNavFragment extends Fragment {

    private ImageButton mBtnMenuMingguini,mBtnMenuBerita,mBtnMenuSpesialis,mBtnDaftar,btn_menu_info,btn_day,mBtnMenuKontak;
    
    int[] sampleImages = {R.drawable.jp1, R.drawable.jp2, R.drawable.jp3, R.drawable.jp4};

    private OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setActionBar(){
        ((MainActivity) Objects.requireNonNull(getActivity()))
                .setActionBarTitle(getString(R.string.title_beranda));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_nav_home, container, false);
        setActionBar();

//        TextView mTextMessage = (TextView) rootView.findViewById(R.id.message);


        CarouselView carousel_view = rootView.findViewById(R.id.carousel_view);
        carousel_view.setPageCount(sampleImages.length);
        carousel_view.setImageListener(imageListener);

        btn_day = rootView.findViewById(R.id.btn_menu_hariini);
        btn_day_click();
        mBtnMenuMingguini = rootView.findViewById(R.id.btn_menu_mingguini);
        mBtnMenuMingguini_click();
        mBtnMenuBerita = rootView.findViewById(R.id.btn_menu_berita);
        mBtnMenuBerita_click();
        btn_menu_info = rootView.findViewById(R.id.btn_menu_info);
        btnInfoOnClick();
        mBtnMenuKontak = rootView.findViewById(R.id.btn_menu_kontak);
        btnMenuKontakClicked();

        return rootView;
    }



    public void btn_day_click(){
        btn_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   Intent i=new Intent(getApplicationContext(), viewinfoday.class);//target = nama class
                //     startActivity(i);

//                MenuHariIniActivity fm =  new MenuHariIniActivity();

                Intent intent = new Intent(getActivity(), MenuHariIniActivity.class);
                startActivity(intent);


//                 FragmentTransaction fragmentTransaction = getActivity().beginTransaction();
//                      fragmentTransaction.replace(R.id.frameLayout,fm);
//                   fragmentTransaction.commit();

            }
        });

    }

    public void mBtnMenuMingguini_click()
    {
        mBtnMenuMingguini.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MingguanFragment fm =  new MingguanFragment();


                FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fm);
                fragmentTransaction.commit();
            }
        });
    }

    public void mBtnMenuBerita_click()
    {
        mBtnMenuBerita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MenuBeritaActivity.class);
                startActivity(intent);
            }
        });
    }

    public void mBtnMenuSpesialis_click()
    {
        mBtnMenuSpesialis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpesialisFragment fm = new SpesialisFragment();


                FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fm);
                fragmentTransaction.commit();
            }
        });
    }

    public void mBtnDaftar_click()
    {
        mBtnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PendaftaranNavFragment fm = new PendaftaranNavFragment();


                FragmentTransaction fragmentTransaction = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fm);
                fragmentTransaction.commit();
            }
        });
    }


    public void btnMenuKontakClicked()
    {
        mBtnMenuKontak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuKontakActivity.class);
                startActivity(intent);

            }
        });
    }


    public void btnInfoOnClick()
    {
        btn_menu_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuInfoFragment fm = new MenuInfoFragment();
                Intent jumpActivity = new Intent(getContext(), MenuInfoActivity.class);
                startActivity(jumpActivity);

            }
        });
    }


    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }  //  throw new RuntimeException(context.toString()
        //         + " must implement OnFragmentInteractionListener");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
