package br.edu.tads.Main;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Principal extends ActionBarActivity {

	// Método onCreate...........................................................
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
	}
	
	// Método que abre a tela de Minicursos......................................
	public void onClickMinicurso(View view){
		Intent intent = new Intent(Principal.this, MainActivity.class);
		Principal.this.startActivity(intent);
	}
	
	// Método que abre a tela de Palestras.......................................
	public void onClickPalestras(View view){
		Intent intent = new Intent(Principal.this, Palestras.class);
		Principal.this.startActivity(intent);
	}
	
	// Método que abre a tela de BomberTads......................................
	public void onClickBomberTads(View view){
		Intent intent = new Intent(Principal.this, BomberTads.class);
		Principal.this.startActivity(intent);
	}
	
	// Método que mostra as informações das maratonas............................
	public void onClickMaratona(View view){
			AlertDialog.Builder mensagem = new AlertDialog.Builder(
			Principal.this);
			mensagem.setTitle("Maratonas");
			mensagem.setMessage("Maratona de Progrmação Técnico " +
					"\nLocal: Laboratório III - Ensino Superior " +
					"\nData: Sex - 8:00 " +
					"\n\nMaratona de Progrmação Superior" +
					"\nLocal: Laboratório III - Ensino Superior " +
					"\nData: Sex - 14:00 ");
			mensagem.setNeutralButton("OK", null);
			mensagem.show();		
	}

	// Método onCreateOptionsMenu................................................
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}

	// Método onOptionsItemSelected..............................................
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
