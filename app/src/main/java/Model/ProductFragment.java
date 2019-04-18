package Model;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsmontreal.productwithdrawerlayout.MainActivity;
import com.appsmontreal.productwithdrawerlayout.R;

public class ProductFragment extends android.app.Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.product_fragment,container,false);
    }


    //receiving data
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Product product = (Product) getArguments().getSerializable(MainActivity.KEY);
        TextView textViewProductName = getActivity().findViewById(R.id.textViewProductName);
        textViewProductName.setText(product.getProductName());
        TextView textViewProductCost = getActivity().findViewById(R.id.textViewProductCost);
        textViewProductCost.setText(String.valueOf(product.getCost()));
        TextView textViewProductFees = getActivity().findViewById(R.id.textViewProductFees);
        textViewProductFees.setText(String.valueOf(product.getFees()));
        TextView textViewProductTotal = getActivity().findViewById(R.id.textViewProductTotal);
        textViewProductTotal.setText(String.valueOf(product.getFees() + product.getCost()));
//        ImageView imageView = getActivity().findViewById(R.id.imageViewProductView);
//        imageView.setImageResource();




    }

}
