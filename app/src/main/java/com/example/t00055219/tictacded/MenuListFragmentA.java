package com.example.t00055219.tictacded;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;



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
        return inflater.inflate(R.layout.fragment_menu_list, container, false);
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
        tv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick (AdapterView<?> parent, View tv,int i, long id){
                selectItem(i);
            };
        });

    }

    public void selectItem(int i) {
        Resources res = getResources();
        String[] items = res.getStringArray(R.array.menuItems);
            switch (i) {
                case 0:
                    Log.d("MENU ITEM:", "Choose Characters");
                    goToEnterNames(getView());
                    break;
                case 1:
                    Log.d("MENU ITEM:", "PVP");
                    goToGame(getView());
                    break;
                case 2:
                    Log.d("MENU ITEM:", "PVAI");
                    break;
                case 3:
                    Log.d("MENU ITEM:", "Score");
                    goToScores(getView());
                    break;
                case 4:
                    Log.d("MENU ITEM:", "Quit");
                    exit(getView());
                    break;

        }
    }

    public void goToGame(View v){
        Intent intent = new Intent(getActivity(), PlayGame.class);
        startActivity(intent);
    }
    public void goToEnterNames(View v){
        Intent intent = new Intent(getActivity(), EnterNames.class);
        startActivity(intent);
    }

    public void goToScores(View v){
        Intent intent = new Intent(getActivity(), Scores.class);
        startActivity(intent);
    }

    public void exit(View v)
    {
        System.exit(0);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String data);
    }
}
