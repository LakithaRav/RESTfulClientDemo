package ormlite.demo.olc.com.restfulclient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;

import ormlite.demo.olc.com.restfulclient.api.RestCountriesAPI;
import ormlite.demo.olc.com.restfulclient.model.Country;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        new DownloadFilesTask().execute("");
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.my, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    //private method for this tutorial

    private class DownloadFilesTask extends AsyncTask<String, Integer, List<Country>> {

        protected List<Country> doInBackground(String... urls) {

            RestCountriesAPI api = new RestCountriesAPI();
            return api.GetAllCountries();
        }

        protected void onProgressUpdate(Integer... progress) {

        }

        protected void onPostExecute(List<Country> results) {

            StringBuilder sb = new StringBuilder();
            for(Country country : results)
            {
                Log.d("Countries Output: ", country.getName());
                sb.append(country.getName() + "\n");
            }

            ((TextView) findViewById(R.id.txt_log)).setText(sb.toString());

        }
    }
}
