package br.edu.tads.Main;

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
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends ActionBarActivity {

	// Variaveis............................................................
	private ListView lstAtividadesTerca;
	private ListView lstAtividadesQuarta;
	private ListView lstAtividadesQuinta;
	private ListView lstAtividadesSexta;

	private List<Atividade> listaTerca;
	private List<Atividade> listaQuarta;
	private List<Atividade> listaQuinta;
	private List<Atividade> listaSexta;

	private ArrayAdapter<Atividade> adapterTerca;
	private ArrayAdapter<Atividade> adapterQuarta;
	private ArrayAdapter<Atividade> adapterQuinta;
	private ArrayAdapter<Atividade> adapterSexta;

	private int adapterLayout = android.R.layout.simple_list_item_1;

	// Método onCreate......................................................
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Configuração das Listas
		lstAtividadesTerca = (ListView) findViewById(R.id.lstAtividadesTerca);
		lstAtividadesQuarta = (ListView) findViewById(R.id.lstAtividadesQuarta);
		lstAtividadesQuinta = (ListView) findViewById(R.id.lstAtividadesQuinta);
		lstAtividadesSexta = (ListView) findViewById(R.id.lstAtividadesSexta);

		registerForContextMenu(lstAtividadesTerca);
		registerForContextMenu(lstAtividadesQuarta);
		registerForContextMenu(lstAtividadesQuinta);
		registerForContextMenu(lstAtividadesSexta);

		// Configuração das Tabs
		TabHost th = (TabHost) findViewById(R.id.tabhost);
		th.setup();

		// Tab Terça
		TabSpec specs = th.newTabSpec("tag1");
		specs.setContent(R.id.tabTerca);
		specs.setIndicator("Ter (28/10)");
		th.addTab(specs);

		// Tab Quarta
		specs = th.newTabSpec("tag2");
		specs.setContent(R.id.tabQuarta);
		specs.setIndicator("Qua (29/10)");
		th.addTab(specs);

		// Tab Quinta
		specs = th.newTabSpec("tag3");
		specs.setContent(R.id.tabQuinta);
		specs.setIndicator("Qui (30/10)");
		th.addTab(specs);

		// Tab Sexta
		specs = th.newTabSpec("tag4");
		specs.setContent(R.id.tabSexta);
		specs.setIndicator("Sex (31/10)");
		th.addTab(specs);
	}

	// Carregas as Listas de Atividades......................................
	public void carregarListas() {
		List<Atividade> listaTerca = new ArrayList<Atividade>();
		List<Atividade> listaQuarta = new ArrayList<Atividade>();
		List<Atividade> listaQuinta = new ArrayList<Atividade>();
		List<Atividade> listaSexta = new ArrayList<Atividade>();

		listaTerca = preencheTerca();
		listaQuarta = preencheQuarta();
		listaQuinta = preencheQuinta();
		listaSexta = preencheSexta();

		this.adapterTerca = new ArrayAdapter<Atividade>(this, adapterLayout,
				listaTerca);
		this.adapterQuarta = new ArrayAdapter<Atividade>(this, adapterLayout,
				listaQuarta);
		this.adapterQuinta = new ArrayAdapter<Atividade>(this, adapterLayout,
				listaQuinta);
		this.adapterSexta = new ArrayAdapter<Atividade>(this, adapterLayout,
				listaSexta);

		this.lstAtividadesTerca.setAdapter(adapterTerca);
		this.lstAtividadesQuarta.setAdapter(adapterQuarta);
		this.lstAtividadesQuinta.setAdapter(adapterQuinta);
		this.lstAtividadesSexta.setAdapter(adapterSexta);
	}

	// Método onResume.......................................................
	@Override
	protected void onResume() {
		super.onResume();
		this.carregarListas();
	}

	// Método que preenche os dados das Atividades de Terça..................
	public List<Atividade> preencheTerca() {
		List<Atividade> listaT = new ArrayList<Atividade>();
		Atividade atividade = new Atividade();
		Date data = new Date();

		atividade.setNome("Minicurso: Introdução a Robótica");
		atividade.setLocal("Laboratório 1 - Ensino Superior");
		atividade.setData(data);

		listaT.add(atividade);

		return listaT;
	}

	// Método que preenche os dados das Atividades de Quarta.................
	public List<Atividade> preencheQuarta() {
		List<Atividade> listaQ = new ArrayList<Atividade>();
		Atividade atividade = new Atividade();
		Date data = new Date();

		atividade.setNome("Minicurso: Versionamento de Código com Git");
		atividade.setLocal("Laboratório 2 - Ensino Superior");
		atividade.setData(data);

		listaQ.add(atividade);

		return listaQ;
	}

	// Método que preenche os dados das Atividades de Quinta.................
	public List<Atividade> preencheQuinta() {
		List<Atividade> listaQ = new ArrayList<Atividade>();
		Atividade atividade = new Atividade();
		Date data = new Date();

		atividade.setNome("Minicurso: Monetização de Apps Android");
		atividade.setLocal("Laboratório 3 - Ensino Superior");
		atividade.setData(data);

		listaQ.add(atividade);

		return listaQ;
	}

	// Método que preenche os dados das Atividades de Sexta...................
	public List<Atividade> preencheSexta() {
		List<Atividade> listaS = new ArrayList<Atividade>();
		Atividade atividade1 = new Atividade();
		Atividade atividade2 = new Atividade();
		Atividade atividade3 = new Atividade();
		Atividade atividade4 = new Atividade();
		Atividade atividade5 = new Atividade();
		
		Date data = new Date();

		atividade1.setNome("Maratona de Programação - Técnico");
		atividade1.setLocal("Laboratório 3 - Ensino Superior");
		atividade1.setData(data);
		
		atividade2.setNome("Maratona de Programação - Superior");
		atividade2.setLocal("Laboratório 3 - Ensino Superior");
		atividade2.setData(data);
		
		atividade3.setNome("Maratona de Programação - Superior");
		atividade3.setLocal("Laboratório 3 - Ensino Superior");
		atividade3.setData(data);
		
		atividade4.setNome("Maratona de Programação - Superior");
		atividade4.setLocal("Laboratório 3 - Ensino Superior");
		atividade4.setData(data);

		atividade5.setNome("Encerramento");
		atividade5.setLocal("Auditório");
		atividade5.setData(data);

		listaS.add(atividade1);
		listaS.add(atividade2);
		listaS.add(atividade3);
		listaS.add(atividade4);
		listaS.add(atividade5);

		return listaS;
	}

	// Método onCreateOptionsMenu.............................................
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Método onOptionsItemSelected...........................................
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
