package cordefundo.vinicius.com.cordefundo;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton selecionado;
    private Button button;
    private RelativeLayout layout;
    private String corDeFundo;

    private static final String PREFERENCE = "Preference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroupId);
        button = findViewById(R.id.buttonId);
        layout = findViewById(R.id.layoutId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int item = radioGroup.getCheckedRadioButtonId();

                if(item > 0) {
                    selecionado = findViewById(item);
                    corDeFundo = selecionado.getText().toString();

                    SharedPreferences preferences = getSharedPreferences(PREFERENCE, 0);
                    SharedPreferences.Editor editor = preferences.edit();

                    editor.putString("cor", selecionado.getText().toString());
                    editor.commit();
                }else{
                    corDeFundo = "";
                }

                setarBackground();

            }
        });

        SharedPreferences preferences = getSharedPreferences(PREFERENCE, 0);
        corDeFundo = preferences.getString("cor", "");
        setarBackground();

    }

    public void setarBackground(){

        switch (corDeFundo){
            case "Amarelo":
                layout.setBackgroundColor(Color.parseColor("#e7de76"));
                break;
            case "Verde":
                layout.setBackgroundColor(Color.parseColor("#a4e793"));
                break;
            case "Azul":
                layout.setBackgroundColor(Color.parseColor("#33b5e5"));
                break;
            case "Vermelho":
                layout.setBackgroundColor(Color.parseColor("#e06767"));
                break;
            case "Marrom":
                layout.setBackgroundColor(Color.parseColor("#985623"));
                break;
            default:
                layout.setBackgroundColor(Color.parseColor("#ffffff"));
        }
    }
}
