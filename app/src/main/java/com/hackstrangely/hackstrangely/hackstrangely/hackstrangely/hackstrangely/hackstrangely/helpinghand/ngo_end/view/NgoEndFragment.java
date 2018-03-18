package com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.R;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.helper.SharedPrefs;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.model.NgoEndList;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.presenter.NgoEndPresenter;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.presenter.NgoEndPresenterImpl;
import com.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.hackstrangely.helpinghand.ngo_end.provider.RetrofitNgoEndProvider;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NgoEndFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NgoEndFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NgoEndFragment extends Fragment implements NgoView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SharedPrefs sharedPrefs;
    private TextView ngoName,ngoDetails;
    private String ddetail,dquantity;
    private int d;
    private Button btn_submit;
    private EditText donationQuantity,donationDetails;
    private OnFragmentInteractionListener mListener;
    private NgoEndPresenter ngoEndPresenter;
    private ProgressBar progressBar;


    public NgoEndFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NgoEndFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NgoEndFragment newInstance(String param1, String param2) {
        NgoEndFragment fragment = new NgoEndFragment();
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
        View view =  inflater.inflate(R.layout.fragment_ngo_end, container, false);
        sharedPrefs = new SharedPrefs(getContext());
        ngoName = (TextView) view.findViewById(R.id.ngo_details_name);
//        ngoDetails = (TextView) view.findViewById(R.id.ngo_details_txt);
        donationQuantity = (EditText) view.findViewById(R.id.donation_quantity);
        donationDetails = (EditText) view.findViewById(R.id.donation_details);
        btn_submit = (Button) view.findViewById(R.id.btn_detail_submit);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar_end);
        ddetail = donationDetails.getText().toString().trim();
        dquantity = donationQuantity.getText().toString().trim();

        ngoName.setText(sharedPrefs.getNgoName());
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (dquantity.isEmpty()){
//                    Toast.makeText(getContext(),"Please fill the quantity field",Toast.LENGTH_SHORT).show();
//                }else if ((ddetail.isEmpty())){
//                    Toast.makeText(getContext(),"Please fill the details field",Toast.LENGTH_SHORT).show();
//               }else{
                    ngoEndPresenter = new NgoEndPresenterImpl(NgoEndFragment.this,new RetrofitNgoEndProvider());
                    ngoEndPresenter.requestNgoDetails(sharedPrefs.getAccessToken(),sharedPrefs.getItemId(),sharedPrefs.getNgoId(),dquantity,ddetail);
//              }
            }
        });
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
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setData(NgoEndList ngoEndList) {
        Toast.makeText(getContext(),"Successfully details sent",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar(boolean show) {
        if(show){
            progressBar.setVisibility(View.VISIBLE);
        }
        else{
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(),message,Toast.LENGTH_LONG).show();
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
