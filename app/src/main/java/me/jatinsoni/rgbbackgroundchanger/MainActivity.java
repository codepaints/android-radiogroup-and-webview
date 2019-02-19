package me.jatinsoni.rgbbackgroundchanger;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    ConstraintLayout parentLayout;
    RadioGroup radioGroup;
    RadioButton checkedColor;
    Button google, yahoo;
    WebView webView;

    Window window;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set status bar color
        window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        // set action bar color
        actionBar = getSupportActionBar();

        //get all view items
        parentLayout = findViewById(R.id.layout_parent);
        radioGroup = findViewById(R.id.radio_group);
        checkedColor = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
        google = findViewById(R.id.google_button);
        yahoo = findViewById(R.id.yahoo_button);

        // setting up web view
        webView = findViewById(R.id.web_loader);
        webView.setBackgroundColor(Color.TRANSPARENT);

        google.setOnClickListener(this);
        yahoo.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);

        // set on radio item change listener in the radio group
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//
//                // get the checked radio button id from the radio group
//                checkedColor = group.findViewById(checkedId);
//                // set the boolean if checked
//                boolean isChecked = checkedColor.isChecked();
//
//                // cross check if the radio is checked
//                if (isChecked) {
//
//                    // convert the radio button text to string
//                    String color = checkedColor.getText().toString();
//
//                    // switch the color based on the radio button checked
//                    switch (color) {
//
//                        //if checked red
//                        case "Red":
//                            //set status bar color
//                            window.setStatusBarColor(getResources().getColor(R.color.colorRedDark));
//                            // set action bar color
//                            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
//                            //set the parent layout background red
//                            parentLayout.setBackgroundColor(getResources().getColor(R.color.bgRed));
//                            break;
//
//                        //if checked green
//                        case "Green":
//                            //set status bar color
//                            window.setStatusBarColor(getResources().getColor(R.color.colorGreenDark));
//                            // set action bar color
//                            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorGreen)));
//                            //set the parent layout background green
//                            parentLayout.setBackgroundColor(getResources().getColor(R.color.bgGreen));
//                            break;
//
//                        //if checked blue
//                        case "Blue":
//                            //set status bar color
//                            window.setStatusBarColor(getResources().getColor(R.color.colorBlueDark));
//                            // set action bar color
//                            actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorBlue)));
//                            //set the parent layout background blue
//                            parentLayout.setBackgroundColor(getResources().getColor(R.color.bgBlue));
//                            break;
//
//                        default:
//                            //set the parent layout background default (white)
//                            parentLayout.setBackgroundColor(getResources().getColor(R.color.bgDefault));
//                            break;
//                    }
//
//                    // display toast for the selected radio button text
//                    Toast.makeText(MainActivity.this, "Checked: " + checkedColor.getText(), Toast.LENGTH_SHORT).show();
//                }
//
//            }
//        });

    }


    @Override
    public void onClick(View v) {
        loadWebPage(v);
    }

    private void loadWebPage(View view) {

        String webUrl = "";

        webView.setBackgroundColor(getResources().getColor(R.color.bgDefault));
        webView.setWebViewClient(new WebViewClient());

        if (view == google) {
            webUrl = "https://www.google.com";

        } else if (view == yahoo) {
            webUrl = "https://www.yahoo.com";

        }

        webView.loadUrl(webUrl);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        // get the checked radio button id from the radio group
        checkedColor = group.findViewById(checkedId);
        // set the boolean if checked
        boolean isChecked = checkedColor.isChecked();

        // cross check if the radio is checked
        if (isChecked) {

            // convert the radio button text to string
            String color = checkedColor.getText().toString();

            // switch the color based on the radio button checked
            switch (color) {

                //if checked red
                case "Red":
                    //set status bar color
                    window.setStatusBarColor(getResources().getColor(R.color.colorRedDark));
                    // set action bar color
                    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorRed)));
                    //set the parent layout background red
                    parentLayout.setBackgroundColor(getResources().getColor(R.color.bgRed));
                    break;

                //if checked green
                case "Green":
                    //set status bar color
                    window.setStatusBarColor(getResources().getColor(R.color.colorGreenDark));
                    // set action bar color
                    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorGreen)));
                    //set the parent layout background green
                    parentLayout.setBackgroundColor(getResources().getColor(R.color.bgGreen));
                    break;

                //if checked blue
                case "Blue":
                    //set status bar color
                    window.setStatusBarColor(getResources().getColor(R.color.colorBlueDark));
                    // set action bar color
                    actionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorBlue)));
                    //set the parent layout background blue
                    parentLayout.setBackgroundColor(getResources().getColor(R.color.bgBlue));
                    break;

                default:
                    //set the parent layout background default (white)
                    parentLayout.setBackgroundColor(getResources().getColor(R.color.bgDefault));
                    break;
            }

            // display toast for the selected radio button text
            Toast.makeText(MainActivity.this, "Checked: " + checkedColor.getText(), Toast.LENGTH_SHORT).show();
        }

    }
}
