package progetto.operatoreAnalogicoBOT.model;

public class Brevetto {

	String p_iva;
	String app_number;
	String titolo;
	String assegnatario;
	String inventori;
	String data;
	String codclass;
	String luogo;
	
	public String getLuogo() {
		return luogo;
	}


	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}


	public String getCodclass() {
		return codclass;
	}


	public void setCodclass(String codclass) {
		this.codclass = codclass;
	}


	public Brevetto(String p_iva, String app_number, String titolo, String assegnatario, String inventori, String data,
			String luogo, String abstract_text,String codclass, String keywords) {
		super();
		this.p_iva = p_iva;
		this.app_number = app_number;
		this.titolo = titolo;
		this.assegnatario = assegnatario;
		this.inventori = inventori;
		this.data = data;
		this.codclass = codclass;
		this.luogo = luogo;
		this.abstract_text = abstract_text;
		this.keywords = keywords;
	}


	public Brevetto(String p_iva, String app_number, String titolo, String assegnatario, String inventori, String data,
			String luogo, String abstract_text, String keywords) {
		super();
		this.p_iva = p_iva;
		this.app_number = app_number;
		this.titolo = titolo;
		this.assegnatario = assegnatario;
		this.inventori = inventori;
		this.data = data;
		this.luogo = luogo;
		this.abstract_text = abstract_text;
		this.keywords = keywords;
	}

	String abstract_text;
	String keywords;
	
	
	public String getKeywords() {
		return keywords;
	}


	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}


	public Brevetto(String p_iva, String app_number, String titolo, String assegnatario, String inventori, String data,
			String abstract_text, String keywords) {
		super();
		this.p_iva = p_iva;
		this.app_number = app_number;
		this.titolo = titolo;
		this.assegnatario = assegnatario;
		this.inventori = inventori;
		this.data = data;
		this.abstract_text = abstract_text;
		this.keywords = keywords;
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public Brevetto(String p_iva, String app_number, String titolo, String assegnatario, String inventori, String data,
			String abstract_text) {
		super();
		this.p_iva = p_iva;
		this.app_number = app_number;
		this.titolo = titolo;
		this.assegnatario = assegnatario;
		this.inventori = inventori;
		this.data = data;
		this.abstract_text = abstract_text;
	}


	public String getInventori() {
		return inventori;
	}


	public void setInventori(String inventori) {
		this.inventori = inventori;
	}


	public Brevetto(String p_iva, String app_number, String titolo, String assegnatario, String inventori,
			String abstract_text) {
		super();
		this.p_iva = p_iva;
		this.app_number = app_number;
		this.titolo = titolo;
		this.assegnatario = assegnatario;
		this.inventori = inventori;
		this.abstract_text = abstract_text;
	}


	
//	public Brevetto(String p_iva, String app_number, String titolo) {
//		super();
//		this.p_iva = p_iva;
//		this.app_number = app_number;
//		this.titolo = titolo;
//	}
	
	

	public Brevetto(String p_iva, String app_number, String titolo, String abstract_text) {
		super();
		this.abstract_text = abstract_text;
		this.p_iva = p_iva;
		this.app_number = app_number;
		this.titolo = titolo;
	}



	public String getAssegnatario() {
		return assegnatario;
	}



	public void setAssegnatario(String assegnatario) {
		this.assegnatario = assegnatario;
	}



	public Brevetto(String p_iva, String app_number, String assegnatario,String titolo, String abstract_text) {
		super();
		this.p_iva = p_iva;
		this.app_number = app_number;
		this.titolo = titolo;
		this.assegnatario = assegnatario;
		this.abstract_text = abstract_text;
	}



	public String getAbstract_text() {
		return abstract_text;
	}

	public void setAbstract_text(String abstract_text) {
		this.abstract_text = abstract_text;
	}

	public String getP_iva() {
		return p_iva;
	}

	public void setP_iva(String p_iva) {
		this.p_iva = p_iva;
	}

	public String getApp_number() {
		return app_number;
	}

	public void setApp_number(String app_number) {
		this.app_number = app_number;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Brevetto [p_iva=" + p_iva + ", app_number=" + app_number + ", titolo=" + titolo + "]";
	}
	
	
	
	

}
