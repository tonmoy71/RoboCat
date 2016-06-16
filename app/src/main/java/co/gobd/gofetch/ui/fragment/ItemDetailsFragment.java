package co.gobd.gofetch.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import co.gobd.gofetch.R;
import co.gobd.gofetch.ui.view.ItemDetailsView;

public class ItemDetailsFragment extends Fragment implements ItemDetailsView {

    private OnItemDetailsFragmentListener mListener;

    public ItemDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Needs to call to show menu in the app bar
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_continue:
                // FIXME
                Toast.makeText(getContext(), "Continue", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_item_details, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false);
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
        mListener = null;
    }


    public interface OnItemDetailsFragmentListener {
        // TODO: Update argument type and name
        void onFragmentInteraction();
    }
}
