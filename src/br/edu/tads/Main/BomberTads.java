package br.edu.tads.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.tads.DomainModel.Atividade;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BomberTads extends ActionBarActivity {

	// Variaveis......................................................
	private ListView lstBomber;
	private List<Atividade> listaBomber;
	private ArrayAdapter<Atividade> adapter;
	private int adapterLayout = android.R.layout.simple_list_item_1;

	// Método onCreate........................................
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bomber_tads);

		lstBomber = (ListView) findViewById(R.id.lstBomber);
		registerForContextMenu(lstBomber);
	}

	// Método para preenche a lista de atividades..............
	public List<Atividade> preencheLista() throws ParseException {
		List<Atividade> atv = new ArrayList<Atividade>();

		Atividade atv1 = new Atividade();
		Atividade atv2 = new Atividade();
		Atividade atv3 = new Atividade();

		atv1.setNome("     Terça 28/10\n\nGrupo 01 - 10 Jogadores " + "\nGrupo 02 - 10 Jogadores");
		atv1.setLocal("Laboratório III - Ensino Superior");
		atv1.setData(converteStringToDate("28-10-2014 17:30"));

		atv2.setNome("     Quarta 29/10\n\nGrupo 03 - 10 Jogadores " + "\nGrupo 04 - 10 Jogadores");
		atv2.setLocal("Laboratório III - Ensino Superior");
		atv2.setData(converteStringToDate("29-10-2014 17:30"));

		atv3.setNome("     Quinta 30/10\n\nGrupo 05 - 10 Jogadores "
				+ "\nGrupo Finalista - Os 10 Melhores Jogadores");
		atv3.setLocal("Laboratório III - Ensino Superior");
		atv3.setData(converteStringToDate("30-10-2014 17:30"));

		atv.add(atv1);
		atv.add(atv2);
		atv.add(atv3);

		return atv;
	}

	// Método que carrega a Lista.....................................
	public void carregarLista() throws ParseException {
		this.listaBomber = preencheLista();
		this.adapter = new ArrayAdapter<Atividade>(this, adapterLayout,
				listaBomber);
		this.lstBomber.setAdapter(adapter);
	}

	// Método onResume........................................
	@Override
	public void onResume() {
		try {
			super.onResume();
			this.carregarLista();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Método para Converter uma String em uma Data...........
	public Date converteStringToDate(String strData) throws ParseException {
		Date data;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		data = dateFormat.parse(strData);
		return data;
	}

	// Método onCreateOptionsMenu.............................
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.bomber_tads, menu);
		return true;
	}

	// Método onOptionsItemSelected...........................
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
