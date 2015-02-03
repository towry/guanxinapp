package me.guanxinapp.guanxin.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import me.guanxinapp.guanxin.R;
import me.guanxinapp.guanxin.adapter.StreamAdapter;
import me.guanxinapp.guanxin.entity.Status;
import me.guanxinapp.guanxin.foundation.BaseApplication;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StreamFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StreamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StreamFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    // The SwipeRefreshLayout
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;

    // status list
    private List<Status> mStatusList = new ArrayList<>();

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StreamFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StreamFragment newInstance(String param1, String param2) {
        StreamFragment fragment = new StreamFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public StreamFragment() {
        // Required empty public constructor
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
        View retV = inflater.inflate(R.layout.fragment_stream, container, false);
        init(retV);

        return retV;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    protected void init(View v) {
        ListView listView1 = (ListView) v.findViewById(R.id.stream_content);

        mStatusList.add(new Status("avatar/avatar1.gif", System.currentTimeMillis(), "睡觉了", "Towry Wang"));
        mStatusList.add(new Status("avatar/avatar2.jpg", System.currentTimeMillis(), "手机已解屏", "WuSheng Chen"));
        mStatusList.add(new Status("avatar/avatar3.gif", System.currentTimeMillis(), "吃饭去", "Maggie Simpson"));
        mStatusList.add(new Status("avatar/avatar5.gif", System.currentTimeMillis(), "玩篮球", "Ming Xiao"));
        mStatusList.add(new Status("avatar/avatar4.gif", System.currentTimeMillis(), "看电影:《仁者无敌》", "Jack Chen"));
        mStatusList.add(new Status("avatar/avatar6.gif", System.currentTimeMillis(), "玩篮球", "Four Lod"));

        StreamAdapter adapter = new StreamAdapter(BaseApplication.getInstance(), getActivity(), mStatusList);
        listView1.setAdapter(adapter);

//        swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.stream_fragment_container);
//        swipeRefreshLayout.setOnRefreshListener(this);
//        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
//                android.R.color.holo_green_light, android.R.color.holo_orange_light,
//                android.R.color.holo_red_light);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    // SwipRefresh event handle
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()  {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 5000);
    }

}
