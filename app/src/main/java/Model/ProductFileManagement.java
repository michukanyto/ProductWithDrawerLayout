package Model;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProductFileManagement {
    public static ArrayList<Product> readFile(Context context, String fileName){
        ArrayList<Product> listOfProduct = new ArrayList<>();

        AssetManager assetManager = context.getResources().getAssets();

        try {
            InputStreamReader isr = new InputStreamReader(assetManager.open(fileName));

            BufferedReader br = new BufferedReader(isr);

            String oneLine = br.readLine();

            while (oneLine != null){
                StringTokenizer st = new StringTokenizer(oneLine,",");
                listOfProduct.add(new Product(st.nextToken(),st.nextToken(),Float.parseFloat(st.nextToken()),Float.parseFloat(st.nextToken())));
                oneLine = br.readLine();
            }
            br.close();
            isr.close();

        } catch (IOException e) {
            Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT).show();
        }

        return listOfProduct;

    }

}
