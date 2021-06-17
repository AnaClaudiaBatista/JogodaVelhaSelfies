package br.ucs.android.jogodavelhaselfies;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MostraVencedorActivity extends AppCompatActivity {
    TextView txtVencedor;

    Button btnjogarNovamente;

    ImageView imgVencedor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostravencedor);

        txtVencedor = (TextView) findViewById(R.id.txtVencedor);
        imgVencedor = (ImageView) findViewById(R.id.imgVencedor);
        btnjogarNovamente = (Button) findViewById(R.id.btnjogarNovamente);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("vencedorBundle");

        byte[] byteArray = bundle.getByteArray("imagem");
        Bitmap image = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        String winnerName = bundle.getString("vencedorNome");

        txtVencedor.setText(winnerName + " Ganhou!");

        imgVencedor.setImageBitmap(image);

        btnjogarNovamente.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent mainScreenIntent = new Intent(getBaseContext(), MainActivity.class);
                setResult(Activity.RESULT_OK, mainScreenIntent);
                finish();
            }
        });


    }
}