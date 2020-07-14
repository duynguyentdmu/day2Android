package vnpt.binhduong.day2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {
    //List Data
    //Layout
    private Activity activity;
    private List<Product> listProduct;
    private ProductClickItem iOnClick;

    public ProductAdapter(Activity activity, List<Product> listProduct) {
        this.activity = activity;
        this.listProduct = listProduct;
    }

    public void setiOnClick(ProductClickItem iOnClick) {
        this.iOnClick = iOnClick;
    }

    //B1:
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //setContentView(R.layout.activity_main);
        View itemView = activity.getLayoutInflater().inflate(R.layout.product_item, parent, false);
        ProductHolder holder = new ProductHolder(itemView);
        return holder;
    }

    //B3:
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHolder productHolder = (ProductHolder) holder;
        Product p = listProduct.get(position);
        productHolder.ivCover.setImageResource(p.getImage());
        productHolder.tvName.setText(p.getName());
        productHolder.tvPrice.setText(p.getPrice());
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    //B2
    public class ProductHolder extends RecyclerView.ViewHolder {
        ImageView ivCover;
        TextView tvName;
        TextView tvPrice;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            ivCover = itemView.findViewById(R.id.ivCover);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    iOnClick.onClickItem(getAdapterPosition());
                }
            });
        }
    }

    public interface ProductClickItem {
        void onClickItem(int position);
    }
}
