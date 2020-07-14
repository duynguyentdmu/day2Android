package vnpt.binhduong.day2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    List<Product> listProduct = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //B1: Data source
        initData();

        //B2: Adapter
        ProductAdapter adapter = new ProductAdapter(this, listProduct);
        adapter.setiOnClick(new ProductAdapter.ProductClickItem() {
            @Override
            public void onClickItem(int position) {
                Log.d("ProductActivity", "onClickItem: "+ position);
            }
        });

        //B3: Layout Manager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        //B4: Recyclerview
        RecyclerView rvProduct = findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);

    }

    private void initData() {
        listProduct.add(new Product("Product 1", "500.000", R.drawable.p1)); //positon = 0
        listProduct.add(new Product("Product 2", "6.000.000", R.drawable.p2)); //position = 1
        listProduct.add(new Product("Product 3", "700.000", R.drawable.p3));
        listProduct.add(new Product("Product 4", "800.000", R.drawable.p4));
        listProduct.add(new Product("Product 5", "900.000", R.drawable.p5));
        listProduct.add(new Product("Product 6", "300.000", R.drawable.p6));
    }
}
