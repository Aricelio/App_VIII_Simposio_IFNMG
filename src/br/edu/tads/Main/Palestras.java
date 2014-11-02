package br.edu.tads.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.edu.tads.DomainModel.Atividade;

public class Palestras extends ActionBarActivity {

	// Variaveis......................................................
	private ListView lstPalestra;
	private List<Atividade> listaPalestras;
	private ArrayAdapter<Atividade> adapter;
	private int adapterLayout = android.R.layout.simple_list_item_1;

	// Método onCreate.................................................
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_palestras);

		lstPalestra = (ListView) findViewById(R.id.lstPalestras);
		registerForContextMenu(lstPalestra);
	}

	// Método que carrega a Lista.....................................
	public void carregarLista() throws ParseException {				
		this.listaPalestras = preencheLista();
		this.adapter = new ArrayAdapter<Atividade>(this, adapterLayout,listaPalestras);
		this.lstPalestra.setAdapter(adapter);		
	}

	// Método que preenche a lista de Palestras.......................
	public List<Atividade> preencheLista() throws ParseException{
		List<Atividade> atv = new ArrayList<Atividade>();
		
		Atividade atv1 = new Atividade();
		Atividade atv2 = new Atividade();
		Atividade atv3 = new Atividade();
		Atividade atv4 = new Atividade();

		atv1.setNome("Palestra: Sobre Problemas, Respostas, Perguntas e Soluções \nTerça 28/10");
		atv1.setLocal("Anfiteatro - Ensino Superior");
		atv1.setData(converteStringToDate("28-10-2014 13:30"));
		
		atv2.setNome("Palestra: Ferramenta de Bioinformática para o HIV: O Brasil no Cenário Mundial "
			   + "\n\nPalestra: Utilização de Ferramentas de Inteligência Computacional para Seleção de Características no Problema de Classificação de Tipos de Leucemia \n\nQuarta 29/10");
		atv2.setLocal("Anfiteatro - Ensino Superior");
		atv2.setData(converteStringToDate("29-10-2014 16:00"));			
		
		atv3.setNome("Palestra: Análise em Big Data via Mineração de Dados \nQuinta 30/10");
		atv3.setLocal("Anfiteatro - Ensino Superior");
		atv3.setData(converteStringToDate("30-10-2014 13:30"));
		
		atv4.setNome("Palestra: Dados Abertos em Governo Eletrônico \nQuinta 30/10");
		atv4.setLocal("Anfiteatro - Ensino Superior");
		atv4.setData(converteStringToDate("30-10-2014 16:00"));

		atv.add(atv1);
		atv.add(atv2);
		atv.add(atv3);
		atv.add(atv4);		

		return atv;
	}
	
	// Método onResume........................................................
	@Override
	public void onResume() {
		try {
			super.onResume();
			this.carregarLista();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Método para Converter uma String em uma Data...........................
	public Date converteStringToDate(String strData) throws ParseException {
		Date data;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		data = dateFormat.parse(strData);
		return data;
	}

	// Método onCreateOptionsMenu.............................................
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.palestras, menu);
		return true;
	}

	// Método onOptionsItemSelected............................................ 
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
