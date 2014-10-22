package br.edu.tads.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import br.edu.tads.DomainModel.Atividade;

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
		
		this.getActionBar().setSubtitle("IFNMG Câmpus Januária");

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
		Atividade atividade15 = new Atividade();

		atividade1.setNome("Credenciamento");
		atividade1.setLocal("Ensino Superior");
		atividade1.setData(converteStringToDate("28-10-2014 07:30"));

		// Intervalo 9:30..............................................
		atividade2.setNome("Intervalo");
		atividade2.setData(converteStringToDate("28-10-2014 09:30"));
		atividade2.setLocal("");

		// Minicursos de Manhã.........................................
		atividade3.setNome("Minicurso: Introdução a Robótica - Turma I");
		atividade3.setLocal("Laboratório II - Ensino Superior");
		atividade3.setData(converteStringToDate("28-10-2014 10:00"));

		atividade4
				.setNome("Minicurso: Modelagem 3D com Trimble Sketchup - Turma I");
		atividade4.setLocal("Laboratório 3 - Ensino Superior");
		atividade4.setData(converteStringToDate("28-10-2014 10:00"));

		// Almoço.......................................................
		atividade5.setNome("Almoço");
		atividade5.setData(converteStringToDate("28-10-2014 12:00"));
		atividade5.setLocal("");

		// Abertura.....................................................
		atividade6.setNome("Abertura Oficial\nPalestra: Sobre Problemas, Respostas, Perguntas e Soluções");
		atividade6.setLocal("Anfiteatro - Ensino Superior");
		atividade6.setData(converteStringToDate("28-10-2014 13:30"));

		atividade7.setNome("Coffee Break");
		atividade7.setLocal("Anfiteatro - Ensino Superior");
		atividade7.setData(converteStringToDate("28-10-2014 15:30"));

		atividade8.setNome("Apresentação de Artigos Completos");
		atividade8.setLocal("Anfiteatro - Ensino Superior");
		atividade8.setData(converteStringToDate("28-10-2014 16:00"));

		// BomberTads.....................................................
		atividade15.setNome("Torneio de Bomber TADS");
		atividade15.setLocal("Laboratório II e Laboratorio III - Superior");
		atividade15.setData(converteStringToDate("28-10-2014 18:00"));
		
		// Minicursos da Noite..........................................
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

		atividade13.setNome("Minicurso: Modelagem 3D com Trimble Sketchup - Turma II");
		atividade13.setLocal("Laboratório I - Técnico");
		atividade13.setData(converteStringToDate("28-10-2014 19:00"));

		// Intervalor 20:30...............................................
		atividade14.setNome("Intervalo");
		atividade14.setData(converteStringToDate("28-10-2014 20:30"));
		atividade14.setLocal("");

		// Adicionando os objetos na lista
		listaT.add(atividade1);
		listaT.add(atividade2);
		listaT.add(atividade3);
		listaT.add(atividade4);
		listaT.add(atividade5);
		listaT.add(atividade6);
		listaT.add(atividade7);
		listaT.add(atividade8);
		listaT.add(atividade15);
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

		// Minicursos de Manhã................................................
		atividade1.setNome("Minicurso: Arduino e PCI");
		atividade1.setLocal("Laboratório II - Ensino Superior");
		atividade1.setData(converteStringToDate("29-10-2014 07:30"));

		atividade2.setNome("Minicurso: Introdução ao Desenvolvimento de Sistemas Embarcados");
		atividade2.setLocal("Laboratório  III - Ensino Superior");
		atividade2.setData(converteStringToDate("29-10-2014 07:30"));

		atividade3.setNome("Minicurso: Introdução ao Versionamento de Código Utilizando Git e GitHub");
		atividade3.setLocal("Carreta");
		atividade3.setData(converteStringToDate("29-10-2014 07:30"));

		atividade4.setNome("Minicurso: Computação em Nuvem e Gerenciamento de Projetos - Análises e Ferramentas");
		atividade4.setLocal("Laboratório IV - Ensino Superior");
		atividade4.setData(converteStringToDate("29-10-2014 07:30"));

		atividade5.setNome("Minicurso: Publicação e Monetização de Conteúdos no Youtube");
		atividade5.setLocal("Auditório da Biblioteca");
		atividade5.setData(converteStringToDate("29-10-2014 07:30"));

		atividade6.setNome("Minicurso: Banco de Dados - Conceitos, SQL e Carreira - Turma II");
		atividade6.setLocal("Laboratório I - Ensino Superior");
		atividade6.setData(converteStringToDate("29-10-2014 07:30"));

		// Almoço......................................................
		atividade7.setNome("Almoço");
		atividade7.setLocal("");
		atividade7.setData(converteStringToDate("29-10-2014 12:00"));

		atividade8.setNome("Apresentação de Artigos Completos");
		atividade8.setLocal("Anfiteatro - Ensino Superior");
		atividade8.setData(converteStringToDate("29-10-2014 13:30"));

		// Intervalo e Mostra de Posteres.............................
		atividade9.setNome("Intervalo - Mostra de Posteres");
		atividade9.setLocal("Anfiteatro - Ensino Superior");
		atividade9.setData(converteStringToDate("29-10-2014 15:30"));

		atividade10.setNome("Palestra: Ferramenta de Bioinformática para o HIV: O Brasil no Cenário Mundial "
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

		// Variaveis
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
		Atividade atividade19 = new Atividade();
		Atividade atividade20 = new Atividade();

		// Minicurso de Manha..................................................
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

		atividade5.setNome("Minicurso: Virtualização com VMWARE ESXI");
		atividade5.setLocal("Laboratório III - Superior");
		atividade5.setData(converteStringToDate("30-10-2014 07:30"));

		atividade6.setNome("Minicurso: Java 8 - A Evolução da Linguagem");
		atividade6.setLocal("Auditório da Biblioteca");
		atividade6.setData(converteStringToDate("30-10-2014 07:30"));

		// Intervalo 9:30...................................................
		atividade7.setNome("Intervalo");
		atividade7.setLocal("");
		atividade7.setData(converteStringToDate("30-10-2014 09:30"));

		// Almoço 12:00....................................................
		atividade8.setNome("Almoço");
		atividade8.setLocal("");
		atividade8.setData(converteStringToDate("30-10-2014 12:00"));

		// Palestras.......................................................
		atividade9.setNome("Palestra: Análise em Big Data via Mineração de Dados");
		atividade9.setLocal("Anfiteatro - Ensino Superior");
		atividade9.setData(converteStringToDate("30-10-2014 13:30"));

		atividade10.setNome("Intervalo - Mostra de Posteres");
		atividade10.setLocal("Ensino Superior");
		atividade10.setData(converteStringToDate("30-10-2014 15:30"));

		atividade11.setNome("Palestra: Dados Abertos em Governo Eletrônico");
		atividade11.setLocal("Anfiteatro - Ensino Superior");
		atividade11.setData(converteStringToDate("30-10-2014 16:00"));
		
		// BomberTads.....................................................
		atividade20.setNome("Torneio de Bomber TADS");
		atividade20.setLocal("Laboratório II e Laboratorio III - Superior");
		atividade20.setData(converteStringToDate("28-10-2014 18:00"));

		// Minicursos á Noite..............................................
		atividade12.setNome("Minicurso: Estimulando o Interesse da Programação de Computadores Desenvolvendo Jogos e Animações");
		atividade12.setLocal("Laboratório III - Superior");
		atividade12.setData(converteStringToDate("30-10-2014 19:00"));

		atividade13.setNome("Minicurso: Instalação e Gestão de Conteúdos com WordPress");
		atividade13.setLocal("Laboratório II - Superior");
		atividade13.setData(converteStringToDate("30-10-2014 19:00"));

		atividade14.setNome("Minicurso: Monetização de Sites");
		atividade14.setLocal("Auditório da Biblioteca");
		atividade14.setData(converteStringToDate("30-10-2014 19:00"));

		atividade15.setNome("Minicurso: Empreendedorismo e Inovação");
		atividade15.setLocal("Sala de Aula 17 - Superior");
		atividade15.setData(converteStringToDate("30-10-2014 19:00"));

		atividade16.setNome("Minicurso: Introdução ao Photoshop - Turma II");
		atividade16.setLocal("Carreta");
		atividade16.setData(converteStringToDate("30-10-2014 19:00"));

		atividade17.setNome("Minicurso: Introdução a Robótica - Turma II");
		atividade17.setLocal("Laboratório I - Superior");
		atividade17.setData(converteStringToDate("30-10-2014 19:00"));

		atividade18.setNome("Minicurso: Desenvolvimento de Sistemas Web com Java");
		atividade18.setLocal("Laboratório IV - Superior");
		atividade18.setData(converteStringToDate("30-10-2014 19:00"));

		// Intervalo 20:30......................................................
		atividade19.setNome("Intervalo");
		atividade19.setLocal("");
		atividade19.setData(converteStringToDate("30-10-2014 20:30"));

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
		listaQ.add(atividade20);
		listaQ.add(atividade12);
		listaQ.add(atividade13);
		listaQ.add(atividade14);
		listaQ.add(atividade15);
		listaQ.add(atividade16);
		listaQ.add(atividade17);
		listaQ.add(atividade18);
		listaQ.add(atividade19);

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
		Atividade atividade6 = new Atividade();
		Atividade atividade7 = new Atividade();
		Atividade atividade8 = new Atividade();
		Atividade atividade9 = new Atividade();
		Atividade atividade10 = new Atividade();
		Atividade atividade11 = new Atividade();
		Atividade atividade12 = new Atividade();

		// Minicursos de Manha..........................................
		atividade1.setNome("Minicurso: Ignorando Proteções - Turma I");
		atividade1.setLocal("Laboratório III - Ensino Superior");
		atividade1.setData(converteStringToDate("31-10-2014 07:30"));

		atividade2.setNome("Minicurso: Sites Rápidos e Profissionais com Bootstrap");
		atividade2.setLocal("Laboratório II - Técnico");
		atividade2.setData(converteStringToDate("31-10-2014 07:30"));

		atividade3.setNome("Minicurso: Análise em Big Data e um Estudo de Caso de Utilizando Computação em Nuvem");
		atividade3.setLocal("Laboratório II - Ensino Superior");
		atividade3.setData(converteStringToDate("31-10-2014 07:30"));

		atividade4.setNome("Minicurso: Monetização de Aplicativos Android");
		atividade4.setLocal("Carreta");
		atividade4.setData(converteStringToDate("31-10-2014 07:30"));
		
		// Intervalo 09:30..............................................
		atividade5.setNome("Intervalo");
		atividade5.setLocal("");
		atividade5.setData(converteStringToDate("31-10-2014 09:30"));

		// Almoço 12:00.................................................
		atividade6.setNome("Almoço");
		atividade6.setLocal("");
		atividade6.setData(converteStringToDate("31-10-2014 12:00"));

		// Maratona Técnico.............................................
		atividade7.setNome("Maratona de Programação - Técnico");
		atividade7.setLocal("Laboratório I - Ensino Superior");
		atividade7.setData(converteStringToDate("31-10-2014 08:00"));
		
		// Minicursos á Tarde...........................................
		atividade8.setNome("Minicurso: Ignorando Proteções - Turma II");
		atividade8.setLocal("Laboratório III - Ensino Superior");
		atividade8.setData(converteStringToDate("31-10-2014 13:30"));

		atividade9.setNome("Minicurso: Criação de um Website Completo em 4 horas Utilizando Joomla!");
		atividade9.setLocal("Carreta");
		atividade9.setData(converteStringToDate("31-10-2014 13:30"));

		atividade10.setNome("Minicurso: Utilização da Realidade Virtual no Auxilio a Educação");
		atividade10.setLocal("Laboratório II - Ensino Superior");
		atividade10.setData(converteStringToDate("31-10-2014 13:30"));		

		// Maratona Superior............................................
		atividade11.setNome("Maratona de Programação - Superior");
		atividade11.setLocal("Laboratório I - Ensino Superior");
		atividade11.setData(converteStringToDate("31-10-2014 14:00"));

		// Intervalo 15:30..............................................
		atividade12.setNome("Intervalo");
		atividade12.setLocal("");
		atividade12.setData(converteStringToDate("31-10-2014 15:30"));

		// Adicionando os objetos na lista..............................
		listaS.add(atividade1);
		listaS.add(atividade2);
		listaS.add(atividade3);
		listaS.add(atividade4);
		listaS.add(atividade5);
		listaS.add(atividade6);
		listaS.add(atividade7);
		listaS.add(atividade8);
		listaS.add(atividade9);
		listaS.add(atividade10);
		listaS.add(atividade11);
		listaS.add(atividade12);
		
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
			//Toast.makeText(this, "Sobre", Toast.LENGTH_SHORT).show();
			Intent intent = new Intent(MainActivity.this, Sobre.class);
			MainActivity.this.startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
