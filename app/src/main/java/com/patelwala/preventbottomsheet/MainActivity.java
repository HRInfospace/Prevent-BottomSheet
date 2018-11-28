package com.patelwala.preventbottomsheet;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private BottomAppBar mBottomAppBar;
    private FloatingActionButton mFloatingActionButton;
    private BottomSheetDialog mBottomSheetDialog;
    private Context mContext = MainActivity.this;
    private NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomAppBar = findViewById(R.id.bottom_app_bar);
        mFloatingActionButton = findViewById(R.id.floating_action_button);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, getString(R.string.hr_info_space), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.hr_info_space), null)
                        .show();
            }
        });

        setSupportActionBar(mBottomAppBar);


        iniModalBottomSheet();
    }

    public void iniModalBottomSheet() {
        View view = getLayoutInflater().inflate(R.layout.layout_fragment_bottom_sheet, null);
        mBottomSheetDialog = new BottomSheetDialog(this);
        mBottomSheetDialog.setContentView(view);
        // mBottomSheetDialog.show();

        mNavigationView = (NavigationView) view.findViewById(R.id.navigation_view);

        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        int id = menuItem.getItemId();
                        switch (id) {
                            case R.id.device_protection:
                                BottomSheetDialogHide();
                                return true;
                            case R.id.application_manager:

                                return true;
                            case R.id.activity_log:
                                BottomSheetDialogHide();
                                return true;
                            case R.id.whitelist:

                                return true;
                            case R.id.profile:
                                BottomSheetDialogHide();
                                return true;
                            case R.id.reset_password:

                                return true;

                            case R.id.settings:
                                BottomSheetDialogHide();
                                return true;
                            case R.id.how_it_works:
                                BottomSheetDialogHide();
                                return true;
                            case R.id.upgrade:
                                BottomSheetDialogHide();
                                return true;
                            case R.id.about_us:
                                BottomSheetDialogHide();
                                return true;
                        }
                        return true;
                    }
                });

    }

    private void BottomSheetDialogHide() {
        if (mBottomSheetDialog.isShowing()) {
            mBottomSheetDialog.hide();
        }

        try {
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=8877686985621699495"));
            startActivity(myIntent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No application can handle this request."
                    + " Please install a webbrowser", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bottom_app_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_sheet_btn:
                mBottomSheetDialog.show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
