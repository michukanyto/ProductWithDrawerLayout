package com.appsmontreal.productwithdrawerlayout;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Model.Product;
import Model.ProductFileManagement;
import Model.ProductFragment;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    public static final String KEY = "ok";
    public static final String FILENAME = "product";
    DrawerLayout drawerLayout;
    ListView productListView;
    ArrayList<Product> productArrayList;
    ArrayAdapter<Product> productArrayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        drawerLayout = findViewById(R.id.drawerLayout);
        productArrayList = new ArrayList<>();
        productArrayList = ProductFileManagement.readFile(this,FILENAME);
        productArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,productArrayList);
        productListView = findViewById(R.id.listViewProducts);
        productListView.setOnItemClickListener(this);
        productListView.setAdapter(productArrayAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEY,productArrayList.get(position));


        //REPLACE THE LINEAR LAYOUT WITH FRAGMENT
        ProductFragment productFragment = new ProductFragment();
        productFragment.setArguments(bundle);


        //REFERENCE THE FRAGMENT MANAGER
        android.app.FragmentManager fragmentManager = getFragmentManager();
        //BEGIN THE TRANSACTION
        android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //REPLACE LINEAR LAYOUT MAIN_UI WITH THE FRAGMENT
        fragmentTransaction.replace(R.id.main_ui,productFragment);

        //COMMIT THE TRANSACTION
        fragmentTransaction.commit();

        setTitle(productArrayList.get(position).getPictureId());

        drawerLayout.closeDrawer(productListView);

    }
}
