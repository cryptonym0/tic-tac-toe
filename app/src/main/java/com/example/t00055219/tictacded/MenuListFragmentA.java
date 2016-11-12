package com.example.t00055219.tictacded;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuListFragmentA.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuListFragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuListFragmentA extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MenuListFragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuListFragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuListFragmentA newInstance(String param1, String param2) {
        MenuListFragmentA fragment = new MenuListFragmentA();
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
        return inflater.inflate(R.layout.fragment_menu_list, container, false);
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListView tv = (ListView) getActivity().findViewById(R.id.menuItemsListView);
        Resources res = getResources();
        String[] menuA = res.getStringArray(R.array.menuItems);
        ArrayAdapter<String> ada = new ArrayAdapter<String>(getActivity(), R.layout.row_description, R.id.rowTv, menuA);

        tv.setAdapter(ada);

    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle myBundle) {
//        // Inflate the layout for this fragment
//        View planetview = inflater.inflate(R.layout.fragment_menu_list, container, false);
//        List<String> planetList = new ArrayList<>();
//        String planetArray[] = getResources().getStringArray(R.array.menuItems);
//
//        for(int i = 0;i<planetArray.length;i++){
//            planetList.add(planetArray[i]);
//        }
//
//        ArrayAdapter<String> a = new ArrayAdapter(getContext(),R.layout.row_description,planetList);
//        ListView listView = (ListView) planetview.findViewById(R.id.menuItemsListView);
//        listView.setAdapter(a);
//        return planetview;
//    }
//
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
