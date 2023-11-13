package com.example.formmovita;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText nomeInput;
    private CheckBox tela1Input, tela2Input, tela3Input;
    private RadioButton mInput, fInput;
    private Switch comprouMovel, interesseMovel;
    private ToggleButton interesseRA;
    private Button enviarButton;
    private List<Form> listaFormularios = new ArrayList<>();
    private TextView nomeResult;
    private TextView telaResult;
    private TextView SexoResult;
    private TextView comprouResult;
    private TextView interreseMovResult;
    private TextView interesseRAResult;
    private TextInputEditText idProcurar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomeInput = findViewById(R.id.inputText);
        tela1Input = findViewById(R.id.tela1Input);
        tela2Input = findViewById(R.id.tela2Input);
        tela3Input = findViewById(R.id.tela3Input);
        mInput = findViewById(R.id.MInput);
        fInput = findViewById(R.id.FInput);
        comprouMovel = findViewById(R.id.switch1input);
        interesseMovel = findViewById(R.id.switch2Input);
        interesseRA = findViewById(R.id.toggleButton2);
        enviarButton = findViewById(R.id.Enviar);
        nomeResult = findViewById(R.id.nomeResult);
        telaResult = findViewById(R.id.telaResult);
        SexoResult = findViewById(R.id.SexoResult);
        comprouResult = findViewById(R.id.comprouResult);
        interreseMovResult = findViewById(R.id.interreseMovResult);
        interesseRAResult = findViewById(R.id.interesseRAResult);
        idProcurar = findViewById(R.id.idProcurar);
    }

    public void clear() {
        nomeInput.setText("");
        tela1Input.setChecked(false);
        tela2Input.setChecked(false);
        tela3Input.setChecked(false);
        mInput.setChecked(false);
        fInput.setChecked(false);
        comprouMovel.setChecked(false);
        interesseMovel.setChecked(false);
        interesseRA.setChecked(false);
    }
    public void limpar(View view) {
        nomeInput.setText("");
        tela1Input.setChecked(false);
        tela2Input.setChecked(false);
        tela3Input.setChecked(false);
        mInput.setChecked(false);
        fInput.setChecked(false);
        comprouMovel.setChecked(false);
        interesseMovel.setChecked(false);
        interesseRA.setChecked(false);
    }

    public void send(View view) {

        char gender;
        if (nomeInput.getText().toString().isEmpty() || (!mInput.isChecked() && !fInput.isChecked())) return;

        if (mInput.isChecked()) {
            gender = 'M';
        } else {
            gender = 'F';
        }

        Form formNovo = new Form(nomeInput.getText().toString(), tela1Input.isChecked(), tela2Input.isChecked(), tela3Input.isChecked(), gender, comprouMovel.isChecked(), interesseMovel.isChecked(), interesseRA.isChecked());
        listaFormularios.add(formNovo);
        int num = listaFormularios.size() -1;
        result(num);
        clear();
    }

    public void result(int id) {
        Form formAtual = listaFormularios.get(id);

        nomeResult.setText("Nome: " + formAtual.getName());
        String telas = "Telas aprovadas: ";
        if (formAtual.isScreen1()) telas += "Tela 1 ";
        if (formAtual.isScreen2()) telas += "Tela 2 ";
        if (formAtual.isScreen3()) telas += "Tela 3";
        if(!formAtual.isScreen3()&&!formAtual.isScreen1()&&!formAtual.isScreen2()) telas+= "Nenhuma";
        telaResult.setText(telas);
        String sexo = formAtual.getGender()=='M'?"Masculino": "Feminino";
        SexoResult.setText("Sexo: " + sexo);
        comprouResult.setText("Comprou móveis: " + validar(formAtual.isBoughtFurniture()));
        interreseMovResult.setText("Interesse em móveis: " + validar(formAtual.isInterestFurniture()));
        interesseRAResult.setText("Interesse em RA: " + validar(formAtual.isInterestRA()));
    }

    public void procurar(View view){
        String numText = idProcurar.getText().toString();
        if (numText.isEmpty()) {
            return;
        }
        //isso verifica se é um número inteiro
        //link do stack overflow: https://pt.stackoverflow.com/questions/432480/m%c3%a9todo-matches-para-validar-se-string-cont%c3%a9m-somente-n%c3%bameros
        if (numText.matches("\\d+")) {
            int num = Integer.parseInt(numText);
            if (num >0 && num <= listaFormularios.size()) {
                result(num - 1);
            }
        }
    }
    public String validar(boolean algo){
        return algo?"Sim":"Não";
    }
}
