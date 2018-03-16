package com.oum.e_commerceapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oum.e_commerceapp.adapter.CategoryAdapter;
import com.oum.e_commerceapp.adapter.ProductAdapter;
import com.oum.e_commerceapp.modal.ProductDomain;

import java.util.ArrayList;

public class ProductActivity extends Activity {
    TextView txtItemCount;
    int itemCount=0;
    ArrayList<ProductDomain> productDomainArrayList;
GridView gridView;

ArrayList<ProductDomain> cartArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        int position =  getIntent().getIntExtra("position",0);

        gridView = findViewById(R.id.grid_product);

        productDomainArrayList = new ArrayList<>();
        cartArray = new ArrayList<>();
//        txtItemCount.setText(itemCount);




        Toast.makeText(getApplicationContext(),String.valueOf(position),Toast.LENGTH_LONG).show();

        ProductDomain productDomain;;

        switch (position){
            case 0:
                String [] clothList = {"JEANS","SHIRTS","PANTS","T-SHIRTS","LG"};
                int [] clothImageList = {R.drawable.samsung_galaxy,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j,R.drawable.lg_g};
                String [] clothpriceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};


                for(int i=0;i<clothList.length;i++){

                    productDomain = new ProductDomain(clothList[i],clothpriceList[i],clothImageList[i]);
                    productDomainArrayList.add(productDomain);
                }


                gridView.setAdapter(new ProductAdapter(productDomainArrayList,getApplicationContext()));

                break;



            case 1:
                String [] electronicsList = {"SAMSUNG","LG","PIXEL","SAMSUNG","LG","PIXEL","SAMSUNG"};
                int [] electoImageList = {R.drawable.samsung_galaxy,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j};

                String [] electropriceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};


                for(int i=0;i<electronicsList.length;i++){

                    productDomain = new ProductDomain(electronicsList[i],electropriceList[i],electoImageList[i]);
                    productDomainArrayList.add(productDomain);
                }


                gridView.setAdapter(new ProductAdapter(productDomainArrayList,getApplicationContext()));

                break;


            case 2:
                String [] categoryList = {"SAMSUNG","LG","PIXEL","SAMSUNG","LG","PIXEL","SAMSUNG"};
                int [] imageList = {R.drawable.samsung_galaxy,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j};

                String [] priceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};
                for(int i=0;i<categoryList.length;i++){

                    productDomain = new ProductDomain(categoryList[i],priceList[i],imageList[i]);
                    productDomainArrayList.add(productDomain);
                }


                gridView.setAdapter(new ProductAdapter(productDomainArrayList,getApplicationContext()));

                break;

            case 3:
                String [] autoList = {"SAMSUNG","LG","PIXEL","SAMSUNG","LG","PIXEL","SAMSUNG"};
                int [] autoImageList = {R.drawable.samsung_galaxy,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j};

                String [] autoPriceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};

                for(int i=0;i<autoList.length;i++){

                    productDomain = new ProductDomain(autoList[i],autoPriceList[i],autoImageList[i]);
                    productDomainArrayList.add(productDomain);
                }


                gridView.setAdapter(new ProductAdapter(productDomainArrayList,getApplicationContext()));

                break;

                default:
                    String [] defaultList = {"SAMSUNG","LG","PIXEL","SAMSUNG","LG","PIXEL","SAMSUNG"};
                    int [] defaultImageList = {R.drawable.samsung_galaxy,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j,R.drawable.lg_g,R.drawable.pixel,R.drawable.samsung_j};

                    String [] defaultPriceList = {"200 MYR","250 MYR","100 MYR","300 MYR","250 MYR","200 MYR","300 MYR"};
                    for(int i=0;i<defaultList.length;i++){

                        productDomain = new ProductDomain(defaultList[i],defaultPriceList[i],defaultImageList[i]);
                        productDomainArrayList.add(productDomain);
                    }


                    gridView.setAdapter(new ProductAdapter(productDomainArrayList,getApplicationContext()));

                    break;


        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_LONG).show();
                //productDetails(productDomainArrayList.get(i).getProductName(),productDomainArrayList.get(i).getProductPrice(),productDomainArrayList.get(i).getImageId(),i);
            }
        });

    }


    public void productDetails(String productName, String productPrice, int imgId, final int position){
        final AlertDialog alert;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.description_layout, null);

        builder.setView(view);
        alert = builder.create();
        alert.show();

        TextView txtProduct = view.findViewById(R.id.txt_product_name);
        TextView txtPrice = view.findViewById(R.id.txt_price);
        ImageView imageView = view.findViewById(R.id.img_product);
        Button btnCart = view.findViewById(R.id.button);




        txtProduct.setText(productName);
        txtPrice.setText(productPrice);
        imageView.setImageResource(imgId);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                cartArray.add(productDomainArrayList.get(position));
                itemCount++;
                updateHotCount(itemCount);
                alert.dismiss();
            }
        });

    }



   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu, menu);

        final View notificaitons = menu.findItem(R.id.cart_item).getActionView();

        txtItemCount = (TextView) notificaitons.findViewById(R.id.cart_badge);
        updateHotCount(itemCount++);
        /*txtItemCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateHotCount(itemCount++);
            }
        });*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.cart_item:
               // newGame();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void updateHotCount(final int new_number) {
        itemCount = new_number;
        if (itemCount < 0) return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (itemCount == 0)
                    txtItemCount.setVisibility(View.GONE);
                else {
                    txtItemCount.setVisibility(View.VISIBLE);
                    txtItemCount.setText(Integer.toString(itemCount));
                    // supportInvalidateOptionsMenu();
                }
            }
        });
    }
}
