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

	String strData;

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
	public void carregarListas() throws ParseException {
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
		try {
			super.onResume();
			this.carregarListas();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Método que preenche os dados das Atividades de Terça..................
	public List<Atividade> preencheTerca() throws ParseException {
		List<Atividade> listaT = new ArrayList<Atividade>();
		Atividade atividade1 = new Atividade();
		Atividade atividade2 = new Atividade();
		Atividade atividade3 = new Atividade();
		Atividade atividade4 = new Atividade();
		Atividade atividade5 = new Atividade();
		Atividade atividade6 = new Atividade();
		Atividade atividade7 = new Atividade();
		Atividade atividade8 = new Atividade();
		Atividade atividade9 = new Atividade();
		Atividade atividade10 = new Atividade();
		Atividade atividade11 = new Atividade();
		Atividade atividade12 = new Atividade();
		Atividade atividade13 = new Atividade();
		Atividade atividade14 = new Atividade();

		atividade1.setNome("Credenciamento");
		atividade1.setLocal("Ensino Superior");
		atividade1.setData(converteStringToDate("28-10-2014 07:30"));

		atividade2.setNome("Intervalo");
		atividade2.setLocal("");
		atividade2.setData(converteStringToDate("28-10-2014 09:30"));

		atividade3.setNome("Minicurso: Introdução a Robótica - Turma 1");
		atividade3.setLocal("Laboratório 2 - Ensino Superior");
		atividade3.setData(converteStringToDate("28-10-2014 10:00"));

		atividade4
				.setNome("Minicurso: Modelagem 3D com Trimble Sketchup - Turma I");
		atividade4.setLocal("Laboratório 3 - Ensino Superior");
		atividade4.setData(converteStringToDate("28-10-2014 10:00"));

		atividade5.setNome("Almoço");
		atividade5.setLocal("");
		atividade5.setData(converteStringToDate("28-10-2014 12:00"));

		atividade6.setNome("Abertura Oficial/Palestra");
		atividade6.setLocal("Anfiteatro - Ensino Superior");
		atividade6.setData(converteStringToDate("28-10-2014 13:30"));

		atividade7.setNome("Coffee Break");
		atividade7.setLocal("Anfiteatro - Ensino Superior");
		atividade7.setData(converteStringToDate("28-10-2014 15:30"));

		atividade8.setNome("Apresentação de Artigos Completos");
		atividade8.setLocal("Anfiteatro - Ensino Superior");
		atividade8.setData(converteStringToDate("28-10-2014 16:00"));

		// Minicursos............................................................
		atividade9.setNome("Minicurso: Desenvolvimento de Sites Responsivos");
		atividade9.setLocal("Laboratório II - Técnico");
		atividade9.setData(converteStringToDate("28-10-2014 19:00"));

		atividade10.setNome("Minicurso: Utilizando o CorelDraw X5");
		atividade10.setLocal("Laboratório III - Superior");
		atividade10.setData(converteStringToDate("28-10-2014 19:00"));

		atividade11.setNome("Minicurso: Criando Jogos com Stencyl");
		atividade11.setLocal("Laboratório II - Superior");
		atividade11.setData(converteStringToDate("28-10-2014 19:00"));

		atividade12.setNome("Minicurso: Introdução ao Photoshop - Turma I");
		atividade12.setLocal("Laboratório I - Superior");
		atividade12.setData(converteStringToDate("28-10-2014 19:00"));

		atividade13
				.setNome("Minicurso: Modelagem 3D com Trimble Sketchup - Turma II");
		atividade13.setLocal("Laboratório I - Técnico");
		atividade13.setData(converteStringToDate("28-10-2014 19:00"));

		atividade14.setNome("Intervalo");
		atividade14.setLocal("");
		atividade14.setData(converteStringToDate("28-10-2014 20:30"));

		listaT.add(atividade1);
		listaT.add(atividade2);
		listaT.add(atividade3);
		listaT.add(atividade4);
		listaT.add(atividade5);
		listaT.add(atividade6);
		listaT.add(atividade7);
		listaT.add(atividade8);
		listaT.add(atividade9);
		listaT.add(atividade10);
		listaT.add(atividade11);
		listaT.add(atividade12);
		listaT.add(atividade13);
		listaT.add(atividade14);

		return listaT;
	}

	// Método que preenche os dados das Atividades de Quarta.................
	public List<Atividade> preencheQuarta() throws ParseException {
		List<Atividade> listaQ = new ArrayList<Atividade>();

		Atividade atividade1 = new Atividade();
		Atividade atividade2 = new Atividade();
		Atividade atividade3 = new Atividade();
		Atividade atividade4 = new Atividade();
		Atividade atividade5 = new Atividade();
		Atividade atividade6 = new Atividade();
		Atividade atividade7 = new Atividade();
		Atividade atividade8 = new Atividade();
		Atividade atividade9 = new Atividade();
		Atividade atividade10 = new Atividade();
		Atividade atividade11 = new Atividade();

		// Minicursos......................................................
		atividade1.setNome("Minicurso: Arduino e PCI");
		atividade1.setLocal("Laboratório II - Ensino Superior");
		atividade1.setData(converteStringToDate("29-10-2014 07:30"));

		atividade2
				.setNome("Minicurso: Introdução ao Desenvolvimento de Sistemas Embarcados");
		atividade2.setLocal("Laboratório  III - Ensino Superior");
		atividade2.setData(converteStringToDate("29-10-2014 07:30"));

		atividade3
				.setNome("Minicurso: Introdução ao Versionamento de Código Utilizando Git e GitHub");
		atividade3.setLocal("Carreta");
		atividade3.setData(converteStringToDate("29-10-2014 07:30"));

		atividade4
				.setNome("Minicurso: Computação em Nuvem e Gerenciamento de Projetos - Análises e Ferramentas");
		atividade4.setLocal("Laboratório IV - Ensino Superior");
		atividade4.setData(converteStringToDate("29-10-2014 07:30"));

		atividade5
				.setNome("Minicurso: Publicação e Monetização de Conteúdos no Youtube");
		atividade5.setLocal("Auditório da Biblioteca");
		atividade5.setData(converteStringToDate("29-10-2014 07:30"));

		atividade6
				.setNome("Banco de Dados - Conceitos, SQL e Carreira - Turma II");
		atividade6.setLocal("Laboratório I - Ensino Superior");
		atividade6.setData(converteStringToDate("29-10-2014 07:30"));

		atividade7.setNome("Almoço");
		atividade7.setLocal("");
		atividade7.setData(converteStringToDate("29-10-2014 12:00"));

		atividade8.setNome("Apresentação de Artigos Completos");
		atividade8.setLocal("Anfiteatro - Ensino Superior");
		atividade8.setData(converteStringToDate("29-10-2014 13:30"));

		atividade9.setNome("Intervalo - Mostra de Posteres");
		atividade9.setLocal("Anfiteatro - Ensino Superior");
		atividade9.setData(converteStringToDate("29-10-2014 15:30"));

		atividade10
				.setNome("Palestra: Ferramenta de Bioinformática para o HIV: O Brasil no Cenário Mundial "
						+ "\n\nPalestra: Utilização de Ferramentas de Inteligência Computacional para Seleção de Características no Problema de Classificação de Tipos de Leucemia\n");
		atividade10.setLocal("Anfiteatro - Ensino Superior");
		atividade10.setData(converteStringToDate("29-10-2014 16:00"));

		atividade11.setNome("Confraternização");
		atividade11.setLocal("Salão de Festas Deth Noivas");
		atividade11.setData(converteStringToDate("29-10-2014 20:00"));

		// Adicionando os objetos na lista
		listaQ.add(atividade1);
		listaQ.add(atividade2);
		listaQ.add(atividade3);
		listaQ.add(atividade4);
		listaQ.add(atividade5);
		listaQ.add(atividade6);
		listaQ.add(atividade7);
		listaQ.add(atividade8);
		listaQ.add(atividade9);
		listaQ.add(atividade10);
		listaQ.add(atividade11);

		return listaQ;
	}

	// Método que preenche os dados das Atividades de Quinta.................
	public List<Atividade> preencheQuinta() throws ParseException {
		List<Atividade> listaQ = new ArrayList<Atividade>();

		Atividade atividade1 = new Atividade();
		Atividade atividade2 = new Atividade();
		Atividade atividade3 = new Atividade();
		Atividade atividade4 = new Atividade();
		Atividade atividade5 = new Atividade();
		Atividade atividade6 = new Atividade();
		Atividade atividade7 = new Atividade();
		Atividade atividade8 = new Atividade();
		Atividade atividade9 = new Atividade();
		Atividade atividade10 = new Atividade();
		Atividade atividade11 = new Atividade();
		Atividade atividade12 = new Atividade();
		Atividade atividade13 = new Atividade();
		Atividade atividade14 = new Atividade();
		Atividade atividade15 = new Atividade();
		Atividade atividade16 = new Atividade();
		Atividade atividade17 = new Atividade();
		Atividade atividade18 = new Atividade();

		atividade1.setNome("Minicurso: Introdução ao Desenvolvimento de Aplicativos Android");
		atividade1.setLocal("Laboratório II - Técnico");
		atividade1.setData(converteStringToDate("30-10-2014 07:30"));

		atividade2.setNome("Minicurso: Redação Científica Sem Stress! LaTex para Iniciantes");
		atividade2.setLocal("Laboratório II - Superior");
		atividade2.setData(converteStringToDate("30-10-2014 07:30"));

		atividade3.setNome("Minicurso: Banco de Dados - Conceitos, SQL e Carreira - Turma I");
		atividade3.setLocal("Laboratório II - Superior");
		atividade3.setData(converteStringToDate("30-10-2014 07:30"));

		atividade4.setNome("Minicurso: Gerenciamento de Projetos e Desenvolvimento Ágil de Softwares com Scrum");
		atividade4.setLocal("Carreta");
		atividade4.setData(converteStringToDate("30-10-2014 07:30"));

		atividade4.setNome("Minicurso: Virtualização com VMWARE ESXI");
		atividade4.setLocal("Laboratório III - Superior");
		atividade4.setData(converteStringToDate("30-10-2014 07:30"));

		atividade5.setNome("Minicurso: Java 8 - A Evolução da Linguagem");
		atividade5.setLocal("Auditório da Biblioteca");
		atividade5.setData(converteStringToDate("30-10-2014 07:30"));

		// Intervalo 9:30...................................................
		atividade14.setNome("Intervalo");
		atividade14.setLocal("");
		atividade14.setData(converteStringToDate("30-10-2014 09:30"));

		// Almoço 12:00....................................................
		atividade15.setNome("Almoço");
		atividade15.setLocal("");
		atividade15.setData(converteStringToDate("30-10-2014 12:00"));
		
		atividade16.setNome("Palestra: ");
		atividade16.setLocal("Anfiteatro - Ensino Superior");
		atividade16.setData(converteStringToDate("30-10-2014 13:30"));
		
		atividade17.setNome("Intervalo/Mostra de Posteres");
		atividade17.setLocal("Ensino Superior");
		atividade17.setData(converteStringToDate("30-10-2014 15:30"));
		
		atividade18.setNome("Palestra: ");
		atividade18.setLocal("Anfiteatro - Ensino Superior");
		atividade18.setData(converteStringToDate("30-10-2014 16:00"));
		
		atividade6.setNome("Minicurso: Estimulando o Interesse da Programação de Computadores Desenvolvendo Jogos e Animações");
		atividade6.setLocal("Laboratório III - Superior");
		atividade6.setData(converteStringToDate("30-10-2014 19:00"));

		atividade7.setNome("Minicurso: Instalação e Gestão de Conteúdos com WordPress");
		atividade7.setLocal("Laboratório II - Superior");
		atividade7.setData(converteStringToDate("30-10-2014 19:00"));

		atividade8.setNome("Minicurso: Monetização de Sites");
		atividade8.setLocal("Auditório da Biblioteca");
		atividade8.setData(converteStringToDate("30-10-2014 19:00"));

		atividade9.setNome("Minicurso: Empreendedorismo e Inovação");
		atividade9.setLocal("Sala de Aula 17 - Superior");
		atividade9.setData(converteStringToDate("30-10-2014 19:00"));

		atividade10.setNome("Minicurso: Introdução ao Photoshop - Turma II");
		atividade10.setLocal("Carreta");
		atividade10.setData(converteStringToDate("30-10-2014 19:00"));

		atividade11.setNome("Minicurso: Introdução a Robótica - Turma II");
		atividade11.setLocal("Laboratório I - Superior");
		atividade11.setData(converteStringToDate("30-10-2014 19:00"));

		atividade12.setNome("Minicurso: Desenvolvimento de Sistemas Web com Java");
		atividade12.setLocal("Laboratório IV - Superior");
		atividade12.setData(converteStringToDate("30-10-2014 19:00"));

		// Intervalo 20:30......................................................
		atividade13.setNome("Intervalo");
		atividade13.setLocal("");
		atividade13.setData(converteStringToDate("30-10-2014 20:30"));

		listaQ.add(atividade1);
		listaQ.add(atividade2);
		listaQ.add(atividade3);
		listaQ.add(atividade4);
		listaQ.add(atividade5);
		listaQ.add(atividade6);
		listaQ.add(atividade7);
		listaQ.add(atividade8);
		listaQ.add(atividade9);
		listaQ.add(atividade10);
		listaQ.add(atividade11);
		listaQ.add(atividade12);

		return listaQ;
	}

	// Método que preenche os dados das Atividades de Sexta...................
	public List<Atividade> preencheSexta() throws ParseException {
		List<Atividade> listaS = new ArrayList<Atividade>();
		Atividade atividade1 = new Atividade();
		Atividade atividade2 = new Atividade();
		Atividade atividade3 = new Atividade();
		Atividade atividade4 = new Atividade();
		Atividade atividade5 = new Atividade();

		// Date data = new Date();

		atividade1.setNome("Maratona de Programação - Técnico");
		atividade1.setLocal("Laboratório 3 - Ensino Superior");
		atividade1.setData(converteStringToDate("31-10-2014 08:00"));

		atividade2.setNome("Maratona de Programação - Superior");
		atividade2.setLocal("Laboratório 3 - Ensino Superior");
		atividade2.setData(converteStringToDate("31-10-2014 14:00"));

		atividade3.setNome("Maratona de Programação - Superior");
		atividade3.setLocal("Laboratório 3 - Ensino Superior");
		atividade3.setData(converteStringToDate("31-10-2014 14:00"));

		atividade4.setNome("Maratona de Programação - Superior");
		atividade4.setLocal("Laboratório 3 - Ensino Superior");
		atividade4.setData(converteStringToDate("31-10-2014 14:00"));

		atividade5.setNome("Encerramento");
		atividade5.setLocal("Auditório");
		atividade5.setData(converteStringToDate("31-10-2014 18:00"));

		listaS.add(atividade1);
		listaS.add(atividade2);
		listaS.add(atividade3);
		listaS.add(atividade4);
		listaS.add(atividade5);

		return listaS;
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
