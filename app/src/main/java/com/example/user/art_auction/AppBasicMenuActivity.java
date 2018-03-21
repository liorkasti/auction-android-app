package com.example.user.art_auction;

import android.app.KeyguardManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

/**
 * Created by user on 21/03/2018.
 */

public class AppBasicMenuActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RelativeLayout main_view = (RelativeLayout) findViewById(R.id.main_view);

        switch (item.getItemId()) {
            case R.id.menu_level1: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AppBasicMenuActivity.this, MainActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level2: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AppBasicMenuActivity.this, AuctionsActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level3: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AppBasicMenuActivity.this, LogInActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.menu_level4: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AppBasicMenuActivity.this, MyUserActivity.class);
                startActivity(myIntent);
                return true;
            }
            case R.id.menu_level5: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AppBasicMenuActivity.this, AddAuctionItemActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level6: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AppBasicMenuActivity.this, AddAuctionActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level7: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AppBasicMenuActivity.this, AboutActivity.class);
                startActivity(myIntent);
                return true;
            }

            case R.id.menu_level9: {
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);

                Intent myIntent = new Intent(AppBasicMenuActivity.this, KeyguardManager.OnKeyguardExitResult.class); //todo: EXIT
                startActivity(myIntent);
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
