package br.ucs.android.jogodavelhaselfies;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final int CAMERA_1 = 1;
    private final int CAMERA_2 = 2;
    private final int VENCEDOR = 3;

    private final int DELAYTIME = 3000;

    int[][] bordas = new int[3][3];

    ImageButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8;
    ImageButton btnJogador1, btnJogador2;
    Bitmap fotojogador1redimensionada, fotojogador2redimensionada;

    Button limparBotao;

    boolean jogador1FotoSelecionada, jogador2FotoSelecionada, primJogadorSelecionado, fimJogo;

    File photoFile;

    Bitmap jogador1Foto, jogador2Foto;

    int cores;
    int vez;
    int jogadorSelecionado;
    int jogadores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (ImageButton) findViewById(R.id.btn0);
        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn2 = (ImageButton) findViewById(R.id.btn2);

        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn5 = (ImageButton) findViewById(R.id.btn5);

        btn6 = (ImageButton) findViewById(R.id.btn6);
        btn7 = (ImageButton) findViewById(R.id.btn7);
        btn8 = (ImageButton) findViewById(R.id.btn8);

        btnJogador1 = (ImageButton) findViewById(R.id.btnJogador1);
        btnJogador2 = (ImageButton) findViewById(R.id.btnJogador2);
        limparBotao = (Button) findViewById(R.id.limparBotao);

        cores = Color.argb(255,0,226,225);

        resetarJogo(true);

        btn0.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bordas[0][0] == -1 && inicioJogo()) {

                    if (jogadorSelecionado == 1) {
                        fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220, 220, true);
                        btn0.setImageBitmap(fotojogador1redimensionada);
                    }
                    else {
                        fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220, 220, true);
                        btn0.setImageBitmap(fotojogador2redimensionada);
                    }
                    bordas[0][0] = jogadorSelecionado;
                    proximoJogador();
                }
            }

        });

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bordas[0][1] == -1 && inicioJogo()) {

                    if (jogadorSelecionado == 1) {
                        fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220, 220, true);
                        btn1.setImageBitmap(fotojogador1redimensionada);
                    }
                    else {
                        fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220, 220, true);
                        btn1.setImageBitmap(fotojogador2redimensionada);
                    }
                    bordas[0][1] = jogadorSelecionado;
                    proximoJogador();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bordas[0][2] == -1 && inicioJogo()) {

                    if (jogadorSelecionado == 1){
                        fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220, 220, true);
                        btn2.setImageBitmap(fotojogador1redimensionada);

                    }
                    else{
                        fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220, 220, true);
                        btn2.setImageBitmap(fotojogador2redimensionada);
                    }
                    bordas[0][2] = jogadorSelecionado;
                    proximoJogador();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bordas[1][0] == -1 && inicioJogo()) {

                    if (jogadorSelecionado == 1){
                        fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220, 220, true);
                        btn3.setImageBitmap(fotojogador1redimensionada);
                    }
                    else{
                        fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220, 220, true);
                        btn3.setImageBitmap(fotojogador2redimensionada);
                    }
                    bordas[1][0] = jogadorSelecionado;
                    proximoJogador();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bordas[1][1] == -1 && inicioJogo()) {

                    if (jogadorSelecionado == 1){
                        fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220, 220, true);
                        btn4.setImageBitmap(fotojogador1redimensionada);
                    }
                    else{
                        fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220, 220, true);
                        btn4.setImageBitmap(fotojogador2redimensionada);
                    }
                    bordas[1][1] = jogadorSelecionado;
                    proximoJogador();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bordas[1][2] == -1 && inicioJogo()) {

                    if (jogadorSelecionado == 1){
                        fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220, 220, true);
                        btn5.setImageBitmap(fotojogador1redimensionada);
                    }
                    else{
                        fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220, 220, true);
                        btn5.setImageBitmap(fotojogador2redimensionada);
                    }
                    bordas[1][2] = jogadorSelecionado;
                    proximoJogador();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bordas[2][0] == -1 && inicioJogo()) {

                    if (jogadorSelecionado == 1){
                        fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220, 220, true);
                        btn6.setImageBitmap(fotojogador1redimensionada);
                    }
                    else{
                        fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220, 220, true);
                        btn6.setImageBitmap(fotojogador2redimensionada);
                    }
                    bordas[2][0] = jogadorSelecionado;
                    proximoJogador();
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bordas[2][1] == -1 && inicioJogo()) {

                    if (jogadorSelecionado == 1){
                        fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220, 220, true);
                        btn7.setImageBitmap(fotojogador1redimensionada);
                    }
                    else{
                        fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220, 220, true);
                        btn7.setImageBitmap(fotojogador2redimensionada);
                    }
                    bordas[2][1] = jogadorSelecionado;
                    proximoJogador();
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (bordas[2][2] == -1 && inicioJogo()) {

                    if (jogadorSelecionado == 1){
                        fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220, 220, true);
                        btn8.setImageBitmap(fotojogador1redimensionada);
                    }
                    else{
                        fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220, 220, true);
                        btn8.setImageBitmap(fotojogador2redimensionada);
                    }
                    bordas[2][2] = jogadorSelecionado;
                    proximoJogador();
                }
            }
        });

        btnJogador1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                if(!jogador1FotoSelecionada)
                    criarFoto(v, CAMERA_1);
                else if(!primJogadorSelecionado && jogador1FotoSelecionada && jogador2FotoSelecionada)
                {
                    btnJogador1.setBackgroundColor(cores);
                    primJogadorSelecionado = true;
                    jogadorSelecionado = 1;
                }
            }
        });

        btnJogador2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if(!jogador2FotoSelecionada)
                    criarFoto(v, CAMERA_2);
                else if(!primJogadorSelecionado & jogador1FotoSelecionada && jogador2FotoSelecionada)
                {
                    btnJogador2.setBackgroundColor(cores);
                    primJogadorSelecionado = true;
                    jogadorSelecionado = 2;
                }
            }
        });

        limparBotao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                resetarJogo(true);
            }
        });

    }

    private boolean inicioJogo() {
        return !fimJogo && jogador1FotoSelecionada && jogador2FotoSelecionada && primJogadorSelecionado;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == CAMERA_1) {
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE),
                    Uri.fromFile(photoFile).toString());

            atualizaFotoJogador(1, data.getExtras().get("data"));
        }

        else if (resultCode == RESULT_OK && requestCode == CAMERA_2) {
            sendBroadcast(new Intent
                    (Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                            Uri.fromFile(photoFile)));

            atualizaFotoJogador(2,  data.getExtras().get("data"));
        }

        else if (resultCode == RESULT_OK && requestCode == VENCEDOR) {
            resetarJogo(false);
        }
    }

    private void atualizaFotoJogador(int id, Object bitmap) {

        if (id == 1) {
            jogador1Foto = (Bitmap) bitmap;
            fotojogador1redimensionada = Bitmap.createScaledBitmap(jogador1Foto, 220,220, true);
            btnJogador1.setImageBitmap(fotojogador1redimensionada);
            jogador1FotoSelecionada = true;
        }

        else if (id == 2) {
            jogador2Foto = (Bitmap) bitmap;
            fotojogador2redimensionada = Bitmap.createScaledBitmap(jogador2Foto, 220,220, true);
            btnJogador2.setImageBitmap(fotojogador2redimensionada);
            jogador2FotoSelecionada = true;
        }
    }

    private void resetarJogo(boolean fullReset) {

        if(fullReset) {
            btnJogador1.setImageResource(R.drawable.jogador1);
            btnJogador2.setImageResource(R.drawable.jogador2);
            jogador1FotoSelecionada = false;
            jogador2FotoSelecionada = false;
        }

        fimJogo = false;

        vez = 1;
        jogadorSelecionado = 0;
        jogadores = 0;

        primJogadorSelecionado = false;

        btn0.setImageBitmap(null);
        btn1.setImageBitmap(null);
        btn2.setImageBitmap(null);

        btn3.setImageBitmap(null);
        btn4.setImageBitmap(null);
        btn5.setImageBitmap(null);

        btn6.setImageBitmap(null);
        btn7.setImageBitmap(null);
        btn8.setImageBitmap(null);

        btn0.setBackgroundColor(Color.argb(255,181,180,189));
        btn1.setBackgroundColor(Color.argb(255,181,180,189));
        btn2.setBackgroundColor(Color.argb(255,181,180,189));

        btn3.setBackgroundColor(Color.argb(255,181,180,189));
        btn4.setBackgroundColor(Color.argb(255,181,180,189));
        btn5.setBackgroundColor(Color.argb(255,181,180,189));

        btn6.setBackgroundColor(Color.argb(255,181,180,189));
        btn7.setBackgroundColor(Color.argb(255,181,180,189));
        btn8.setBackgroundColor(Color.argb(255,181,180,189));

        btnJogador1.setBackgroundColor(Color.WHITE);
        btnJogador2.setBackgroundColor(Color.WHITE);

        for(int x = 0; x < 3; x++)
            for(int y = 0; y < 3; y++)
                bordas[x][y] = -1;
    }

    private void criarFoto(View view, int param) {

        Intent takePictureIntent = new
                Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if ( takePictureIntent.resolveActivity(getPackageManager()) != null ) {
            try {
                photoFile = createFile();
            } catch (IOException ex) {
                showAlert(getBaseContext().getResources().getString(R.string.error), ex.toString(), 0);
            }
            if (photoFile != null)
                startActivityForResult(takePictureIntent, param);
        }
    }

    private void showAlert(String title, String message, int id) {
        AlertDialog alertDialog = new
                AlertDialog.Builder(MainActivity.this).create();

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,
                getString(R.string.ok),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        if (id == 0)
                            dialog.dismiss();
                        else if (id == 1)
                        {
                            dialog.dismiss();
                            resetarJogo(false);
                        }
                    }
                });
        alertDialog.show();
    }

    private File createFile() throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_Hhmmss").format(new Date());

        File folder = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);

        File image = new File(folder.getPath() +
                File.separator + "JPG_" + timeStamp + ".jpg");

        return image;
    }

    private void proximoJogador() {

        fimJogo = ganhou(jogadorSelecionado);

        if(jogadores == 8 && fimJogo == false)
            showAlert(getBaseContext().getResources().getString(R.string.draw), getBaseContext().getResources().getString(R.string.drawMessage), 1);

        if (jogadorSelecionado == 1) {

            if (fimJogo) {
                btnJogador1.setBackgroundColor(Color.argb(255,94,31,205));
                (new Handler()).postDelayed(this::mostraVencedor, DELAYTIME);
            }
            else {
                btnJogador1.setBackgroundColor(Color.argb(255,181,180,189));
                btnJogador2.setBackgroundColor(cores);
                jogadorSelecionado++;
            }
        }
        else {

            if (fimJogo) {//cor roxo
                btnJogador2.setBackgroundColor(Color.argb(255,94,31,205));
                (new Handler()).postDelayed(this::mostraVencedor, DELAYTIME);
            }
            else {
                //cor cinza
                btnJogador2.setBackgroundColor(Color.argb(255,181,180,189));
                jogadorSelecionado--;
                btnJogador1.setBackgroundColor(cores);
            }
        }

        jogadores++;
    }

    private void mostraVencedor() {

        Intent winnerIntent = new Intent(getBaseContext(), MostraVencedorActivity.class);
        Bundle bundle = new Bundle();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        if(jogadorSelecionado == 1) {
            jogador1Foto.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            bundle.putByteArray("imagem", byteArray);
            bundle.putString("vencedorNome", "Jogador 1");
        }
        else {
            jogador2Foto.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            bundle.putByteArray("imagem", byteArray);
            bundle.putString("vencedorNome", "Jogador 2");
        }

        winnerIntent.putExtra("vencedorBundle", bundle);
        startActivityForResult(winnerIntent, VENCEDOR);
    }

    private boolean ganhou(int player) {

        if(bordas[0][0] == player && bordas[0][1] == player && bordas[0][2] == player) {
            btn0.setBackgroundColor(Color.argb(255,94,31,205));
            btn1.setBackgroundColor(Color.argb(255,94,31,205));
            btn2.setBackgroundColor(Color.argb(255,94,31,205));

            return true;
        }

        else if(bordas[1][0] == player && bordas[1][1] == player && bordas[1][2] == player) {
            btn3.setBackgroundColor(Color.argb(255,94,31,205));
            btn4.setBackgroundColor(Color.argb(255,94,31,205));
            btn5.setBackgroundColor(Color.argb(255,94,31,205));

            return true;
        }

        else if(bordas[2][0] == player && bordas[2][1] == player && bordas[2][2] == player) {
            btn6.setBackgroundColor(Color.argb(255,94,31,205));
            btn7.setBackgroundColor(Color.argb(255,94,31,205));
            btn8.setBackgroundColor(Color.argb(255,94,31,205));

            return true;
        }

        else if(bordas[0][0] == player && bordas[1][1] == player && bordas[2][2] == player) {
            btn0.setBackgroundColor(Color.argb(255,94,31,205));
            btn4.setBackgroundColor(Color.argb(255,94,31,205));
            btn8.setBackgroundColor(Color.argb(255,94,31,205));

            return true;
        }

        else if(bordas[0][2] == player && bordas[1][1] == player && bordas[2][0] == player) {
            btn2.setBackgroundColor(Color.argb(255,94,31,205));
            btn4.setBackgroundColor(Color.argb(255,94,31,205));
            btn6.setBackgroundColor(Color.argb(255,94,31,205));

            return true;
        }

        else if(bordas[0][0] == player && bordas[1][0] == player && bordas[2][0] == player) {
            btn0.setBackgroundColor(Color.argb(255,94,31,205));
            btn3.setBackgroundColor(Color.argb(255,94,31,205));
            btn6.setBackgroundColor(Color.argb(255,94,31,205));

            return true;
        }

        else if(bordas[0][2] == player && bordas[1][2] == player && bordas[2][2] == player) {
            btn2.setBackgroundColor(Color.argb(255,94,31,205));
            btn5.setBackgroundColor(Color.argb(255,94,31,205));
            btn8.setBackgroundColor(Color.argb(255,94,31,205));

            return true;
        }

        else if(bordas[0][1] == player && bordas[1][1] == player && bordas[2][1] == player) {
            btn1.setBackgroundColor(Color.argb(255,94,31,205));
            btn4.setBackgroundColor(Color.argb(255,94,31,205));
            btn7.setBackgroundColor(Color.argb(255,94,31,205));

            return true;
        }

        return false;
    }

}