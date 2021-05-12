package vnua.duykhanh.connectdbtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Database database;

    ListView lvCongViec;
    ArrayList<Congviec> arrayCongViec;
    CongViecAdepter adepter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCongViec = (ListView) findViewById(R.id.listviewCongViec);

        arrayCongViec = new ArrayList<>();

        adepter = new CongViecAdepter(this, R.layout.donglayout, arrayCongViec);
        lvCongViec.setAdapter(adepter);

        database = new Database(MainActivity.this, "ghichu.sqlite", null, 1);

        database.queryData("CREATE TABLE IF NOT EXISTS congViec( id INTEGER PRIMARY KEY AUTOINCREMENT, tenCongViec VARCHAR(200) NOT NULL)");

//        database.queryData("INSERT INTO congViec VALUES(null, 'Học lập trình')");

        Cursor dataCongViec = database.getData("SELECT * FROM congViec");
        while (dataCongViec.moveToNext()) {
            String tenCongViec = dataCongViec.getString(1);
            int id = dataCongViec.getInt(0);
            arrayCongViec.add(new Congviec(id, tenCongViec));
        }
    adepter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.menuAdd) {
            dialogThem();
        }

        return super.onOptionsItemSelected(item);
    }

    private void dialogThem() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.them_cong_viec);
        dialog.show();

        EditText ten = ()
    }
}