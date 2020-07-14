package vnpt.binhduong.day2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //B1: Data source
        String[] datas = {"SAMSUNG", "LG", "SONY", "NOKIA", "APPLE"};

        //B2: Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, datas);

        //B3: ListView
        lvContact = findViewById(R.id.lvContact);
        lvContact.setAdapter(adapter);

    }
}
