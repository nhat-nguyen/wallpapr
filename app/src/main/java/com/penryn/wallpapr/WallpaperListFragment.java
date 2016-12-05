package com.penryn.wallpapr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link WallpaperListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link WallpaperListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WallpaperListFragment extends Fragment {
    public static final String TAG = "WallpaperListFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView mRecyclerView;

    private OnFragmentInteractionListener mListener;

    public WallpaperListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WallpaperListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WallpaperListFragment newInstance(String param1, String param2) {
        WallpaperListFragment fragment = new WallpaperListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wallpaper_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_wallpaper_list);


        List<String> urls = Arrays.asList(
                "https://images.unsplash.com/photo-1480618213131-3abfec8a53cd",
                "https://images.unsplash.com/photo-1480619110243-c94e677a8d2b",
                "https://images.unsplash.com/photo-1480643518368-6db7a44be5a0",
                "https://images.unsplash.com/photo-1480640156110-da820214e689",
                "https://images.unsplash.com/photo-1480623940435-62a1340b08c6",
                "https://images.unsplash.com/photo-1480623826718-27e89ac63a4f",
                "https://images.unsplash.com/photo-1480618425819-5530e06e4a03",
                "https://images.unsplash.com/photo-1480667638300-80b8576bc604",
                "https://images.unsplash.com/photo-1480651270449-8aab33d75b17",
                "https://images.unsplash.com/photo-1480623131803-41cf5ee121c8",
                "https://images.unsplash.com/photo-1480618213131-3abfec8a53cd",
                "https://images.unsplash.com/photo-1480619110243-c94e677a8d2b",
                "https://images.unsplash.com/photo-1480643518368-6db7a44be5a0",
                "https://images.unsplash.com/photo-1480640156110-da820214e689",
                "https://images.unsplash.com/photo-1480623940435-62a1340b08c6",
                "https://images.unsplash.com/photo-1480623826718-27e89ac63a4f",
                "https://images.unsplash.com/photo-1480618425819-5530e06e4a03",
                "https://images.unsplash.com/photo-1480667638300-80b8576bc604",
                "https://images.unsplash.com/photo-1480651270449-8aab33d75b17",
                "https://images.unsplash.com/photo-1480623131803-41cf5ee121c8"
        );

        List<Wallpaper> wallpapers = new ArrayList<>();

        for (String url : urls) {
            wallpapers.add(new Wallpaper(url, ""));
        }

        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        mRecyclerView.setAdapter(new WallpaperListAdapter(getContext(), Glide.with(this), wallpapers));
        mRecyclerView.addItemDecoration(new WallpaperItemDecoration());

        return view;
    }

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
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
     * "https://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
