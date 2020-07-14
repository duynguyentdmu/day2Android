package vnpt.binhduong.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // B1 datasource
        final String[] datas = {"samsung", "xiaomi", "xiaomi", "xiaomi", "xiaomi", "xiaomi", "xiaomi", "xiaomi", "xiaomi", "xiaomi", "xiaomi", "xiaomi"};

        // B2 adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datas);

        // B3 list view
        ListView lvList = findViewById(R.id.lsListView);
        lvList.setAdapter(adapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = datas[position];
                Toast.makeText(ListActivity.this, item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
