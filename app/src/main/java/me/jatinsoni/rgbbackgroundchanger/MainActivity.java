package me.jatinsoni.rgbbackgroundchanger;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout parentLayout;
    RadioGroup radioGroup;
    RadioButton checkedColor;
    //    RadioButton red, green, blue;
    Button google, yahoo;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get all view items
        parentLayout = findViewById(R.id.layout_parent);
        radioGroup = findViewById(R.id.radio_group);
        checkedColor = radioGroup.findViewById(radioGroup.getCheckedRadioButtonId());
//        red = findViewById(R.id.color_red);
//        green = findViewById(R.id.color_green);
//        blue = findViewById(R.id.color_blue);
        google = findViewById(R.id.google_button);
        yahoo = findViewById(R.id.yahoo_button);
        webView = findViewById(R.id.web_loader);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                checkedColor = group.findViewById(checkedId);
                boolean isChecked = checkedColor.isChecked();

                if (isChecked) {

                    String color = checkedColor.getText().toString();

                    switch (color) {
                        case "Red":
                            parentLayout.setBackgroundColor(getResources().getColor(R.color.bgRed));
                            break;

                        case "Green":
                            parentLayout.setBackgroundColor(getResources().getColor(R.color.bgGreen));
                            break;

                        case "Blue":
                            parentLayout.setBackgroundColor(getResources().getColor(R.color.bgBlue));
                            break;

                        default:
                            parentLayout.setBackgroundColor(getResources().getColor(R.color.bgDefault));
                            break;
                    }


                    Toast.makeText(MainActivity.this, "Checked: " + checkedColor.getText(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
