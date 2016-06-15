package co.gobd.gofetch.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.gobd.gofetch.R;
import co.gobd.gofetch.ui.view.ItemDetailsView;

public class ItemDetailsFragment extends Fragment implements ItemDetailsView{

    private OnItemDetailsFragmentListener mListener;

    public ItemDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_details, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_no_menu);
        if (toolbar != null) {
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemDetailsFragmentListener) {
            mListener = (OnItemDetailsFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnItemDetailsFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;    }


    public interface OnItemDetailsFragmentListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
